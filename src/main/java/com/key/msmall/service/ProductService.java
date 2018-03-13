package com.key.msmall.service;

import java.util.List;

import com.key.msmall.pojo.Category;
import com.key.msmall.pojo.Product;

public interface ProductService {
	Product get(int id);
	List list(int cid);
	List listall();
	void fill(Category c);
	void fill(List<Category> cs);
    void fillByRow(List<Category> cs);
    void setFirstProductImage(Product p);
}
