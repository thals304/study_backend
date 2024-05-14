package com.application.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.aop.chapter01_aop.Boss;
import com.application.aop.chapter01_aop.Employee;
import com.application.aop.chapter01_aop.Manager;

@SpringBootTest
public class AopTest {

	@Autowired
	private Boss boss;
	
	@Autowired
	private Manager manager;
	
	@Autowired
	private Employee employee;
	
	@Test
	void testMethod() {
		boss.work();
		manager.work();
		employee.work();
		
		System.out.println("\n\n");
		
		boss.getWorkingTime();
		manager.getWorkingTime();
		employee.getWorkingTime();
	}
}
