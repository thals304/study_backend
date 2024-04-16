package _05_el_jstl;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jstlEx04")
public class JstlEx04 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("nData", 100000000.12345);
		request.setAttribute("now" , new Date());
	
		RequestDispatcher dis = request.getRequestDispatcher("chapter05_el_jstl/jstlEx04.jsp"); 
		dis.forward(request, response);
		
	}

}
