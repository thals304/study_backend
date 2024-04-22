package _07_session_cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*

# 세션(Session)

	- HTTP 프로토콜은 클라이언트의 요청(request)과 서버의 응답(response)이 이루어지고 나면 더 이상 연결상태를 '지속'하지 않는다.
	
	- 클라이언트와 서버의 연결 정보를 계속 유지할 방법이 필요한데 대표적으로 '쿠키(Cookie)'와 '세션(Session)'이 있다. 
	
	- 세션은 클라이언트와의 연결 정보를 유지하기 위한 정보를 웹 컨테이너(웹 서버)에 저장한다.
	
	- 쿠키는 클라이언트와의 연결정보를 유지하기 위한 정보를 클라이언트측에 저장한 뒤에 웹 서버가 클라이언트의 웹브라우저에서 쿠키를 읽어서 사용한다.
	
	- 클라이언트측에 저장된 연결정보(쿠키)는 연결정보가 클라이언트에서 관리되고 있다는 점에서 
	  연결정보를 서버측에서 관리하는 것보다 보안상 문제가 생길 확률이 많다. 
	
	- 세션은 클라이언트와의 연결정보를 서버에서 관리하므로 보안적인 측면에서 쿠키보다 안전하다.
	
	- 세션만을 사용하면 서버에 부하를 줄 수도 있으므로 쿠키와 세션을 각각 목적에 맞게 사용하도록 권장한다.
	

	[ 자주 사용되어지는 메서드 ]

	setAttribute(속성명, 값) 				: 세션 속성명과 속성값으로 value를 할당한다. 
	getAttribute(속성명) 					: 세션 속성명의 값을 Object 타입으로 리턴한다.(할당했던 데이터 타입으로 형변환 후 사용) 
									      해당 되는 속성명이 없을 경우에는 null 값을 리턴한다.
	removeAttribute(속성명)				: 세션속성을 제거한다. (해당 속성만 제거) 
	invalidate() 						: 세션속성을 제거한다. (초기화 , 주로 로그아웃시 사용)
	setMaxInactiveInterval(유지기간(초))	: 세션을 유지하기 위한 세션 유지시간을 초 단위로 설정한다. (기본값은 30분)

*/
import javax.servlet.http.HttpSession;

@WebServlet("/sessionLogin")
public class SessionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 로그인(인증)화면 요청 or 로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("chapter07_session_cookie/07_01_session/sessionLogin.jsp"); 
		dis.forward(request, response);

	}
	// 로그인 기능 처리 로직
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 전송된 id , password를 받는다.
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
	    // 2) SQL쿼리로 인증한다. 
		// 예시 : SELECT * FROM MEMBER WHERE MEMBER_ID = ? AND PASSWORD = ?
		
		String dbId = "qwer1234";
		String dbPasswd = "qwer1234";
		String dbRole = "user";
		
		
		// 3-1) 인증된 유저이면 session객체에 관련된 정보를 저장한다.
		if (dbId.equals(id) && dbPasswd.equals(passwd) ) {
				
				// 3-1-1) request.getSesstion(); 메서드로 Session 객체를 생성 한다.
				HttpSession session = request.getSession();
				
				// 3-1-2) 세션객체에 인증 관련 정보를 등록한다. 
				// session.setAttribute("세션정보" , 데이터);
				session.setAttribute("id", id );
				session.setAttribute("role", dbRole); // 권한
				
				// 3-1-3) View로 페이지 이동
				RequestDispatcher dis = request.getRequestDispatcher("chapter07_session_cookie/07_01_session/memberView.jsp"); 
				dis.forward(request, response);

		}
		// 3-2) 인증된 유저가 아니면 비인증 유저에 관한 절차를 진행한다.
		else {
			String jsScript = """
					<script>
						alert("패스워드를 확인하세요.");
						history.go(-1);
					</script>
				""";
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();	
			out.print(jsScript);
			

		}

	}

}
