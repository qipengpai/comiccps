package com.qpp.comiccps.basics.controller;

import com.github.pagehelper.Page;
import com.qpp.comiccps.basics.entity.data.MallCartoonOrderData;
import com.qpp.comiccps.basics.entity.data.MallCartoonOrderTotalData;
import com.qpp.comiccps.basics.service.impl.MallCartoonOrderServiceImpl;
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

import java.util.List;

@RestController
public class MallCartoonOrderController {

    @Autowired
    private MallCartoonOrderServiceImpl mallCartoonOrderService;

    /**
     * （条件）分页查询咔咔豆订
     *
     * @param pageInfo
     * @return com.qpp.comiccps.tool.Model
     * @author pengpai
     * @date 2018/4/25 10:45
     */
    @ApiOperation("（条件）分页查询咔咔豆订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "condition", value = "查詢條件", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页的数量", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开始时间", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", dataType = "String", paramType = "query")
    })
    @PostMapping(value = ActionUrl.SELECT_CARTOON_MALL_ORDER)
    @RequiresPermissions("comicOrder:select")
    public Model selectMallCartoonOrder(PageInfo pageInfo)
            throws Exception {
        PageInfo pageInfo1;
        try{
            pageInfo1=DateUtil.checkPageInfo(pageInfo);
        }catch (RuntimeException e){
            return new Model(500, "时间有误");
        }
        //  （条件）分页查询咔咔豆订
        Page<MallCartoonOrderData> list = mallCartoonOrderService.selectMallCartoonOrder(pageInfo1);
        if (!ParaClick.clickList(list))
            return new Model(500, "查询失败");
        for (MallCartoonOrderData mallCartoonOrderData:list) {
            if (!ParaClick.clickString(mallCartoonOrderData.getUserName()))
                mallCartoonOrderData.setUserName(StringToInt.toString(mallCartoonOrderData.getUserName()));
        }
        // 查询咔咔豆总和
        // Double sum = mallCartoonOrderService.selectSumMallCartoonOrder(pageInfo);
        PageInfo<MallCartoonOrderData> pageInfos = new PageInfo<>(list);
        return new Model(pageInfos);
    }

    @ApiOperation("（条件）咔咔豆收益")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "condition", value = "查詢條件", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页的数量", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开始时间", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", dataType = "String", paramType = "query")
    })
    @PostMapping(value = ActionUrl.SELECT_CARTOON_MALL_ORDER_TOTAL)
    @RequiresPermissions("comicOrder:total")
    public Model selectMallCartoonOrderTotal(PageInfo pageInfo)
            throws Exception {
        PageInfo pageInfo1;
        try{
            pageInfo1=DateUtil.checkTodayTime(pageInfo);
        }catch (RuntimeException e){
            return new Model(500, "时间有误");
        }
        //  （条件）咔咔豆收益
        Page<MallCartoonOrderTotalData> list = mallCartoonOrderService.selectMallCartoonOrderTotal(pageInfo1);
        if (!ParaClick.clickList(list))
            return new Model(500, "查询失败");
        // 查询咔咔豆总和
        Double sum = mallCartoonOrderService.selectSumMallCartoonOrder(pageInfo);
        PageInfo<MallCartoonOrderTotalData> pageInfos = new PageInfo<>(list);
        return new Model(pageInfos, sum);
    }
}
