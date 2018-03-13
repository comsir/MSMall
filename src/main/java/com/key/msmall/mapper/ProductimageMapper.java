package com.key.msmall.mapper;


import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.key.msmall.pojo.Productimage;
import com.key.msmall.pojo.ProductimageExample;

public interface ProductimageMapper {
    int countByExample(ProductimageExample example);

    int deleteByExample(ProductimageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Productimage record);

    int insertSelective(Productimage record);

    List<Productimage> selectByExample(ProductimageExample example);

    Productimage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Productimage record, @Param("example") ProductimageExample example);

    int updateByExample(@Param("record") Productimage record, @Param("example") ProductimageExample example);

    int updateByPrimaryKeySelective(Productimage record);

    int updateByPrimaryKey(Productimage record);
}