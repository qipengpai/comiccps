package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.DistributorUserStatistics;

public interface DistributorUserStatisticsMapper {
    int deleteByPrimaryKey(String id);

    int insert(DistributorUserStatistics record);

    int insertSelective(DistributorUserStatistics record);

    DistributorUserStatistics selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DistributorUserStatistics record);

    int updateByPrimaryKey(DistributorUserStatistics record);
}