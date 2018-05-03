package com.qpp.comiccps.quartz;

import com.qpp.comiccps.basics.service.impl.UserOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserOrderQuartz {

    @Autowired
    private UserOrderServiceImpl userOrderService;

    @Scheduled(cron = "0 15 5 * * ?")
    public void distributorTotalYmd() throws Exception {
        if (userOrderService.deleteInvalidOrder()) {
            System.out.println("------------------------------------------------清除无效订单成功-----------------------------------------------");
        } else {
            System.out.println("------------------------------------------------清除无效订单失败-----------------------------------------------");
        }
        System.out.println("执行调度任务：" + new Date());
    }
}
