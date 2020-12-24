package com.remo.filemonitoring;

import java.io.IOException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.remo.filemonitoring.mapper")
@EnableScheduling
@EnableAsync
public class FileMonitoringApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(FileMonitoringApplication.class, args);
	}

}
