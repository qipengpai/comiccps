package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.PhoneVerification;

public interface PhoneVerificationMapper {
    int deleteByPrimaryKey(String id);

    int insert(PhoneVerification record);

    int insertSelective(PhoneVerification record);

    PhoneVerification selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhoneVerification record);

    int updateByPrimaryKey(PhoneVerification record);
}