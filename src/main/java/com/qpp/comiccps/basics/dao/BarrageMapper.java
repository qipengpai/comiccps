package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.Barrage;

public interface BarrageMapper {
    int deleteByPrimaryKey(String id);

    int insert(Barrage record);

    int insertSelective(Barrage record);

    Barrage selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Barrage record);

    int updateByPrimaryKey(Barrage record);
}