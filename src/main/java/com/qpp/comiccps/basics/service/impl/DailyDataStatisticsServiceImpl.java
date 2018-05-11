package com.qpp.comiccps.basics.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qpp.comiccps.basics.dao.DailyDataStatisticsMapper;
import com.qpp.comiccps.basics.dao.MallCartoonOrderMapper;
import com.qpp.comiccps.basics.dao.UserEntityMapper;
import com.qpp.comiccps.basics.dao.UserOrderMapper;
import com.qpp.comiccps.basics.entity.DailyDataStatistics;
import com.qpp.comiccps.basics.entity.data.AdminFansData;
import com.qpp.comiccps.tool.DateUtil;
import com.qpp.comiccps.tool.PageInfo;
import com.qpp.comiccps.tool.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyDataStatisticsServiceImpl {

    @Autowired
    private DailyDataStatisticsMapper dailyDataStatisticsMapper;
    @Autowired
    private UserEntityMapper userEntityMapper;
    @Autowired
    private UserOrderMapper userOrderMapper;
    @Autowired
    private MallCartoonOrderMapper mallCartoonOrderMapper;

    /**
     * 统计昨日数据
     *
     * @return boolean
     * @author pengpai
     * @date 2018/5/5 10:15
     */
    public boolean dailyDataStatistics(int sentry) {
        boolean flag = false;
        try {
            String sentry1;
            String sentry2;
            if (sentry == 2) {
                sentry1 = "101";
                sentry2 = null;
            } else {
                sentry1 = null;
                sentry2 = "101";
            }
            //查询日活用户数
            int dailyVisterNum = userEntityMapper.getUserEntityTotalCount(sentry1, sentry2);
            //查询新增Svip数量
            int dailySvipUserAddNum = userEntityMapper.getSvipUserNum(sentry1, sentry2);
            //查询新增vip数量
            int dailyVipUserAddNum = userOrderMapper.getVipUserAddNum(sentry1, sentry2);
            //查询昨日订单数量
            int dailyPayNum = userOrderMapper.getAllPayNum(sentry1, sentry2);
            //查询昨日付费人数
            int dailyPayPersonNum = userOrderMapper.getAllPayPersonNum(sentry1, sentry2);
            //查询昨日付费金额
            int dailyPaySum = userOrderMapper.getAllPaySum(sentry1, sentry2);
            //查询昨日咔咔逗总收益
            int dailyBeanSum = mallCartoonOrderMapper.getBeanSum(sentry1, sentry2);

            DailyDataStatistics dailyDataStatistics = new DailyDataStatistics();
            dailyDataStatistics.setBeanincome(dailyBeanSum);
            dailyDataStatistics.setDailyvisteraddnum(dailyPaySum);
            dailyDataStatistics.setDailyvisternum(dailyVisterNum);
            dailyDataStatistics.setPaynum(dailyPayNum);
            dailyDataStatistics.setPaypersonnum(dailyPayPersonNum);
            dailyDataStatistics.setState(1);
            dailyDataStatistics.setVipuseraddnum(dailyVipUserAddNum-dailySvipUserAddNum);
            dailyDataStatistics.setSvipuseraddnum(dailySvipUserAddNum);
            if (dailyPaySum > 0) {
                dailyDataStatistics.setArppu(Double.parseDouble(dailyPaySum + "") / Double.parseDouble(dailyPayPersonNum + ""));
                dailyDataStatistics.setArpu(Double.parseDouble(dailyPaySum + "") / Double.parseDouble(dailyVisterNum + ""));
            } else {
                dailyDataStatistics.setArppu(0.0);
                dailyDataStatistics.setArpu(0.0);
            }
            if (dailyPayPersonNum > 0) {
                dailyDataStatistics.setAru(Double.parseDouble(dailyPayPersonNum + "") / Double.parseDouble(dailyVisterNum + ""));
            } else {
                dailyDataStatistics.setAru(0.0);
            }
            if (sentry == 1) {
                // 判斷今天是否生成
                DailyDataStatistics dailyDataStatistics1 = dailyDataStatisticsMapper.getAllIfExists(DateUtil.getYesterday());
                dailyDataStatistics.setId(dailyDataStatistics1.getId());
                dailyDataStatistics.setImpldate(DateUtil.getYesterday());
                int index = dailyDataStatisticsMapper.updateByPrimaryKeySelective(dailyDataStatistics);
                if (index < 1)
                    return flag;
                flag = true;
            } else {
                // 判斷今天是否生成
                DailyDataStatistics dailyDataStatistics1 = dailyDataStatisticsMapper.getAllIfExists(DateUtil.getdate_yyyy_MM_dd());
                int index = 0;
                if (dailyDataStatistics1 == null) {
                    dailyDataStatistics.setImpldate(DateUtil.getdate_yyyy_MM_dd());
                    dailyDataStatistics.setUuid(Uuid.getUUID());
                    index = dailyDataStatisticsMapper.insertSelective(dailyDataStatistics);
                } else {
                    dailyDataStatistics.setId(dailyDataStatistics1.getId());
                    index = dailyDataStatisticsMapper.updateByPrimaryKeySelective(dailyDataStatistics);
                }
                if (index < 1) {
                    return flag;
                }
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return flag;
        }
        return flag;
    }


    /**
     * 后台查看歷史每日统计数据
     *
     * @param pageInfo1
     * @return com.github.pagehelper.Page<com.qpp.comiccps.basics.entity.DailyDataStatistics>
     * @author pengpai
     * @date 2018/5/5 13:45
     */
    public Page<DailyDataStatistics> selectDataStatisticsEveryDay(PageInfo pageInfo1) {
        PageHelper.startPage(pageInfo1.getPageNum(), pageInfo1.getPageSize());
        return dailyDataStatisticsMapper.selectDataStatisticsEveryDay(pageInfo1);
    }


    /**
     *   (钱收入)数据趋势统计
     *
     * @author pengpai
     * @date 2018/5/5 16:53
     * @param pageInfo1
     * @return java.util.List<com.qpp.comiccps.basics.entity.data.AdminFansData>
     */
    public List<AdminFansData> selectDataTrendMapByMoneySum(PageInfo pageInfo1) {
        return dailyDataStatisticsMapper.selectDataTrendMapByMoneySum(pageInfo1);
    }

    /**
     *    (豆收入)数据趋势统计
     *
     * @author pengpai
     * @date 2018/5/5 17:15
     * @param pageInfo1
     * @return java.util.List<com.qpp.comiccps.basics.entity.data.AdminFansData>
     */
    public List<AdminFansData> selectDataTrendMapByBeanSum(PageInfo pageInfo1) {
        return dailyDataStatisticsMapper.selectDataTrendMapByBeanSum(pageInfo1);
    }

    /**
     *    (日訪問量)数据趋势统计
     *
     * @author pengpai
     * @date 2018/5/5 17:22
     * @param pageInfo1
     * @return java.util.List<com.qpp.comiccps.basics.entity.data.AdminFansData>
     */
    public List<AdminFansData> selectDataTrendMapByVisterSum(PageInfo pageInfo1) {
        return dailyDataStatisticsMapper.selectDataTrendMapByVisterSum(pageInfo1);
    }
}
