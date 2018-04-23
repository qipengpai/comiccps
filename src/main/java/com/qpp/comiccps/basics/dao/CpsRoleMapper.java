package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.CpsRole;

public interface CpsRoleMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(CpsRole record);

    int insertSelective(CpsRole record);

    CpsRole selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(CpsRole record);

    int updateByPrimaryKey(CpsRole record);
}