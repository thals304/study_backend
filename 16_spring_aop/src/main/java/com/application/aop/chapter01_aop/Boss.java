package com.application.aop.chapter01_aop;

import org.springframework.stereotype.Component;

// 테스트 클래스
@Component
public class Boss {

	public void work() {
		System.out.println("사장의 일을 한다.");
	}
	
	public void getWorkingTime() {
		try {
			Thread.sleep(300); // 0.3초
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
}
