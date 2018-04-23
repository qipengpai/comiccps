package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.CartoonAllType;

public interface CartoonAllTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(CartoonAllType record);

    int insertSelective(CartoonAllType record);

    CartoonAllType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CartoonAllType record);

    int updateByPrimaryKey(CartoonAllType record);
}