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
 * 24.05.20 time 13:43-13:58
 * 24.05.21 time 22:20-23:20
 * 24.05.23 time 10:23-10:35
 * sql logging까지 포함해 MVC spring boot 게시판 만들기 시작
 * 5/20 - 설정, db 생성/연결 및 Controller , Service , DAO 의 injection까지 
 * 5/21 - 게시물 작성, 비밀번호 암호화, 전체 게시물 조회, 게시물 디테일 조회, 수정/삭제를 위한 비밀번호 검사까지 
 * > 실수하고 놓치는 부분 발생 
 *   전체게시물 조회 Controller가 html로 받은 자료 전달해야 하니 GetMapping인 것 
 *   html : @{url 쓰는 방법} & Controller에서 html 전달 "" 쓰는 방법
 *   html : thymleaf에서 writer로 그냥 쓰는게 아닌 boardDTO.writer 형식으로 써야함
 *   html : #dates.format(,) / utext / boardDTOStat.count / th:click="|location.href='@{}'|"
 *   비밀번호 암호화는 자료 보고 해야 기억남 (configuration,boardServiceImpl) 
 *   boardServiceImpl에서 비밀번호가 db에 존재하는지 확인하는 부분
 *   디테일에서 패스워드 입력 후 수정 버튼 눌렀을 때 400 에러 발생
 *   > Failed to convert property value of type 'java.lang.String' to required type 'long' for property 'boardId'
 *		authentication / detailBoard .html에서 내가 오류 발생하는 코드를 쓴 것 같음
 * 5/22 - 게시물 수정, 삭제 끝
 * > 실수하고 놓치는 부분 발생 
 *   updateBoard.html에서 PostMapping에 보낼 정보 중에서 object 사용 시에 filed만 쓰고 name value 안써도 됨 
 *   but, object를 사용 안 할 정보는 반드시 name 써줘야 제대로 Post에 전달 가능
 *   PostMapping에서 @ResponseBody를 쓰지 않는 실수
 * */
@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/createBoard")
	public String createBoard() {
		return "board/createBoard"; // templates/board/createBoard.html로 이동
	}
	
	@PostMapping("/createBoard")
	@ResponseBody
	public String createBoard(@ModelAttribute BoardDTO boardDTO) {
		
		System.out.println(boardDTO);
		
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
	public String boardList(Model model) {
		
		model.addAttribute("boardList" , boardService.getBoardList());
		
		return "board/boardList";
	}
	
	@GetMapping("/boardDetail")
	public String boardDetail(Model model , @RequestParam("boardId") long boardId) {
		
		model.addAttribute("boardDTO", boardService.getBoardDetail(boardId, true));
		
		return "board/boardDetail";
	}
	
	@GetMapping("/authentication")
	public String authentication(@RequestParam("boardId") long boardId, 
			                     @RequestParam("menu") String menu ,
			                     Model model) {
		
		model.addAttribute("boardDTO", boardService.getBoardDetail(boardId, false) );
		model.addAttribute("menu", menu);
		
		return "board/authentication";
	}
	
	@PostMapping("/authentication")
	@ResponseBody
	public String authentication(@ModelAttribute BoardDTO boardDTO, 
			                     @RequestParam("menu") String menu) {
		
		String jsScript ="";
		if (boardService.checkAuthenticationUser(boardDTO)) {
			if (menu.equals("update")) {
				jsScript = "<script>";
				jsScript += "location.href='/board/updateBoard?boardId="+ boardDTO.getBoardId() + "';";
				jsScript += "</script>";
			}
			else if (menu.equals("delete")) {
				jsScript = "<script>";
				jsScript += "location.href='/board/deleteBoard?boardId="+ boardDTO.getBoardId() + "';";
				jsScript += "</script>";
			}
		}
		else {
			jsScript = "<script>";
			jsScript += "alert('패스워드를 확인하세요');";
			jsScript += "history.go(-1);";
			jsScript += "</script>";
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
			 	   alert('수정 되었습니다.');
			 	   location.href = '/board/boardList';
		   	    </script>""";
		
		return jsScript;
	}
	
	@GetMapping("/deleteBoard")
	public String deleteboard(@RequestParam("boardId") long boardId, Model model) {
		
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