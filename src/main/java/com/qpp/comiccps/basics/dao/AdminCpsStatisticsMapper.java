package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.AdminCpsStatistics;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminCpsStatisticsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminCpsStatistics record);

    int insertSelective(AdminCpsStatistics record);

    AdminCpsStatistics selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminCpsStatistics record);

    int updateByPrimaryKey(AdminCpsStatistics record);

    // 后台查看cps总统计数据
    AdminCpsStatistics selectCpsTotalDataStatistics(@Param("uid") String uid);

}