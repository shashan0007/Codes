package com.photo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name = "getAlbumByName", query = "from Album where name = :name"),
    @NamedQuery(name = "listAlbumByName", query = "from Album order by name")
})
public class Album implements Serializable{
	
	private Integer albumId;
	private String name;
	private String description;
	private Date creationDate = new Date();
	private List<Picture> pictures = new ArrayList<Picture>();

	public Album(){
	}

	@Id
	@GeneratedValue
	public Integer getAlbumId(){
		return albumId;
	}

	public void setAlbumId(Integer albumId){
		this.albumId = albumId;
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

	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreationDate(){
		return creationDate;
	}

	public void setCreationDate(Date creationDate){
		this.creationDate = creationDate;
	}

	@OneToMany(
		mappedBy="album",
		targetEntity=Picture.class, 
		cascade = CascadeType.ALL, 
		fetch = FetchType.EAGER
	)	
	public List<Picture> getPictures(){
		return pictures;
	}

	public void setPictures(List<Picture> pictures){
		this.pictures = pictures;
	}

}