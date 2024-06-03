package com.application.trainingVer2.postAdvance.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AuthInterceptorConfig implements WebMvcConfigurer {
   
	
	@Autowired
	private AuthAdminInterceptor authAdminInterceptor;
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
		
        registry.addInterceptor(authAdminInterceptor)   // authAdminInterceptor객체 사용
                .addPathPatterns("/admin/*" ) 		 	// /admin/* 하위경로는 인증 인터셉터 적용	
                .excludePathPatterns("/admin/signIn"); 	// /admin/signIn 경로는 예외 적용

    }
  
	
}