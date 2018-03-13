package com.key.msmall.service;

import java.util.List;

import com.key.msmall.pojo.Productimage;

public interface ProductImageService {
    String type_single = "type_single";
    String type_detail = "type_detail";
    Productimage get(int id);
    List listi(Integer pid, String type);
}
