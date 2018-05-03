package com.qpp.comiccps.basics.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qpp.comiccps.basics.dao.MallCartoonOrderMapper;
import com.qpp.comiccps.basics.entity.MallCartoonOrder;
import com.qpp.comiccps.basics.entity.data.MallCartoonOrderData;
import com.qpp.comiccps.basics.entity.data.MallCartoonOrderTotalData;
import com.qpp.comiccps.tool.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MallCartoonOrderServiceImpl {

    @Autowired
    private MallCartoonOrderMapper mallCartoonOrderMapper;


    /**
     *    （条件）分页查询咔咔豆订
     *
     * @author pengpai
     * @date 2018/4/25 10:46
     * @param pageInfo
     * @return com.github.pagehelper.Page<com.qpp.comiccps.basics.entity.MallCartoonOrder>
     */
    public Page<MallCartoonOrderData> selectMallCartoonOrder(PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        if (pageInfo.getPageNum()>2000)
            return mallCartoonOrderMapper.selectMallCartoonOrder2000(pageInfo);
        return mallCartoonOrderMapper.selectMallCartoonOrder(pageInfo);
    }

    /**
     *    查询咔咔豆总和
     *
     * @author pengpai
     * @date 2018/4/25 11:41
     * @param pageInfo
     * @return java.lang.Double
     */
    public Double selectSumMallCartoonOrder(PageInfo pageInfo) {
        return mallCartoonOrderMapper.selectSumMallCartoonOrder(pageInfo);
    }



    public Page<MallCartoonOrderTotalData> selectMallCartoonOrderTotal(PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        return mallCartoonOrderMapper.selectMallCartoonOrderTotal(pageInfo);
    }
}
