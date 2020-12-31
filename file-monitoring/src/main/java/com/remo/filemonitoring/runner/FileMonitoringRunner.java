package com.remo.filemonitoring.runner;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class FileMonitoringRunner implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileMonitoringRunner.class); 

    private static WatchService service;
    private static final String listenerPath = "D:\\TestFile\\";

    @Override
    @Async
    public void run(ApplicationArguments args) throws Exception {
        service = FileSystems.getDefault().newWatchService();
        Path p = Paths.get(listenerPath);
        p.register(service, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_CREATE);

        try {
            while (true) {
                WatchKey watchKey = service.take();
                List<WatchEvent<?>> watchEvents = watchKey.pollEvents();
                for (WatchEvent<?> event : watchEvents) {
                    String filePath = listenerPath + event.context();
                    LOGGER.info("[" + filePath + "]文件发生了[" + event.kind() + "]事件" + event.count());
                    

                }
                watchKey.reset();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                service.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    

}
