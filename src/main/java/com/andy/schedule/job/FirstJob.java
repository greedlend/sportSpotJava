package com.andy.schedule.job;

import com.andy.model.Spot;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 建立Job的時候，可以實現Job介面，也可以繼承QuartzJobBean
 * */
@Slf4j
public class FirstJob extends QuartzJobBean {

    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String now = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());

        log.info("當前的時間: " + now);

        Spot spot = new Spot();
        spot.setAddress("address");

        threadPoolTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {

                log.info("test for scoped object: " + now);
                log.info("test for scoped object: " + now.toLowerCase());
                log.info("test for scoped object: " + spot.getAddress());

            }
        });
    }
}
