package com.qpp.comiccps.basics.dao;

import com.github.pagehelper.Page;
import com.qpp.comiccps.basics.entity.UserEntity;
import com.qpp.comiccps.basics.entity.data.AdminFansData;
import com.qpp.comiccps.basics.entity.data.UserOrderProfitNew;
import com.qpp.comiccps.tool.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserEntityMapper {
    int deleteByPrimaryKey(String userid);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);

    //分页查询用户列表
    Page<UserEntity> getAllUserEntity(PageInfo pageInfo);

    //（条件）分页查询用户列表
    Page<UserEntity> getConditionUserEntity(PageInfo pageInfo);

    //分页查询用户列表>1000
    Page<UserEntity> getAllUserEntityBetter1000(PageInfo pageInfo);

    //公众号粉丝分布
    Page<UserOrderProfitNew> selectUserDistribution(PageInfo pageInfo);

    //公众号粉丝性別
    List<AdminFansData> selectUserSex();

    //总用户数
    int getUserEntityTotalCount(@Param("sentry1") String sentry1, @Param("sentry2") String sentry2);

    //查询Svip数量
    int getSvipUserNum(@Param("sentry1") String sentry1, @Param("sentry2") String sentry2);

    //查询vip数量
    int getVipUserNum();

}