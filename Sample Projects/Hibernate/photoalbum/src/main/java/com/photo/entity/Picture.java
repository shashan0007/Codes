package com.photo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.ManyToOne;

@Entity
@NamedQueries({
	@NamedQuery(name = "albumPicture", query = "from Picture p where p.album.albumId = ?1")
})
public class Picture {
	
	private Integer pictureId;
	private String name;
	private String description;
	private long size;
	private String path;
	private String file;
	public Album album;

	public Picture(){
	}

	@Id
	@GeneratedValue
	public Integer getPictureId(){
		return pictureId;
	}

	public void setPictureId(Integer pictureId){
		this.pictureId = pictureId;
	}

	@Column(nullable = false, length = 25)
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}	

	@Column(nullable = true, length = 50)
	public String getDescription(){
		return description;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public long getSize(){
		return size;
	}

	public void setSize(long size){
		this.size = size;
	}
	
	@Column(nullable = false, length = 50)
	public String getPath(){
		return path;
	}
	
	public void setPath(String path){		
		this.path = path;
	}
	
	@Column(nullable = false, length = 20)
	public String getFile(){
		return file;
	}
	
	public void setFile(String file){		
		this.file = file;
	}
	
	@ManyToOne
	@JoinColumn(name="albumid")
	public Album getAlbum(){
		return album;
	}
	
	public void setAlbum(Album album){
		this.album = album;
	}
}