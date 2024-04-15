package _05_el_jstl;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jstlEx08_연습1정답")
public class JstlEx08_연습1정답 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Scanner scan = new Scanner(System.in);
		
		// String myId = scan.next();
		// String myPw = scan.next();
		
		request.setAttribute("myId", "qwer1234");
		request.setAttribute("myPw", "1234");
		
		RequestDispatcher dis = request.getRequestDispatcher("chapter05_el_jstl/jstlEx08_연습1.jsp");
		dis.forward(request, response);
	}

}
