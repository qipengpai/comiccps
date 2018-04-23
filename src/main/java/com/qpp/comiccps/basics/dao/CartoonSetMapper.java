package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.CartoonSet;

public interface CartoonSetMapper {
    int deleteByPrimaryKey(String id);

    int insert(CartoonSet record);

    int insertSelective(CartoonSet record);

    CartoonSet selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CartoonSet record);

    int updateByPrimaryKey(CartoonSet record);
}