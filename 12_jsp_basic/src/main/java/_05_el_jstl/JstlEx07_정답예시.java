package _05_el_jstl;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jstlEx07_정답예시")
public class JstlEx07_정답예시 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Random ran = new Random();
		int temp = ran.nextInt(3) + 1;

		String value = "";
		if (temp == 1) 		value = "가위";
		else if (temp == 2) value = "바위";
		else if (temp == 3) value = "보";
		
		request.setAttribute("me" , value);
		
		RequestDispatcher dis = request.getRequestDispatcher("chapter05_el_jstl/jstlEx07_정답예시.jsp"); 
		dis.forward(request, response);
		
	}

}
