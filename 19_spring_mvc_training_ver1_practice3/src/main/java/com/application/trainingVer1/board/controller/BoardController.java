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
 * 24.05.25 time 17:11-17:46
 *               17:51-18:32
 * today 소감문 
 *  실수 및 오류 발생
 *  > html에서 오류가 많이 나는 것 같음 (thymeleaf & url 아직 미숙)
 *  th:onclick="|location.href='@{/board/createBoard}'|"
 *  createBoard.html & updateBoard.html
 * */
@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/createBoard")
	public String createBoard() {
		return "board/createBoard";
	}
	
	@PostMapping("/createBoard")
	@ResponseBody
	public String createBoard(@ModelAttribute BoardDTO boardDTO) {
		
		System.out.println(boardDTO);
		
		boardService.createBoard(boardDTO);
		
		String jsScript = """
				<script>
				alert('게시글 작성되었습니다.');
				location.href='/board/boardList';
				</script>
				""";
		return jsScript;
	}
	
	@GetMapping("/boardList")
	public String boardList(Model model) {
		
		model.addAttribute("boardList", boardService.getBoardList());
		
		return "board/boardList";
	}
	
	@GetMapping("/boardDetail")
	public String boardDetail(@RequestParam("boardId") long boardId, Model model) {
		
		model.addAttribute("boardDTO", boardService.getBoardDetail(boardId, true));
		
		return "board/boardDetail";
	}
	
	@GetMapping("/authentication")
	public String authentication(@RequestParam("boardId") long boardId, 
			                     @RequestParam("menu") String menu , 
			                     Model model  ) {
		
		model.addAttribute("boardDTO", boardService.getBoardDetail(boardId, false));
		model.addAttribute("menu", menu);
		
		return "board/authentication";
		
	}
	
	@PostMapping("/authentication")
	@ResponseBody
	public String authentication(@ModelAttribute BoardDTO boardDTO,
			                     @RequestParam("menu") String menu) {
		String jsScript = "";
		
		if (boardService.checkAuthenticationUser(boardDTO)) {
			if(menu.equals("update")) {
				jsScript ="<script>";
				jsScript += "location.href='/board/updateBoard?boardId="+ boardDTO.getBoardId() +"'";
				jsScript += "</script>";
			}
			else if (menu.equals("delete")) {
				jsScript ="<script>";
				jsScript += "location.href='/board/deleteBoard?boardId="+ boardDTO.getBoardId() +"'";
				jsScript += "</script>";
			}
		}
		else {
			jsScript ="""
					<script>
					alert('비밀번호를 다시 확인해주세요.');
					history.go(-1);
					</script>
					""";
		}
		
		return jsScript;
		
	}
	
	@GetMapping("/updateBoard")
	public String updateBoard(@RequestParam("boardId") long boardId, Model model) {
		
		model.addAttribute("boardDTO", boardService.getBoardDetail(boardId, false));
		
		return "board/updateBoard";
	}
	
	@PostMapping("/updateBoard")
	@ResponseBody
	public String updateBoard(@ModelAttribute BoardDTO boardDTO) {
		
		boardService.updateBoard(boardDTO);
		
		String jsScript = """
				<script>
				alert('게시글 수정되었습니다.');
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
				alert('게시글 삭제되었습니다.');
				location.href='/board/boardList';
				</script>
				""";
		return jsScript;
	}
	
}
