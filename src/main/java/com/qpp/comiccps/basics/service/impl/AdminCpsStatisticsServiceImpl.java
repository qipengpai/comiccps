package com.qpp.comiccps.basics.service.impl;

import com.qpp.comiccps.basics.dao.*;
import com.qpp.comiccps.basics.entity.Admin;
import com.qpp.comiccps.basics.entity.AdminCpsStatistics;
import com.qpp.comiccps.basics.entity.Distributor;
import com.qpp.comiccps.basics.entity.data.WithdrawalsStatistics;
import com.qpp.comiccps.tool.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminCpsStatisticsServiceImpl {


    @Autowired
    private AdminCpsStatisticsMapper adminCpsStatisticsMapper;
    @Autowired
    private DistributorWithdrawalsMapper distributorWithdrawalsMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private DistributorMapper distributorMapper;

    /**
     * 更新统计CPS总数据
     *
     * @return boolean
     * @author pengpai
     * @date 2018/5/7 18:19
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean cpsTotalDataStatistics() {
        boolean flag = false;
        try {
            List<Admin> list = adminMapper.getAllCpsAdminState();
            for (Admin admin : list) {
                //本月流水與收益
                List<WithdrawalsStatistics> withdrawalsStatistics = distributorWithdrawalsMapper.cpsMonthDataStatistics(admin.getUid());
                // cps总数
                int num = adminMapper.getCpsCount(admin.getUid());
                // cps旗下提現數據总数
                Distributor distributor = distributorMapper.getDistributorByAdmin(admin.getUid());
                AdminCpsStatistics adminCpsStatistics = new AdminCpsStatistics();
                adminCpsStatistics.setAllrecharge(distributor.getAllrecharge());
                adminCpsStatistics.setBalance(distributor.getBalance());
                adminCpsStatistics.setOverrecharge(distributor.getOverrecharge());
                adminCpsStatistics.setCpsnum(num);
                adminCpsStatistics.setUid(admin.getUid());
                adminCpsStatistics.setUsername(admin.getUsername());
                adminCpsStatistics.setCpsprofitsum(withdrawalsStatistics.get(1).getMoney());
                adminCpsStatistics.setCpsrunwater((int) withdrawalsStatistics.get(1).getProportion());
                adminCpsStatistics.setImpldate(DateUtil.getdate_yyyy_MM_dd_HH_MM_SS());
                adminCpsStatistics.setMonthprofit(withdrawalsStatistics.get(0).getMoney());
                adminCpsStatistics.setMonthrunwater((int) withdrawalsStatistics.get(0).getProportion());
                // 查看该cps是否已有统计记录
                AdminCpsStatistics adminCpsStatistics2=adminCpsStatisticsMapper.selectCpsTotalDataStatistics(admin.getUid());
                if (adminCpsStatistics2 == null) {
                    int index = adminCpsStatisticsMapper.insertSelective(adminCpsStatistics);
                    if (index < 1)
                        return flag;
                }else {
                    adminCpsStatistics.setId(adminCpsStatistics2.getId());
                    int index = adminCpsStatisticsMapper.updateByPrimaryKeySelective(adminCpsStatistics);
                    if (index < 1)
                        return flag;
                }
            }
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            return flag;
        }
        return flag;
    }


    /**
     *    后台查看cps总统计数据
     *
     * @author pengpai
     * @date 2018/5/8 10:14
     * @return com.qpp.comiccps.basics.entity.AdminCpsStatistics
     */
    public AdminCpsStatistics selectCpsTotalDataStatistics(String uid) {
        return adminCpsStatisticsMapper.selectCpsTotalDataStatistics(uid);
    }
}
