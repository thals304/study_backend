package com.application.aop.chapter01_aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*

	# AOP ( Aspect-Oriented Programming ) 관점 지향 프로그래밍
	
		- 프로젝트 개발 과정에서 핵심 기능 외에 추가적이고 다양한 부가(공통) 기능이 필요로 한다. (로깅 , 보안 , 트랜잭션 , 테스트 , 등등)
		- 이 부가(공통)기능들은 프로젝트에 중요한 역할을 하며 이 부가(공통)기능이 코드마다 반복적(중복)으로 나타나는 부분이 존재한다. 
		- 코드에서 비즈니스 핵심 로직과 부가기능을 분리하여 부가 로직을 따로 관리(모듈화)한다.
		- 종단(비즈니스 로직) 기능 , 횡단(관심,Aspect) 기능 
		- 부가 기능이 비즈니스 로직(핵심 기능)을 담은 클래스의 코드에 전혀 영향을 주지 않으면서 부가기능의 구현을 용이하게 할 수 있는 구조를 제공한다.
		- AOP는 OOP를 대체하는 새로운 개념이 아니라 OOP를 돕는 보조적 기술 중에 하나이다.
		- 스프링 DI  : 의존성(new)주입 , 스프링 AOP  : 로직(code) 주입
		
		
		[ 용어 정리 ]
		
			1) Aspect	   : 관점
			2) Advice	   : 핵심기능에 부여되는 부가기능 ( 타겟 메서드에 적용될 부가 기능 )
			
				2-1) Around (Advice)		 : 대상 객체의 메서드 실행 전,후 및 예외 발생 모두 실행한다.
				2-2) Before (Advice)	     : 대상 객체의 메서드 메서드 호출전에 수행한다.
				2-3) After (Advice)			 : 대상 객체의 메서드 실행도중 예외 발생 여부와 상관없이 메서드 실행 후 실행한다.
				2-4) AfterReturning (Advice) : 대상 객체의 메서드가 실행 도중 예외없이 실행 성공한 경우에 실행한다.
				2-5) AfterThrowing (Advice)  : 대상 객체의 메서드가 실행 도중 예외가 발생한 경우에 실행한다.
			
			3) Pointcut   : Aspect 적용 위치 지정자      ( Advice를 어디에 적용할지를 결정  )
			4) Advisor    : Advice + Pointcut
			5) Joinpoint  : Aspect가 적용한 지점
	
	
	
	# AOP 구현
	
		1) build.gradle 파일에 AOP 의존성 추가
		  
			// AOP
			implementation 'org.springframework.boot:spring-boot-starter-aop' 
		
		2) Application 클래스에 어노테이션 추가
		
			@EnableAspectJAutoProxy
		
		
		3) Advice 클래스에 @Component 및 @Aspect 어노테이션 지정
			
			@Component
			@Aspect
		
		4) Advice 적용
	
	
	
	# execution 명시자 
	
	   - execution(수식어(접근제어자)패턴 리턴타입패턴 패키지이름패턴.클래스이름패턴.메서드이름패턴(파라미터패턴))
	    		Ex)        public           void          com.application.aop.board.dto.boardDetail(long)
	   - 각 패턴은 *을 이용하여 모든값을 표현할 수 있습니다.
	
	   - 패키지
	   com.spring.aop	 > com.spring.aop패키지를 타겟
	   com.spring.aop..  > com.spring.aop로 시작하는 하위의 모든 패키지를 타겟
	
	   - 리턴타입
	   *	 > 모든 리턴 타입 타겟
	   void	 > 리턴 타입이 void인 메서드만 타겟
	   !void > 리턴 타입이 void가 아닌 메서드만 타겟 
	
	   - 매개 변수 지정
	   (..)			> 0개 이상의 모든 파라미터 타겟
	   (*)			> 1개의 파라미터만 타겟
	   (*,*)		> 2개의 파라미터만 타겟
	   (String,*)	> 2개의 파라미터중 첫번째 파라미터가 String타입만 타겟
	
	   - 샘플 예시
	   execution(void set*(..)) 							>> 리턴 타입이 void이고 메서드 이름이 set으로 시작하고 파라미터가 0개 이상인 메서드 타겟
	   execution(* abc.*.*()) 								>> 모든 리턴타입 매칭 , abc패키지에 속한 파라미터가 없는 모든 메서드 타겟
	   execution(* abc..*.*(..)) 							>> 모든 리턴타입 매칭 , abc패키지 및 하위 패키지에 있는 파라미터가 0개 이상인 메서드 타겟
	   execution(long com.spring.aop.Boss.work(..))   		>> 리턴 타입인 long이며 com.spring.aop 패키지 안의 Boss클래스의 work 메서드 타겟
	   execution (* get*(*)) 								>> 모든 리턴타입 매칭 , 이름이 get으로 시작하고 파라미터가 한 개(모든타입)인 메서드 타겟
	   execution(* get*(*,*)) 								>> 모든 리턴타입 매칭 , 이름이 get으로 시작하고 파라미터가 2개인(모든타임) 메서드 타겟
	   execution(* read*(int,..)) 							>> 메서드 이름이 read로 시작하고 첫번째 파라미터 타입이 int이며 한개 이상의 파라미터를 갖는 메서드 타겟

