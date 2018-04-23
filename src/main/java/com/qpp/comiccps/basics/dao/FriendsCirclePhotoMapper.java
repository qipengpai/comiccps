package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.FriendsCirclePhoto;

public interface FriendsCirclePhotoMapper {
    int deleteByPrimaryKey(String id);

    int insert(FriendsCirclePhoto record);

    int insertSelective(FriendsCirclePhoto record);

    FriendsCirclePhoto selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FriendsCirclePhoto record);

    int updateByPrimaryKey(FriendsCirclePhoto record);
}