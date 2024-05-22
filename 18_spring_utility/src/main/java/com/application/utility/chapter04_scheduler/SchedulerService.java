package com.application.utility.chapter04_scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
/*

[ 스케쥴링 구현 방법 ] 

	1) 설정
	
		- Application Class에 @EnableScheduling 어노테이션을 추가한다.

	2) 기능 구현
	
	 	- 주기적으로 실행되어야 하는 메서드(Service Layer)위에 @Scheduled(cron="초 분 시 일 월 요일 (연도)") 어노테이션을 사용한 뒤에 스케쥴링을 사용한다.
	 	  [ 사용법은 스프링 배치 스케쥴링.pdf 참조 ]
	 	 
	 	- 스케쥴링에서는 return과 parameter를 사용할 수 없다.

*/

@Service
public class SchedulerService {
	
	@Autowired
	private SchedulerDAO schedulerDAO;
	
	@Scheduled(cron="0 10-15 12 * * *")
	public void schedulerEx() {
		System.out.println("scheduler test");
	}
	
	// 초 분 시 일 월 요일 (컴퓨터시간에 의존)
	@Scheduled(cron="0 0 15 * * *") 
	public void getProductList() {
		
		System.out.println("ex) 15시 스케쥴러");
		schedulerDAO.getProductList();
	}
	
	@Scheduled(cron="0 0 17 * * *")
	public void getBrandList() {
		System.out.println("ex) 17시 스케쥴러");
		schedulerDAO.getBrandList();
	}
	
}
