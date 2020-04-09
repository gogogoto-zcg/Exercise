package com.exercise.web.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author : cg.zhou
 * @date : 2020/4/9 000911:47
 * @Description : springboot 自带Schdule
 */
@Component
public class SpringbootSchduleDemo {

    /**
     * 每分钟的 0 5 10 15 20 25 30 35 40 45 50 55 s执行
     */
    @Scheduled(cron = " 0/5 * * * * ?")
    public void scheduleJob(){
        System.out.println("每分钟的 0 5 10 15 20 25 30 35 40 45 50 55 s执行 " +new Date());
    }

}
