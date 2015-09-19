package com.efftech.spring.dao;

import java.util.List;

import com.efftech.spring.domain.Image;
import com.efftech.spring.domain.Season;

public interface ImageDAO {
	
 void save(Image uploadFile);
	    
 public List<Image> list();  
 
 public Image retriveImage(Long id);
	    
 public List<Image> findImageByPrice(Float price);
		
 public List<Image> findImageByManuf(String manufacturer);
		 	
 public List<Image> findImageBySize(Integer size,Integer proportion,Integer diameter);
		 	
 public List<Image> findImageBySeason(Season season);   
}