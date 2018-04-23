package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.FollowCartoon;

public interface FollowCartoonMapper {
    int deleteByPrimaryKey(String id);

    int insert(FollowCartoon record);

    int insertSelective(FollowCartoon record);

    FollowCartoon selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FollowCartoon record);

    int updateByPrimaryKey(FollowCartoon record);
}