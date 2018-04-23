package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.CartoonComment;

public interface CartoonCommentMapper {
    int deleteByPrimaryKey(String id);

    int insert(CartoonComment record);

    int insertSelective(CartoonComment record);

    CartoonComment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CartoonComment record);

    int updateByPrimaryKey(CartoonComment record);
}