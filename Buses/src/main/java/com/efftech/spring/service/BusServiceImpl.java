package com.efftech.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.efftech.spring.dao.BusDAO;
import com.efftech.spring.domain.Bus;
import com.efftech.spring.domain.Season;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusDAO userDAO;

    @Transactional
    public void saveBus(Bus bus) {
        userDAO.saveBus(bus);
    }

    @Transactional
    public List<Bus> busList() {
        return userDAO.busList();
    }

    @Transactional
    public void removeBus(Long id) {
        userDAO.removeBus(id);
    }
    
    @Transactional
    public Bus retriveBus(Long id){
        return userDAO.retriveBus(id);
    }
    
    @Transactional
    public List<Bus> findBusByPrice(Float price){
    	return userDAO.findBusByPrice( price);
    }
    
    @Transactional
	public List<Bus> findBusByManuf(String manufacturer) {
    	// System.out.println("jgmjerm"+manufacturer);
	  return userDAO.findBusByManuf(manufacturer);
    	 
    } 
    	 
    @Transactional
	public List<Bus> findBusBySeason(Season season) {
		return userDAO.findBusBySeason(season);
	}
    
    @Transactional
	public List<Bus> findBusBySize(Integer size,Integer proportion,Integer diameter) {
		return userDAO.findBusBySize(size,proportion,diameter);
	}
}