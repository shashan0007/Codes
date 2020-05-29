package com.photo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.photo.entity.Picture;
import com.photo.dao.PictureDao;

public class FormPictureController extends SimpleFormController {
	
	private PictureDao pictureDao;
	
	public FormPictureController(){
		setCommandClass(Picture.class);
		setValidator(new PictureValidator());
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
		throws Exception{
		
		Integer pictureid = ServletRequestUtils.getIntParameter(request, "pictureid");
		
		if (pictureid != null && !"".equals(pictureid)) {
			return pictureDao.getPicture(pictureid);
		}
		else {
			return super.formBackingObject(request);
		}
	}
	
	@Override
	 public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
			 Object picture, BindException errors) throws Exception {		 	
        if (request.getParameter("update") != null) {
            pictureDao.updatePicture((Picture)picture);            
        } else if (request.getParameter("delete") != null){       
        	Picture pic = (Picture)picture;
        	pictureDao.deletePicture(pic, true);        	        
        }
		return new ModelAndView("redirect:albums.htm");
	 }
	
	public void setPictureDao(PictureDao pictureDao) {
		this.pictureDao = pictureDao;
	}
	
	class PictureValidator implements Validator
	{
		public boolean supports(Class clazz){
			return Picture.class.isAssignableFrom(clazz);
		}

		public void validate(Object command, Errors errors){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "message.name.filled");			
		}
	}
}
