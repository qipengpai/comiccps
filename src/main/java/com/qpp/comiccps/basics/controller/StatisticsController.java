package com.qpp.comiccps.basics.controller;


import com.github.pagehelper.Page;
import com.qpp.comiccps.basics.entity.DailyDataStatistics;
import com.qpp.comiccps.basics.entity.DataStatistics;
import com.qpp.comiccps.basics.entity.data.AdminFansData;
import com.qpp.comiccps.basics.entity.data.TabulationData;
import com.qpp.comiccps.basics.entity.data.UserOrderProfitNew;
import com.qpp.comiccps.basics.service.impl.DailyDataStatisticsServiceImpl;
import com.qpp.comiccps.basics.service.impl.DataStatisticsServiceImpl;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StatisticsController {

    @Autowired
    private UserEntityServiceImpl userEntityService;
    @Autowired
    private UserOrderServiceImpl userOrderService;
    @Autowired
    private DataStatisticsServiceImpl dataStatisticsService;
    @Autowired
    private DailyDataStatisticsServiceImpl dailyDataStatisticsService;

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
        List<AdminFansData> list = userEntityService.selectUserSex();
        List<Object> obj = new ArrayList<>();
        for (AdminFansData adminFansData : list) {
            TabulationData tabulation =new TabulationData();
            if ("1".equals(adminFansData.getPropertiesName()) || adminFansData.getPropertiesName() == "1") {
                tabulation.setName("男");
            } else if ("2".equals(adminFansData.getPropertiesName()) || adminFansData.getPropertiesName() == "2") {
                tabulation.setName("女");
            } else {
                tabulation.setName("未知");
            }
            tabulation.setValue(adminFansData.getPropertiesValue());
            obj.add(tabulation);
        }
        Model model = new Model();
        model.setCode(200);
        model.setMsg("公众号粉丝统计");
        model.setObj(obj);
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

    /**
     *    后台统计所有数据
     *
     * @author pengpai
     * @date 2018/5/5 10:11
     * @return com.qpp.comiccps.tool.Model
     */
    @ApiOperation("后台统计所有数据")
    @PostMapping(value = ActionUrl.SELECT_DATA_STATISTICS)
    @RequiresPermissions("data:Statistics")
    public Model selectDataStatistics()
            throws Exception {
        //  后台统计所有数据
        DataStatistics dataStatistics = dataStatisticsService.selectDataStatistics();
        if (dataStatistics == null)
            return new Model(500, "查询失败");
        // 查询现金收益
        return new Model(dataStatistics);
    }

    /**
     *    后台查看歷史每日统计数据
     *
     * @author pengpai
     * @date 2018/5/5 10:11
     * @return com.qpp.comiccps.tool.Model
     */
    @ApiOperation("后台查看歷史每日统计数据")
    @PostMapping(value = ActionUrl.SELECT_DATA_STATISTICS_EVERYDAY)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页的数量", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开始时间",  dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", dataType = "String", paramType = "query")
    })
    @RequiresPermissions("dataEveryDay:Statistics")
    public Model selectDataStatisticsEveryDay(PageInfo pageInfo)
            throws Exception {
        PageInfo pageInfo1;
        try{
            pageInfo1=DateUtil.checkPageInfo(pageInfo);
        }catch (RuntimeException e){
            return new Model(500, "时间有误");
        }
        //  后台查看歷史每日统计数据
        Page<DailyDataStatistics> dailyDataStatistics = dailyDataStatisticsService.selectDataStatisticsEveryDay(pageInfo1);
        if (!ParaClick.clickList(dailyDataStatistics))
            return new Model(500, "查询失败");
        PageInfo<DailyDataStatistics> pageInfos = new PageInfo<>(dailyDataStatistics);
        return new Model(pageInfos);
    }

    /**
     *    数据趋势统计
     *
     * @author pengpai
     * @date 2018/5/5 16:54
     * @param pageInfo
     * @return com.qpp.comiccps.tool.Model
     */
    @ApiOperation("数据趋势统计")
    @PostMapping(value = ActionUrl.SELECT_DATA_TRENDMAP)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "开始时间", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", required = true, dataType = "String", paramType = "query")
    })
    @RequiresPermissions("data:TrendMap")
    public Model selectDataTrendMap(PageInfo pageInfo)
            throws Exception {
        PageInfo pageInfo1;
        try{
            pageInfo1=DateUtil.checkDateByTrendMap(pageInfo);
        }catch (RuntimeException e){
            return new Model(500, "时间有误");
        }
        List<Object> list =new ArrayList<>();
        Map<String,Object> map =new HashMap<>();
        //  (钱收入)数据趋势统计
        List<AdminFansData> adminFansData = dailyDataStatisticsService.selectDataTrendMapByMoneySum(pageInfo1);
        if (!ParaClick.clickList(adminFansData))
            return new Model(500, "查询失败");
        map.put("name","金钱收入");
        map.put("data",adminFansData);
        list.add(map);
        //  (豆收入)数据趋势统计
        List<AdminFansData> adminFansData2 = dailyDataStatisticsService.selectDataTrendMapByBeanSum(pageInfo1);
        if (!ParaClick.clickList(adminFansData2))
            return new Model(500, "查询失败");
        map.put("name","咔咔豆收入");
        map.put("data",adminFansData2);
        list.add(map);
        //  (日訪問量)数据趋势统计
        List<AdminFansData> adminFansData3 = dailyDataStatisticsService.selectDataTrendMapByVisterSum(pageInfo1);
        if (!ParaClick.clickList(adminFansData3))
            return new Model(500, "查询失败");
        map.put("name","日访问量");
        map.put("data",adminFansData3);
        list.add(map);
        return new Model(list);
    }
}
