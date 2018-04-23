package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.DistributorCartoonModel;

public interface DistributorCartoonModelMapper {
    int deleteByPrimaryKey(String id);

    int insert(DistributorCartoonModel record);

    int insertSelective(DistributorCartoonModel record);

    DistributorCartoonModel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DistributorCartoonModel record);

    int updateByPrimaryKey(DistributorCartoonModel record);
}