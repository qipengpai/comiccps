package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.FriendsVeryOk;

public interface FriendsVeryOkMapper {
    int deleteByPrimaryKey(String id);

    int insert(FriendsVeryOk record);

    int insertSelective(FriendsVeryOk record);

    FriendsVeryOk selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FriendsVeryOk record);

    int updateByPrimaryKey(FriendsVeryOk record);
}