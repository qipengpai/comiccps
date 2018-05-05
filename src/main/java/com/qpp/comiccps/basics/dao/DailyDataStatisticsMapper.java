package com.qpp.comiccps.basics.dao;

import com.github.pagehelper.Page;
import com.qpp.comiccps.basics.entity.DailyDataStatistics;
import com.qpp.comiccps.basics.entity.data.AdminFansData;
import com.qpp.comiccps.tool.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyDataStatisticsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DailyDataStatistics record);

    int insertSelective(DailyDataStatistics record);

    DailyDataStatistics selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DailyDataStatistics record);

    int updateByPrimaryKey(DailyDataStatistics record);

    // 后台查看歷史每日统计数据
    Page<DailyDataStatistics> selectDataStatisticsEveryDay(PageInfo pageInfo1);

    // 判斷今天是否生成
    DailyDataStatistics getAllIfExists(@Param("implDate") String implDate);

    // (钱收入)数据趋势统计
    List<AdminFansData> selectDataTrendMapByMoneySum(PageInfo pageInfo1);

    // (豆收入)数据趋势统计
    List<AdminFansData> selectDataTrendMapByBeanSum(PageInfo pageInfo1);

    // (日訪問量)数据趋势统计
    List<AdminFansData> selectDataTrendMapByVisterSum(PageInfo pageInfo1);
}