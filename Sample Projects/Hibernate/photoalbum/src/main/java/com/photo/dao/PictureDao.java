package com.photo.dao;

import java.util.List;

import com.photo.entity.Picture;
import com.photo.web.Upload;

public interface PictureDao{

	public enum UploadStatus{
		SUCCESS, EXISTS, INVALID, FAILED
	}

	public List<Picture> listAlbumPicture(Integer id);
	public Picture getPicture(Integer id);
	public void updatePicture(Picture picture);
	public void deletePicture(Picture picture, boolean removeFile);	
	public UploadStatus storePicture(Upload picture);
	
}