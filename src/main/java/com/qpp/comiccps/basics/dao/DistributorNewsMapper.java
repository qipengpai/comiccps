package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.DistributorNews;

public interface DistributorNewsMapper {
    int deleteByPrimaryKey(String id);

    int insert(DistributorNews record);

    int insertSelective(DistributorNews record);

    DistributorNews selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DistributorNews record);

    int updateByPrimaryKey(DistributorNews record);
}