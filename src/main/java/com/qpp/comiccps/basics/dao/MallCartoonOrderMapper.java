package com.qpp.comiccps.basics.dao;

import com.github.pagehelper.Page;
import com.qpp.comiccps.basics.entity.MallCartoonOrder;
import com.qpp.comiccps.basics.entity.data.MallCartoonOrderData;
import com.qpp.comiccps.basics.entity.data.MallCartoonOrderTotalData;
import com.qpp.comiccps.tool.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MallCartoonOrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(MallCartoonOrder record);

    int insertSelective(MallCartoonOrder record);

    MallCartoonOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MallCartoonOrder record);

    int updateByPrimaryKey(MallCartoonOrder record);

    // （条件）分页查询咔咔豆订
    Page<MallCartoonOrderData> selectMallCartoonOrder(PageInfo pageInfo);

    // （条件）分页查询咔咔豆订(count)
    Double selectMallCartoonOrder_COUNT();

    // （条件）分页查询咔咔豆订>2000
    Page<MallCartoonOrderData> selectMallCartoonOrder2000(PageInfo pageInfo);

    // （条件）分页查询咔咔豆订>2000(count)
    Double selectMallCartoonOrder2000_COUNT();

    // 查询咔咔豆总和
    Double selectSumMallCartoonOrder(PageInfo pageInfo);

    //（条件）咔咔豆收益
    Page<MallCartoonOrderTotalData> selectMallCartoonOrderTotal(PageInfo pageInfo);

    // 查询咔咔豆总和
    int getBeanSum(@Param("sentry1") String sentry1, @Param("sentry2") String sentry2);
}