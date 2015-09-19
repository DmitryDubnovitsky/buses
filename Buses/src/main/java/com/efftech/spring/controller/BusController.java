package com.efftech.spring.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.efftech.spring.domain.Bus;
import com.efftech.spring.domain.Factory;
import com.efftech.spring.domain.Image;
import com.efftech.spring.service.BusService;
import com.efftech.spring.service.FactoryService;
import com.efftech.spring.service.ImageService;

@Controller
public class BusController {
	 
   @Autowired
   private BusService busService;
   
   @Autowired
   private FactoryService factoryService;
   
   @Autowired
   private ImageService userService;

   @RequestMapping("/admin/index")
   public String listBus(Map<String, Object> map) {
    map.put("bus", new Bus());
    map.put("image", new Image());
    map.put("factory", new Factory());
    map.put("findBus", new Bus());
    map.put("imageList", userService.list());
    map.put("busList", busService.busList());
    map.put("factoryList", factoryService.factoryList());
       return "admin_list";
    }
   
   @RequestMapping("/admin/addfact")
   public String addFactory(@ModelAttribute("factory") Factory factory, BindingResult result) {
	   if(factory.getName().matches(".*[A-Za-z].*") && factory.getManager().matches(".*[A-Za-z].*")){
	      factoryService.saveFactory(factory);        
	       return "redirect:/admin/index";  }
	   else { return "redirect:/admin/index"; }
    }
   
   
   @RequestMapping("/factory/delete/{factoryId}")
   public String deleteFactory(@PathVariable("factoryId") Long factoryId) {
     factoryService.removeFactory(factoryId);
       return "redirect:/admin/index";
   }
   
   
    
    @RequestMapping(value ="/bus/index", method = RequestMethod.GET)
    public String listAllBus(Map<String, Object> map) {
     map.put("findManuf", new Bus());
     map.put("findPrice", new Bus());
     map.put("findSeason", new Bus());
     map.put("findSize", new Bus());
     map.put("imageList", userService.list());
     map.put("busList", busService.busList());
       return "bus_list";
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public String handleFileUpload(@ModelAttribute("bus") Bus bus, BindingResult result) {
    	System.out.println(bus.getPrice());
    	if(bus.getName().matches(".*[A-Za-z].*")&&bus.getManufacturer().matches(".*[A-Za-z].*")&&(bus.getSize()!=0
    			&& Integer.toString(bus.getSize()).length()==3)&&(bus.getProportion()!=0
    			&& Integer.toString(bus.getProportion()).length()==2)
    			&& (bus.getDiameter()!=0
    			&& Integer.toString(bus.getDiameter()).length()==2)
    			&&(bus.getPrice()!=0.0)){
    	        busService.saveBus(bus);
    			return "redirect:/admin/index/";
    	    	}
    	    	else return "redirect:/admin/index/";
    }   

    @RequestMapping("/admin/delete/{busId}")
    public String deleteBus(@PathVariable("busId") Long busId) {
      busService.removeBus(busId);
        return "redirect:/admin/index";
    }
    
    @RequestMapping("/admin/save")
    public String saveBus(@ModelAttribute("bus") Bus bus, BindingResult result) {
    		if(bus.getName().matches(".*[A-Za-z].*")&&bus.getManufacturer().matches(".*[A-Za-z].*")&&(bus.getSize()!=0
        			&& Integer.toString(bus.getSize()).length()==3)&&(bus.getProportion()!=0
        			&& Integer.toString(bus.getProportion()).length()==2)
        			&& (bus.getDiameter()!=0
        			&& Integer.toString(bus.getDiameter()).length()==2)
        			&&(bus.getPrice()!=0.0)
        			){
      busService.saveBus(bus);
		return "redirect:/admin/edit/" + bus.getId();
    	}
    	else return "redirect:/admin/edit/" + bus.getId();
    }
    
    @RequestMapping("/admin/edit/{busId}")
    public String editBus(@PathVariable("busId") Long busId, Map<String, Object> map) {
      Bus bus = busService.retriveBus(busId);
      map.put("bus", bus); 
      map.put("busList", busService.busList());
        return "admin_edit";
    }
    
    
    
    @RequestMapping("/bus/find")
    public String findBus(@ModelAttribute("findManuf") Bus bus, BindingResult result, Map<String, Object> map) {
    	if(bus.getManufacturer().matches(".*[A-Za-z].*")){
    	map.put("busList", busService.findBusByManuf(bus.getManufacturer()) );
        map.put("imageList",userService.findImageByManuf(bus.getManufacturer())); 
    	 return "list";}
    	else { return "redirect:/bus/index"; }
    } 
    
    @RequestMapping("/bus/price")
    public String findPrice(@ModelAttribute("findPrice") Bus bus, BindingResult result, Map<String, Object> map) {      
    	System.out.println(bus.getPrice());
    	//String s = Float.toString(bus.getPrice());
    	//if(s.matches("^([+-]?\\d*\\.?\\d*)$")){
    	if(bus.getPrice()==0)  { return "redirect:/bus/index"; }
    	else{
    	map.put("busList", busService.findBusByPrice(bus.getPrice()) );
      map.put("imageList",userService.findImageByPrice(bus.getPrice()));
         return "list";}
    	
    }
    
    @RequestMapping("/bus/season")
    public String findSeason(@ModelAttribute("findSeason") Bus bus, BindingResult result, Map<String, Object> map) {
       map.put("busList", busService.findBusBySeason(bus.getSeason()));
       map.put("imageList",userService.findImageBySeason(bus.getSeason()));
          return "list";
    }
    
    @RequestMapping("/bus/size")
    public String findSize(@ModelAttribute("findSize") Bus bus, BindingResult result, Map<String, Object> map) {
    	System.out.println(bus.getSize());
       map.put("busList", busService.findBusBySize(bus.getSize(),bus.getProportion(),bus.getDiameter()) );
       map.put("imageList",userService.findImageBySize(bus.getSize(),bus.getProportion(),bus.getDiameter()));
          return "list";
    }   
}