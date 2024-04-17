package step01_board.controller;
/*
 * 24.04.17 time 19:30-
 * today 소감문
 * 오늘부터 게시판 만들기 3번씩 연습하기 시작하는 첫 날이다.
 * 첫날이므로 정답예시를 확인하면서 흐름을 이해하고 모르는 부분을 체크하는 시간을 가질 것이다. 
 * db > DTO > DAO 데이터 베이스 연동
 * */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bMain_연습1")
public class MainBoard_연습1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("step01_boardEx/bMain.jsp");
		dis.forward(request, response);
	}

}
