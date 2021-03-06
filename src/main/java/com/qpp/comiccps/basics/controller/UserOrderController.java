package com.qpp.comiccps.basics.controller;

import com.github.pagehelper.Page;
import com.qpp.comiccps.basics.entity.UserOrder;
import com.qpp.comiccps.basics.entity.data.UserOrderProfitNew;
import com.qpp.comiccps.basics.service.impl.UserOrderServiceImpl;
import com.qpp.comiccps.system.ActionUrl;
import com.qpp.comiccps.tool.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserOrderController {

    @Autowired
    private UserOrderServiceImpl userOrderService;


    /**
     *  （条件）分页查询用户订单列表
     *
     * @author pengpai
     * @date 2018/4/23 14:01
     * @param pageInfo
     * @return com.qpp.comiccps.tool.Model
     */
    @ApiOperation("（条件）分页查询用户订单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "condition", value = "查詢條件",  dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页的数量", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开始时间",  dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", dataType = "String", paramType = "query")
    })
    @PostMapping(value = ActionUrl.ADMIN_GET_ALL_USER_ORDER)
    @RequiresPermissions("userOrder:select")
    public Model getUserEntity(PageInfo pageInfo)
            throws Exception {
        //  查询平台用户列表
        PageInfo pageInfo1;
        try{
            pageInfo1=DateUtil.checkPageInfo(pageInfo);
        }catch (RuntimeException e){
            return new Model(500, "时间有误");
        }
        Page<UserOrder> list = userOrderService.getAllUserOrder(pageInfo1);
        if (!ParaClick.clickList(list))
            return new Model(500, "查询失败");
        for (UserOrder userOrder:list) {
            if (!ParaClick.clickString(userOrder.getOrderusername())) {
                userOrder.setOrderusername(StringToInt.toString(userOrder.getOrderusername()));
            }
        }
        //Double sum = userOrderService.getAllUserOrderSum(pageInfo);
        PageInfo<UserOrder> pageInfos = new PageInfo<>(list);
        return new Model(pageInfos);
    }

}
