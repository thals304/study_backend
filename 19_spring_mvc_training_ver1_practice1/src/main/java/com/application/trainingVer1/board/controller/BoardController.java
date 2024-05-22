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
 * 24.05.12 time 21:40-22:23
 * 24.05.14 time 13:00-13:51 14:00-14:17 22:05-22:56
 * DB 연결 -> DTO -> Controller & Service & ServiceImpl & DAO & mapper
 *                 (injection)
 * 게시글 작성하기 : Controller(GetMapping) -> createBoard.html -> Controller(PostMapping)  
 * ->Service -> ServiceImpl -> DAO -> mapper 
 * 500 에러 발생 > templates.board를 만들고 그 안에 createBoard.html을 만들어야함
 * 게시글 전체보기 :  mapper -> DAO -> Service & ServiceImpl -> Controller -> html
 * 게시글 디테일하게 보기 : boardList.html -> Controller <> Service & ServiceImple (readCnt 증가와 detail 게시물 보기가 나눠짐) <> DAO <> mapper 
 * 								    boardDetail.html
 * 500 에러 발생 > boardDetail에 model로 보낼 때 "boardDTO"로 보내야 html에서도 boardDTO.writer ~~로 사용 가능
 * 수정/삭제 버튼 클릭 시 비밀번호 인증 : boardDetail.html -> Controller -> authentication.html -> Controller 
 * <> Service & ServiceImpl (비밀번호 인증 처리) <> DAO <> mapper
 * 400 에러 발생 > boardDetail에서 boardId 이름이 틀려 넘어가지 않음
 * 500 에러 발생 > PasswordEncoder가 null이라는 오류인데 ServiceImpl에서 PasswordEncoder에 @Autowired를 해주지 않아서 생긴 문제
 * 404 에러 발생 > 아직 updateBoard를 만들지 않아서 생긴 문제
 * 게시글 수정하기 : (authentication) Controller -> (updateBoard) Controller -> updateBoard.html -> Controller
 * -> Service & ServiceImpl -> DAO -> mapper
 * 500 에러 발생 > Column 'CONTENT' cannot be null 해결 못함
 *                  updateBoard.html에서 dates 형식 yyyy인데 yy라고 작성 & hidden boardId에서 name을 작성함 
 *                  th:utext=*{content}는 th:field가 아니기 때문에 반드시 name을 써줘야 함
 *                  Controller(PostMapping)에서 location
 * mapper에서 parameterType="BoardDTO"인가 "boardDTO"인가? BoardDTO
 * 게시글 삭제하기 : (authentication) Controller -> (deleteBoard) Controller -> deleteBoard.html -> Controller
 * -> Service & ServiceImpl -> DAO -> mapper
 * 405 에러 발생 > Method 'POST' is not supported. : @PostMapping("")의 url을 deleteBoard가 아닌 delteBoard라고 잘못 작성
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
	public String updateBoard(@RequestParam("boardId") long boardId,
			                  Model model) {
		System.out.println(boardId);
		
		model.addAttribute("boardDTO", boardService.getBoardDetail(boardId, false));
		
		return "board/updateBoard";
	}
	
	@PostMapping("/updateBoard")
	@ResponseBody
	public String updateBoard(@ModelAttribute BoardDTO boardDTO) {
		
		System.out.println(boardDTO);
		
		boardService.updateBoard(boardDTO);
		// responseBody를 쓰고 /board/boardList로 보냈는데 /board/board/boardList로 가는 이유?
		String jsScript = """
				<script>
				alert('게시글 수정되었습니다');
				location.href='/board/boardList'; 
				</script>
				""";
		
		return jsScript;
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(@RequestParam("boardId") long boardId ,Model model) {
		
		model.addAttribute("boardId", boardId);
		
		return "board/deleteBoard";
	}
	
	@PostMapping("/deleteBoard")
	@ResponseBody
	public String deleteBoard(@RequestParam("boardId") long boardId) {
		
		boardService.deleteBoard(boardId);
		
		String jsScript = """
				<script>
				alert('삭제되었습니다.');
				location.href = '/board/boardList';
				</script>
				""";
		return jsScript;
	}
}
