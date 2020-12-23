package com.remo.filemonitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FileMonitoringApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileMonitoringApplication.class, args);
	}

}
