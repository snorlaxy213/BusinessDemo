package com.remo.filemonitoring.async;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class FileMonitoringThread {

    private WatchService service;
    private String listenerPath;

    @Async
    public void openFileMonitoring() throws IOException {
        service = FileSystems.getDefault().newWatchService();
        listenerPath = "D:\\TestFile\\";

        Path p = Paths.get(listenerPath);
        p.register(service, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_CREATE);

        try {
            while (true) {
                WatchKey watchKey = service.take();
                List<WatchEvent<?>> watchEvents = watchKey.pollEvents();
                for (WatchEvent<?> event : watchEvents) {

                    
                    // TODO 根据事件类型采取不同的操作。。。。。。。
                    System.out.println(
                            "[" + listenerPath + event.context() + "]文件发生了[" + event.kind() + "]事件" + event.count());
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
