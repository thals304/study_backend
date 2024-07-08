package com.application.trainingVer1.config;

import java.util.List;
import java.util.stream.Collectors;

import com.application.trainingVer1.data.Board;
import com.application.trainingVer1.data.BoardDTO;

//DTO <> Entity 매핑 클래스
public class BoardMapper {

	// DTO > Entity 매핑 정적 메서드
	public static Board toEntity(BoardDTO boardDTO) {

		Board entity = new Board();

		entity.setBoardId(boardDTO.getBoardId());
		entity.setPasswd(boardDTO.getPasswd());
		entity.setWriter(boardDTO.getWriter());
		entity.setSubject(boardDTO.getSubject());
		entity.setContent(boardDTO.getContent());
		entity.setReadCnt(boardDTO.getReadCnt());
		entity.setEnrollAt(boardDTO.getEnrollAt());

		return entity;

	}

	// Entity > DTO 매핑 정적 메서드
	public static BoardDTO toDTO(Board entity) {

		BoardDTO boardDTO = new BoardDTO();

		boardDTO.setBoardId(entity.getBoardId());
		boardDTO.setPasswd(entity.getPasswd());
		boardDTO.setWriter(entity.getWriter());
		boardDTO.setSubject(entity.getSubject());
		boardDTO.setContent(entity.getContent());
		boardDTO.setReadCnt(entity.getReadCnt());
		boardDTO.setEnrollAt(entity.getEnrollAt());

		return boardDTO;

	}

	// List<Entity> > List<DTO> 매핑 정적 메서드
	public static List<BoardDTO> toDTOList(List<Board> boards) {
		return boards.stream().map(BoardMapper::toDTO).collect(Collectors.toList());
	}

}
