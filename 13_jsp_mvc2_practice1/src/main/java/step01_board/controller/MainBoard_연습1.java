package step01_board.controller;
/*
 * 24.04.17 time 19:30-19:51
 * 24.04.18 time 13:46-14:44
 * 24.04.19 time 08:14-08:57
 * 24.04.21 time 21:20-22:33
 * today 소감문
 * 오늘부터 게시판 만들기 3번씩 연습하기 시작하는 첫날이다.
 * 첫날이므로 정답예시를 확인하면서 흐름을 이해하고 모르는 부분을 체크하는 시간을 가질 것이다. 
 * [내가 생각한 순서]
 * db > DTO > DAO 데이터 베이스 연동 + lib
 * bMain (서블렛, jsp)
 * bWrite (서블렛, jsp)
 * bList (서블렛, jsp)
 * bDetail (서블렛, jsp)
 * bAuthentication (서블렛, jsp)
 * bUpdate (서블렛, jsp)
 * bDelete (서블렛, jsp)
 * 
 * // detail에서 duplicate entry 발생  > DAO getDetailBoard에서 update 에서 readCnt 증가를 boardId 증가로 잘못 써줌
 * // Authentication부터 Delete 사이에 문제 발생 > 코드 하나씩 다시 봐야될 듯 DTO에 BoardID가 없다? DTO로 바꾸는 코드 중에 boardId를 boardID라고 잘못쓴 애가 있는거 같음
 *                                       > bDetail_연습1.jsp의 삭제 버튼에서 ${boardDTO.boardId}를 ${ boardDTO.boardID}라서 잘못 씀
 * // 인증에서 password를 잘못 입력했을 때 alert과 history.go(-1)가 안먹힘 (선생님과 같이한 자료에서도 같은 오류 발생)
 *    > 검색해보니 숫자형포맷오류 
 * */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import step01_board.dao.BoardDAO_연습1;

@WebServlet("/bMain_연습1")
public class MainBoard_연습1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dis = request.getRequestDispatcher("step01_boardEx/bMain_연습1.jsp");
		dis.forward(request, response);
	}

}
