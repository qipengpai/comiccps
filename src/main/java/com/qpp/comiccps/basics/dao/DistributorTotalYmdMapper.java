package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.DistributorTotalYmd;

public interface DistributorTotalYmdMapper {
    int deleteByPrimaryKey(String id);

    int insert(DistributorTotalYmd record);

    int insertSelective(DistributorTotalYmd record);

    DistributorTotalYmd selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DistributorTotalYmd record);

    int updateByPrimaryKey(DistributorTotalYmd record);
}