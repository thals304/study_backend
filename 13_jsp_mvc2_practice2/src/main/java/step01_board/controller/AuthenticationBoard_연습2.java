package step01_board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import step01_board.dao.BoardDAO_연습2;
import step01_board.dto.BoardDTO_연습2;

@WebServlet("/bAuthentication")
public class AuthenticationBoard_연습2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long boardId = Long.parseLong(request.getParameter("boardId"));
		BoardDTO_연습2 boardDTO = BoardDAO_연습2.getInstance().getDetailBoard(boardId);
		
		request.setAttribute("boardDTO", boardDTO);
		request.setAttribute("menu", request.getParameter("menu"));
		
		RequestDispatcher dis = request.getRequestDispatcher("step01_boardEx/bAuthentication_연습2.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		BoardDTO_연습2 boardDTO = new BoardDTO_연습2();
		long boardId = Long.parseLong(request.getParameter("boardId"));
		boardDTO.setBoardId(boardId);
		boardDTO.setPassword(request.getParameter("password"));
		
		String menu = request.getParameter("menu");
		
		Boolean isAuthenticationUser = BoardDAO_연습2.getInstance().checkAuthenticationUser(boardDTO);
		
		String jsScript = "";
		
		if (isAuthenticationUser) {
			if (menu.equals("update")) {
				jsScript = "<script>";
				jsScript += "location.href='bUpdate?boardId="+ boardId +"';";
				jsScript += "</script>";
			}
			else if (menu.equals("delete")) {
				jsScript = "<script>";
				jsScript += "location.href='bDelete?boardId="+ boardId + "';";
				jsScript += "</script>";
			}
		}
		else {
			jsScript = "<script>";
			jsScript += "alert('Invalid Password')";
			jsScript += "history.go(-1)";
			jsScript += "</script>";
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsScript);
	}

}
