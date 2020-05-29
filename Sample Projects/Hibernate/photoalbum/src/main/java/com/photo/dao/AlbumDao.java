package com.photo.dao;

import java.util.List;

import com.photo.entity.Album;

public interface AlbumDao{
	
	public List<Album> listAlbum();
	public Album getAlbum(Integer id);
	public Album getAlbum(String name);
	public void insertAlbum(Album album);
	public void updateAlbum(Album album);
	public void deleteAlbum(Album album);	
	
}