package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.RoleMenuKey;

public interface RoleMenuMapper {
    int deleteByPrimaryKey(RoleMenuKey key);

    int insert(RoleMenuKey record);

    int insertSelective(RoleMenuKey record);
}