<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정답예시</title>
</head>
<body>

	<%
	
		request.setCharacterEncoding("utf-8");
	
		Connection conn = null;  
		PreparedStatement pstmt = null; 
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");	
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_EX?serverTimezone=Asia/Seoul" , "root" , "1234"); 
			
			String  sql = "UPDATE PRODUCT ";
					sql += "SET	   PRODUCT_NM = ? , ";
					sql += "	   PRICE = ? ";
					sql += "WHERE  PRODUCT_CD = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("productNm"));
			pstmt.setInt(2, Integer.parseInt(request.getParameter("price")));
			pstmt.setString(3, request.getParameter("productCd"));
			pstmt.executeUpdate();
			
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			conn.close();
		}
	
	%>

	
	<h3>상품이 수정되었습니다.</h3>
	<a href="jdbcEx08_문제.jsp">상품수정 화면으로 이동하기</a>
</body>
</html>