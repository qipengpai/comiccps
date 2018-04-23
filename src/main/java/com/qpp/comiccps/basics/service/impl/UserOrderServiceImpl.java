package com.qpp.comiccps.basics.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qpp.comiccps.basics.dao.UserOrderMapper;
import com.qpp.comiccps.basics.entity.UserOrder;
import com.qpp.comiccps.tool.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return userOrderMapper.getAllUserOrder(pageInfo);
    }
}
