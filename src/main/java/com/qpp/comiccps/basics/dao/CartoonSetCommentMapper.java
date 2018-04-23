package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.CartoonSetComment;

public interface CartoonSetCommentMapper {
    int deleteByPrimaryKey(String id);

    int insert(CartoonSetComment record);

    int insertSelective(CartoonSetComment record);

    CartoonSetComment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CartoonSetComment record);

    int updateByPrimaryKey(CartoonSetComment record);
}