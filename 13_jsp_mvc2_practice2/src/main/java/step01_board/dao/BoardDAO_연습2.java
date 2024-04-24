package step01_board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import step01_board.dto.BoardDTO_연습2;

public class BoardDAO_연습2 {
	
	// 싱글턴 패턴(static)
	BoardDAO_연습2(){}
	private static BoardDAO_연습2 instance = new BoardDAO_연습2();
	public static BoardDAO_연습2 getInstance() {
		return instance;
	}
	
	// 데이터베이스 연동객체 생성
	private Connection conn         = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs            = null;


	// 데이터베이스 연동 메서드 생성
	private void getConnection() {
		Context initctx;
		try {
			initctx = new InitialContext(); // 데이터베이스와 연결하기 위한 init객체 생성
			Context envctx = (Context) initctx.lookup("java:comp/env");  // lookup 메서드를 통해 context.xml 파일에 접근하여 자바환경 코드를 검색
			DataSource ds = (DataSource) envctx.lookup("jdbc/board"); 	 // <Context>태그안의 <Resource> 환경설정의 name이 jdbc/board인 것을 검색
			conn = ds.getConnection();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 데이터베이스 연동해지 메서드 생성
	private void getClose() {
		if (rs != null)    try {rs.close();} catch(SQLException e) {e.printStackTrace();}
		if (pstmt != null) try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
		if (conn!= null)   try {conn.close();} catch (SQLException e) {e.printStackTrace();}
	}

	public void insertBoard(BoardDTO_연습2 boardDTO) {
		try {
			getConnection();
			String sql =""" 
					INSERT INTO BOARD(WRITER , SUBJECT , EMAIL , PASSWORD , CONTENT , READ_CNT , ENROLL_DT)
					VALUES(? , ? , ? , ? , ? , 0 , NOW())
					""";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getWriter());
			pstmt.setString(2, boardDTO.getSubject());
			pstmt.setString(3, boardDTO.getEmail());
			pstmt.setString(4, boardDTO.getPassword());
			pstmt.setString(5, boardDTO.getContent());
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			getClose();
		}
	}
	
	public ArrayList<BoardDTO_연습2> getBoardList(){
		
		ArrayList<BoardDTO_연습2> boardList = new ArrayList<BoardDTO_연습2>();
		
		try {
			getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM BOARD");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO_연습2 temp = new BoardDTO_연습2();
				temp.setBoardId(rs.getLong("BOARD_ID"));
				temp.setWriter(rs.getString("WRITER"));
				temp.setSubject(rs.getString("SUBJECT"));
				temp.setReadCnt(rs.getLong("READ_CNT"));
				temp.setEnrollDt(rs.getDate("ENROLL_DT"));
				boardList.add(temp);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			getClose();
		}
		
		System.out.println("getBoardList : " + boardList);
		
		return boardList;
	}
	
	public BoardDTO_연습2 getDetailBoard(long boardId) {
		
		BoardDTO_연습2 boardDTO = new BoardDTO_연습2();
		
		try {
			getConnection();
			
			pstmt = conn.prepareStatement("UPDATE BOARD SET READ_CNT = READ_CNT + 1 WHERE BOARD_ID = ?");
			pstmt.setLong(1, boardId);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("SELECT * FROM BOARD WHERE BOARD_ID = ?");
			pstmt.setLong(1, boardId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				boardDTO.setBoardId(rs.getLong("BOARD_ID"));
				boardDTO.setWriter(rs.getString("WRITER"));
				boardDTO.setEmail(rs.getString("EMAIL"));
				boardDTO.setSubject(rs.getString("SUBJECT"));
				boardDTO.setContent(rs.getString("CONTENT"));
				boardDTO.setReadCnt(rs.getLong("READ_CNT"));
				boardDTO.setEnrollDt(rs.getDate("ENROLL_DT"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			getClose();
		}
		
		System.out.println("getBoardDetail : " + boardDTO);
		
		return boardDTO;
	}
	
	public boolean checkAuthenticationUser(BoardDTO_연습2 boardDTO) {
		
		System.out.println("checkAuthenticationUser param : " + boardDTO);
		
		boolean isAuthenticationUser = false;
		
		try {
			getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM BOARD WHERE BOARD_ID = ? AND PASSWORD = ?");
			pstmt.setLong(1, boardDTO.getBoardId());
			pstmt.setString(2, boardDTO.getPassword());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				isAuthenticationUser = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			getClose();
		}
		
		System.out.println("checkAuthenticationUser return : " + isAuthenticationUser);
		
		return isAuthenticationUser;
	}
	
	public void updateBoard(BoardDTO_연습2 boardDTO) {
		
		System.out.println("updateBoard param : " + boardDTO);
		
		try {
			getConnection();
			String sql = """
					UPDATE BOARD
					SET SUBJECT = ? , 
					    CONTENT = ?
					WHERE BOARD_ID = ?
					""";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getSubject());
			pstmt.setString(2, boardDTO.getContent());
			pstmt.setLong(3, boardDTO.getBoardId());
			pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			getClose();
		}
	}
	
	public void deleteBoard(long boardId) {
		try {
			getConnection();
			pstmt = conn.prepareStatement("DELETE FROM BOARD WHERE BOARD_ID = ?");
			pstmt.setLong(1, boardId);
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			getClose();
		}
	}
}
