package com.efftech.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.efftech.spring.dao.FactoryDAO;
import com.efftech.spring.domain.Bus;
import com.efftech.spring.domain.Factory;

@Service
public class FactoryServiceImpl implements FactoryService {

	@Autowired
    private FactoryDAO factoryDAO;

    @Transactional
    public void saveFactory(Factory factory) {
    	factoryDAO.saveFactory(factory);
    }

    @Transactional
    public List<Factory> factoryList() {
        return factoryDAO.factoryList();
    }

    @Transactional
    public void removeFactory(Long id) {
    	factoryDAO.removeFactory(id);
    }
	
    @Transactional
    public Factory retriveFactory(Long id){
        return factoryDAO.retriveFactory(id);
    }

}
