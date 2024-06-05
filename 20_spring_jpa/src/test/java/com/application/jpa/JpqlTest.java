package com.application.jpa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.jpa.chapter03_persistenceQueries.JpqlRepository;
import com.application.jpa.data.Product;

@SpringBootTest
public class JpqlTest {

	@Autowired
	private JpqlRepository jpqlRepository;

	
	@DisplayName("쿼리 메서드 예시 1) 배송비로 조회하기")
	@Test
	public void findByDeliveryPrice() {
		
		System.out.println("\n - 쿼리 메서드 예시 1 - \n");
		
		for (Product product : jpqlRepository.findByDeliveryPrice(0)) {
			System.out.println(product);
		}
		
	}
	
	
	@DisplayName("쿼리 메서드 예시 2) 파라메타보다 큰 가격으로 조회하기")
	@Test
	public void findByPriceGreaterThan() {
		
		System.out.println("\n - 쿼리 메서드 예시 2 - \n");
		
		for (Product product : jpqlRepository.findByPriceGreaterThan(1000000)) {
			System.out.println(product);
		}
	}

	
	@DisplayName("쿼리 메서드 예시 3) 파라메타보다 큰 가격으로 조회한뒤 가격을 내림차순으로 정렬하여 조회하기")
	@Test
	public void findByPriceGreaterThanOrderByPriceDesc() {
	
		System.out.println("\n - 쿼리 메서드 예시 3 - \n");
		
		for (Product product : jpqlRepository.findByPriceGreaterThanOrderByPriceDesc(1000000)) {
			System.out.println(product);
		}
		
	}
	

	
	
	@DisplayName("1) 기초 메뉴얼")
	@Test
	public void basicEx() {
		
		System.out.println("\n - 기초 - \n");
		
		
	}
	
	
	// 2) Where 구문 사용 메뉴얼
	@DisplayName("2) Where 구문 사용 메뉴얼")
	@Test
	public void whereEx() {
		
		System.out.println("\n - Where 구문 사용 - \n");
		
		
	}
	
	
	@DisplayName("3) Order By 구문 사용 메뉴얼")
	@Test
	public void orderByEx() {

		System.out.println("\n - Order By 구문 사용 - \n");
		
	}
	
	
	@DisplayName("4) Group By 사용 메뉴얼")
	@Test
	public void groupByEx() {

		System.out.println("\n - Group By 구문 사용 - \n");
		
	}
	
	
	@DisplayName("5) Join 구문 사용 메뉴얼")
	@Test
	public void joinEx() {
		System.out.println("\n - Join 구문 사용 - \n");
		
	}
	
	
	@DisplayName("6) Subquery 구문 사용 메뉴얼")
	@Test
	public void subqueryEx() {

		System.out.println("\n - Subquery 구문 사용 - \n");
		
	}
	
	
	@DisplayName("7) Insert 구문 사용 메뉴얼(지원 없음)")
	@Test
	public void insertEx() {}
	
	
	@DisplayName("8) Update 구문 사용 메뉴얼")
	@Test
	public void updateEx() {
		
		System.out.println("\n - Update 구문 사용 - \n");
		
		long productId = 101;
		String productNm = "JPQL Update Test";
		
		
	}
	
	
	@DisplayName("9) Delete 구문 사용 메뉴얼")
	@Test
	public void deleteEx() {
		
		System.out.println("\n - Delete 구문 사용 - \n");
		
		long productId = 102;
		
	}
	
}
