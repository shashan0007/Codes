package com.photo.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.photo.entity.Album;
import com.photo.dao.AlbumDao;

public class AlbumsController extends AbstractController{
	
	private AlbumDao albumDao;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
		throws Exception{
		
		List<Album> albums = albumDao.listAlbum();
		
		if (albums == null || albums.isEmpty()){			
			ModelAndView mav = new ModelAndView("forward:formalbum.htm");
			return mav.addObject("message", "message.form.formalbum");			
		} else {
			ModelAndView mav = new ModelAndView();
			return mav.addObject(albums);
		}		
	}
	
	public void setAlbumDao(AlbumDao albumDao){
		this.albumDao = albumDao;
	}
}