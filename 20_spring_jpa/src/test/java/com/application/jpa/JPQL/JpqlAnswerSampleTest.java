package com.application.jpa.JPQL;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.jpa.chapter03_persistenceQueries.JPQL.JpqlRepositoryAnswerSample;
import com.application.jpa.data.Brand;
import com.application.jpa.data.Product;

import jakarta.persistence.Tuple;

@SpringBootTest
public class JpqlAnswerSampleTest {

	@Autowired
	private JpqlRepositoryAnswerSample answerSample;
	
	// 1) 상품의 productId , productNm , price를 조회하는 쿼리를 작성하시오.
	@Order(1) // import org.junit.jupiter.api.Order;
	@DisplayName("answerSample01")
	@Test
	public void answerSample01() {
		
		System.out.println("\n - answerSample01 - \n");
		for (Tuple product : answerSample.answerSample01()) {
			System.out.println("productId : " + product.get("productId"));
			System.out.println("productNm : " + product.get("productNm"));
			System.out.println("price : " + product.get("price"));
			System.out.println();
		}
		
	}
	
	
	// 2) 배송비가 0원인 상품의 전체 컬럼을 조회하는 쿼리를 작성하시오. (파라메타를 전달받아서 구현)
	@Order(2)
	@DisplayName("answerSample02")
	@Test
	public void answerSample02() {
		
		System.out.println("\n - answerSample02 - \n");
		int deliveryPrice = 0;
		for (Product product : answerSample.answerSample02(deliveryPrice)) {
			System.out.println(product);
		}
		System.out.println();
		
	}
	
	
	// 3) 가격이 높은 순서대로 상품의 전체컬럼을 조회하시오.
	@Order(3)
	@DisplayName("answerSample03")
	@Test
	public void answerSample03() {
		
		System.out.println("\n - answerSample03 - \n");
		for (Product product : answerSample.answerSample03()) {
			System.out.println(product);
		}
		System.out.println();
		
	}
	
	
	// 4) 상품의 평균 price를 조회하시오.
	@Order(4)
	@DisplayName("answerSample04")
	@Test
	public void answerSample04() {
		
		System.out.println("\n - answerSample04 - \n");
		System.out.println("평균가격 : " + answerSample.answerSample04());
		System.out.println();
		
	}
	
	
	// 5) 2021년에 등록된 상품의 개수를 조회하시오. (파라메타를 전달받아서 구현)
	@Order(5)
	@DisplayName("answerSample05")
	@Test
	public void answerSample05() {
		
		System.out.println("\n - answerSample05 - \n");
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			
			// JPQL에서는 String으로 날짜비교가 안되므로 Date 타입으로 전송
			Date startDate = formatter.parse("2021-01-01");
			Date endDate = formatter.parse("2021-12-31");
			System.out.println("상품의 개수 : " + answerSample.answerSample05(startDate , endDate));
			System.out.println();
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	
	// 6) 사용중(activeYn = 'Y')인 브랜드의 전체컬럼을 조회하시오. (파라메타를 전달받아서 구현)
	@Order(6)
	@DisplayName("answerSample06")
	@Test
	public void answerSample06() {
		
		System.out.println("\n - answerSample06 - \n");
		String activeYn = "Y";
		
		for (Brand brand : answerSample.answerSample06(activeYn)) {
			System.out.println(brand);
		}
		System.out.println();
		
	}
	
	
	// 7) 사용중(activeYn = 'Y')인 브랜드의 brandNm과 해당 브랜드의 productNm컬럼을 조회하시오. (파라메타를
	@Order(7)
	@DisplayName("answerSample07")
	@Test
	public void answerSample07() {
		
		System.out.println("\n - answerSample07 - \n");
		String activeYn = "Y";
		
		for (Tuple result : answerSample.answerSample07(activeYn)) {
			System.out.println(result);
			System.out.println(result.get("brandNm") + " / " + result.get("productNm"));
			
		}	
		System.out.println();
		
	}
	
	
	// 8) 'samsung' 브랜드의 상품개수를 조회하시오. (파라메타를 전달받아서 구현)
	@Order(8)
	@DisplayName("answerSample08")
	@Test
	public void answerSample08() {
		
		System.out.println("\n - answerSample08 - \n");
		String brandNm = "samsung";
		
		System.out.println("개수 : " + answerSample.answerSample08(brandNm));
		System.out.println();
		
	}
	
	
	// 9) 'lg' 브랜드의 상품 productNm을 조회하시오. (파라메타를 전달받아서 구현)
	@Order(9)
	@DisplayName("answerSample09")
	@Test
	public void answerSample09() {
		
		System.out.println("\n - answerSample09 - \n");
		String brandNm = "lg";
		for (String productNm : answerSample.answerSample09(brandNm)) {
			System.out.println(productNm);
		}
		System.out.println();
		
	}
	
	
	// 10) '2021년 1사분기(1월~3월)에 입점한 브랜드 상품의 평균 가격을 조회하시오. (파라메타를 전달받아서 구현)
	@Order(10)
	@DisplayName("answerSample10")
	@Test
	public void answerSample10() {
		
		System.out.println("\n - answerSample10 - \n");
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			
			// JPQL에서는 String으로 날짜비교가 안되므로 Date 타입으로 전송
			Date startDate = formatter.parse("2021-01-01");
			Date endDate = formatter.parse("2021-03-31");
			System.out.println(answerSample.answerSample10(startDate , endDate));
			System.out.println();
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
