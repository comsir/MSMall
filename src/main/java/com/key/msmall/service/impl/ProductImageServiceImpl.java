package com.key.msmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.key.msmall.mapper.ProductimageMapper;
import com.key.msmall.pojo.Productimage;
import com.key.msmall.pojo.ProductimageExample;
import com.key.msmall.service.ProductImageService;

@Service
public class ProductImageServiceImpl implements ProductImageService {
	
	@Autowired
	ProductimageMapper productimageMapper;
	
	@Override
    public Productimage get(int id) {
        return productimageMapper.selectByPrimaryKey(id);
    }

    @Override
    public List listi(Integer pid, String type) {
        ProductimageExample example =new ProductimageExample();
        example.createCriteria()  //设定要取得产品的标准
                .andPidEqualTo(pid)
                .andTypeEqualTo(type);
        example.setOrderByClause("id desc");
        return productimageMapper.selectByExample(example);
    }

}
