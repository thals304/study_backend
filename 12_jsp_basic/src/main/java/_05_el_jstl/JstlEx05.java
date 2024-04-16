package _05_el_jstl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jstlEx05")
public class JstlEx05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("fileName" , "test_file.png");
	
		RequestDispatcher dis = request.getRequestDispatcher("chapter05_el_jstl/jstlEx05.jsp"); 
		dis.forward(request, response);
		
	}

}
