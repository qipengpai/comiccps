package com.qpp.comiccps.basics.dao;

import com.github.pagehelper.Page;
import com.qpp.comiccps.basics.entity.MallCartoonOrder;
import com.qpp.comiccps.basics.entity.data.MallCartoonOrderData;
import com.qpp.comiccps.basics.entity.data.MallCartoonOrderTotalData;
import com.qpp.comiccps.tool.PageInfo;
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

    // 查询咔咔豆总和
    Double selectSumMallCartoonOrder(PageInfo pageInfo);

    //（条件）咔咔豆收益
    Page<MallCartoonOrderTotalData> selectMallCartoonOrderTotal(PageInfo pageInfo);
}