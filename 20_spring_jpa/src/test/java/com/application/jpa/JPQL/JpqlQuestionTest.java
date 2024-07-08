package com.application.jpa.JPQL;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.jpa.chapter03_persistenceQueries.JPQL.JpqlRepositoryQuestion;

@SpringBootTest
public class JpqlQuestionTest {

	@Autowired
	private JpqlRepositoryQuestion question;
	
	// 1) 상품의 productId , productNm , price를 조회하는 쿼리를 작성하시오.
	@Order(1) // import org.junit.jupiter.api.Order;
	@DisplayName("question01")
	@Test
	public void question01() {
		
		System.out.println("\n - question01 - \n");
		question.question01();
		
	}
	
	
	// 2) 배송비가 0원인 상품의 전체 컬럼을 조회하는 쿼리를 작성하시오. (파라메타를 전달받아서 구현)
	@Order(2)
	@DisplayName("question02")
	@Test
	public void question02() {
		
		System.out.println("\n - question02 - \n");
		int deliveryPrice = 0;
		question.question02();
		
	}
	
	
	// 3) 가격이 높은 순서대로 상품의 전체컬럼을 조회하시오.
	@Order(3)
	@DisplayName("question03")
	@Test
	public void question03() {
		
		System.out.println("\n - question03 - \n");
		question.question03();
		
	}
	
	
	// 4) 상품의 평균 price를 조회하시오.
	@Order(4)
	@DisplayName("question04")
	@Test
	public void question04() {
		
		System.out.println("\n - question04 - \n");
		question.question04();
		
	}
	
	
	// 5) 2021년에 등록된 상품의 개수를 조회하시오. (파라메타를 전달받아서 구현)
	@Order(5)
	@DisplayName("question05")
	@Test
	public void question05() {
		
		System.out.println("\n - question05 - \n");
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			
			// JPQL에서는 String으로 날짜비교가 안되므로 Date 타입으로 전송
			Date startDate = formatter.parse("2021-01-01");
			Date endDate = formatter.parse("2021-12-31");

			question.question05();
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	
	// 6) 사용중(activeYn = 'Y')인 브랜드의 전체컬럼을 조회하시오. (파라메타를 전달받아서 구현)
	@Order(6)
	@DisplayName("question06")
	@Test
	public void question06() {
		
		System.out.println("\n - question06 - \n");
		String activeYn = "Y";
		
		question.question06();
		
	}
	
	
	// 7) 사용중(activeYn = 'Y')인 브랜드의 brandNm과 해당 브랜드의 productNm컬럼을 조회하시오. (파라메타를
	@Order(7)
	@DisplayName("question07")
	@Test
	public void question07() {
		
		System.out.println("\n - question07 - \n");
		String activeYn = "Y";
		
		question.question07();
		
	}
	
	
	// 8) 'samsung' 브랜드의 상품개수를 조회하시오. (파라메타를 전달받아서 구현)
	@Order(8)
	@DisplayName("question08")
	@Test
	public void question08() {
		
		System.out.println("\n - question08 - \n");
		String brandNm = "samsung";
		
		question.question08();
		
	}
	
	
	// 9) 'lg' 브랜드의 상품 productNm을 조회하시오. (파라메타를 전달받아서 구현)
	@Order(9)
	@DisplayName("question09")
	@Test
	public void question09() {
		
		System.out.println("\n - question09 - \n");
		String brandNm = "lg";
		
		question.question09();
		
	}
	
	
	// 10) '2021년 1사분기(1월~3월)에 입점한 브랜드 상품의 평균 가격을 조회하시오. (파라메타를 전달받아서 구현)
	@Order(10)
	@DisplayName("question10")
	@Test
	public void question10() {
		
		System.out.println("\n - question10 - \n");
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			
			// JPQL에서는 String으로 날짜비교가 안되므로 Date 타입으로 전송
			Date startDate = formatter.parse("2021-01-01");
			Date endDate = formatter.parse("2021-03-31");
			question.question10();
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
