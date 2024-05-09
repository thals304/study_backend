package com.application.trainingVer1.board.dao;

import org.apache.ibatis.annotations.Mapper;

import com.application.trainingVer1.board.dto.BoardDTO;

@Mapper
public interface BoardDAO {
	
	// Service에서 전달받은 객체를 <id="createBoard"> 매퍼로 전달한다.
	public void createBoard(BoardDTO boardDTO);
	
}
