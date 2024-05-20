package com.application.aop.chapter03_interceptor.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AuthInterceptorConfig implements WebMvcConfigurer {

	@Autowired
	private AuthInterceptorAdmin authInterceptorAdmin;
	
	@Autowired
	private AuthInterceptorUser authInterceptorUser;
	
	String[] adminAccessModifierList = {"/admin/*" , "/management/*"};
	String[] userAccessModifierList = {"/user/*" , "/post/*"};
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) { 	// addInterceptors 메서드로 Interceptor 설정 지정
        registry.addInterceptor(authInterceptorAdmin)				// Interceptor로직을 사용할 객체를 지정
        		.order(1)                                  // Interceptor 우선순위를 지정
                .addPathPatterns(adminAccessModifierList); // Interceptor를 적용할 URL 패턴을 지정
        
        registry.addInterceptor(authInterceptorUser)	    // Interceptor로직을 사용할 객체를 지정
				.order(2)                                    		// Interceptor 우선순위를 지정
		        .addPathPatterns(userAccessModifierList);
	}
	
}
