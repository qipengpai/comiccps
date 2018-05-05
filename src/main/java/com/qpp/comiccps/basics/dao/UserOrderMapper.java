package com.qpp.comiccps.basics.dao;

import com.github.pagehelper.Page;
import com.qpp.comiccps.basics.entity.UserOrder;
import com.qpp.comiccps.basics.entity.data.UserOrderProfitNew;
import com.qpp.comiccps.tool.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserOrder record);

    int insertSelective(UserOrder record);

    UserOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserOrder record);

    int updateByPrimaryKey(UserOrder record);

    // （条件）分页查询用户订单列表
    Page<UserOrder> getAllUserOrder(PageInfo pageInfo);

    // 用户订单求和
    Double getAllUserOrderSum(PageInfo pageInfo);

    // 分页条件查询现金收益列表
    Page<UserOrderProfitNew> selectOrderProfitNew(PageInfo pageInfo);

    // 查询现金收益
    Double selectOrderProfitNewSum(@Param("startDate") String startDate, @Param("endDate") String endDate);

    // 每日定时清除无效订单
    int deleteInvalidOrder();

    // 查询总订单数量
    int getAllPayNum(@Param("sentry1") String sentry1,@Param("sentry2") String sentry2);

    // 查询总付费人数
    int getAllPayPersonNum(@Param("sentry1") String sentry1,@Param("sentry2") String sentry2);

    //查询总付费金额
    int getAllPaySum(@Param("sentry1") String sentry1,@Param("sentry2") String sentry2);

    // 查询 昨日/今日 新增vip数量
    int getVipUserAddNum(@Param("sentry1") String sentry1,@Param("sentry2") String sentry2);


}