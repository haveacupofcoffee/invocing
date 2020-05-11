package com.codingforfun.invocing.jobs;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyJobListener implements ServletContextListener {
    public static Scheduler scheduler = null;

    /**
     * Default constructor.
     */
    public MyJobListener() {
        // TODO Auto-generated constructor stub
    }

    /**
     * web容器启动时，开启定时任务
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
//		ServletContextListener.super.contextInitialized(sce);
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            System.out.println("开始创建任务实例...");
            JobDetail detail = JobBuilder.newJob(MyJob.class).withDescription("testMyJob").withIdentity("MyJob", "jobgroup1").build();
            System.out.println("任务实例创建完成");

            System.out.println("开始创建任务触发器...");
            Trigger trigger = TriggerBuilder.newTrigger().withDescription("MyJobTrigger").withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5)).build();

            System.out.println("任务触发器创建完成");

            System.out.println("开始关联任务、触发器...");
            scheduler.scheduleJob(detail, trigger);
            System.out.println("任务和触发器关联完成");

            System.out.println("开启调度器 Scheduler...");
            scheduler.start();
            System.out.println("调度器 Scheduler已开启");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * web容器关闭时，注销定时任务
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//		ServletContextListener.super.contextDestroyed(sce);
        if (scheduler != null) {
            try {
                System.out.println("关闭调度器 Scheduler...");
                scheduler.shutdown();

                if(scheduler.isShutdown()) {
                    System.out.println("调度器 Scheduler已关闭。");
                }else {
                    System.out.println("调度器 Scheduler未正确关闭！");
                }
            } catch (SchedulerException e) {
                System.out.println("调度器 Scheduler关闭时发生异常，未正确关闭！");
                e.printStackTrace();
            }
        }
    }

}
