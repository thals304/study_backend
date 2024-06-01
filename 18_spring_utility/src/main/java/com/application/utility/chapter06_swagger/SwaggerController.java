package com.application.utility.chapter06_swagger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/swagger")
public class SwaggerController {
	
	/* 
	 
	   - 'build.gradle' 파일에 의존성 추가 후 사용 
	    implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0'
	   
	   - swagger 구현 URL : localhost/swagger-ui/index.html
	
	*/
	
	// 1) Basic
	@GetMapping("/basic")
	public String basic(@RequestParam("basicInput") String basicInput) {
		
		System.out.println("--- basic ---");
		System.out.println("basicInput : " + basicInput);
		
		return "";
		
	}
	
	
	/*
	 
	 	2) Description
	 
	 	- Operation 어노테이션을 사용하여, 각 API에 대한 설명을 추가할 수 있다.
	 	
	 	[ 형식 ] 
	 	@Operation(summary = "설명요약" , description = "설명상세")
	 
	 
	 */
	@Operation(summary="Swagger 실습" , description="Swagger - operation")
	@GetMapping("/operation")
	public String operation() {
		
		System.out.println("--- @Operation ---");
		
		return "";
		
	}
	
	
	/*
	 
	 	3) Parameter
	 
	 	@Parameters 어노테이션을 사용하여 파라미터에 대한 정보를 나타낼 수 있다.
	 	
	 	[ 형식 ] 
	 	
	 	@Parameters({
	        @Parameter(name = "설명이름1" , description = "설명1" , example = "예시1"),
	        @Parameter(name = "설명이름2" , description = "설명2" , example = "예시2")
		})
	 
	 */
	@Parameters({
        @Parameter(name = "전송데이터1" , description = "테스트 문자열" , example = "yyyy-MM-dd"),
        @Parameter(name = "전송데이터2" , description = "테스트 정수" , example = "13579")
	})
	@GetMapping("/parameter")
	public String parameter(@RequestParam("testString") String testString , 
							@RequestParam("testInt") int testInt) {
		
		System.out.println("--- @Parameters ---");
		System.out.println("testString : " + testString);
		System.out.println("testInt : " + testInt);
		
		
		return "Parameter Output Data";
		
	}
	

	
	
	/*
	 
	 	4) ApiResponse
	 
	 	@ApiResponses 어노테이션을 사용하여 응답 코드에 대한 정보를 나타낼 수도 있다.
	 	
	 	[ 형식 ]
	 	 
	 	@ApiResponses(value={
			@ApiResponse(responseCode="응답코드1" , description="설명1"),
			@ApiResponse(responseCode="응답코드2" , description="설명2")
		})
	 
	 */
	@ApiResponses(value={
			@ApiResponse(responseCode="200" , description="성공"),
			@ApiResponse(responseCode="400" , description="잘못된 파라메타"),
			@ApiResponse(responseCode="404" , description="잘못된 url"),
			@ApiResponse(responseCode="405" , description="잘못된 방식"),
			@ApiResponse(responseCode="500" , description="내부 오류")
		})
	@GetMapping("/apiResponse")
	public String apiResponse() {
		
		System.out.println("--- @ApiResponse ---");
		
		return "ApiResponse Output Data";
		
	}
	
	
	// 5) Synthesize@Parameters({
   
	@Operation(summary="Swagger 종합실습" , description="Swagger - operation")
	@Parameters({
        @Parameter(name = "전송데이터1" , description = "테스트 문자열" , example = "yyyy-MM-dd"),
        @Parameter(name = "전송데이터2" , description = "테스트 정수" , example = "13579")
	})
	@ApiResponses(value={
			@ApiResponse(responseCode="200" , description="성공"),
			@ApiResponse(responseCode="400" , description="잘못된 파라메타"),
			@ApiResponse(responseCode="404" , description="잘못된 url"),
			@ApiResponse(responseCode="405" , description="잘못된 방식"),
			@ApiResponse(responseCode="500" , description="내부 오류")
		})
	@GetMapping("/synthesize")
	public String synthesize(@RequestParam("testString") String testString , 
			@RequestParam("testInt") int testInt) {
		
		System.out.println("--- synthesize ---");
		System.out.println("testString : " + testString);
		System.out.println("testInt : " + testInt);
		
		return "Synthesize Output data";
		
	}
	
}
