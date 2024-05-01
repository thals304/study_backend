package step02_member.controller;
/*
 * 24.04.30 time 20:30-21:54 22:25-22:45
 * today 소감문
 * 저번에는 정답예시를 보면서 이해하는 시간을 가졌고 이번에는 이해 + 따라해보기 시간을
 * 가지고자 한다.
 * DAO > 싱글턴 패턴 더 공부하기
 * mRegister.jsp > 아이디 중복체크 type: "get"인 이유? 
 *               > 유효성 체크 checkForm()을 아이디와 비번만 해준 이유?
 * 회원가입 DAO > INSERT INTO MEMBER VALUES()를 ORDER_CD 신경안쓰고 VALUES(?,?,,,)로 해도 되는건가?
 *             INSERT INTO MEMBER(MEMBER_ID, , ) VALUES(?, ? , )로 안하고?
 * 
 * */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mainMember")
public class MainMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("step02_memberEx/mMain.jsp");
		dis.forward(request, response);
	}

}
