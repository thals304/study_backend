package com.application.jpa.JPQL;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.jpa.chapter03_persistenceQueries.JPQL.JpqlRepository;
import com.application.jpa.data.Product;

import jakarta.persistence.Tuple;

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
	

	
	
	@DisplayName("1-1) 기초 메뉴얼 (전체컬럼)")
	@Test
	public void basicEx01() {
		
		System.out.println("\n - 기초(전체컬럼) - \n");
		
		List<Product> products = jpqlRepository.basicEx01();
		
		for (Product product : products) {
			System.out.println(product);
		}
		System.out.println();
		
		
	}
	
	
	@DisplayName("1-2) 기초 메뉴얼 (단일컬럼)")
	@Test
	public void basicEx02() {
		
		System.out.println("\n - 기초(단일컬럼) - \n");
		
		List<String> productNms = jpqlRepository.basicEx02();
		for (String productNm : productNms) {
			System.out.println(productNm);
		}
		System.out.println();
		
	}
	
	
	@DisplayName("1-3) 기초 메뉴얼 (2개 이상 컬럼)")
	@Test
	public void basicEx03() {
		
		System.out.println("\n - 기초(2개 이상 컬럼) - \n");
		
//		List<Object[]> products = jpqlRepository.basicEx03();
//		for (Object[] objects : products) {
//			System.out.println(objects[0] + " / " + objects[1]);
//		}
		
		List<Tuple> products = jpqlRepository.basicEx03();
		for (Tuple product : products) {
			
			// 튜플
			System.out.println(product);
			
			// 튜플 요소 접근 (index)
			System.out.println("tuple elements(index) : " + product.get(0) + " / " + product.get(1));
			
			// 튜플 요소 접근 (alias)
			System.out.println("tuple elements(alias) : " + product.get("productNm") + " / " + product.get("price"));
			System.out.println();
			
		}
		System.out.println();
		
	}
	
	
	// 2) Where 구문 사용 메뉴얼
	@DisplayName("2) Where 구문 사용 메뉴얼")
	@Test
	public void whereEx() {
		
		System.out.println("\n - Where 구문 사용 - \n");
		int min = 500000;
		int max = 1000000;
		
		List<Product> products = jpqlRepository.whereEx(min , max);
		for (Product product : products) {
			System.out.println(product);
		}
		System.out.println();
		
	}
	
	
	@DisplayName("3) Order By 구문 사용 메뉴얼")
	@Test
	public void orderByEx() {

		System.out.println("\n - Order By 구문 사용 - \n");
		int deliveryPrice = 0;
		
		List<Product> products = jpqlRepository.orderByEx(deliveryPrice);
		for (Product product : products) {
			System.out.println(product);
		}
		System.out.println();
		
	}
	
	
	@DisplayName("4) Group By 사용 메뉴얼")
	@Test
	public void groupByEx() {

		System.out.println("\n - Group By 구문 사용 - \n");
	
		List<Tuple> results = jpqlRepository.groupByEx();
		for (Tuple result : results) {
			System.out.println(result);
			System.out.println(result.get("deliveryPrice") + " / " +  result.get("count"));
			System.out.println();
		}
		System.out.println();
		
	}
	
	
	@DisplayName("5) Join 구문 사용 메뉴얼")
	@Test
	public void joinEx() {
		
		System.out.println("\n - Join 구문 사용 - \n");
		List<Product> products = jpqlRepository.joinEx();
		for (Product product : products) {
			System.out.println(product);
		}
		System.out.println();
		
	}
	
	
	@DisplayName("6) Subquery 구문 사용 메뉴얼")
	@Test
	public void subqueryEx() {

		System.out.println("\n - Subquery 구문 사용 - \n");
		List<Product> products = jpqlRepository.subqueryEx();
		for (Product product : products) {
			System.out.println(product);
		}
		System.out.println();
		
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
