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
	
	public String getInfo(String title , int salary) {
		return "(return) title : " + title + " / salary : " + salary;
	}
	
	public void getException() {
		
		//throw new ArithmeticException();
		//System.out.println("코드 잘 돌아감");
		// System.out.println(0/0);
	}

}
