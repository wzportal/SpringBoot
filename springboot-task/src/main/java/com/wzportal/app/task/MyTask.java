package com.wzportal.app.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyTask.class);

    @Scheduled(cron = "*/10 * * * * ?")
    public void job1() {
        LOGGER.info("task running.");
    }
}
