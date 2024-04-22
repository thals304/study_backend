package step01_board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import step01_board.dao.BoardDAO_연습2;
import step01_board.dto.BoardDTO_연습2;

@WebServlet("/bList")
public class ListBoard_연습2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<BoardDTO_연습2> boardList = BoardDAO_연습2.getInstance().getBoardList();
		
		request.setAttribute("boardList", boardList);
		
		RequestDispatcher dis = request.getRequestDispatcher("step01_boardEx/bList_연습2.jsp");
		dis.forward(request, response);
	}


}
