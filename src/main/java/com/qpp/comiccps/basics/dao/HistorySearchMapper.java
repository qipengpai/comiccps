package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.HistorySearch;

public interface HistorySearchMapper {
    int deleteByPrimaryKey(String id);

    int insert(HistorySearch record);

    int insertSelective(HistorySearch record);

    HistorySearch selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(HistorySearch record);

    int updateByPrimaryKey(HistorySearch record);
}