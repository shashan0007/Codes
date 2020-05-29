package com.photo.web;

import org.springframework.web.multipart.MultipartFile;

import com.photo.entity.Picture;

public class Upload{
	private MultipartFile upload;
	private Picture picture;
	
	public MultipartFile getUpload(){
		return upload;
	}

	public void setUpload(MultipartFile upload){
		this.upload = upload;
	}

	public Picture getPicture(){
		return picture;
	}

	public void setPicture(Picture picture){
		this.picture = picture;
	}	
}