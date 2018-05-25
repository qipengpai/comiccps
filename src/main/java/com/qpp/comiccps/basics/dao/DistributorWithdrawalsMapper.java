package com.qpp.comiccps.basics.dao;

import com.github.pagehelper.Page;
import com.qpp.comiccps.basics.entity.DistributorWithdrawals;
import com.qpp.comiccps.basics.entity.data.UserOrderProfitNew;
import com.qpp.comiccps.basics.entity.data.WithdrawalsStatistics;
import com.qpp.comiccps.tool.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistributorWithdrawalsMapper {
    int deleteByPrimaryKey(String id);

    int insert(DistributorWithdrawals record);

    int insertSelective(DistributorWithdrawals record);

    DistributorWithdrawals selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DistributorWithdrawals record);

    int updateByPrimaryKey(DistributorWithdrawals record);

    // （条件）分页查看分销商结算单
    Page<DistributorWithdrawals> selectDistributorWithdrawals(@Param("withdrawalsState")String withdrawalsState,
                                                              @Param("startDate")String startDate,
                                                              @Param("condition")String condition,
                                                              @Param("endDate")String endDate,
                                                              @Param("uid")String uid);

    // 打款后完成订单
    int finishDistributorWithdrawals(@Param("id")String id);

    // 结算单求和
    Double selectSumDistributorWithdrawals(@Param("withdrawalsState")String withdrawalsState,
                                           PageInfo pageInfo,
                                           @Param("uid") String uid);

    // 分页条件查询现金收益列表
    Page<WithdrawalsStatistics> selectOrderProfitNew(PageInfo pageInfo1);

    // cps昨日流水
    WithdrawalsStatistics yestodayCpsDataStatistics(@Param("uid") String uid, @Param("startDate") String startDate);

    //本月流水與收益
    List<WithdrawalsStatistics> cpsMonthDataStatistics(@Param("uid") String uid);

    List<WithdrawalsStatistics> selectOrderProfitNew2(@Param("startDate")String startDate,@Param("endDate") String endDate);
}