package com.application.jpa.chapter03_persistenceQueries.QueryDsl.sample;

import org.springframework.stereotype.Repository;


//@RequiredArgsConstructor // final 키워드가 붙거나 @NonNull 어노테이션이 붙은 필드에 대한 생성자를 자동으로 생성
@Repository
public class step04_QueryDslImpl_sample implements step03_QueryDslCustom_sample {

	
	// 1) JPAQueryFactory 객체 주입
	//@Autowired
	//private JPAQueryFactory queryFactory;  // QueryDslConfig 파일의 JPAQueryFactory 객체 주입
	//private final JPAQueryFactory queryFactory; // 이 필드는 @RequiredArgsConstructor에 의해 생성되는 생성자를 통해 자동으로 주입된다.

	/*
	  
	  	2) Q-Type 클래스 생성
	  
	   # Q-Type
	   
		- QProduct와 QBrand는 QueryDSL이 엔티티 클래스(Product와 Brand)로부터 자동으로 생성한 Q-타입 클래스이다.
		
		-이 클래스들은 타입 세이프 쿼리를 작성할 때 해당 엔티티의 필드에 접근하는 데 사용되며
		 Product와 Brand 엔티티에 대한 복잡한 쿼리나 조건을 처리하는 커스텀 리포지토리 메서드를 작성할 수 있다.
	
	*/
	
	//QProduct product = QProduct.product;
	//QBrand brand = QBrand.brand;
	
	
	// 3) 사용자정의 Repository 구현 시작
	/*
	@Override
	public void customSQL1() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void customSQL2() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void customSQL3() {
		// TODO Auto-generated method stub
		
	}
	*/
	
}
