package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.CartoonTask;

public interface CartoonTaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CartoonTask record);

    int insertSelective(CartoonTask record);

    CartoonTask selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CartoonTask record);

    int updateByPrimaryKey(CartoonTask record);
}