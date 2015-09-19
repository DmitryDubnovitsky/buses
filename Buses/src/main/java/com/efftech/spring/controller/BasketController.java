package com.efftech.spring.controller;

import java.awt.Desktop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.efftech.spring.domain.Basket;
import com.efftech.spring.domain.Factory;
import com.efftech.spring.domain.Image;
import com.efftech.spring.service.BasketService;
import com.efftech.spring.service.FactoryService;
import com.efftech.spring.service.ImageService;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;

@Controller
public class BasketController {
	
	@Autowired
    private BasketService basketService;
	
	@Autowired
    private FactoryService factoryService;
	
	@Autowired
    private ImageService userService;
		
    @RequestMapping("/basket/index")
    public String listBus(Map<String, Object> map) {
        map.put("basket", new Basket());
        map.put("basketList", basketService.basketList());
        map.put("imageList", userService.list());
       // map.put("factory", new Factory());
       // map.put("factoryList", factoryService.factoryList());
        return "basket_list";
    }
    
    @RequestMapping(value = "/basket/add/{busId}", method = RequestMethod.POST)
    public String addBus(@ModelAttribute("basket") Basket basket, BindingResult result,@PathVariable("busId") Long busId) {
        basketService.saveBasket(basket,busId);
        System.out.println(busId);
        return "sucess";
    }
    
    @RequestMapping("/basket/delete/{busId}")
    public String deleteBus(@PathVariable("busId") Long busId) {
      basketService.removeBasket(busId);
      System.out.println(busId);
        return "redirect:/basket/index";
    }  
    
    @RequestMapping("/basket/payment/{busId}")
    public String payBus(@PathVariable("busId") Long busId, Map<String, Object> map) {
     Basket basket = basketService.retriveBasket(busId);
     Image image=userService.retriveImage(busId+23);
     map.put("basket", basket);
     map.put("basketList", basketService.basketList());
     map.put("factory",new Factory());
     map.put("factoryList", factoryService.factoryList());
     try {
         File file = new File("C:\\Users\\ִלטענטי\\Desktop\tex.pdf");
         FileOutputStream pdfFileout = new FileOutputStream(file);
         Document doc = new Document();
         PdfWriter.getInstance(doc, pdfFileout);
         doc.open();
         Paragraph para1 = new Paragraph();
         para1.add(basket.getName()+" "+basket.getSize()+"/"+basket.getDiameter()+
        		 " "+basket.getProportion()+" "+basket.getManufacturer()+" "+basket.getPrice());
         doc.add(para1);
         com.lowagie.text.Image image1=com.lowagie.text.Image.getInstance("/home/dmitry/workspac/Buses/src/main/webapp/resources/images/"+image.getImageName());
         doc.add(image1);
         doc.close();
         pdfFileout.close();
         System.out.println("Success!");
     } catch (Exception e) {
         e.printStackTrace();
     }	
        return "payment";
    }
    
    @RequestMapping("/basket/payment/pdf")
    public String listFactory(@ModelAttribute("factory") Factory factory, BindingResult result) throws DocumentException, FileNotFoundException, IOException {
    	System.out.println(factory.getName());
    	if (Desktop.isDesktopSupported()) {
    		PdfReader pdfReader = new PdfReader("../../tex.pdf");	 
            PdfStamper pdfStamper = new PdfStamper(pdfReader,new FileOutputStream("../../text.pdf") );

          PdfContentByte canvas=pdfStamper.getOverContent(1);
          ColumnText.showTextAligned(canvas, Element.ALIGN_TOP, new Phrase("Company:"+factory.getName()+"   "+"Manager:"+factory.getManager()), 36, 820, 0);
          pdfStamper.close();
          pdfReader.close();
          Desktop.getDesktop().open(new File("../../text.pdf"));
    	}
		return "redirect:/basket/index";
    }
}