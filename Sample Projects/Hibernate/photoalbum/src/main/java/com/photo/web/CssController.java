package com.photo.web;

import java.util.Map;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class CssController extends AbstractController {
	private String color, fontFamily;	
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
		throws Exception{
		ModelAndView mav = new ModelAndView(new CssView());
		Map<String,Object> referenceData = new HashMap<String,Object>();
		referenceData.put("color", this.color);
		referenceData.put("fontFamily", this.fontFamily);		
		mav.addAllObjects(referenceData);
		return mav;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public void setFontFamily(String fontFamily){
		this.fontFamily = fontFamily;
	}	
}
