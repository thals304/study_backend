package step01_board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import step01_board.dao.BoardDAO;
import step01_board.dto.BoardDTO;

@WebServlet("/bDetail")
public class DetailBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 주는 것을 받자(boardId)
		long boardId = Long.parseLong(request.getParameter("boardId"));
		
		// DB로 보내서 게시글 검색해오기
		BoardDTO boardDTO = BoardDAO.getInstance().getBoardDetail(boardId);
		
		// bDetail.jsp로 데이터 보내기
		request.setAttribute("boardDTO", boardDTO);
		
		RequestDispatcher dis = request.getRequestDispatcher("step01_boardEx/bDetail.jsp");
		dis.forward(request, response);
	}

}
