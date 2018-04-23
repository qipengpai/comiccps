package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.Administrators;

public interface AdministratorsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Administrators record);

    int insertSelective(Administrators record);

    Administrators selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Administrators record);

    int updateByPrimaryKey(Administrators record);
}