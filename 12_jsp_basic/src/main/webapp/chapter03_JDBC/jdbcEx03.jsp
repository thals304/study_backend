<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert 예시</title>
</head>
<body>
	<%
		Connection conn = null;
	
		PreparedStatement pstmt = null;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_EX?serverTimezone=Asia/Seoul", "root", "0000");
			
		/*
		
			# prepareStatement
			
			- 원래 statement객체로 사용하였으나 SQL Injection 공격에 대응하는 보안 기법으로 prepareStatement를 사용한다.
			
			- 우선 ?로 쿼리문의 파라메타 형식을 만들고 setter 메서드로 데이터를 대입하여 쿼리문을 완성한다.
			   pstmt.set자료형(인덱스, 값);
			
			- 인덱스는 1부터 시작한다.
			
			Ex)
			pstmt.setInt(index , value);     // 정수 타입 데이터 적용 메서드
			pstmt.setString(index , value);  // 문자열 타입 데이터 적용 메서드
			pstmt.setDate(index , value);  	 // 날짜 타입 데이터 적용 메서드
		
		*/
			// ? 기능 : sql 인젝션(injection)을 디펜스함
			String sql = "INSERT INTO PRODUCT VALUES(? , ? , ? , NOW())"; 
			
			// 선처리문 쿼리 작성
			pstmt = conn.prepareStatement(sql);
			
			// 선처리문 쿼리 완성
			pstmt.setString(1, "P10016");  // INSERT INTO PRODUCT VALUES("P10016" , ? , ? , NOW())
			pstmt.setString(2, "게이밍의자1");  // INSERT INTO PRODUCT VALUES("P10016" , "게이밍의자" , ? , NOW())
			pstmt.setInt(3, 185000);       // INSERT INTO PRODUCT VALUES("P10016" , "게이밍의자" , 185000 , NOW())
			
			/*
			  - 화면에서 전송된 데이터를 저장
			  pstmt.setString(1, request.getParameter("전송된 데이터"));
			  pstmt.setString(2, request.getParameter("전송된 데이터"));
			  pstmt.setInt(3, Integer.parseInt(getParameter("전송된 데이터")));
			
			*/
			
			// executeUpdate(); : insert , update, delete 실행 메서드
			pstmt.executeUpdate();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			pstmt.close();
			conn.close();
		}
	%>
</body>
</html>