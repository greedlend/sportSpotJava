package com.andy.schedule;

import com.andy.schedule.job.FirstJob;
import com.andy.schedule.job.SecondJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 安排定時任務
 * 1.啟用/停用
 * 2.定時時間
 * */
@Component
public class JobInit implements ApplicationRunner {

    private static final String ID = "SUMMERDAY";

    @Autowired
    private Scheduler scheduler;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        JobDetail jobDetail1 = JobBuilder.newJob(FirstJob.class)
                .withIdentity(ID + " 01")
                .storeDurably()
                .build();
        JobDetail jobDetail2 = JobBuilder.newJob(SecondJob.class)
                .withIdentity(ID + " 02")
                .storeDurably()
                .build();

        CronScheduleBuilder jobOneScheduleBuilder =
                CronScheduleBuilder.cronSchedule("0/5 * * * * ? *");
        CronScheduleBuilder jobTwoScheduleBuilder =
                CronScheduleBuilder.cronSchedule("0/10 * * * * ? *");

        // 建立任務觸發器
        Trigger trigger1 = TriggerBuilder.newTrigger()
                .forJob(jobDetail1)
                .withIdentity(ID + " 01Trigger")
                .withSchedule(jobOneScheduleBuilder)
                .startNow() //立即執行一次任務
                .build();
        Trigger trigger2 = TriggerBuilder.newTrigger()
                .forJob(jobDetail2)
                .withIdentity(ID + " 02Trigger")
                .withSchedule(jobTwoScheduleBuilder)
                .startNow() //立即執行一次任務
                .build();

        // 手動將觸發器與任務繫結到排程器內
        scheduler.scheduleJob(jobDetail1, trigger1);
        scheduler.scheduleJob(jobDetail2, trigger2);
    }
}
