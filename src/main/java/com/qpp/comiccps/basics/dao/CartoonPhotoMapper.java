package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.CartoonPhoto;

public interface CartoonPhotoMapper {
    int deleteByPrimaryKey(String id);

    int insert(CartoonPhoto record);

    int insertSelective(CartoonPhoto record);

    CartoonPhoto selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CartoonPhoto record);

    int updateByPrimaryKey(CartoonPhoto record);
}