package com.qpp.comiccps.basics.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qpp.comiccps.basics.dao.FeedBackMapper;
import com.qpp.comiccps.basics.entity.FeedBack;
import com.qpp.comiccps.basics.entity.data.FeedBackData;
import com.qpp.comiccps.tool.PageInfo;
import com.qpp.comiccps.tool.ParaClick;
import com.qpp.comiccps.tool.StringToInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedBackServiceImpl {

    @Autowired
    private FeedBackMapper feedBackMapper;

    /**
     *    （条件）分页查询反馈列表
     *
     * @author pengpai
     * @date 2018/4/23 15:04
     * @param pageInfo
     * @return com.github.pagehelper.Page<com.qpp.comiccps.basics.entity.FeedBack>
     */
    public Page<FeedBackData> getAllFeedBack(PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        if (!ParaClick.clickString(pageInfo.getCondition()))
            pageInfo.setCondition2(StringToInt.toInt(pageInfo.getCondition()));
        return feedBackMapper.getAllFeedBack(pageInfo);
    }
}
