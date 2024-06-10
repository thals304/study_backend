package com.application.jpa.chapter03_persistenceQueries.QueryDsl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.jpa.data.Product;
import com.application.jpa.data.QBrand;
import com.application.jpa.data.QProduct;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

/*

	# 객체 주입 방법 2
	
	@RequiredArgsConstructor 					// final 키워드가 붙거나 @NonNull 어노테이션이 붙은 필드에 대한 생성자를 자동으로 생성
	private final JPAQueryFactory queryFactory; // 이 필드는 @RequiredArgsConstructor에 의해 생성되는 생성자를 통해 자동으로 주입된다.

*/


@Repository
public class QueryDslRepositoryImpl implements QueryDslRepositoryCustom {  // 커스텀 인터페이스를 구현하여 사용

	// 객체 주입 방법 1
	@Autowired
	private JPAQueryFactory queryFactory; // QueryDslConfig 파일의 JPAQueryFactory 객체 주입
	
	/*
	
	 	# Q-Type 클래스
	 	
	 	- Q-Type 클래스는 QueryDSL에서 자동으로 생성되며 , JPA 엔티티를 타입 안전하게 쿼리할 수 있도록 돕는 클래스이다.
	 	- Q-Type 클래스를 사용한 쿼리작성이 더욱 간편하고 안전해진다.
	 	- Q-Type 클래스는 각 엔티티 클래스에 대응한다.
	
	 */
	
	
	QProduct product = QProduct.product; // Q(Query)-Type 클래스 생성  
	QBrand brand = QBrand.brand;		 // Q(Query)-Type 클래스 생성
	
	/*
	 
	 	[ QueryDSL 레퍼런스 사이트 ] 
	 
	 	http://querydsl.com/
	 
	 */
	
	// 1-1) 기초 메뉴얼 (전체컬럼 조회)
	@Override
	public List<Product> basicEx01() {
		
		List<Product> products = queryFactory
								.selectFrom(product)
								.fetch(); // (가져오다,데려오다,불러오다) > 리스트로 조회 , 데이터가 없으면 빈 리스트를 반환
		
		// 매핑 후 반환 (추후에 공부)
		
		
		return products;
		
	}
	
	// 1-2) 기초 메뉴얼 (단일컬럼 조회)
	@Override
	public List<String> basicEx02() {
		List<String> productNms = queryFactory
								.select(product.productNm)
								.from(product)
								.fetch();
		return productNms;
	}
	
	// 1-3) 기초 메뉴얼 (2개 이상의 컬럼 조회)
	@Override
	// List<Tuple> : import com.querydsl.core.Tuple;
	public List<Tuple> basicEx03() {
		List<Tuple> products = queryFactory
				              .select(product.productId , product.productNm)
				              .from(product)
				              .fetch();
		
		// 매핑 후 반환(추후에 공부)
		/*for (Tuple tuple : products) {
			// Q-Type class.field 형태로 접근
			long productId = tuple.get(product.productId);
			String productNm = tuple.get(product.productNm);
		
			System.out.println(productId);
			System.out.println(productNm);
		}*/
		
		return products;
	}

	@Override
	public Product whereEx(Long productId) {
		Product result = queryFactory
						.selectFrom(product)
						.where(product.productId.eq(productId))
						.fetchOne(); // 1건 조회 
		return result;
	}

	@Override
	public List<Product> orderByEx(Integer deliveryPrice) {
		List<Product> products = queryFactory
				                .selectFrom(product)
				                .where(product.deliveryPrice.eq(deliveryPrice))
				                .orderBy(product.price.asc())
				                .fetch();
		return products;
	}

	@Override
	public List<Tuple> groupByEx() {
		
		List<Tuple> result = queryFactory
				            .select(product.deliveryPrice , product.price.count())
				            .from(product)
				            .groupBy(product.deliveryPrice)
				            .fetch();
		return result;
	}

	@Override
	public List<Product> joinEx() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> subqueryEx() {
		// TODO Auto-generated method stub
		return null;
	}

}
