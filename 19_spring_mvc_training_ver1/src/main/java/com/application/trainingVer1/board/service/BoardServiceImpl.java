package com.application.trainingVer1.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.trainingVer1.board.dao.BoardDAO;
import com.application.trainingVer1.board.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO; // BoardDAO 객체를 주입한다.

	@Override
	public void createBoard(BoardDTO boardDTO) {
		
		// 비밀번호를 암호화할 예정
		boardDAO.createBoard(boardDTO);
	}
}
