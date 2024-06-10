package com.application.jpa.chapter03_persistenceQueries.QueryDsl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.jpa.data.Product;

//JPA Repository와 사용자 정의 Repository를 상속받은 Repository를 최종적으로 사용한다.
@Repository
public interface QueryDslRepository extends JpaRepository<Product, Long> , QueryDslRepositoryCustom{

	
}
