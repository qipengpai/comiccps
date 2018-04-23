package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.Member;

public interface MemberMapper {
    int deleteByPrimaryKey(String uid);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}