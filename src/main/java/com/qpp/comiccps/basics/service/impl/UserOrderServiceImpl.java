package com.qpp.comiccps.basics.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qpp.comiccps.basics.dao.UserOrderMapper;
import com.qpp.comiccps.basics.entity.UserOrder;
import com.qpp.comiccps.basics.entity.data.UserOrderProfitNew;
import com.qpp.comiccps.tool.PageInfo;
import com.qpp.comiccps.tool.ParaClick;
import com.qpp.comiccps.tool.StringToInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.nio.cs.ext.PCK;

@Service
public class UserOrderServiceImpl {

    @Autowired
    private UserOrderMapper userOrderMapper;

    /**
     *    （条件）分页查询用户订单列表
     *
     * @author pengpai
     * @date 2018/4/23 14:22
     * @param pageInfo
     * @return com.github.pagehelper.Page<com.qpp.comiccps.basics.entity.UserOrder>
     */
    public Page<UserOrder> getAllUserOrder(PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        if (!ParaClick.clickString(pageInfo.getCondition()))
            pageInfo.setCondition2(StringToInt.toInt(pageInfo.getCondition()));
        return userOrderMapper.getAllUserOrder(pageInfo);
    }

    /**
     *    用户订单求和
     *
     * @author pengpai
     * @date 2018/4/25 18:25
     * @param pageInfo
     * @return java.lang.Double
     */
    public Double getAllUserOrderSum(PageInfo pageInfo) {
        if (!ParaClick.clickString(pageInfo.getCondition()))
            pageInfo.setCondition2(StringToInt.toInt(pageInfo.getCondition()));
        return userOrderMapper.getAllUserOrderSum(pageInfo);
    }


    /**  
     *    分页条件查询现金收益列表
     *   
     * @author pengpai 
     * @date 2018/4/25 17:48  
     * @param pageInfo
     * @return com.github.pagehelper.Page<com.qpp.comiccps.basics.entity.data.UserOrderProfitNew>  
     */  
    public Page<UserOrderProfitNew> selectOrderProfitNew(PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        return userOrderMapper.selectOrderProfitNew(pageInfo);
    }

    /**
     *    查询现金收益
     *
     * @author pengpai
     * @date 2018/4/25 17:50
     * @param pageInfo
     * @return java.lang.Double
     */
    public Double selectOrderProfitNewSum(PageInfo pageInfo) {
        return userOrderMapper.selectOrderProfitNewSum(pageInfo.getStartDate(),pageInfo.getEndDate());
    }

    /**
     *    每日定时清除无效订单
     *
     * @author pengpai
     * @date 2018/4/27 14:51
     * @param
     * @return boolean
     */
    public boolean deleteInvalidOrder() {
        int index = userOrderMapper.deleteInvalidOrder();
        if (index<1)
            return false;
        return true;
    }
}
