package com.key.msmall.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.key.msmall.pojo.Category;
import com.key.msmall.pojo.Product;
import com.key.msmall.service.CategoryService;
import com.key.msmall.service.ProductImageService;
import com.key.msmall.service.ProductService;

@Controller
@RequestMapping("")
public class HomeController {
	@Autowired
    CategoryService categoryService;
	@Autowired
	ProductService productService;
	
    @RequestMapping("home_list")
    public String list(Model model){
    	
        List<Category> cs = categoryService.list();
               
        productService.fill(cs);
        
        productService.fillByRow(cs);
        
        model.addAttribute("cs", cs);
        
//        for(Category c:cs){
//        	for(List<Product> p:c.getProductsByRow()){
//        		for(Product pp:p){
//        			System.out.println(pp.getSubtitle());;
//        		}
//        	}
//        	System.out.println("----------------------------");
//        }
//        
        return "/fore/home";
    }
    
    @RequestMapping("forecategory")
//    public String category(@RequestParam("cid")int cid, Model model) {
//    	
//    	System.out.println("**********************"+cid);
//    	
//    	
//    	
//    	
//
//    	
//    	return "/fore/category";
//    }
    public String category(int cid,String sort, Model model) {
    	System.out.println("**********************"+cid);
        Category c = categoryService.get(cid);
        productService.fill(c);
//
      
        model.addAttribute("c", c);
        return "fore/category";
    }
    
    
}
