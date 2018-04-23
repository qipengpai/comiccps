package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.VeryOk;

public interface VeryOkMapper {
    int deleteByPrimaryKey(String id);

    int insert(VeryOk record);

    int insertSelective(VeryOk record);

    VeryOk selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(VeryOk record);

    int updateByPrimaryKey(VeryOk record);
}