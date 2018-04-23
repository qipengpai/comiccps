package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.HistoryRecord;

public interface HistoryRecordMapper {
    int deleteByPrimaryKey(String id);

    int insert(HistoryRecord record);

    int insertSelective(HistoryRecord record);

    HistoryRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(HistoryRecord record);

    int updateByPrimaryKey(HistoryRecord record);
}