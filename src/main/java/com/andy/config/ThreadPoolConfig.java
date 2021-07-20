package com.andy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@ConfigurationProperties(prefix = "self.execution.pool")
public class ThreadPoolConfig {

    private int coreSize;

    private int maxSize;

    private int keepAliveSeconds;

    private int queueCapacity;

    private boolean allowCoreThreadTimeout;

//    @Value("spring.task.execution.thread-name-prefix")
//    private String threadNamePrefix;

    @Bean("definedThreadExecutor")
    public ThreadPoolTaskExecutor getExecutor() {
        System.out.println("corePoolSize" + coreSize);
        System.out.println("maxPoolSize" + maxSize);
        System.out.println("keepAliveSeconds" + keepAliveSeconds);
        System.out.println("queueCapacity" + queueCapacity);
        System.out.println("allowCoreThreadTimeout" + allowCoreThreadTimeout);
//        System.out.println("threadNamePrefix" + threadNamePrefix);

        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(coreSize);
        threadPoolTaskExecutor.setMaxPoolSize(maxSize);
        threadPoolTaskExecutor.setKeepAliveSeconds(keepAliveSeconds);
        threadPoolTaskExecutor.setQueueCapacity(queueCapacity);
        threadPoolTaskExecutor.setAllowCoreThreadTimeOut(allowCoreThreadTimeout);
//        threadPoolTaskExecutor.setThreadNamePrefix(threadNamePrefix);
        return threadPoolTaskExecutor;
    }

}
