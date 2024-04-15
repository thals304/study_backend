package _05_el_jstl;

import java.io.IOException;
import java.util.ArrayList;

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
		
		// 배열형 데이터 타입 (3가지 경우)
		ArrayList<String> list1 = null;						// 생성 x
		ArrayList<String> list2 = new ArrayList<String>();	// 생성 o , 데이터 x
		ArrayList<String> list3 = new ArrayList<String>();  // 생성 o , 데이터 o
		list3.add("data1");
		list3.add("data2");
		list3.add("data3");
		
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		request.setAttribute("list3", list3);
		
		// Spring Ver
		// model.addAttribute("list3" , list3); // 주로 사용
		// mv.addObject("list3" , list3);

		RequestDispatcher dis = request.getRequestDispatcher("chapter05_el_jstl/elEx01.jsp");
		dis.forward(request, response);

	}

}
