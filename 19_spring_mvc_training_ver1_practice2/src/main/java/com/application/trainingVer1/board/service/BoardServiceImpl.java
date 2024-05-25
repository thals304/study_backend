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

	@Override // ServiceImpl에서 getBoardList 와 updateReadCnt로 나뉨
	public BoardDTO getBoardDetail(long boardId, boolean isUpdateReadCnt) {
		
		if (isUpdateReadCnt) {
			boardDAO.updateReadCnt(boardId);
		}
		return boardDAO.getBoardDetail(boardId);
	}

	@Override
	public boolean checkAuthenticationUser(BoardDTO boardDTO) {
		
		String encodedPasswd = boardDAO.getEncodedPasswd(boardDTO.getBoardId());
		
		boolean isAuthentication = passwordEncoder.matches(boardDTO.getPasswd(), encodedPasswd);
				
		return isAuthentication;
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
