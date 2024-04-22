package step01_board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import step01_board.dao.BoardDAO_연습2;
import step01_board.dto.BoardDTO_연습2;

@WebServlet("/bDetail")
public class DetailBoard_연습2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long boardId = Long.parseLong(request.getParameter("boardId")); // bList에서 받아 온 것
		BoardDTO_연습2 boardDTO = BoardDAO_연습2.getInstance().getDetailBoard(boardId);
		
		request.setAttribute("boardDTO", boardDTO);
		
		RequestDispatcher dis = request.getRequestDispatcher("step01_boardEx/bDetail_연습2.jsp");
		dis.forward(request, response);
	}

}
