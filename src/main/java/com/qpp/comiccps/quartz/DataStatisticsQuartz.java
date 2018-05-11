package com.qpp.comiccps.quartz;

import com.qpp.comiccps.basics.service.impl.DailyDataStatisticsServiceImpl;
import com.qpp.comiccps.basics.service.impl.DataStatisticsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DataStatisticsQuartz {

    @Autowired
    private DataStatisticsServiceImpl dataStatisticsService;
    @Autowired
    private DailyDataStatisticsServiceImpl dailyDataStatisticsService;
    /**
     *    每三分钟更新总统计数据
     *
     * @author pengpai
     * @date 2018/5/4 17:37
     * @return void
     */
    @Scheduled(cron = "0 */20 * * * ?")
    public void dataStatistics() throws Exception {
        if (dataStatisticsService.dataStatistics()) {
            System.out.println("------------------------------------------------统计数据成功-----------------------------------------------");
        } else {
            System.out.println("------------------------------------------------统计数据失败-----------------------------------------------");
        }
        System.out.println("执行调度任务：" + new Date());
    }

    /**
     *    每天汇总昨日统计数据
     *
     * @author pengpai
     * @date 2018/5/5 12:17
     * @return void
     */
    @Scheduled(cron = "0 3 0 * * ?")
    public void dailyDataStatistics() throws Exception {
        if (dailyDataStatisticsService.dailyDataStatistics(1)) {
            System.out.println("------------------------------------------------昨日统计数据成功-----------------------------------------------");
        } else {
            System.out.println("------------------------------------------------昨日统计数据失败-----------------------------------------------");
        }
        System.out.println("执行调度任务：" + new Date());
    }

    /**
     *    当日统计数据成功
     *
     * @author pengpai
     * @date 2018/5/5 14:01
     * @return void
     */
    //@Scheduled(cron = "0 */4 * * * ?")
    @Scheduled(cron = "0 0/5 9-20 * * ?")
    public void todayDataStatistics() throws Exception {
        if (dailyDataStatisticsService.dailyDataStatistics(2)) {
            System.out.println("------------------------------------------------当日统计数据成功-----------------------------------------------");
        } else {
            System.out.println("------------------------------------------------当日统计数据失败-----------------------------------------------");
        }
        System.out.println("执行调度任务：" + new Date());
    }
}
