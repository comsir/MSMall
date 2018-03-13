package com.key.msmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.key.msmall.pojo.Category;
import com.key.msmall.pojo.Product;
import com.key.msmall.service.CategoryService;
import com.key.msmall.service.ProductService;

@Controller
@RequestMapping("")
public class CategoryController {
	
    @Autowired
    CategoryService categoryService;
  
    @RequestMapping("admin_category_list")
    public String listCategory(Model model){
        List<Category> cs= categoryService.list();
        model.addAttribute("cs", cs);
        return "/admin/listCategory";
    }

}