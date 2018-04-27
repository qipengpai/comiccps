package com.qpp.comiccps.basics.dao;

import com.github.pagehelper.Page;
import com.qpp.comiccps.basics.entity.UserEntity;
import com.qpp.comiccps.tool.PageInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityMapper {
    int deleteByPrimaryKey(String userid);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);

    //分页查询用户列表
    Page<UserEntity> getAllUserEntity(PageInfo pageInfo);

    //（条件）分页查询用户列表
    Page<UserEntity> getConditionUserEntity(PageInfo pageInfo);

    //分页查询用户列表>1000
    Page<UserEntity> getAllUserEntityBetter1000(PageInfo pageInfo);
}