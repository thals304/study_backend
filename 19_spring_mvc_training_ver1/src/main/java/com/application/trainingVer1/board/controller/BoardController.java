package com.application.trainingVer1.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.trainingVer1.board.dto.BoardDTO;
import com.application.trainingVer1.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService; // BoardService 객체를 주입한다.
	
	@GetMapping("/createBoard") // localhost/board/createBoard로 요청시 아래의 메서드로 매핑된다.
	public String createBoard() {
		return "board/createBoard";  // templates/board/createBoard.html로 이동
	}
	
	@PostMapping("/createBoard") // createBoard.html에서 submit진행시 아래의 메서드로 매핑된다.
	@ResponseBody
	public String createBoard(@ModelAttribute BoardDTO boardDTO) { // <form>태그의 데이터를 BoardDTO타입으로 전달받는다.
		
		// 단위 테스트
		//System.out.println(boardDTO);
		boardService.createBoard(boardDTO);
		
		return "대기";
	}
}
