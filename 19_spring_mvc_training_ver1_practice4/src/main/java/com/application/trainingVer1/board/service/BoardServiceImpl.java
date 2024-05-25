package com.application.trainingVer1.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.trainingVer1.board.dao.BoardDAO;
import com.application.trainingVer1.board.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void createBoard(BoardDTO boardDTO) {
		
		boardDTO.setPasswd(passwordEncoder.encode(boardDTO.getPasswd()));
		
		boardDAO.createBoard(boardDTO);
		
	}

	@Override
	public List<BoardDTO> getBoardList() {
		
		return boardDAO.getBoardList();
	}

	@Override
	public BoardDTO getBoardDetail(long boardId, boolean updateReadCnt) {
		
		if (updateReadCnt) {
			boardDAO.updateReadCnt(boardId);
		}
		
		return boardDAO.getBoardDetail(boardId);
	}

	@Override
	public boolean isAuthenticationUser(BoardDTO boardDTO) {
		
		String passwdEncoded = boardDAO.passwdEncoded(boardDTO.getBoardId());
		
		boolean isPasswordExists = passwordEncoder.matches(boardDTO.getPasswd(), passwdEncoded);
		
		return isPasswordExists;
	}

	@Override
	public void updateBoard(BoardDTO boardDTO) {
		
		boardDAO.updateBoard(boardDTO);
		
	}

	@Override
	public void deleteBoard(long boardId) {
		
		boardDAO.deleteBoard(boardId);
		
	}
}
