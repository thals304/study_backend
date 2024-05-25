package com.application.trainingVer1.board.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.trainingVer1.board.dto.BoardDTO;
import com.application.trainingVer1.board.service.BoardService;

/*
 * 24.05.25 time 19:44 - 20:29
 * today 소감문
 * html과 config를 이전 것 복붙하다 싶이 해서 1시간 안에 완성할 수 있었던 것 같다.
 * 아직은 반환값, 파라매터 등이 보내는 건지 받는 건지 헷갈린다.
 * 그래도 게시판 get, post의 흐름은 이제 거의 이해를 한 것 같아
 * thymeleaf > @, $ , ||, location.href ,ckeditor,config
 * */
@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	// 게시물 작성
	@GetMapping("/createBoard")
	public String createBoard() {
		return "board/createBoard";
	}
	
	@PostMapping("/createBoard")
	@ResponseBody
	public String createBoard(@ModelAttribute BoardDTO boardDTO) {
		
		boardService.createBoard(boardDTO);
		
		String jsScript = """
				<script>
					alert('게시글이 작성되었습니다.');
					location.href='/board/boardList';
				</script>
				"""; 
		return jsScript;
	}
	
	@GetMapping("/boardList")
	public String boardList(Model model) { // import org.springframework.ui.Model; (lombok 선택하지 않게 주의)
		
		model.addAttribute("boardList", boardService.getBoardList());
		
		return "board/boardList";
	}
	
	@GetMapping("/boardDetail")
	public String boardDetail(@RequestParam("boardId") long boardId, Model model) {
		
		model.addAttribute("boardDTO" , boardService.getBoardDetail(boardId, true));
		
		return "board/boardDetail";
	}
	
	@GetMapping("/authentication")
	public String authentication(@RequestParam("boardId") long boardId,
			                     @RequestParam("menu") String menu,
			                     Model model) {
		
		model.addAttribute("boardDTO", boardService.getBoardDetail(boardId, false));
		model.addAttribute("menu", menu);
		
		return "board/authentication";
	}
	
	@PostMapping("/authentication")
	@ResponseBody
	public String authentication(@ModelAttribute BoardDTO boardDTO, @RequestParam("menu") String menu) {
	
		String jsScript = "";
		if (boardService.isAuthenticationUser(boardDTO)) {
			if (menu.equals("update")) {
				jsScript = "<script>";
				jsScript += "location.href='/board/updateBoard?boardId="+ boardDTO.getBoardId() +"'";
				jsScript += "</script>";
			}
			else if (menu.equals("delete")) {
				jsScript = "<script>";
				jsScript += "location.href='/board/deleteBoard?boardId="+ boardDTO.getBoardId() +"'";
				jsScript += "</script>";
			}
		}
		else {
			jsScript = """
					<script>
						alert('비밀번호를 다시 확인해주세요.');
						history.go(-1);
					</script>
					""";
		}
		
		return jsScript;
	}
	
	@GetMapping("/updateBoard")
	public String updateBoard(@RequestParam("boardId") long boardId , Model model) {
		
		model.addAttribute("boardDTO", boardService.getBoardDetail(boardId, false));
		
		return "board/updateBoard";
	}
	
	@PostMapping("/updateBoard")
	@ResponseBody
	public String updateBoard(@ModelAttribute BoardDTO boardDTO) {
		boardService.updateBoard(boardDTO);
		
		String jsScript = """
				<script>
					alert('게시글이 수정되었습니다.');
					location.href='/board/boardList';
				</script>
				"""; 
		return jsScript;
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(@RequestParam("boardId") long boardId , Model model) {
		
		model.addAttribute("boardId", boardId);
		
		return "board/deleteBoard";
	}
	
	@PostMapping("/deleteBoard")
	@ResponseBody
	public String deleteBoard(@RequestParam("boardId") long boardId) {
		
		boardService.deleteBoard(boardId);
		
		String jsScript = """
				<script>
					alert('게시글이 삭제되었습니다.');
					location.href='/board/boardList';
				</script>
				"""; 
		return jsScript;
	}
}
