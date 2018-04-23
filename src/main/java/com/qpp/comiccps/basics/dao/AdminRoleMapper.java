package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.AdminRoleKey;

public interface AdminRoleMapper {
    int deleteByPrimaryKey(AdminRoleKey key);

    int insert(AdminRoleKey record);

    int insertSelective(AdminRoleKey record);
}