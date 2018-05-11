package com.qpp.comiccps.basics.dao;

import com.github.pagehelper.Page;
import com.qpp.comiccps.basics.entity.AdminCpsStatisticsDay;
import com.qpp.comiccps.tool.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminCpsStatisticsDayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminCpsStatisticsDay record);

    int insertSelective(AdminCpsStatisticsDay record);

    AdminCpsStatisticsDay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminCpsStatisticsDay record);

    int updateByPrimaryKey(AdminCpsStatisticsDay record);

    // 后台查看cps统计数据
    Page<AdminCpsStatisticsDay> selectCpsDataStatistics(@Param("startDate") String startDate,
                                                        @Param("endDate") String endDate,
                                                        @Param("uid") String uid);
}