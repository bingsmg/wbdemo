package live.clover.job;

import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author weibb
 * @date 2023-12-19
 */
@SuppressWarnings("ALL")
public class SimpleQuartzTest {

    @Test
    public void simple_test() throws SchedulerException, InterruptedException {
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class)
                .withIdentity("job1", "group1")
                .build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger-1", "trigger-group")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2)
                        .repeatForever())
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
        TimeUnit.SECONDS.sleep(30);
        scheduler.shutdown();
    }

    @Test
    public void cron_test() throws SchedulerException, InterruptedException {
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class)
                .withIdentity("job1", "job1-group1")
                .build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger-1", "trigger1-group")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("* 18 10 ? * * *"))
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
        TimeUnit.SECONDS.sleep(60);
        scheduler.shutdown();
    }
}
