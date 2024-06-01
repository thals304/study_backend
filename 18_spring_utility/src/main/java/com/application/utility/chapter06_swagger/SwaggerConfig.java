package com.application.utility.chapter06_swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	
	@Bean
    public OpenAPI customOpenAPI() {
    	
        return new OpenAPI() // import io.swagger.v3.oas.models.OpenAPI;
                .info(new Info() // import io.swagger.v3.oas.models.info.Info;
                .title("Swagger 실습") // Your API Title 입력
                .description("스웨거 실습") // Your API Description 설명
                .version("1.0")); // version 입력
        
    }
	
	
}
