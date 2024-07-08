package com.application.jpa.chapter04_entityRelation.manyToOne;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
	// repository가 있어야 test 코드 사용 가능
}
