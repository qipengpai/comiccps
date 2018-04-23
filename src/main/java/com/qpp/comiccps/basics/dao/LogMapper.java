package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.Log;

public interface LogMapper {
    int deleteByPrimaryKey(String logId);

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(String logId);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
}