package com.key.msmall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.key.msmall.mapper.ProductMapper;
import com.key.msmall.pojo.Category;
import com.key.msmall.pojo.CategoryExample;
import com.key.msmall.pojo.Product;
import com.key.msmall.pojo.ProductExample;
import com.key.msmall.pojo.Productimage;
import com.key.msmall.service.CategoryService;
import com.key.msmall.service.ProductImageService;
import com.key.msmall.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMapper productMapper;
	@Autowired
	CategoryService categoryService;
	@Autowired
    ProductImageService productImageService;
	 
	@Override
    public Product get(int id) {
        Product p = productMapper.selectByPrimaryKey(id);
        setCategory(p);
        return p;
    }
    public void setCategory(List<Product> ps){
        for (Product p : ps)
            setCategory(p);
    }
    public void setCategory(Product p){
        int cid = p.getCid();
        Category c = categoryService.get(cid);
        p.setCategory(c);
    }

	@Override
	public List list(int cid) {
        ProductExample example = new ProductExample();
        example.createCriteria().andCidEqualTo(cid);   //选cid类别相同的
        example.setOrderByClause("id desc");
        List result = productMapper.selectByExample(example);
        setFirstProductImage(result);
        setCategory(result);       
        return result;
	}
	
	@Override
	public List listall(){
		ProductExample example =new ProductExample();
	    example.setOrderByClause("id desc");
	    return productMapper.selectByExample(example);
	}
	
	@Override
    public void fill(List<Category> cs) {
        for (Category c : cs) {
            fill(c);
        }
    }
 
    @Override
    public void fill(Category c) {
        List<Product> ps = list(c.getId());
        c.setProducts(ps);
    }
    
    @Override
    public void fillByRow(List<Category> cs) {
        int productNumberEachRow = 8;
        for (Category c : cs) {
            List<Product> products =  c.getProducts();
            List<List<Product>> productsByRow =  new ArrayList<>();
            for (int i = 0; i < products.size(); i+=productNumberEachRow) {
                int size = i+productNumberEachRow;
                size= size>products.size()?products.size():size;
                List<Product> productsOfEachRow =products.subList(i, size);
                productsByRow.add(productsOfEachRow);
            }
            c.setProductsByRow(productsByRow);
        }
    }

    @Override
    public void setFirstProductImage(Product p) {
    	
        List<Productimage> pis = productImageService.listi(p.getId(), ProductImageService.type_single);//列出一个产品对应的所有图片
        
        if (!pis.isEmpty()) {
            Productimage pi = pis.get(0);

            p.setFirstProductImage(pi);
        }
    }
    
    public void setFirstProductImage(List<Product> ps) {
        for (Product p : ps) {
            setFirstProductImage(p);
        }
    }
    
    
    
}
