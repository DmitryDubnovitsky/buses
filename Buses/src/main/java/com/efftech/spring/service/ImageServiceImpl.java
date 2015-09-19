package com.efftech.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.efftech.spring.dao.ImageDAO;
import com.efftech.spring.domain.Factory;
import com.efftech.spring.domain.Image;
import com.efftech.spring.domain.Season;

@Service
public class ImageServiceImpl implements ImageService {
	
	@Autowired
	private ImageDAO imageDAO;

	@Transactional
	public void save(Image uploadFile) {
		imageDAO.save(uploadFile);
		
		
	}
	@Transactional
    public List<Image> list() {
        return imageDAO.list();
    }
	
	 @Transactional
	 public Image retriveImage(Long id){
	        return imageDAO.retriveImage(id);
	    }
	
	@Transactional
    public List<Image> findImageByPrice(Float price){
    	return imageDAO.findImageByPrice( price);
    }
    
    @Transactional
	public List<Image> findImageByManuf(String manufacturer) {
	  return imageDAO.findImageByManuf(manufacturer);
	
	}
    @Transactional
	public List<Image> findImageBySeason(Season season) {
		return imageDAO.findImageBySeason(season);
	}
    @Transactional
	public List<Image> findImageBySize(Integer size,Integer proportion,Integer diameter) {
		return imageDAO.findImageBySize(size,proportion,diameter);
	}
    
}