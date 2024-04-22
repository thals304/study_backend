package step01_board.controller;
/*
 * 24.04.22 time 12:05-12:50 13:03-13:50
 * today 소감문
 * BoardDAO 부분에서 싱글턴 패턴부터 데이터 연결시키는 것이 아직 어렵고
 * 데이터 연결은 그냥 복붙을 하는 것 같은데 내가 이해하고 하나씩 써야 하는지
 * 아니면 복붙해도 되는 부분인지 잘 모르겠다.
 * 45-50분 컷 - bList까지 끝냄
 * 20-30분 컷 - bAuthentication ~ bUpdate doGet 끝냄 
 * */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bMain")
public class MainBoard_연습2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("step01_boardEx/bMain_연습2.jsp");
		dis.forward(request, response);
	}

}
