package com.qpp.comiccps.basics.service.impl;

import com.qpp.comiccps.basics.dao.*;
import com.qpp.comiccps.basics.entity.DailyDataStatistics;
import com.qpp.comiccps.basics.entity.DataStatistics;
import com.qpp.comiccps.tool.DateUtil;
import com.qpp.comiccps.tool.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DataStatisticsServiceImpl {

    @Autowired
    private DataStatisticsMapper dataStatisticsMapper;
    @Autowired
    private UserEntityMapper userEntityMapper;
    @Autowired
    private UserOrderMapper userOrderMapper;
    @Autowired
    private MallCartoonOrderMapper mallCartoonOrderMapper;

    /**
     *    每三分钟更新总统计数据
     *
     * @author pengpai
     * @date 2018/5/4 17:37
     * @return boolean
     */
    public boolean dataStatistics() {
        boolean flag = false;
        try {
            String sentry1 =null;
            String sentry2 =null;
            //查询总用户数
            int visterNum = userEntityMapper.getUserEntityTotalCount(sentry1,sentry2);
            //查询Svip数量
            int svipUserAddNum = userEntityMapper.getSvipUserNum(sentry1,sentry2);
            //查询vip数量
            int vipUserAddNum = userEntityMapper.getVipUserNum();
            //查询总订单数量
            int payNum = userOrderMapper.getAllPayNum(sentry1,sentry2);
            //查询总付费人数
            int payPersonNum = userOrderMapper.getAllPayPersonNum(sentry1,sentry2);
            //查询总付费金额
            int paySum = userOrderMapper.getAllPaySum(sentry1,sentry2);
            //查询咔咔逗总收益
            int beanSum = mallCartoonOrderMapper.getBeanSum(sentry1,sentry2);

            DataStatistics dataStatistics =new DataStatistics();
            dataStatistics.setId("054bc331500811e8ab3e7cd30ab8a718");
            dataStatistics.setState(1);
            dataStatistics.setBeanincome(beanSum);
            dataStatistics.setDailyvisteraddnum(paySum);
            dataStatistics.setPaynum(payNum);
            dataStatistics.setPaypersonnum(payPersonNum);
            dataStatistics.setImpldate(DateUtil.getdate_yyyy_MM_dd_HH_MM_SS());
            dataStatistics.setSvipuseraddnum(svipUserAddNum);
            dataStatistics.setVipuseraddnum(vipUserAddNum);
            dataStatistics.setVisternum(visterNum);
            dataStatistics.setArppu(Double.parseDouble(paySum+"")/Double.parseDouble(payPersonNum+""));
            dataStatistics.setArpu(Double.parseDouble(paySum+"")/Double.parseDouble(visterNum+""));
            dataStatistics.setAru(Double.parseDouble(payPersonNum+"")/Double.parseDouble(visterNum+""));
            //int index = dataStatisticsMapper.insertSelective(dataStatistics);
            int index = dataStatisticsMapper.updateByPrimaryKeySelective(dataStatistics);
            if (index < 1)
                return flag;
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            return flag;
        }
        return flag;
    }


    /**
     *    后台统计所有数据
     *
     * @author pengpai
     * @date 2018/5/5 10:11
     * @return com.qpp.comiccps.basics.entity.DataStatistics
     */
    public DataStatistics selectDataStatistics() {
        return dataStatisticsMapper.selectByPrimaryKey("054bc331500811e8ab3e7cd30ab8a718");
    }


}
