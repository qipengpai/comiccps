package com.qpp.comiccps.basics.dao;

import com.github.pagehelper.Page;
import com.qpp.comiccps.basics.entity.Admin;
import com.qpp.comiccps.basics.entity.Distributor;
import com.qpp.comiccps.basics.entity.data.DistributorData;
import com.qpp.comiccps.tool.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributorMapper {
    int deleteByPrimaryKey(String id);

    int insert(Distributor record);

    int insertSelective(Distributor record);

    Distributor selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Distributor record);

    int updateByPrimaryKey(Distributor record);

    // （条件）分页查询分销商列表
    Page<Distributor> getDistributor(PageInfo pageInfo);

    // 增加分销商并绑定CPS
    int addDistributor(DistributorData distributorData);

    // 修改分销商或 修改绑定CPS
    int updateDistributor(DistributorData distributorData);

    // 解除绑定
    int updateDistributorNull(@Param("id") String id,@Param("userType")String userType);

    // 增加已结算收益 并减少未结算收益
    int updateOverReCharge(@Param("overrecharge")Double overrecharge,
                           @Param("balance")Double balance,
                           @Param("id")String id);

    //修改分销商状态为下架
    int updateDistributorState(@Param("id") String id, @Param("state") int state);
}