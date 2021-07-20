package com.andy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


@Configuration
//@ConfigurationProperties(prefix = "self.execution.pool")
public class ThreadPoolConfig {

    @Value("${self.execution.pool.core-size}")
    private Integer coreSize;

    @Value("${self.execution.pool.max-size}")
    private Integer maxSize;

    @Value("${self.execution.pool.keep-alive-seconds}")
    private Integer keepAliveSeconds;

    @Value("${self.execution.pool.queue-capacity}")
    private Integer queueCapacity;

    @Value("${self.execution.pool.allow-core-thread-timeout}")
    private Boolean allowCoreThreadTimeout;

    @Value("${self.execution.thread-name-prefix}")
    private String threadNamePrefix;

    @Bean("definedThreadExecutor")
    public ThreadPoolTaskExecutor getExecutor() {
        System.out.println("corePoolSize" + coreSize);
        System.out.println("maxPoolSize" + maxSize);
        System.out.println("keepAliveSeconds" + keepAliveSeconds);
        System.out.println("queueCapacity" + queueCapacity);
        System.out.println("allowCoreThreadTimeout" + allowCoreThreadTimeout);
        System.out.println("threadNamePrefix" + threadNamePrefix);

        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(coreSize);
        threadPoolTaskExecutor.setMaxPoolSize(maxSize);
        threadPoolTaskExecutor.setKeepAliveSeconds(keepAliveSeconds);
        threadPoolTaskExecutor.setQueueCapacity(queueCapacity);
        threadPoolTaskExecutor.setAllowCoreThreadTimeOut(allowCoreThreadTimeout);
        threadPoolTaskExecutor.setThreadNamePrefix(threadNamePrefix);
        return threadPoolTaskExecutor;
    }

}
