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

@WebServlet("/cart")
public class SessionCart extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	// 카트리스트 화면으로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 1) request.getSession();	메서드로 Session 객체를 생성한다.
		HttpSession session = request.getSession();
		
		// 2)  getAttribute(세션정보); 메서드를 사용하여 로그인관련 데이터를 가져온다.
		String id  = (String)session.getAttribute("id");
		
		// 3-1) Session객체에 정보가 있으면 (인증)
		if (id != null) {	
				/* 
				 
					 3-1-1) DAO에서 유저 관련 데이터를 조회하는 로직 
					   SELECT * FROM MEMBER WHERE MEMBER_ID = 'user';
				 
				 */
				
				// 3-1-2) DAO에서 조회한 데이터를 request객체에 저장
				request.setAttribute("cart1","저장한 상품1" );
				request.setAttribute("cart2","저장한 상품2" );
				request.setAttribute("cart3","저장한 상품3" );
			
				// 3-1-3) View로 페이지 이동 (데이터 포함)
				RequestDispatcher dis = request.getRequestDispatcher("chapter07_session_cookie/07_01_session/cart.jsp"); 
				dis.forward(request, response);
		}	
		// 3-2) Session객체에 정보가 없으면 (비인증)
		else {
			String jsScript = """
					<script>
						alert("로그인을 먼저 진행해주세요");
						history.go(-1);
					</script>
				""";
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();	
			out.print(jsScript);
		}
		
		
	}


}
