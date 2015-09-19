package com.efftech.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.efftech.spring.domain.Bus;
import com.efftech.spring.domain.Factory;
import com.efftech.spring.service.FactoryService;
import com.efftech.spring.service.ImageService;

@Repository
public class FactoryDAOImpl implements FactoryDAO {
	
	@Autowired
    private FactoryService factoryService;

    @Autowired
    private SessionFactory sessionFactory;
    
   
    public void saveFactory(Factory factory) {
    	
        sessionFactory.getCurrentSession().saveOrUpdate(factory);
    }

    @SuppressWarnings("unchecked")
	public List<Factory> factoryList() {
        return sessionFactory.getCurrentSession().
        		getNamedQuery( Factory.NamedQuery.FACTORY_FIND_ALL ).list();
    }

    public void removeFactory(Long id) {
        Factory factory = (Factory) sessionFactory.getCurrentSession().load(
                Factory.class, id);
        if (null != factory) {
            sessionFactory.getCurrentSession().delete(factory);
         }
     }
    public  Factory retriveFactory(Long id){
        Query q = sessionFactory.getCurrentSession().
        		getNamedQuery( Factory.NamedQuery.FACTORY_FIND_BY_ID );
        q.setLong("id", id);
        return (Factory) q.uniqueResult();
     }

}
