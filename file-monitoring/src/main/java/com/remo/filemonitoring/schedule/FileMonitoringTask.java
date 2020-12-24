package com.remo.filemonitoring.schedule;

import java.io.IOException;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FileMonitoringTask {

    private int i = 100;

    @Scheduled(cron = "*/6 * * * * ?")
    private void fileMonitoringTask() throws IOException{
        System.out.println(i = i + 2);
    }
}
