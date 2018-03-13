package com.key.msmall.service;

import java.util.List;

import com.key.msmall.pojo.Category;


public interface CategoryService{
    List<Category> list();
    Category get(int id);
}