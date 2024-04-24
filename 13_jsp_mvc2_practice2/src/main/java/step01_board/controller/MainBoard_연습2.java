package step01_board.controller;
/*
 * 24.04.22 time 12:05-12:50 13:03-13:50 15:26-
 * today 소감문
 * BoardDAO 부분에서 싱글턴 패턴부터 데이터 연결시키는 것이 아직 어렵고
 * 데이터 연결은 그냥 복붙을 하는 것 같은데 내가 이해하고 하나씩 써야 하는지
 * 아니면 복붙해도 되는 부분인지 잘 모르겠다.
 * 처음 게시물 형태를 접하고 이해하면서 따라해 보는 과정은 거의 4시간이 걸렸던 것 같다.
 * 근데 지금은 어떤 것은 복붙을 해도 되고 흐름을 이해하는 과정도 빨라져 시간을 조금 줄일 수 있었던 것 같다.
 * 하지만, 아직도 코드를 보고 따라하는 부분들이 존재하기 때문에 더 많이 복습하면서 디테일을 채우고
 * 내 머리로만 코드를 처음부터 끝까지 끝낼 수 있도록 도전할 것이다.
 * 45-50분 컷 - bList까지 끝냄
 * 20-30분 컷 - bAuthentication ~ bUpdate doGet 끝냄 
 * 20-30분 컷 - bUpdate doPost ~ bDelete 끝냄 (bUpdate에서 오류가 없었으면 더 빨라질 수 있음)
 *  //jsva.lang.NumberFormatException 오류 발생 > form(jsp)에서 boardId 보내는 것을 boarId라고 스펠링 잘못씀 
 *  // 연습1에서 인증-패스워드 인증 실패시 발생한 문제가 똑같이 일어남 > java.lang.NumberFormatException: Cannot parse null string 
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
