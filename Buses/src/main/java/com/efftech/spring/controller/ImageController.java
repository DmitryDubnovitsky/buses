package com.efftech.spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.efftech.spring.domain.Bus;
import com.efftech.spring.domain.Image;
import com.efftech.spring.domain.Season;
import com.efftech.spring.domain.VectorId;
import com.efftech.spring.service.BusService;
import com.efftech.spring.service.ImageService;

@Controller
public class ImageController {
	
	 @Autowired
	 private ImageService imageService;
	 
	 @Autowired
	 private BusService busService;
	 
	 Vector<Long> vector=new Vector<Long>();

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String listBus(Map<String, Object> map) {
        map.put("image", new Image());
        return "home";
    }
    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String listB( @RequestParam CommonsMultipartFile[] fileUpload,Map<String, Object> map) throws IOException {
    	 if (fileUpload != null && fileUpload.length > 0) {
    		Vector<Object> vec=new Vector<Object>();
    		  for (CommonsMultipartFile aFile : fileUpload){
            	 if( aFile.getOriginalFilename().endsWith("xls")){
                 System.out.println("Saving file: " + aFile.getOriginalFilename().endsWith("xls"));
                 FileInputStream file = new FileInputStream(new File("/home/dmitry/workspac/Buses/src/main/webapp/document/"+aFile.getOriginalFilename()) );
                 HSSFWorkbook workbook = new HSSFWorkbook(file);
                 HSSFSheet sheet = workbook.getSheetAt(0);
                 Iterator<Row> rowIterator = sheet.iterator();
                 rowIterator.next();
                 while (rowIterator.hasNext())
                 {
                	 Row row = rowIterator.next();
                     Iterator<Cell> cellIterator = row.cellIterator();
                     while (cellIterator.hasNext())
                     {
                         Cell cell = cellIterator.next();
                         System.out.println(cell);
                         vec.add(cell);                       
                     }  
                 }  
                   if(aFile.getOriginalFilename().equals("Price.xls")){
                	Bus bus=new Bus();
                	for(int i=0;i<vec.size();i++){
                	  bus=busService.retriveBus(VectorId.getInstance().getVector().get(i));
                	  bus.setPrice(Float.parseFloat(vec.get(i).toString()));
                	  busService.saveBus(bus);                		   
                	   }
                   }
                   else {
                  for(int i=0;i<vec.size();i+=6){
                	 Bus bus=new Bus();
                	bus.setName(vec.get(i).toString());
                	bus.setSize(Integer.parseInt(vec.get(i+1).toString().substring(0, 3) ));
                	if(vec.get(i+2).toString().equals("summer")){
                		bus.setSeason(Season.summer);
                	}
                	else if(vec.get(i+2).toString().equals("winter")){
                		bus.setSeason(Season.winter);
                	}
                	bus.setProportion(Integer.parseInt(vec.get(i+3).toString().substring(0, 2) ));
                	bus.setDiameter(Integer.parseInt(vec.get(i+4).toString().substring(0, 2)));
                	bus.setManufacturer(vec.get(i+5).toString());
                	busService.saveBus(bus);
                	if(bus.getPrice()==0.0){
                		vector.add(bus.getId());
                		if(vector.size()>4){
                			vector.clear();
                		}
                		
                		VectorId.getInstance().setVector(vector);
                		System.out.println(vector);
                	     }
                	}
                	List list = workbook.getAllPictures(); 
                	System.out.println(list.size());
                	 for (int i=0; i<list.size(); i++) {
                		 Image image=new Image();
                		 PictureData picture = (PictureData) list.get(i);            
                			  switch(i){
                			  case 0:image.setImageName("bravuris."+picture.suggestFileExtension());
                			  image.setData(picture.getData()); 
                      	      imageService.save(image);
                			  break;
                			  case 1:image.setImageName("polaris."+picture.suggestFileExtension());
                			  image.setData(picture.getData()); 
                      	      imageService.save(image);
                			  break;
                			  case 2:image.setImageName( "kelly."+picture.suggestFileExtension());
                			  image.setData(picture.getData()); 
                      	      imageService.save(image);
                			  break;
                			  case 3:image.setImageName( "zeta."+picture.suggestFileExtension());
                			  image.setData(picture.getData()); 
                      	      imageService.save(image);
                			  break;              			  
                			  }               			  
                	 }                 		                   		                   	   
                	  }
                
                 file.close();  
             }
           }
    	 }
    	 return "redirect:/admin/index";
      }
    
    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String handleFileUpload(
            @RequestParam CommonsMultipartFile[] fileUpload,Map<String, Object> map) {
        if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile aFile : fileUpload){                 
               Image uploadFile = new Image();
                uploadFile.setImageName(aFile.getOriginalFilename()); 
                uploadFile.setData(aFile.getBytes());
               imageService.save(uploadFile);              
            }
        }
        return "redirect:/admin/index";
    }       
}