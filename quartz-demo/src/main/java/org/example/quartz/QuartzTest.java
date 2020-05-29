package org.example.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class QuartzTest {
    public static void main(String[] args) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            scheduler.start();

            JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("job1", "group1").build();
            SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever()).build();
            scheduler.scheduleJob(jobDetail, trigger);
//            当你调用StdSchedulerFactory.getDefaultScheduler()获取scheduler实例对象后，
//            在调用scheduler.shutdown()之前，scheduler不会终止，因为还有活跃的线程在执行。
            //scheduler.shutdown();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public static class HelloJob implements Job {

        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {

            System.out.println("current:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }
    }
}


