package step01_board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import step01_board.dao.BoardDAO;
import step01_board.dto.BoardDTO;

@WebServlet("/bAuthentication")
public class AuthenticationBoard extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	// 인증화면 달라
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 *  수정 , 삭제버튼을 눌렀을때 인증화면으로 이동시키는 메서드
		 * */
		
		
		long boardId = Long.parseLong(request.getParameter("boardId")); // boardId
		BoardDTO boardDTO = BoardDAO.getInstance().getBoardDetail(boardId, false);
		
		request.setAttribute("boardDTO" , boardDTO); 				// 1개의 게시글 정보를 bAuthentication.jsp로 전달
		request.setAttribute("menu", request.getParameter("menu")); // update문자열을 bAuthentication.jsp로 전달
		
		RequestDispatcher dis = request.getRequestDispatcher("step01_boardEx/bAuthentication.jsp");
		dis.forward(request, response);
		
	}

	// 인증로직 메서드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * bAuthentication.jsp 에서 submit이후를 처리하는 메서드
		 * */
		
		request.setCharacterEncoding("utf-8");
		
		// 전송된 데이터 받기
		String menu = request.getParameter("menu");
		
		// 전송된 데이터를 DTO형태로 만들어서 DAO로 전달
		BoardDTO boardDTO = new BoardDTO();
		long boardId = Long.parseLong(request.getParameter("boardId"));
		boardDTO.setBoardId(boardId);
		boardDTO.setPassword(request.getParameter("password"));
		
		// boardId, password를 전달하고 사용자인증 결과에따라 true , false를 반환
		boolean isAuthenticationUser = BoardDAO.getInstance().checkAuthenticationUser(boardDTO);
		
		String jsScript = ""; // 리액션 변수
		
		// 인증이 되었으면
		if (isAuthenticationUser) {
			
			// update버튼을 클릭했으면
			if (menu.equals("update")) {
				// bUpdate Servlet으로 boardId파라메터와 함께 이동
				jsScript = "<script>";
				jsScript += "location.href='bUpdate?boardId=" + boardId + "';";
				jsScript += "</script>";
			}
			// delete버튼을 클릭했으면
			else if (menu.equals("delete")) {
				// bDelete Servlet으로 boardId파라메터와 함께 이동
				jsScript = "<script>";
				jsScript += "location.href='bDelete?boardId=" + boardId + "';";
				jsScript += "</script>";
			}
			
		}
		else {

			/*
			  
				# history 객체
	
				- 사용자가 방문한 url 정보로 이동하는 객체
	
				[ 페이지 관련 기능 ]
				history.go(-1); 	// 한페이지 뒤로 이동
				history.back();		// 한페이지 뒤로 이동
	
				history.go(1);		// 한페이지 앞으로 이동
				history.forward(); 	// 한페이지 앞으로 이동
				
				history.go(n);		// n페이지 앞으로 이동
				history.go(-n);		// n페이지 뒤로 이동
			
			*/
			jsScript = "<script>";
			jsScript += "alert('Invalid Password')";
			jsScript += "history.go(-1);"; // -1 : 한 칸 뒤로 가기
			jsScript += "</script>";
		}
		
		// 리액션
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsScript);
	
	}

}
