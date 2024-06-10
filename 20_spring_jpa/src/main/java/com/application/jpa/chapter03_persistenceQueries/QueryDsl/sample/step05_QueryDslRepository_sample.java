package com.application.jpa.chapter03_persistenceQueries.QueryDsl.sample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.jpa.data.Product;

/*
 * 
 * 사용자 정의 리포지토리
 * 
 * 사용자정의 인터페이스 작성
 * 사용자정의 인터페이스 구현
 * 스프링 데이터 리포지토리에 사용자정의 인터페이스 상속
 * */

@Repository
public interface step05_QueryDslRepository_sample extends JpaRepository<Product, Long> , step03_QueryDslCustom_sample {

}