*/

@Aspect
@Component
public class AopAdvice {

	@Pointcut("execution(public void com.application.aop.chapter01_aop.*.work())")
	public void abcde() { // 해당 메서드 이름으로 포인트컷을 적용한다.
		// 특정 의미 없음
	}
	
	// 메서드 호출 전
	//@Before("execution(public void com.application.aop.chapter01_aop.*.work())")
	@Before("abcde()")
	public void beforeWork() {
		System.out.println("(공통기능 , Before)출근한다.");
	}
	
	// 메서드 호출 후
	//@After("execution(public void com.application.aop.chapter01_aop.*.work())")
	@After("abcde()")
	public void afterWork() {
		System.out.println("(공통기능 , After)퇴근한다.\n");
	}
	
	// 메서드 호출 전 후
	@Around("execution(public * com.application.aop.chapter01_aop.*.getWorkingTime())")
	public void aroundGetWorkingTime(ProceedingJoinPoint pjp) throws Throwable {
		
		// 메서드 호출 전
		long startTime = System.currentTimeMillis();
		
		// ProceedingJoinPoint 객체의 proceed(); 메서드를 사용하여 타겟팅 메서드를 실행한다.
		pjp.proceed();
		
		// 메서드 호출 후
		long endTime = System.currentTimeMillis();
		
		System.out.println("메서드 실행 시간 : " + (endTime - startTime)/1000.0 +"초");
	}
	                                                                             // getInfo(..)
	// 메서드 호출 후(예외없이 정상적으로 실행된 후)                                            // getInfo(* , *)
	@AfterReturning(value="execution(public String com.application.aop.chapter01_aop.*.getInfo(String , int))",
			returning="returnObj")
	public void afterReturning(JoinPoint jp , Object returnObj) {  // JoinPoint를 통하여 메서드의 파라메타를 전달받을 수 있다.
		/*
	 	
	 	# 기능 설명
	  
		value: com.application.aop.chapter01_aop 패키지 내의 getInfo 메소드가 실행된 후에 이 어드바이스가 적용된다.
		
		returning: returnObj라는 이름으로 리턴 값을 참조한다.
				   어드바이스 메소드의 파라미터로 지정된 returnObj를 통해 리턴 값을 참조할 수 있다.
		
		JoinPoint : 메소드의 파라미터에 접근할 수 있다.
		
		jp.getArgs() : 메소드의 인수 배열을 반환한다.
		
		jp.getSignature().getName() : 메소드의 이름을 가져온다.
		
		jp.getTarget(): 메소드를 실행한 대상 객체를 가져온다.
	
	*/
		
		System.out.println("\n - get info - \n");
		System.out.println("target object : " + jp.getTarget()); 
		System.out.println("method name : " + jp.getSignature().getName());
		System.out.println("paramter : " + Arrays.toString(jp.getArgs()));
		System.out.println("return : " + returnObj);
	}
	
	@AfterThrowing("execution(public void com.application.aop.chapter01_aop.*.getException())")
	public void afterThrowingGetException() {
		System.out.println("(공통기능, afterThrowing) 로깅 및 트랜잭션 롤백 로직");
	}
}

