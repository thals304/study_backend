package step01_board.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import step01_board.dto.BoardDTO_연습1;

public class BoardDAO_연습1 {
	
	// 싱글턴 디자인 패턴
	private BoardDAO_연습1(){};
	private static BoardDAO_연습1 instance = new BoardDAO_연습1();
	public static BoardDAO_연습1 getInstance() {
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
	
	public void insertBoard (BoardDTO_연습1 boardDTO_연습1) {
		try {
			getConnection();
			
			String sql = "INSERT INTO BOARD(WRITER, SUBJECT, EMAIL, PASSWORD, CONTENT , READ_CNT , ENROLL_DT) VALUES(? , ? , ? , ? , ? , 0 , NOW())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDTO_연습1.getWriter());
			pstmt.setString(2, boardDTO_연습1.getSubject());
			pstmt.setString(3, boardDTO_연습1.getEmail());
			pstmt.setString(4, boardDTO_연습1.getPassword());
			pstmt.setString(5, boardDTO_연습1.getContent());
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			getClose();
		}
	}
	
	public ArrayList<BoardDTO_연습1> getBoardList() {
		
		ArrayList<BoardDTO_연습1> boardList = new ArrayList<BoardDTO_연습1>();
		
		try {
			getConnection();
			pstmt = conn.prepareStatement("SELECT BOARD_ID , SUBJECT , WRITER , ENROLL_DT , READ_CNT FROM BOARD");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO_연습1 temp = new BoardDTO_연습1();
				temp.setBoardId(rs.getLong("BOARD_ID"));
				temp.setSubject(rs.getString("SUBJECT"));
				temp.setWriter(rs.getString("WRITER"));
				temp.setEnrollDt(rs.getDate("ENROLL_DT"));
				temp.setReadCnt(rs.getLong("READ_CNT"));
				boardList.add(temp); // arrayList는 .set~가 안되고 add로 해야하므로 DTO 객체 하나 만들어서 어레이리스트.add(객체이름)으로 select로 뽑아온 것 저장
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			getClose();
		}
		
		System.out.println("getboardList : " + boardList);
		
		return boardList;
	}
	
	public BoardDTO_연습1 getBoardDetail(long boardId) {
		BoardDTO_연습1 boardDTO = new BoardDTO_연습1();
		
		try {
			getConnection();
			
			pstmt = conn.prepareStatement("UPDATE BOARD SET READ_CNT = READ_CNT + 1 WHERE BOARD_ID = ?");
			pstmt.setLong(1, boardId);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("SELECT * FROM BAORD WHERE BOARD_ID = ?");
			pstmt.setLong(1, boardId);
			rs = pstmt.executeQuery();
			// 패스워드 제외 값을 db에서 select해서 DTO에 보냄
			if (rs.next()) {
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
		
		System.out.println("detail : " + boardDTO);
		
		return boardDTO;
	}
	
}
