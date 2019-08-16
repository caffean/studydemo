package com.example.nettydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * @Classname ThreadPoolTaskSchedulerConf
 * @Description TODO
 * @Date 2019/8/16 16:07
 * @Author lyn
 */
@Configuration
public class ThreadPoolTaskSchedulerConf {

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }
}
