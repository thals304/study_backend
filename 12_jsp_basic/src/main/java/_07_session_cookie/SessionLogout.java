package _07_session_cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class SessionLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) request.getSession();	메서드로 Session 객체를 생성한다.
		HttpSession session = request.getSession();
		
		// 2) Session객체에서 로그인관련 데이터를 삭제한다.
		// session.removeAttribute("id");   // 특정 속성 제거
		// session.removeAttribute("role"); // 특정 속성 제거
		
		session.invalidate(); // 전체 속성 제거
		
		// 3) 페이지 이동
		String jsScript = """
			<script>
				alert("로그아웃 되었습니다.");
				location.href = "sessionLogin";
			</script>""";
				
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsScript);

	}

}
