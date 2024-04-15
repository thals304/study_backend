package _05_el_jstl;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jstlEx07_연습1정답")
public class JstlEx07_연습1정답 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Random ran = new Random();
		int rNum = ran.nextInt(3); // [0-2]
		String value = "";
		
		if (rNum == 0) value = "가위";
		else if (rNum == 1) value = "바위";
		else value ="보";
		
		request.setAttribute("me", value); 
		RequestDispatcher dis = request.getRequestDispatcher("chapter05_el_jstl/jstlEx07_연습1.jsp");
		dis.forward(request, response);
	}


}
