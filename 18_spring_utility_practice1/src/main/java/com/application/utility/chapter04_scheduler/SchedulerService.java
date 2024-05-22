package com.application.utility.chapter04_scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {

	@Autowired
	private SchedulerDAO schedulerDAO;
	
	// 초 분 시 일 월 요일
	@Scheduled(cron="* 32 13 * * *")
	public void getProductList() {
		System.out.println("ex)13시 31분 스케쥴러");
		schedulerDAO.getProductList();
	}
}
