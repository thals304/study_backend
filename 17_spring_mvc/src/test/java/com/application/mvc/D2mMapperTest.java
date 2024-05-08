package com.application.mvc;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.mvc.chapter03_mybatis.D2M;
/*

	# 테스트 코드 
	
	- 테스트 코드를 작성하는 것은 애플리케이션의 안정성을 보장하고, 
	기능이 예상대로 동작하는지 확인하기 위한 중요한 과정이다.
	
	- 단위 테스트(Unit Test): 가장 작은 코드 단위의 기능을 테스트한다.
	보통 메소드 레벨에서 이루어지며, 스프링 컨텍스트를 로드하지 않아 실행 속도가 빠르다.
	
	- @SpringBootTest 애너테이션을 클래스 레벨에 사용하여 스프링 부트의 테스트 환경을 구성한다. 
	@Test 애너테이션을 메서드 레벨에 사용하여 테스트 케이스를 정의한다.

*/
import com.application.mvc.data.BrandDTO;
import com.application.mvc.data.ProductDTO; 

@SpringBootTest
public class D2mMapperTest {
	
	@Autowired
	private D2M d2m;
	
	@DisplayName("단일 데이터 전송 예시 1")
	@Test
	public void ex01() {
		
		long productId = 1;
	    d2m.ex01(productId);
		
	}
	
	
	@DisplayName("단일 데이터 전송 예시 2")
	@Test
	public void ex02() {
		
		long brandId = 6;
		d2m.ex02(brandId);
		
	}
	
	
	@DisplayName("단일 데이터 전송 예시 3")
	@Test
	public void ex03() {
		
		String brandNm = "apple";
		
		for (BrandDTO brandDTO : d2m.ex03(brandNm)) {
			System.out.println(brandDTO);
		}

	}
	
	
	@DisplayName("DTO 전송예시 1")
	@Test
	public void ex04() {
		
		/*
		
			(자주발생하는 오류 원인)
			Duplicate entry '~~~' for key 'PRIMARY' : primary key 중복 에러
			Data too long for column				: 데이터 길이 오버플로우 에러
		 
		 */
		
		BrandDTO brandDTO = new BrandDTO();
		brandDTO.setBrandId(1); 	
		brandDTO.setBrandNm("추가된브랜드");
		brandDTO.setActiveYn("N");
		
	}
	
	
	@DisplayName("DTO 전송예시 2")
	@Test
	public void ex05() {
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNm("추가된 상품1");
		productDTO.setPrice(1);
		productDTO.setDeliveryPrice(1);
		productDTO.setBrandId(1);
		
	}
	
	
	@DisplayName("DTO 전송예시 3")
	@Test
	public void ex06() {
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setPrice(1000000);
		productDTO.setDeliveryPrice(3000);
		
	}
	
	
	@DisplayName("Map 전송예시 1")
	@Test
	public void ex07() {
		
		Map<String, Integer> priceMap = new HashMap<String, Integer>();
		priceMap.put("min", 500000);
		priceMap.put("max", 1000000);
		
	}
	
	
	@DisplayName("Map 전송예시 2")
	@Test
	public void ex08() {
		
		Map<String, String> dateMap = new HashMap<String, String>();
		dateMap.put("startDate","2021-01-01");
		dateMap.put("endDate", "2021-03-31");
		
	}
	
	
	@DisplayName("Map 전송예시3")
	@Test
	public void ex09() {
		
		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("activeYn","N");
		searchMap.put("price", 1000000);
		
		
	}

	
}
