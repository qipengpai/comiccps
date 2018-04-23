package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.Cartoon;

public interface CartoonMapper {
    int deleteByPrimaryKey(String id);

    int insert(Cartoon record);

    int insertSelective(Cartoon record);

    Cartoon selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Cartoon record);

    int updateByPrimaryKey(Cartoon record);
}