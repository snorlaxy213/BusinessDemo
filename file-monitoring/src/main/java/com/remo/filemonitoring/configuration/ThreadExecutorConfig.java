package com.remo.filemonitoring.configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadExecutorConfig {
    
    @Bean 
    public Executor executor() { 
        
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor(); 
        executor.setCorePoolSize(2);//线程池维护线程的最少数量 
        executor.setMaxPoolSize(5);//线程池维护线程的最大数量 
        executor.setQueueCapacity(10);//缓存队列 
        executor.setThreadNamePrefix("FileMonitoring-"); 
        /**
         * 对拒绝task的处理策略
         rejection-policy：当pool已经达到max size的时候，如何处理新任务
         CALLER_RUNS：不在新线程中执行任务，而是由调用者所在的线程来执行
         */ 
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy()); 
        executor.setKeepAliveSeconds(60);//允许的空闲时间 
        executor.initialize(); 
        return executor; 
    } 
}
