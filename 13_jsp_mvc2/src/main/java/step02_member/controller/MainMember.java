package step02_member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 24.04.26 time 12:00-14:00
 * today 소감문
 * 분석하는 시간을 가져볼 것이다.
 * 로그인 성공 시 session에 아이디 저장하는 것과 DetailMember에서 session에 저장된 아이디를 불러오는 것이 아직 헷갈림
 * 1) sql , dto , Fileconfig, lib & server 
 * 2) dao 데이터 베이스 연결 및 해지 메서드 + 싱글턴 패턴
 * 3) RegisterMember > 회원가입 (servlet , jsp)
 *    CheckDuplicateId > 아이디 중복 확인 (servlet , jsp , dao)
 * 4) LoginMember > 로그인 (servlet, jsp)
 *    로그인 세션 객체에 정보 저장
 * 5) DetailMember > 유저 디테일 정보 (servlet, jsp)
 * 6) UpdateMember > 회원 정보 수정 
 *    기존 파일 제거
 * 7) LogoutMember > 로그아웃 (servlet)
 *    session에 저장된 정보만 삭제해주면 됨
 * 8) DeleteMEmber > 회원탈퇴  
 * 	 
 *  // 로그아웃이랑 회원탈퇴 다시 분석하기 
 * */
@WebServlet("/mainMember")
public class MainMember extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	// 메인화면 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dis = request.getRequestDispatcher("step02_memberEx/mMain.jsp");
		dis.forward(request, response);
	
	}

}
