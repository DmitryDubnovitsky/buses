package com.efftech.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.efftech.spring.domain.Basket;
import com.efftech.spring.domain.Bus;
import com.efftech.spring.service.BusService;

@Repository
public class BasketDAOImpl implements BasketDAO {
	
   @Autowired
   private BusService busService;
	
   @Autowired
   private SessionFactory sessionFactory;
	 
   public void saveBasket(Basket basket,Long id) {
	Bus bus = busService.retriveBus(id);
	basket.setManufacturer(bus.getManufacturer());
	basket.setName(bus.getName());
	basket.setPrice(bus.getPrice());
	basket.setSeason(bus.getSeason());
	basket.setSize(bus.getSize());
	basket.setDiameter(bus.getDiameter());
	basket.setProportion(bus.getProportion());
    sessionFactory.getCurrentSession().saveOrUpdate(basket);
	}

   @SuppressWarnings("unchecked")
   public List<Basket> basketList() {
    return  sessionFactory.getCurrentSession().getNamedQuery( Basket.NamedQuery.BASKET_FIND_ALL ).list();
	    }
	 
    public void removeBasket(Long id) {
     Basket basket = (Basket) sessionFactory.getCurrentSession().load(
	                Basket.class, id);
        if (null != basket) {
            sessionFactory.getCurrentSession().delete(basket);
	    }
	}
	    
     public  Basket retriveBasket(Long id){
      Query q = sessionFactory.getCurrentSession().
	        		getNamedQuery( Basket.NamedQuery.BASKET_FIND_BY_ID );
	        q.setLong("id", id);
	        return (Basket) q.uniqueResult();
	     }
}