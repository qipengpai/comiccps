package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.DistributorWithdrawals;

public interface DistributorWithdrawalsMapper {
    int deleteByPrimaryKey(String id);

    int insert(DistributorWithdrawals record);

    int insertSelective(DistributorWithdrawals record);

    DistributorWithdrawals selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DistributorWithdrawals record);

    int updateByPrimaryKey(DistributorWithdrawals record);
}