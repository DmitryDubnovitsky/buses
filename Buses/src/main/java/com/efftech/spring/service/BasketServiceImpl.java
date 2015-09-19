package com.efftech.spring.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.efftech.spring.dao.BasketDAO;
import com.efftech.spring.domain.Basket;

@Service
public class BasketServiceImpl implements BasketService {
	
	@Autowired
    private BasketDAO userDAO;
	
	@Transactional
	public void saveBasket(Basket basket,Long id) {
        userDAO.saveBasket(basket,id);
	 }

    @Transactional
    public List<Basket> basketList() {
        return userDAO.basketList();
	}

    @Transactional
    public void removeBasket(Long id) {
        userDAO.removeBasket(id);
    }

    @Transactional
	public Basket retriveBasket(Long id) {
		return userDAO.retriveBasket(id);
	}	
}