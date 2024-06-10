package com.application.jpa.chapter03_persistenceQueries.QueryDsl;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.application.jpa.data.Product;
import com.querydsl.core.Tuple;



/*

	# 사용자 정의 레포지토리 생성 절차 (Repository Custom)
	
	1) 사용자정의 인터페이스 생성 (예시 : ~~RepositoryCumstom)
	2) 사용자정의 인터페이스를 구현한 구현체 (Impl Class) 생성 (예시 : ~~RepositoryImpl)  
	3) 데이터 레포지토리(JpaRepoistory상속)에 사용자정의 인터페이스를 다중상속하여 구현 (예시 extends JpaRepoistory<Entity,PK> , ~~RepositoryCustom

*/

public interface QueryDslRepositoryCustom {

	// 1-1) 기초 메뉴얼 (전체컬럼 조회)
	public List<Product> basicEx01();
	
	// 1-2) 기초 메뉴얼 (단일컬럼 조회)
	public List<String> basicEx02();
	
	// 1-3) 기초 메뉴얼 (2개 이상의 컬럼 조회)
	public List<Tuple> basicEx03(); // import com.querydsl.core.Tuple;
	
	// 2) Where 구문 사용 메뉴얼
	public Product whereEx(Long productId);
	
	// 3) Order By 구문 사용 메뉴얼
	public List<Product> orderByEx(@Param("deliveryPrice") Integer deliveryPrice);

	// 4) Group By 사용 메뉴얼
	public List<Tuple> groupByEx();

	// 5) Join 구문 사용 메뉴얼
	public List<Product> joinEx();
	
	// 6) Subquery 구문 사용 메뉴얼
	public List<Product> subqueryEx();
	
}
