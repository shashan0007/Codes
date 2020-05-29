package com.photo.dao.hibernate;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.FileCopyUtils;

import com.photo.dao.PictureDao;
import com.photo.entity.Picture;
import com.photo.web.Upload;

public class HibernatePictureDaoImpl extends HibernateDaoSupport implements PictureDao {
	
	private String root = System.getProperty("webapp.root");
	private boolean deleteOnShutdown = true;		
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
    public List<Picture> listAlbumPicture(Integer id) {
		Session session = getSession();	
		Query query = session.getNamedQuery("albumPicture");
		query.setParameter("1", id);
		return query.list();		
	}
	
	@Transactional
	public Picture getPicture(Integer id){	
		return (Picture)getHibernateTemplate().get(Picture.class, id);
	}
	
	@Transactional
	public void updatePicture(Picture picture){
		getHibernateTemplate().update(picture);
	}
	
	@Transactional
	public void deletePicture(Picture picture, boolean isRemovePic){
		try {
			if (isRemovePic == true){
				getHibernateTemplate().delete(picture);						
			}
		}finally {
			String location = picture.getPath() + picture.getFile();
			File file = new File(this.root + location);
			file.delete();
		}
	}
		
	public PictureDao.UploadStatus storePicture(Upload upload){
		if (upload.getUpload() == null || root == null){
			throw new IllegalArgumentException("A picture cannot be stored if the file or repository doesnt exists.");
		}	

		StringBuffer target = new StringBuffer();
		target.append("myPicture");
		target.append(File.separator);
		
		String path = target.toString();
		
		target.insert(0, this.root);
		
		File dir = new File(target.toString());
		if (!dir.exists()){
			dir.mkdirs();
		}

		String fileName = upload.getUpload().getOriginalFilename();
		if (fileName == null || "".equals(fileName)){
			fileName = upload.getUpload().getName();
		}
		target.append(fileName);
		
		File targetFile = new File(target.toString());
		if (targetFile.exists()){
			return UploadStatus.EXISTS;
		}

		if (deleteOnShutdown){
			targetFile.deleteOnExit();
		}

		try{
			if (ImageIO.read(upload.getUpload().getInputStream()) == null ){
				return UploadStatus.INVALID;
			}
		}catch (IOException e){
			e.printStackTrace();
			return UploadStatus.FAILED;
		}

		try{
			FileCopyUtils.copy(upload.getUpload().getBytes(), targetFile);
 		}catch(IOException e){
			e.printStackTrace();
			return UploadStatus.FAILED;
		}

		Picture picture = upload.getPicture();
		if (upload.getPicture() == null){
			picture = new Picture();
			upload.setPicture(picture);
		}
		picture.setPath(path);
		picture.setFile(fileName);		
		picture.setSize(upload.getUpload().getSize());

		return UploadStatus.SUCCESS;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public void setDeleteOnShutdown(boolean deleteOnShutdown) {
		this.deleteOnShutdown = deleteOnShutdown;
	}
	
}