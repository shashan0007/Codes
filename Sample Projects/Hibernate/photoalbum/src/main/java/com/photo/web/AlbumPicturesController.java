package com.photo.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.photo.dao.AlbumDao;
import com.photo.dao.PictureDao;
import com.photo.entity.Picture;

public class AlbumPicturesController extends AbstractController {

	private AlbumDao albumDao;
	private PictureDao pictureDao;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) 
		throws Exception{
		
		Integer albumid = ServletRequestUtils.getRequiredIntParameter(request ,"albumid");
				
		List<Picture> pictures = pictureDao.listAlbumPicture(albumid);

		if (pictures == null || pictures.isEmpty()){	
			ModelAndView mav = new ModelAndView("forward:upload.htm?albumid=" + albumid);
			return mav.addObject("message", "message.form.formpicture");			
		} 
		else{
			String view = ServletRequestUtils.getStringParameter(request, "view");
			ModelAndView mav = new ModelAndView(view);
			return mav.addObject(albumDao.getAlbum(albumid));
		}
	}
	
	public void setAlbumDao(AlbumDao albumDao) {
		this.albumDao = albumDao;
	}
	
	public void setPictureDao(PictureDao pictureDao) {
		this.pictureDao = pictureDao;
	}
}	

