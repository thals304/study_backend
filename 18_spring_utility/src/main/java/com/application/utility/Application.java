package com.application.utility;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // 스케쥴러 사용 어노테이션
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
