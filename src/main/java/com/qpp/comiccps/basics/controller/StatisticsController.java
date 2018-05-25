package com.qpp.comiccps.basics.controller;


import com.github.pagehelper.Page;
import com.qpp.comiccps.basics.dao.DistributorWithdrawalsMapper;
import com.qpp.comiccps.basics.entity.AdminCpsStatistics;
import com.qpp.comiccps.basics.entity.AdminCpsStatisticsDay;
import com.qpp.comiccps.basics.entity.DailyDataStatistics;
import com.qpp.comiccps.basics.entity.DataStatistics;
import com.qpp.comiccps.basics.entity.data.AdminFansData;
import com.qpp.comiccps.basics.entity.data.TabulationData;
import com.qpp.comiccps.basics.entity.data.UserOrderProfitNew;
import com.qpp.comiccps.basics.entity.data.WithdrawalsStatistics;
import com.qpp.comiccps.basics.service.impl.*;
import com.qpp.comiccps.system.ActionUrl;
import com.qpp.comiccps.tool.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Autowired
    private DistributorWithdrawalsServiceImpl distributorWithdrawalsService;
    @Autowired
    private AdminCpsStatisticsServiceImpl adminCpsStatisticsService;
    @Autowired
    private AdminCpsStatisticsDayServiceImpl adminCpsStatisticsDayService;
    /**
     *    公众号粉丝分布
     *
     * @author pengpai
     * @date 2018/5/3 14:53
     * @return com.qpp.comiccps.tool.Model
     */
    @ApiOperation("公众号粉丝分布")
    @PostMapping(value = ActionUrl.SELECT_USER_DISTRIBUTION_BYQD)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "condition", value = "查詢條件",  dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页的数量", required = true, dataType = "String", paramType = "query"),
    })
    @RequiresPermissions("userDistribution:select")
    public Model selectUserDistribution(PageInfo pageInfo)
            throws Exception {
        // 公众号粉丝分布
        Page<UserOrderProfitNew> list = userEntityService.selectUserDistribution(pageInfo);
        if (!ParaClick.clickList(list))
            return new Model(500, "查询失败");
        PageInfo<UserOrderProfitNew> pageInfos = new PageInfo<>(list);
        Model model = new Model();
        model.setCode(200);
        model.setMsg("公众号粉丝统计");
        model.setObj(pageInfos);
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
             pageInfo1=DateUtil.checkYesterdayTime(pageInfo);
        }catch (RuntimeException e){
            return new Model(500, "时间有误");
        }
        //  分页条件查询现金收益列表
        Page<WithdrawalsStatistics> list = distributorWithdrawalsService.selectOrderProfitNew(pageInfo1);
        if (!ParaClick.clickList(list))
            return new Model(500, "查询失败");
        for (WithdrawalsStatistics withdrawalsStatistics:list) {
            withdrawalsStatistics.setMoney(ArithUtil.interceptDouble(withdrawalsStatistics.getMoney(),2));
        }
        // 查询现金收益
        Double sum = userOrderService.selectOrderProfitNewSum(pageInfo);
        PageInfo<WithdrawalsStatistics> pageInfos = new PageInfo<>(list);
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
        List<DataStatistics> list=new ArrayList<>();
        DataStatistics dataStatistics = dataStatisticsService.selectDataStatistics();
        if (dataStatistics == null)
            return new Model(500, "查询失败");
        dataStatistics.setAru(ArithUtil.interceptDouble(dataStatistics.getAru(),3));
        dataStatistics.setArpu(ArithUtil.interceptDouble(dataStatistics.getArpu(),3));
        dataStatistics.setArppu(ArithUtil.interceptDouble(dataStatistics.getArppu(),3));
        // 查询现金收益
        list.add(dataStatistics);
        return new Model(list);
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

        for (DailyDataStatistics dailyDataStatistics1:dailyDataStatistics) {
            dailyDataStatistics1.setAru(ArithUtil.interceptDouble(dailyDataStatistics1.getAru(),3));
            dailyDataStatistics1.setArpu(ArithUtil.interceptDouble(dailyDataStatistics1.getArpu(),3));
            dailyDataStatistics1.setArppu(ArithUtil.interceptDouble(dailyDataStatistics1.getArppu(),3));
        }
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
        Map<String,Object> map1 =new HashMap<>();
        Map<String,Object> map2 =new HashMap<>();
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
        map1.put("name","咔咔豆收入");
        map1.put("data",adminFansData2);
        list.add(map1);
        //  (日訪問量)数据趋势统计
        List<AdminFansData> adminFansData3 = dailyDataStatisticsService.selectDataTrendMapByVisterSum(pageInfo1);
        if (!ParaClick.clickList(adminFansData3))
            return new Model(500, "查询失败");
        map2.put("name","日访问量");
        map2.put("data",adminFansData3);
        list.add(map2);
        return new Model(list);
    }

    /**
     *    后台查看cps统计数据
     *
     * @author pengpai
     * @date 2018/5/8 10:04
     * @param pageInfo
     * @return com.qpp.comiccps.tool.Model
     */
    @ApiOperation("后台查看cps统计数据")
    @PostMapping(value = ActionUrl.SELECT_CPSDATA_STATISTICS)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页的数量", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开始时间",  dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "uid", value = "adminId", required = true, dataType = "String", paramType = "query")
    })
    @RequiresPermissions("cpsData:Statistics")
    public Model selectCpsDataStatistics(PageInfo pageInfo,@RequestParam("uid") String uid)
            throws Exception {
        PageInfo pageInfo1;
        try{
            pageInfo1=DateUtil.checkPageInfo(pageInfo);
        }catch (RuntimeException e){
            return new Model(500, "时间有误");
        }
        //  后台查看cps统计数据
        Page<AdminCpsStatisticsDay> adminCpsStatisticsDays = adminCpsStatisticsDayService.selectCpsDataStatistics(pageInfo1,uid);
        if (!ParaClick.clickList(adminCpsStatisticsDays))
            return new Model(500, "查询失败");

        for (AdminCpsStatisticsDay adminCpsStatisticsDay:adminCpsStatisticsDays) {
            adminCpsStatisticsDay.setMonthprofit(ArithUtil.interceptDouble(adminCpsStatisticsDay.getMonthprofit(),3));
        }
        PageInfo<AdminCpsStatisticsDay> pageInfos = new PageInfo<>(adminCpsStatisticsDays);
        return new Model(pageInfos);
    }

    /**
     *    后台查看cps总统计数据
     *
     * @author pengpai
     * @date 2018/5/8 10:11
     * @return com.qpp.comiccps.tool.Model
     */
    @ApiOperation("后台查看cps总统计数据")
    @PostMapping(value = ActionUrl.SELECT_CPSTOTALDATA_STATISTICS)
    @ApiImplicitParam(name = "uid", value = "adminId", required = true, dataType = "String", paramType = "query")
    @RequiresPermissions("cpsTotalData:Statistics")
    public Model selectCpsTotalDataStatistics(@RequestParam("uid") String uid)
            throws Exception {
        List<AdminCpsStatistics> adminCpsStatisticsList=new ArrayList<>();
        //  后台查看cps总统计数据
        AdminCpsStatistics adminCpsStatistics = adminCpsStatisticsService.selectCpsTotalDataStatistics(uid);
        if (adminCpsStatistics == null)
            return new Model(500, "查询失败");
        adminCpsStatistics.setMonthprofit(ArithUtil.interceptDouble(adminCpsStatistics.getMonthprofit(),3));
        adminCpsStatistics.setCpsprofitsum(ArithUtil.interceptDouble(adminCpsStatistics.getCpsprofitsum(),3));
        adminCpsStatistics.setBalance(ArithUtil.interceptDouble(adminCpsStatistics.getBalance(),3));
        adminCpsStatistics.setOverrecharge(ArithUtil.interceptDouble(adminCpsStatistics.getOverrecharge(),3));
        adminCpsStatistics.setAllrecharge(ArithUtil.interceptDouble(adminCpsStatistics.getAllrecharge(),3));
        adminCpsStatisticsList.add(adminCpsStatistics);
        return new Model(adminCpsStatisticsList);
    }

    /**
     *   导出excel
     *
     * @author pengpai
     * @date 2018/5/14 10:24
     * @param response, request, startDate, endDate
     * @return com.qpp.comiccps.tool.Model
     */
    @ApiOperation("导出excel")
    @GetMapping(value = ActionUrl.EXPORT_EXCEL)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "開始時間", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "結束時間", dataType = "String", paramType = "query")
    })
    //@RequiresPermissions("money:exportExcel")
    public Model exportExcel(HttpServletResponse response, HttpServletRequest request,
                             String startDate,
                             String endDate)
            throws Exception {
        if (ParaClick.clickString(startDate)
                && ParaClick.clickString(endDate)) {
            startDate = DateUtil.getYesterday();
            endDate=DateUtil.getYesterday();
        } else if (ParaClick.clickString(startDate)
                || ParaClick.clickString(endDate)) {
            return new Model(500, "请输入时间区间");
        }
        if (!ParaClick.clickString(startDate)
                && !ParaClick.clickString(endDate)) {
            Long start = 0L;
            Long end = 0L;
            start = DateUtil.getdate_yyyy_MM_dd_00_00_00(
                    startDate+ " 00:00:00").getTime();
            end = DateUtil.getdate_yyyy_MM_dd_00_00_00(
                    endDate+ " 23:59:59").getTime();
            if (start > end) {
                return new Model(500, "开始时间大于结束时间");
            }
        }
        String dateStr="kaka";
        // 指定下载的文件名
        response.setHeader("Content-Disposition", "attachment;filename=" +dateStr+".xls");
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        try {
            ServletOutputStream out = response.getOutputStream();
            String fileName = new String(("咔咔漫画平台收益" + new SimpleDateFormat(
                    "yyyy-MM-dd").format(new Date())).getBytes(), "UTF-8");
            response.setHeader("Content-disposition", "attachment; filename="
                    + fileName + ".xls");
            String[] titles = { "渠道", "分成比例" ,"收益" };
            userOrderService.export(titles, out,startDate,endDate);
            return new Model(200, "success");
        } catch (Exception e) {
            e.printStackTrace();
            return new Model(200, "error");
        }

    }
}
