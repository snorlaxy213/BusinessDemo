package com.remo.filemonitoring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.remo.filemonitoring.mapper")
public class FileMonitoringApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileMonitoringApplication.class, args);
	}

}
