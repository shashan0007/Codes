package com.photo.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.photo.entity.Album;
import com.photo.entity.Picture;
import com.photo.dao.AlbumDao;
import com.photo.dao.PictureDao;

public class FormAlbumController extends SimpleFormController {

	private AlbumDao albumDao;
	private PictureDao pictureDao;
		
	public FormAlbumController(){
		setCommandClass(Album.class);
		setValidator(new AlbumValidator());
	}

	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
		throws Exception{
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception{		
		Integer albumid = ServletRequestUtils.getIntParameter(request, "albumid");
		
		if (albumid != null && !"".equals(albumid)) {
			return albumDao.getAlbum(albumid);
		}
		else {
			return super.formBackingObject(request);
		}
	}
	
	@Override
	 public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
			 Object album, BindException errors) throws Exception {		 	
        if (request.getParameter("update") != null) {
            albumDao.updateAlbum((Album)album);            
        } else if (request.getParameter("insert") != null) {
        	albumDao.insertAlbum((Album)album);                         
        } else if (request.getParameter("delete") != null){          	        	
        	Integer albumid = ServletRequestUtils.getIntParameter(request, "albumid");
        	
        	List<Picture> pictures = pictureDao.listAlbumPicture(albumid);
        	
        	if (pictures != null || !pictures.isEmpty()){
    			for(Iterator itr = pictures.iterator(); itr.hasNext();){
    				Picture pic = (Picture) itr.next();
    				if (pic.getAlbum().getAlbumId().intValue() == albumid.intValue()){
    					pictureDao.deletePicture(pic, false);
    				}    				    			
    			}	        		
        	}
        	
        	albumDao.deleteAlbum((Album)album);
        }
		return new ModelAndView("redirect:albums.htm");
	 }
	
	public void setAlbumDao(AlbumDao albumDao) {
		this.albumDao = albumDao;
	}
	
	public void setPictureDao(PictureDao pictureDao) {
		this.pictureDao = pictureDao;
	}

	class AlbumValidator implements Validator
	{
		public boolean supports(Class clazz){
			return Album.class.isAssignableFrom(clazz);
		}

		public void validate(Object command, Errors errors){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "message.name.filled");			
		}
	}
}

