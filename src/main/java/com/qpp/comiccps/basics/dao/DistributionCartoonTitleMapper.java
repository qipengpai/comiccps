package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.DistributionCartoonTitle;

public interface DistributionCartoonTitleMapper {
    int deleteByPrimaryKey(String id);

    int insert(DistributionCartoonTitle record);

    int insertSelective(DistributionCartoonTitle record);

    DistributionCartoonTitle selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DistributionCartoonTitle record);

    int updateByPrimaryKey(DistributionCartoonTitle record);
}