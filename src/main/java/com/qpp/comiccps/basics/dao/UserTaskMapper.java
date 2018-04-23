package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.UserTask;

public interface UserTaskMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserTask record);

    int insertSelective(UserTask record);

    UserTask selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserTask record);

    int updateByPrimaryKey(UserTask record);
}