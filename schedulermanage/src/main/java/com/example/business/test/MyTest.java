package com.example.business.test;

import com.example.business.model.QuartzManager;
import com.example.business.model.ScheduleJob;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTest {

    public static void main(String[] args) throws Exception{
        ScheduleJob scheduleJob = new ScheduleJob();
        scheduleJob.setJobName("00");
        scheduleJob.setJobGroupName("TEST");
        scheduleJob.setTriggerName("00");
        scheduleJob.setTriggerGroupName("TEST");
        scheduleJob.setBeanClass("com.example.business.test.MyTest");
        scheduleJob.setMethodName("show");
        scheduleJob.setCronExpression("0/1 * * * * ?");// 每秒钟执行一次

        QuartzManager.addJob(scheduleJob);


    }

    public void show(ScheduleJob scheduleJob) {
        System.err.println(getNow()+scheduleJob.getCronExpression());// 打印当前时间
    }

    private String getNow() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return sdf.format(new Date());
    }
}
