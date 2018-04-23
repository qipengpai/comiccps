package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.DistributionCover;

public interface DistributionCoverMapper {
    int deleteByPrimaryKey(String id);

    int insert(DistributionCover record);

    int insertSelective(DistributionCover record);

    DistributionCover selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DistributionCover record);

    int updateByPrimaryKey(DistributionCover record);
}