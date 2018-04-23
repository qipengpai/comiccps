package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.DistributorOrder;

public interface DistributorOrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(DistributorOrder record);

    int insertSelective(DistributorOrder record);

    DistributorOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DistributorOrder record);

    int updateByPrimaryKey(DistributorOrder record);
}