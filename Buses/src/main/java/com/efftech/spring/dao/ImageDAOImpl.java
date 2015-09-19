package com.efftech.spring.dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.efftech.spring.domain.Factory;
import com.efftech.spring.domain.Image;
import com.efftech.spring.domain.Season;

@Repository
public class ImageDAOImpl implements ImageDAO {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
    public void save(Image uploadFile) {
        sessionFactory.getCurrentSession().saveOrUpdate(uploadFile);
    }
  
    @SuppressWarnings("unchecked")
	public List<Image> list() {
        return sessionFactory.getCurrentSession().
        		getNamedQuery( Image.NamedQuery.Image_FIND_ALL).list();
    }
    
    public Image retriveImage(Long id){
        Query q = sessionFactory.getCurrentSession().
        		getNamedQuery( Image.NamedQuery.Image_FIND_BY_ID );
        q.setLong("id", id);
        return (Image) q.uniqueResult();
     }
    
    @SuppressWarnings("unchecked")
	public List<Image> findImageByManuf(String manufacturer) {
		 Query q = sessionFactory.getCurrentSession().getNamedQuery( Image.NamedQuery.Image_FIND_BY_MANUF );
	     q.setString("manufacturer", "%" + manufacturer + "%");
	     System.out.println(q.list());
	       return (List<Image>) q.list();
	 }
	
    @SuppressWarnings("unchecked")
	public List<Image> findImageBySeason(Season season) {
    	 List<Image> result=null;
    	 if(season.toString().equals("summer")){
    	 result = (List<Image>) sessionFactory.getCurrentSession().createQuery("from Image where id in(select id from Bus where season = 'summer')").list();
    	}
    	if(season.toString().equals("winter")){
    	 result = (List<Image>) sessionFactory.getCurrentSession().createQuery("from Image where id in(select id from Bus where season = 'winter')").list();
    	}
    	   return (List<Image>) result;  
	 }

	@SuppressWarnings("unchecked")
	public List<Image> findImageBySize(Integer size,Integer proportion,Integer diameter) {
		Query q = sessionFactory.getCurrentSession().getNamedQuery( Image.NamedQuery.Image_FIND_BY_SIZE );
		q.setInteger("size", size);
		q.setInteger("proportion", proportion);
		q.setInteger("diameter", diameter);
           return (List<Image>) q.list();
	 }

	@SuppressWarnings("unchecked")
	public List<Image> findImageByPrice(Float price) {
		Query q = sessionFactory.getCurrentSession().
	        	 getNamedQuery( Image.NamedQuery.Image_FIND_BY_PRICE );
	    q.setFloat("price", price );
	         return (List<Image>) q.list();	
	}    
}