package com.efftech.spring.dao;

import com.efftech.spring.domain.Bus;
import com.efftech.spring.domain.Season;

import java.util.List;

public interface BusDAO {

public void saveBus(Bus bus);

public List<Bus> busList();

public void removeBus(Long id);

public Bus retriveBus(Long id);
    
public List<Bus> findBusByPrice(Float price);
    
public List<Bus> findBusByManuf(String manufacturer);
    
public List<Bus> findBusBySize(Integer size,Integer proportion,Integer diameter);

public List<Bus> findBusBySeason(Season season);
}