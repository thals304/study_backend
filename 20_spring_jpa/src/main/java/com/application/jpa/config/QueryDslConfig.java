package com.application.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
/*

[ 설명 ] 

1) EntityManager
 
	- @PersistenceContext 어노테이션은 EntityManager의 인스턴스를 자동으로 주입한다. 
	
	- EntityManager는 JPA(Java Persistence API)의 핵심 인터페이스로 엔티티 객체의 생명주기를 관리하고 
	  데이터베이스 쿼리( 데이터를 조회, 저장, 삭제 등의 작업) 를 수행하는 역할을 한다. 
	
	- 이 인스턴스는 영속성 컨텍스트(중요)와 연결되어 있으며 JPA 작업을 위한 기본적인 인터페이스를 제공한다.



	2) JPAQueryFactory
	
		- JPAQueryFactory는 QueryDSL을 사용하여 타입 세이프 쿼리를 생성할 때 사용되는 클래스이다.
   
    - JPAQueryFactory는 생성 시 EntityManager를 필요로 하므로 주입된 EntityManager를 생성자에 전달하여 생성한다.
    
    - JPAQueryFactory 객체를 통해 JPQL이 아닌 자바 코드로 데이터베이스 쿼리를 구성하고 실행할 수 있다.
    
    - JPAQueryFactory 객체를 스프링 빈으로 등록하여 애플리케이션의 다른 부분에서 주입받아 사용한다.
    
*/

@Configuration
public class QueryDslConfig {

		// 1)
		@PersistenceContext
	    private EntityManager entityManager;  
		
		// 2)
	    @Bean
	    public JPAQueryFactory jpaQueryFactory() {
	        return new JPAQueryFactory(entityManager);
	    }
}
