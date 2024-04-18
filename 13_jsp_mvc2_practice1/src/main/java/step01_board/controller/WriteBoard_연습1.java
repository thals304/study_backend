package step01_board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import step01_board.dao.BoardDAO_연습1;
import step01_board.dto.BoardDTO_연습1;

@WebServlet("/bWrite_연습1")
public class WriteBoard_연습1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("step01_boardEx/bWrite_연습1.jsp");
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 전송받은 데이터를 DTO 형태로 만들기
		BoardDTO_연습1 boardDTO_연습1 = new BoardDTO_연습1();
		boardDTO_연습1.setWriter(request.getParameter("writer"));
		boardDTO_연습1.setSubject(request.getParameter("subject"));
		boardDTO_연습1.setEmail(request.getParameter("email"));
		boardDTO_연습1.setPassword(request.getParameter("password"));
		boardDTO_연습1.setContent(request.getParameter("content"));
		
		System.out.println("boardDTO_연습1 : " + boardDTO_연습1);
		
		// DTO 형태로 바꾼 것을 DAO로 보내기
		BoardDAO_연습1.getInstance().insertBoard(boardDTO_연습1);
	}

}
