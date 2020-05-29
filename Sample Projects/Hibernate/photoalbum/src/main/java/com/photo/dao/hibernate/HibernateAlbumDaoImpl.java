package com.photo.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.photo.dao.AlbumDao;
import com.photo.entity.Album;

public class HibernateAlbumDaoImpl extends HibernateDaoSupport implements AlbumDao{
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Album> listAlbum(){		
		return (List<Album>)getHibernateTemplate().findByNamedQuery("listAlbumByName");
	}

	@Transactional
	public Album getAlbum(Integer id){	
		return (Album)getHibernateTemplate().get(Album.class, id);
	}	

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public Album getAlbum(String name){
		Session session = getSession();		
		try{
			Query query = session.getNamedQuery("getAlbumByName");
			query.setParameter("name", name);
			return (Album)query.uniqueResult();
		}finally{
			releaseSession(session);
		}
	}

	@Transactional
	public void insertAlbum(Album album){
	  getHibernateTemplate().saveOrUpdate(album);		
	}

	@Transactional
	public void updateAlbum(Album album) {
      getHibernateTemplate().update(album);
    }

	@Transactional
    public void deleteAlbum(Album album) {
      getHibernateTemplate().delete(album);
    }	
}