package com.application.trainingVer1.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.trainingVer1.config.BoardMapper;
import com.application.trainingVer1.data.Board;
import com.application.trainingVer1.data.BoardDTO;
import com.application.trainingVer1.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void createBoard(BoardDTO boardDTO) {
		
		boardDTO.setPasswd(passwordEncoder.encode(boardDTO.getPasswd()));
		boardDTO.setEnrollAt(new Date());
		boardDTO.setReadCnt(0l);
		
		boardRepository.save(BoardMapper.toEntity(boardDTO));
	}

	@Override
	public List<BoardDTO> getBoardList() {
		
		List<Board> boards = boardRepository.findAll();
		// List<Board> > List<BoardDTO>로 변환 후 컨트롤러로 전송
		return BoardMapper.toDTOList(boards); 
	}

	@Override
	public BoardDTO getBoardDetail(Long boardId, Boolean isUpdateReadCnt) {
		
		// 1개의 게시물 정보 반환 (entity 타입)
		Board board = boardRepository.findById(boardId).orElse(null);
		
		// readCnt 증가 수정
		if(isUpdateReadCnt) {
			board.setReadCnt(board.getReadCnt() + 1);
			boardRepository.save(board);
		}
			
		return BoardMapper.toDTO(board); // DTO 타입으로 변환 후 컨트롤러로 전송
	}

	@Override
	public boolean checkAuthorizedUser(BoardDTO boardDTO) {
		
		// 암호화된 비밀번호 조회 (JPQL 사용)
		String encodedPasswd = boardRepository.getEncodedPasswd(boardDTO.getBoardId());
		
		// 평문과 암호문 비밀번호를 비교한다.
		boolean isMatched = passwordEncoder.matches(boardDTO.getPasswd(), encodedPasswd);
		
		boolean isAuthorizedUser = false;
		
		if (isMatched) {
			isAuthorizedUser = true;
		}
		
		return isAuthorizedUser;
	}

	@Override
	public void updateBoard(BoardDTO boardDTO) {
		// 저장된 데이터 조회
		Board board = boardRepository.findById(boardDTO.getBoardId()).orElse(null);
		
		// 데이터를 수정한다.
		board.setSubject(boardDTO.getSubject());
		board.setContent(boardDTO.getContent());
		
		// 업데이트
		boardRepository.save(board);
	}

	@Override
	public void deleteBoard(Long boardId) {
		
		boardRepository.deleteById(boardId);
		
	}
	
	
	
	
	
}
