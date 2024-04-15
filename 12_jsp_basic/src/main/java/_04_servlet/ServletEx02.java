package _04_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletEx02")
public class ServletEx02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// servlet에서 jsp파일로 데이터를 전송할 경우 request.setAttribute("속성명", 값); 메서드를 통하여서 전송한다.
		request.setAttribute("data1", "글자데이터");
		request.setAttribute("data2", 3);
		request.setAttribute("data3", 3.14);
		
		RequestDispatcher dis = request.getRequestDispatcher("chapter04_servlet/servletEx02.jsp"); // webapp 디렉터리 경로부터 기술한다.
		dis.forward(request, response);
	}

}
