package step01_board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import step01_board.dao.BoardDAO_연습2;

@WebServlet("/bDelete")
public class DeleteBoard_연습2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long boardId = Long.parseLong(request.getParameter("boardId"));
		
		request.setAttribute("boardId", boardId);
		
		RequestDispatcher dis = request.getRequestDispatcher("step01_boardEx/bDelete_연습2.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long boardId = Long.parseLong(request.getParameter("boardId"));
		
		BoardDAO_연습2.getInstance().deleteBoard(boardId);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String jsScript = "";
		jsScript = """
				<script>
				alert('게시글이 삭제되었습니다.');
				location.href='bList';
				</script>
				""";
		
		out.print(jsScript);
				
	}

}
