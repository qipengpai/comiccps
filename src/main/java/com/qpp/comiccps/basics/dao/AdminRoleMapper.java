package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.AdminRoleKey;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRoleMapper {
    int deleteByPrimaryKey(AdminRoleKey key);

    int insert(AdminRoleKey record);

    int insertSelective(AdminRoleKey record);
}