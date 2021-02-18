package com.example.demo.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.scheduling.annotation.Scheduled;

//@Configuration
//@EnableScheduling
public class TaskDemo {
	
	// fixedRate 表示时间间隔，单位毫秒
	// fixedDelay 表示任务间隔
	@Scheduled(fixedDelay = 10000)
	private void task() {
		System.out.println("-----------------task job "+LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)+"--------------------");
	}

}
