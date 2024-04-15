package _05_el_jstl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/elEx01")
public class ElEx01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("name", "Tim");
		request.setAttribute("num1", 12);
		request.setAttribute("num2", 3);
		
		RequestDispatcher dis = request.getRequestDispatcher("chapter05_el_jstl/elEx01.jsp");
		dis.forward(request, response);

	}

}
