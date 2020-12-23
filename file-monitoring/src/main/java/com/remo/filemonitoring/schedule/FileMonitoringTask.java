package com.remo.filemonitoring.schedule;

import java.io.IOException;

import com.remo.filemonitoring.lister.ResourceListener;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

// @Component
public class FileMonitoringTask {

    private int count=0;
    
    @Scheduled(cron = "*/6 * * * * ?")
    private void fileMonitoringTask() throws IOException{
        System.out.println("this is scheduler task runing  "+(count++));
        ResourceListener.addListener("D:\\TestFile\\");
    }
}
