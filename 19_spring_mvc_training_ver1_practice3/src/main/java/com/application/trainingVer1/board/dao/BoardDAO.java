package com.application.trainingVer1.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.application.trainingVer1.board.dto.BoardDTO;

@Mapper
public interface BoardDAO {

	public void createBoard(BoardDTO boardDTO);
	
	public List<BoardDTO> getBoardList();
	
	public void updateReadCnt(long boardId);
	
	public BoardDTO getBoardDetail(long boardId);
	
	public String getEncodedPasswd(long boardId);
	
	public void updateBoard(BoardDTO boardDTO);
	
	public void deleteBoard(long boardId);
}
