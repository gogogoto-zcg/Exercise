package com.exercise.web.controller;

import com.exercise.web.quartz.schedule.MyQuartzScheduler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.quartz.SchedulerException;
import org.quartz.core.QuartzScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/9 0009 -12:35
 * @Description : TODO
 */
@Api("Quartz api")
@RestController("/quartz")
public class QuartzApiController {

    @Autowired
    private MyQuartzScheduler quartzScheduler;

    @ApiOperation("启动所有定时任务")
    @GetMapping("/start")
    public void startQuartzJob() {
        try {
            quartzScheduler.startJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation("获取定时任务信息")
    @GetMapping("/info")
    public String getQuartzJob(String name, String group) {
        String info = null;
        try {
            info = quartzScheduler.getJobInfo(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return info;
    }

    @ApiOperation("修改某个任务的定时任务时间")
    @GetMapping("/modify")
    public boolean modifyQuartzJob(String name, String group, String time) {
        boolean flag = true;
        try {
            flag = quartzScheduler.modifyJob(name, group, time);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @ApiOperation("暂停某个定时任务")
    @GetMapping(value = "/pause")
    public void pauseQuartzJob(String name, String group) {
        try {
            quartzScheduler.pauseJob(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation("暂停所有定时任务")
    @PutMapping(value = "/pauseAll")
    public void pauseAllQuartzJob() {
        try {
            quartzScheduler.pauseAllJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation("删除指定定时任务")
    @DeleteMapping(value = "/delete")
    public void deleteJob(String name, String group) {
        try {
            quartzScheduler.deleteJob(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
