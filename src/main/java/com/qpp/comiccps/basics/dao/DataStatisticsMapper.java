package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.DataStatistics;
import org.springframework.stereotype.Repository;

@Repository
public interface DataStatisticsMapper {
    int deleteByPrimaryKey(String id);

    int insert(DataStatistics record);

    int insertSelective(DataStatistics record);

    DataStatistics selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DataStatistics record);

    int updateByPrimaryKey(DataStatistics record);
}