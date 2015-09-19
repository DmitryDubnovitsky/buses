package com.efftech.spring.dao;
import java.util.List;
import java.util.Vector;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.efftech.spring.domain.Bus;
import com.efftech.spring.domain.Season;
import com.efftech.spring.service.ImageService;

@Repository
public class BusDAOImpl implements BusDAO {
	
	@Autowired
    private ImageService userService;

    @Autowired
    private SessionFactory sessionFactory;
    
   
    public void saveBus(Bus bus) {
    	
        sessionFactory.getCurrentSession().saveOrUpdate(bus); }

    @SuppressWarnings("unchecked")
	public List<Bus> busList() {
        return sessionFactory.getCurrentSession().
        		getNamedQuery( Bus.NamedQuery.BUS_FIND_ALL ).list();
    }

    public void removeBus(Long id) {
        Bus bus = (Bus) sessionFactory.getCurrentSession().load(
                Bus.class, id);
        if (null != bus) {
            sessionFactory.getCurrentSession().delete(bus);
         }
     }
    
    public  Bus retriveBus(Long id){
        Query q = sessionFactory.getCurrentSession().
        		getNamedQuery( Bus.NamedQuery.Bus_FIND_BY_ID );
        q.setLong("id", id);
        return (Bus) q.uniqueResult();
     }

    @SuppressWarnings("unchecked")
	public List<Bus> findBusByPrice(Float price){
        Query q = sessionFactory.getCurrentSession().
        	 getNamedQuery( Bus.NamedQuery.Bus_FIND_BY_PRICE );
        q.setFloat("price", price );
        return (List<Bus>) q.list();
     }

	public void updateBus(Bus bus) {
	    sessionFactory.getCurrentSession().update(bus);
	        }

	public void updateBus(Float price) {
		sessionFactory.getCurrentSession().update(price);
		
	 }
	
	@SuppressWarnings("unchecked")
	public List<Bus> findBusByManuf(String manufacturer) {
		 Query q = sessionFactory.getCurrentSession().getNamedQuery( Bus.NamedQuery.Bus_FIND_BY_MANUF );
	     q.setString("manufacturer", "%" + manufacturer + "%");
	       return (List<Bus>) q.list();
	 }
	
    @SuppressWarnings("unchecked")
	public List<Bus> findBusBySeason(Season season) {
	 Query q;
		 if(season.toString().equals("summer")){
		   q = sessionFactory.getCurrentSession().createQuery("from Bus  where season = :season")
					 .setParameter("season", Season.summer); }
		 else  {
		   q = sessionFactory.getCurrentSession().createQuery("from Bus  where season = :season")
					 .setParameter("season", Season.winter); 
		  }
          return (List<Bus>) q.list();  
	 }

	@SuppressWarnings("unchecked")
	public List<Bus> findBusBySize(Integer size,Integer proportion,Integer diameter) {
		Query q = sessionFactory.getCurrentSession().getNamedQuery( Bus.NamedQuery.Bus_FIND_BY_SIZE )
				.setInteger("size", size);
		q.setInteger("proportion", proportion);
		q.setInteger("diameter", diameter);
		System.out.println(q.list().toString());
        return (List<Bus>) q.list();
	 }
}