package _07_session_cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/admin")
public class SessionAdmin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	// 관리자 화면으로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1) request.getSession();	메서드로 Session 객체를 생성한다.
		HttpSession session = request.getSession();
		
		// 2) getAttribute(세션정보); 메서드를 사용하여 권한관련 데이터를 가져온다.
		String role = (String)session.getAttribute("role");
		
		// 3-1) 권한이 관리자 혹은 운영자인지 판별한다. 권한이 있고 admin이면 (인증)
		if (role != null && role.equals("admin")) {
			
			/* 
			 
				 3-1-1) DAO에서 관리자 관련 데이터를 조회하는 로직 
				   SELECT * FROM MEMBER WHERE MEMBER_ID = 'admin';
			 
			 */
			
			// 3-1-2) DAO에서 조회한 데이터를 request객체에 저장
			request.setAttribute("productList" , "상품1, 상품2, 상품3");
			request.setAttribute("userList" , "유저1 , 유저2 , 유저3");
			request.setAttribute("orderList" , "결제1 , 결제2, 결제3");
			
			// 3-1-3) View로 페이지 이동 (데이터 포함)
			RequestDispatcher dis = request.getRequestDispatcher("chapter07_session_cookie/07_01_session/admin.jsp"); 
			dis.forward(request, response);
			
		}
		// 3-2) 로그인을 하지 않았거나 관리자 권한이 아니면 (비인증)
		else {
			
			String jsScript = """
					<script>
						alert("접근 금지");
						history.go(-1);
					</script>
				""";
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();	
			out.print(jsScript);
			
		}
		
		
	}


}
