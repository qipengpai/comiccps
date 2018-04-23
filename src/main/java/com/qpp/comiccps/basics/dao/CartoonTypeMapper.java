package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.CartoonType;

public interface CartoonTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(CartoonType record);

    int insertSelective(CartoonType record);

    CartoonType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CartoonType record);

    int updateByPrimaryKey(CartoonType record);
}