package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.DistributorOrderTotal;

public interface DistributorOrderTotalMapper {
    int deleteByPrimaryKey(String id);

    int insert(DistributorOrderTotal record);

    int insertSelective(DistributorOrderTotal record);

    DistributorOrderTotal selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DistributorOrderTotal record);

    int updateByPrimaryKey(DistributorOrderTotal record);
}