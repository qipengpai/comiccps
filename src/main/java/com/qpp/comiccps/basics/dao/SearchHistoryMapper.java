package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.SearchHistory;

public interface SearchHistoryMapper {
    int deleteByPrimaryKey(String id);

    int insert(SearchHistory record);

    int insertSelective(SearchHistory record);

    SearchHistory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SearchHistory record);

    int updateByPrimaryKey(SearchHistory record);
}