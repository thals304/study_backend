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
		// brandDTO.setBrandId(1); 키 중복 오류 
		brandDTO.setBrandId(100); 	
		brandDTO.setBrandNm("추가된브랜드100");
		brandDTO.setActiveYn("N");
		//brandDTO.setActiveYn("N하이헬로우"); char/varchar 정한 길이 넘어가면 에러
		
		d2m.ex04(brandDTO);
		
	}
	
	
	@DisplayName("DTO 전송예시 2")
	@Test
	public void ex05() {
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNm("추가된 상품1");
		productDTO.setPrice(1);
		productDTO.setDeliveryPrice(1);
		productDTO.setBrandId(1);
		
		d2m.ex05(productDTO);
		
	}
	
	
	@DisplayName("DTO 전송예시 3")
	@Test
	public void ex06() {
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setPrice(1000000);
		productDTO.setDeliveryPrice(3000);
		
		for (ProductDTO dto : d2m.ex06(productDTO)) {
			System.out.println(dto);
		}
		
	}
	
	
	@DisplayName("Map 전송예시 1")
	@Test
	public void ex07() {
		
		Map<String, Integer> priceMap = new HashMap<String, Integer>();
		// ProductDTO 에 포함되어 있지 않은 데이터
		priceMap.put("min", 500000);
		priceMap.put("max", 1000000);
		
		for (ProductDTO productDTO : d2m.ex07(priceMap)) {
			System.out.println(productDTO);
		}
		
	}
	
	
	@DisplayName("Map 전송예시 2")
	@Test
	public void ex08() {
		
		Map<String, String> dateMap = new HashMap<String, String>();
		// BrandDTO 에 포함되어 있지 않은 데이터
		dateMap.put("startDate","2021-01-01");
		dateMap.put("endDate", "2021-03-31");
		
		for (BrandDTO brandDTO : d2m.ex08(dateMap)) {
			System.out.println(brandDTO);
		}
		
	}
	
	
	@DisplayName("Map 전송예시3")
	@Test
	public void ex09() {
		
		Map<String, Object> searchMap = new HashMap<String, Object>();
		// DTO 에 포함되어 있지만 , BrandDTO와 ProductDTO에 포함되어 있는 데이터
		searchMap.put("activeYn","N");
		searchMap.put("price", 1000000);
				
		for (Map<String, Object> map : d2m.ex09(searchMap)) {
			System.out.println(map);
		}
	}

	
}
