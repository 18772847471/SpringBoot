package com.example.business.model;

public class ScheduleJob {
    /** job名称 **/
    private String jobName;

    /** job组 **/
    private String jobGroupName = "QUARTZ_JOB_GROUP";// 默认组名

    /** trigger名称 **/
    private String triggerName;// 未赋值时默认返回jobName

    /** jtrigger组 **/
    private String triggerGroupName = "QUARTZ_TRIGGER_GROUP";// 默认组名

    /** cron时间表达式 **/
    private String cronExpression;

    /** 任务执行的类名：service类名 **/
    private String springId;

    /** 任务执行的类名：包名+类名 **/
    private String beanClass;

    /** 任务执行的方法名 **/
    private String methodName;

    /** 是否自定义 **/
    private String isZdy = "n";// 反射时默认不指定参数类型

    public String getTriggerName() {
        if(triggerName == null || "".equals(triggerName)) {
            return jobName;
        }else {
            return triggerName;
        }
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroupName() {
        return jobGroupName;
    }

    public void setJobGroupName(String jobGroupName) {
        this.jobGroupName = jobGroupName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroupName() {
        return triggerGroupName;
    }

    public void setTriggerGroupName(String triggerGroupName) {
        this.triggerGroupName = triggerGroupName;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getSpringId() {
        return springId;
    }

    public void setSpringId(String springId) {
        this.springId = springId;
    }

    public String getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(String beanClass) {
        this.beanClass = beanClass;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getIsZdy() {
        return isZdy;
    }

    public void setIsZdy(String isZdy) {
        this.isZdy = isZdy;
    }
}
