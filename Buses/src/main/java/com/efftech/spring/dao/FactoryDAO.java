package com.efftech.spring.dao;

import java.util.List;

import com.efftech.spring.domain.Factory;

public interface FactoryDAO {
	
	public void saveFactory (Factory factory);

	public List<Factory> factoryList();

	public void removeFactory(Long id);
	
	public Factory retriveFactory(Long id);

}
