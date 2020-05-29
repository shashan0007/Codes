package com.photo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import com.photo.entity.Album;
import com.photo.dao.AlbumDao;
import com.photo.dao.PictureDao;
import com.photo.dao.PictureDao.UploadStatus;

public class UploadController extends AbstractWizardFormController{
	
	private AlbumDao albumDao;
	private PictureDao pictureDao;
	
	public UploadController(){
		setCommandClass(Upload.class);
		setCommandName("upload");
		setPages(new String[] {"uploadpicture", "editpicture"});
	}

	@Override
	protected void postProcessPage(HttpServletRequest request, Object command, Errors errors, int page)
		throws Exception{
		if (errors.hasErrors()){
			return;
		}

		Upload upload = (Upload)command;	
		
		if (page == 0){
			UploadStatus status = pictureDao.storePicture(upload);
			if (status.equals(UploadStatus.EXISTS)){
				errors.rejectValue("upload", "error.upload.exists");
			} else if (status.equals(UploadStatus.INVALID)){
				errors.rejectValue("upload", "error.upload.invalid");
			} else if (status.equals(UploadStatus.FAILED)) {
				errors.rejectValue("upload", "error.upload.failed");
			}
		}
	}

	@Override
	protected void validatePage(Object command, Errors errors, int page){
		Upload upload = (Upload)command;
	
		if (page == 0 && upload.getUpload().getSize() <= 0) {
			errors.rejectValue("upload", "error.upload.invalid");			
		}
	}

	@Override
	protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command, BindException e)
			throws Exception {		
		Upload upload = (Upload) command;
		pictureDao.deletePicture(upload.getPicture(), false);
		
		Integer albumid = ServletRequestUtils.getRequiredIntParameter(request,"albumid");		
		return new ModelAndView("redirect:albumpictures.htm?albumid=" + albumid);
	}
	
	@Override
	protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command, BindException e)
		throws Exception {
		Upload upload = (Upload)command;
	
		Integer albumid = ServletRequestUtils.getRequiredIntParameter(request,"albumid");				
		Album album = albumDao.getAlbum(albumid);
	
		upload.getPicture().setAlbum(album);				
		album.getPictures().add(upload.getPicture());
		albumDao.insertAlbum(album);			
	    
		return new ModelAndView("redirect:albums.htm");
	}

		public void setAlbumDao(AlbumDao albumDao){
		this.albumDao = albumDao;
	}

	public void setPictureDao(PictureDao pictureDao){
		this.pictureDao = pictureDao;
	}
}
