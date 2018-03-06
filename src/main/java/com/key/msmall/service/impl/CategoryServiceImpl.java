package com.key.msmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.key.msmall.mapper.CategoryMapper;
import com.key.msmall.pojo.Category;
import com.key.msmall.service.CategoryService;

@Service
public class CategoryServiceImpl  implements CategoryService {
	 @Autowired
	 CategoryMapper categoryMapper;
	  public List<Category> list(){
	     return categoryMapper.list();
	  }
}

