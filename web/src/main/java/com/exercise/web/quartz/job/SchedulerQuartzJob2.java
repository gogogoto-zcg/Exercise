package com.exercise.web.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/9 0009 -12:19
 * @Description : TODO
 */
public class SchedulerQuartzJob2 implements Job {


    private void before(){
        System.out.println("SchedulerQuartzJob2任务开始执行");
    }

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        before();
        System.out.println("开始："+System.currentTimeMillis());
        // TODO 业务
        System.out.println("结束："+System.currentTimeMillis());
        after();
    }

    private void after(){
        System.out.println("SchedulerQuartzJob2任务开始执行");
    }

}
