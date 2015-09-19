package com.efftech.spring.service;

import java.util.List;

import com.efftech.spring.domain.Bus;
import com.efftech.spring.domain.Factory;


public interface FactoryService {

	public void saveFactory (Factory factory);

	public List<Factory> factoryList();

	public void removeFactory(Long id);
	
	public Factory retriveFactory(Long id);

}
