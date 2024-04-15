package _05_el_jstl;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JstlEx09_연습1정답")
public class JstlEx09_연습1정답 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Random ran = new Random();
		
		int rNum = ran.nextInt(2); //[0-1]
		boolean isChecked = true; 
		if (rNum == 0) isChecked = false;
		else isChecked = true;
		
		request.setAttribute("isChecked", isChecked);
		
		RequestDispatcher dis = request.getRequestDispatcher("chapter05_el_jstl/jstlEx09_연습2.jsp");
		dis.forward(request, response);
	}

}
