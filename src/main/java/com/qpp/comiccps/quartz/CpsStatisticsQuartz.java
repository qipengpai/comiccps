package com.qpp.comiccps.quartz;

import com.qpp.comiccps.basics.entity.AdminCpsStatisticsDay;
import com.qpp.comiccps.basics.service.impl.AdminCpsStatisticsDayServiceImpl;
import com.qpp.comiccps.basics.service.impl.AdminCpsStatisticsServiceImpl;
import com.qpp.comiccps.basics.service.impl.DistributorWithdrawalsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CpsStatisticsQuartz {


    @Autowired
    private AdminCpsStatisticsServiceImpl adminCpsStatisticsService;
    @Autowired
    private AdminCpsStatisticsDayServiceImpl adminCpsStatisticsDayService;


    /**
     *    统计昨日CPS数据
     *
     * @author pengpai
     * @date 2018/5/7 17:10
     * @return void
     */
    @Scheduled(cron = "0 11 0 * * ?")
    public void cpsDataStatistics() throws Exception {
        if (adminCpsStatisticsDayService.cpsDataStatistics()) {
            System.out.println("------------------------------------------------统计昨日CPS数据-----------------------------------------------");
        } else {
            System.out.println("------------------------------------------------统计昨日CPS数据-----------------------------------------------");
        }
        System.out.println("执行调度任务：" + new Date());
    }


    /**
     *    更新统计CPS总数据
     *
     * @author pengpai
     * @date 2018/5/7 18:17
     * @return void
     */
    @Scheduled(cron = "0 0/5 10-20 * * ?")
    public void cpsTotalDataStatistics() throws Exception {
        if (adminCpsStatisticsService.cpsTotalDataStatistics()) {
            System.out.println("------------------------------------------------更新统计CPS总数据-----------------------------------------------");
        } else {
            System.out.println("------------------------------------------------更新统计CPS总数据-----------------------------------------------");
        }
        System.out.println("执行调度任务：" + new Date());
    }
}
