package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.CommentVeryOk;

public interface CommentVeryOkMapper {
    int deleteByPrimaryKey(String id);

    int insert(CommentVeryOk record);

    int insertSelective(CommentVeryOk record);

    CommentVeryOk selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CommentVeryOk record);

    int updateByPrimaryKey(CommentVeryOk record);
}