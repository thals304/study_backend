package com.application.jpa.chapter03_persistenceQueries.JPQL;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.application.jpa.data.Brand;
import com.application.jpa.data.Product;

import jakarta.persistence.Tuple;

@Repository
public interface JpqlRepositoryAnswerSample extends JpaRepository<Product, Long> {

	// 1) 상품의 productId , productNm , price를 조회하는 쿼리를 작성하시오.
	@Query("""
			SELECT p.productId AS productId,
				   p.productNm AS productNm,
				   p.price	   AS price
			FROM   Product p""")
	public List<Tuple> answerSample01();

	// 2) 배송비가 0원인 상품의 전체 컬럼을 조회하는 쿼리를 작성하시오. (파라메타를 전달받아서 구현)
	@Query("""
			SELECT p
			FROM   Product p
			WHERE  p.deliveryPrice = :deliveryPrice""")
	public List<Product> answerSample02(@Param("deliveryPrice") Integer deliveryPrice);

	// 3) 가격이 높은 순서대로 상품의 전체컬럼을 조회하시오.
	@Query("""
			SELECT   p
			FROM     Product p
			ORDER BY p.price DESC""")
	public List<Product> answerSample03();

	// 4) 상품의 평균 price를 조회하시오.
	@Query("""
			SELECT   AVG(p.price)
			FROM     Product p""")
	public Double answerSample04();

	// 5) 2021년에 등록된 상품의 개수를 조회하시오. (파라메타를 전달받아서 구현)
	@Query("""
			SELECT   count(p)
			FROM     Product p
			WHERE    p.enrollDt between :startDate and :endDate""")
	public Integer answerSample05(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	// 6) 사용중(activeYn = 'Y')인 브랜드의 전체컬럼을 조회하시오. (파라메타를 전달받아서 구현)
	@Query("""
			SELECT  b
			FROM    Brand b
			WHERE   b.activeYn = :activeYn""")
	public List<Brand> answerSample06(@Param("activeYn") String activeYn);

	// 7) 사용중(activeYn = 'Y')인 브랜드의 brandNm과 해당 브랜드의 productNm컬럼을 조회하시오. (파라메타를 전달받아서 구현)
	@Query("""
			SELECT 	 	b.brandNm    AS brandNm ,
						p.productNm  AS productNm
			FROM    	Product p
			JOIN   	    p.brand b
			WHERE   	b.activeYn = :activeYn""")
	public List<Tuple> answerSample07(@Param("activeYn") String activeYn);

	// 8) 'samsung' 브랜드의 상품개수를 조회하시오. (파라메타를 전달받아서 구현)
	@Query("""
			SELECT     count(p)
			FROM       Product p
			JOIN  	   p.brand b
			WHERE      b.brandNm = :brandNm""")
	public Long answerSample08(@Param("brandNm") String brandNm);

	// 9) 'lg' 브랜드의 상품 productNm을 조회하시오. (파라메타를 전달받아서 구현)
	@Query("""
			SELECT     p.productNm
			FROM       Product p
			JOIN       p.brand b
			WHERE  	   b.brandNm = :brandNm""")
	public List<String> answerSample09(@Param("brandNm") String brandNm);

	// 10) '2021년 1사분기(1월~3월)에 입점한 브랜드 상품의 평균 가격을 조회하시오. (파라메타를 전달받아서 구현)
	@Query("""
			SELECT     AVG(p.price)
			FROM       Product p
			JOIN 	   p.brand b
			WHERE      b.enteredDt BETWEEN :startDate AND :endDate""")
	public Double answerSample10(@Param("startDate") Date startDate , @Param("endDate") Date endDate);

}
