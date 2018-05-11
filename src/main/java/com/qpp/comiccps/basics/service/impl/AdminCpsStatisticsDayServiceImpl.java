package com.qpp.comiccps.basics.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qpp.comiccps.basics.dao.AdminCpsStatisticsDayMapper;
import com.qpp.comiccps.basics.dao.AdminMapper;
import com.qpp.comiccps.basics.dao.DistributorWithdrawalsMapper;
import com.qpp.comiccps.basics.entity.Admin;
import com.qpp.comiccps.basics.entity.AdminCpsStatisticsDay;
import com.qpp.comiccps.basics.entity.data.WithdrawalsStatistics;
import com.qpp.comiccps.tool.DateUtil;
import com.qpp.comiccps.tool.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminCpsStatisticsDayServiceImpl {

    @Autowired
    private AdminCpsStatisticsDayMapper adminCpsStatisticsDayMapper;
    @Autowired
    private DistributorWithdrawalsMapper distributorWithdrawalsMapper;
    @Autowired
    private AdminMapper adminMapper;
    /**
     *    统计昨日CPS数据
     *
     * @author pengpai
     * @date 2018/5/7 17:11
     * @return boolean
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean cpsDataStatistics() {
        boolean flag = false;
        try {
            List<Admin> list=adminMapper.getAllCpsAdminState();
            for (Admin admin:list) {
                //cps昨日流水
                WithdrawalsStatistics withdrawalsStatistics=distributorWithdrawalsMapper.yestodayCpsDataStatistics(admin.getUid(), DateUtil.getYesterday());
                AdminCpsStatisticsDay adminCpsStatisticsDay=new AdminCpsStatisticsDay();
                adminCpsStatisticsDay.setAddcps(0);
                adminCpsStatisticsDay.setImpldate(DateUtil.getdate_yyyy_MM_dd());
                adminCpsStatisticsDay.setMonthrunwater((int) withdrawalsStatistics.getProportion());
                adminCpsStatisticsDay.setMonthprofit(withdrawalsStatistics.getMoney());
                adminCpsStatisticsDay.setState(1);
                adminCpsStatisticsDay.setUid(admin.getUid());
                adminCpsStatisticsDay.setUsername(admin.getUsername());
                int index =adminCpsStatisticsDayMapper.insertSelective(adminCpsStatisticsDay);
                if (index < 1)
                    return flag;
            }
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
            return flag;
    }
        return flag;
    }
    /**
     *    后台查看cps统计数据
     *
     * @author pengpai
     * @date 2018/5/7 19:33
     * @param pageInfo1 uid
     * @return com.github.pagehelper.Page<com.qpp.comiccps.basics.entity.AdminCpsStatisticsDay>
     */
    public Page<AdminCpsStatisticsDay> selectCpsDataStatistics(PageInfo pageInfo1, String uid) {
        PageHelper.startPage(pageInfo1.getPageNum(),pageInfo1.getPageSize());
        return adminCpsStatisticsDayMapper.selectCpsDataStatistics(pageInfo1.getStartDate(),pageInfo1.getEndDate(),uid);
    }

}
