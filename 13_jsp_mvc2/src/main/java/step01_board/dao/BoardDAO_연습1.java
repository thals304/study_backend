package step01_board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDAO_연습1 {
	
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
	
	
	
}
