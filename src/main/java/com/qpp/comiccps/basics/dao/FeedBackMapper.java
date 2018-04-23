package com.qpp.comiccps.basics.dao;

import com.github.pagehelper.Page;
import com.qpp.comiccps.basics.entity.FeedBack;
import com.qpp.comiccps.tool.PageInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedBackMapper {
    int deleteByPrimaryKey(String id);

    int insert(FeedBack record);

    int insertSelective(FeedBack record);

    FeedBack selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FeedBack record);

    int updateByPrimaryKey(FeedBack record);

    // （条件）分页查询反馈列表
    Page<FeedBack> getAllFeedBack(PageInfo pageInfo);
}