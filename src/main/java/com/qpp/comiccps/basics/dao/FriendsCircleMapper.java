package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.FriendsCircle;

public interface FriendsCircleMapper {
    int deleteByPrimaryKey(String id);

    int insert(FriendsCircle record);

    int insertSelective(FriendsCircle record);

    FriendsCircle selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FriendsCircle record);

    int updateByPrimaryKey(FriendsCircle record);
}