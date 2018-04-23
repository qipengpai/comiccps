package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.FirstType;

public interface FirstTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(FirstType record);

    int insertSelective(FirstType record);

    FirstType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FirstType record);

    int updateByPrimaryKey(FirstType record);
}