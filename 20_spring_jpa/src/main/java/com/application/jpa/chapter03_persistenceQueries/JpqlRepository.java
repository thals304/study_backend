package com.application.jpa.chapter03_persistenceQueries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.jpa.data.Product;

@Repository
public interface JpqlRepository extends JpaRepository<Product, Long>{

	/*
	
		1. 쿼리 메서드
		
		- Spring Data JPA는 메소드 이름을 분석하여 특정 필드를 사용한 쿼리를 자동으로 생성하고 실행 할 수 있다.
		
		[ 레퍼런스 메뉴얼 ]
		
		https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
	
	 */
	
	// 쿼리 메서드 예시 1) 배송비로 조회하기
	public List<Product> findByDeliveryPrice(Integer deliveryPrice);
	
	// 쿼리 메서드 예시 2) 파라메타보다 큰 가격으로 조회하기
	public List<Product> findByPriceGreaterThan(Integer price);
	
	// 쿼리 메서드 예시 3) 파라메타보다 큰 가격으로 조회한뒤 가격을 내림차순으로 정렬하여 조회하기
	public List<Product> findByPriceGreaterThanOrderByPriceDesc(Integer price);
	
	
	
	/*
	 
		 2. JPQL (Java Persistence Query Language)
		 
		 - JPQL은 SQL과 유사하지만 데이터베이스 테이블 대신 엔티티 '객체 모델을 대상'으로 쿼리를 작성한다.
		 
		 - Keyword는 대소문자를 구분하지 않지만 엔티티 및 속성은 '대소문자를 구분'한다.
		 
		 - 엔티티 이름에는 'ALIAS를 지정하여 사용'한다.
		 
		 - JPQL로 전달되는 데이터는 파라메타의 '순서' 및 '파라메타명'으로 접근할 수 있다.
		  
			  1) 파라메타 순서는 ?index로 표현한다.
			  
			  	[ 예시 ]
			  	
			  	@Query("SELECT p from Product p WHERE p.price >= ?1 and p.deliveryPrice = ?2")
			  	List<Product> ex(Integer price , Integer deliveryPrice); 
		 
		 
			  2) 파라메타 이름은 @Param(파라메타명)으로 데이터를 전달받고 :파라메타명으로 표현한다.
			  
				  [ 예시 ]
				  
				  @Query("SELECT p from Product p WHERE p.price >= :price and p.deliveryPrice = :deliveryPrice")
				  List<Product> ex(@Param("price") Integer price , @Param("deliveryPrice") Integer deliveryPrice);
		 
		 [ 레퍼런스 메뉴얼 ]
			 
		 http://www.java2s.com/Tutorials/Java/JPA/4800__JPA_Query_new_Object.htm
 
	  */

	
	// 1) 기초 메뉴얼    

	
	// 2) Where 구문 사용 메뉴얼
	
	
	// 3) Order By 구문 사용 메뉴얼

	
	// 4) Group By 사용 메뉴얼

	
	// 5) Join 구문 사용 메뉴얼
	
	
	// 6) Subquery 구문 사용 메뉴얼
	
	
	/*
	  
	  	# 추가(insert) , 수정(update) , 삭제(delete)
	  	
		- 기본적으로 @Query는 조회용 쿼리를 실행하는 데 사용되는데, 
		  데이터 변경을 하는 쿼리를 실행할 때는 @Modifying을 함께 사용해야 한다.
	  
	  	- @Modifying 어노테이션은 Spring Data JPA에서 @Query 애노테이션과 함께 사용되며, 
	  	  데이터베이스의 데이터에 변경(삽입, 수정, 삭제)을 수행하는 쿼리임을 나타낸다.
	  	
		- @Transactional은 해당 메서드가 트랜잭션의 일부로 실행되어야 함을 나타내며 
		  해당 어노테이션을 @Modifying 에노테이션과 함께 직접 사용해야 한다. 
		
	 */
	
	
	// 7) insert 구문 사용 메뉴얼(지원 없음)
	
	
	// 8) update 구문 사용 메뉴얼

	
	// 9) delete 구문 사용 메뉴얼
	
}
