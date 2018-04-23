package com.qpp.comiccps.basics.dao;

import com.github.pagehelper.Page;
import com.qpp.comiccps.basics.entity.Distributor;
import com.qpp.comiccps.basics.entity.data.DistributorData;
import com.qpp.comiccps.tool.PageInfo;
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

    //修改分销商或 修改绑定CPS
    int updateDistributor(DistributorData distributorData);
}