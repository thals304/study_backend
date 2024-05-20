package com.application.aop.chapter03_interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration // 스프링 애플리케이션 설정 클래스로 등록한다.
public class InterceptorExConfig implements WebMvcConfigurer{
	
	/*
	@Autowired
	private InterceptorEx interceptorEx;
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) { // addInterceptors 메서드로 Interceptor 설정 지정
        registry.addInterceptor(interceptorEx)			 	// Interceptor로직을 사용할 객체를 지정
        		//.order(1)                                    	// Interceptor 우선순위를 지정
                .addPathPatterns("/admin/*"); 					 	// Interceptor를 적용할 URL 패턴을 지정
                //.excludePathPatterns("/login", "/register"); 	// Interceptor를 제외할 URL 패턴을 지정
    }
	*/
	
}
