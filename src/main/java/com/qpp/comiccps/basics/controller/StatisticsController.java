package com.qpp.comiccps.basics.controller;


import com.github.pagehelper.Page;
import com.qpp.comiccps.basics.entity.data.AdminFansData;
import com.qpp.comiccps.basics.entity.data.UserOrderProfitNew;
import com.qpp.comiccps.basics.service.impl.UserEntityServiceImpl;
import com.qpp.comiccps.basics.service.impl.UserOrderServiceImpl;
import com.qpp.comiccps.system.ActionUrl;
import com.qpp.comiccps.tool.DateUtil;
import com.qpp.comiccps.tool.Model;
import com.qpp.comiccps.tool.PageInfo;
import com.qpp.comiccps.tool.ParaClick;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatisticsController {

    @Autowired
    private UserEntityServiceImpl userEntityService;
    @Autowired
    private UserOrderServiceImpl userOrderService;

    /**
     *    公众号粉丝分布
     *
     * @author pengpai
     * @date 2018/5/3 14:53
     * @return com.qpp.comiccps.tool.Model
     */
    @ApiOperation("公众号粉丝分布")
    @PostMapping(value = ActionUrl.SELECT_USER_DISTRIBUTION_BYQD)
    @RequiresPermissions("userDistribution:select")
    public Model selectUserDistribution()
            throws Exception {
        // 公众号粉丝分布
        List<AdminFansData> list =userEntityService.selectUserDistribution();
        for (AdminFansData adminFansData:list) {
            if (!ParaClick.clickString(adminFansData.getPropertiesName()))
                adminFansData.setPropertiesName("平台用户");
        }
        Model model = new Model();
        model.setCode(200);
        model.setMsg("公众号粉丝统计");
        model.setObj(list);
        return model;
    }

    /**
     *    公众号粉丝性别
     *
     * @author pengpai
     * @date 2018/5/3 15:14
     * @return com.qpp.comiccps.tool.Model
     */
    @ApiOperation("公众号粉丝性别")
    @PostMapping(value = ActionUrl.SELECT_USER_SEX)
    @RequiresPermissions("userSex:select")
    public Model selectUserSex()
            throws Exception {
        // 公众号粉丝分布
        List<AdminFansData> list =userEntityService.selectUserSex();
        for (AdminFansData adminFansData:list) {
            if ("1".equals(adminFansData.getPropertiesName())||adminFansData.getPropertiesName()=="1") {
                adminFansData.setPropertiesName("男");
            }else if("2".equals(adminFansData.getPropertiesName())||adminFansData.getPropertiesName()=="2"){
                adminFansData.setPropertiesName("女");
            }else {
                adminFansData.setPropertiesName("未知");
            }
        }
        Model model = new Model();
        model.setCode(200);
        model.setMsg("公众号粉丝统计");
        model.setObj(list);
        return model;
    }

    /**
     *    各個公衆號現金收益(新)
     *
     * @author pengpai
     * @date 2018/4/25 17:48
     * @param pageInfo
     * @return com.qpp.comiccps.tool.Model
     */
    @ApiOperation("各個公衆號現金收益(新)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "condition", value = "查詢條件",  dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页的数量", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开始时间",  dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", dataType = "String", paramType = "query")
    })
    @PostMapping(value = ActionUrl.SELECT_CARTOON_PROFIT_NEW)
    @RequiresPermissions("monetTotal:select")
    public Model selectCartoonProfit(PageInfo pageInfo)
            throws Exception {
        PageInfo pageInfo1;
        try{
             pageInfo1=DateUtil.checkTodayTime(pageInfo);
        }catch (RuntimeException e){
            return new Model(500, "时间有误");
        }
        //  分页条件查询现金收益列表
        Page<UserOrderProfitNew> list = userOrderService.selectOrderProfitNew(pageInfo1);
        if (!ParaClick.clickList(list))
            return new Model(500, "查询失败");
        // 查询现金收益
        Double sum = userOrderService.selectOrderProfitNewSum(pageInfo);
        PageInfo<UserOrderProfitNew> pageInfos = new PageInfo<>(list);
        return new Model(pageInfos,sum);
    }
}
