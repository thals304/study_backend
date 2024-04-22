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
import step01_board.dto.BoardDTO_연습2;

@WebServlet("/bWrite")
public class WriteBoard_연습2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("step01_boardEx/bWrite_연습2.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		BoardDTO_연습2 boardDTO = new BoardDTO_연습2();
		boardDTO.setWriter(request.getParameter("writer"));
		boardDTO.setSubject(request.getParameter("subject"));
		boardDTO.setEmail(request.getParameter("email"));
		boardDTO.setContent(request.getParameter("content"));
		
		BoardDAO_연습2.getInstance().insertBoard(boardDTO);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		System.out.println("doPost : " + boardDTO);
		
		String jsScript = """
				<script>
					alert('게시글이 등록되었습니다.');
					location.href = 'bList';
				</script>
				""";
		
		out.print(jsScript);
	}

}
