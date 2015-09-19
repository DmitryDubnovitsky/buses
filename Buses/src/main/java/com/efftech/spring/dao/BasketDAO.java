package com.efftech.spring.dao;

import java.util.List;

import com.efftech.spring.domain.Basket;

public interface BasketDAO {
	
	public void saveBasket(Basket basket,Long id);

	public List<Basket> basketList();

	public void removeBasket(Long id);
	
	public Basket retriveBasket(Long id);

}