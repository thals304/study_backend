package com.application.trainingVer1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.application.trainingVer1.data.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>{

	// 맞춤형 쿼리를 사용하고 싶을 때
	@Query("""
			select b.passwd
			from   Board b
			where  b.boardId = :boardId
			""")
	public String getEncodedPasswd(@Param("boardId") Long boardId);
}
