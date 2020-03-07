package com.devculi.springevent.configs.events.listeners;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync // kích hoạt xử lý bất đồng bộ
public class ListerConfiguration {

    @Bean(name = "threadPoolExecutor")
    public TaskExecutor getThreadPoolTaskExecutor() {
        return new ThreadPoolTaskExecutor();
    }

    @Bean
    public TaskExecutor getSimpleTaskExecutor() {
        return new SimpleAsyncTaskExecutor();
    }
}
