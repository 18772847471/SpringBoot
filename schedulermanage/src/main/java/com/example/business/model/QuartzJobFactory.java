package com.example.business.model;

import com.example.business.model.ScheduleJob;
import com.example.business.utils.ScheduleJobUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.apache.log4j.Logger;


public class QuartzJobFactory implements Job {
    public final Logger log = Logger.getLogger(this.getClass());

    /**
     * 这个方法里写需要定时执行的任务
     * 		我这里已经将需要执行的类名和方法名封装进ScheduleJob中，因此此方法利用反射获取ScheduleJob中的信息去执行
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // 获取创建Job时传递的数据
        ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
        // 利用反射去执行
        ScheduleJobUtils.invokMethod(scheduleJob);
    }
}
