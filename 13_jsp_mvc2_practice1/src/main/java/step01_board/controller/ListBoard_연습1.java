package step01_board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import step01_board.dao.BoardDAO_연습1;
import step01_board.dto.BoardDTO_연습1;

@WebServlet("/bList_연습1")
public class ListBoard_연습1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// DB에서 값을 뽑아와서 어레이 리스트에 저장
		// ArrayList<BoardDTO_연습1> boardList = BoardDAO_연습1.getInstance().getBoardList();
		ArrayList<BoardDTO_연습1> boardList = new ArrayList<BoardDTO_연습1>();
		boardList = BoardDAO_연습1.getInstance().getBoardList();
		
		// jsp에 전달
		request.setAttribute("boardList", boardList);
		
		RequestDispatcher dis = request.getRequestDispatcher("step01_boardEx/bList_연습1.jsp");
		dis.forward(request, response);	
	}

}
