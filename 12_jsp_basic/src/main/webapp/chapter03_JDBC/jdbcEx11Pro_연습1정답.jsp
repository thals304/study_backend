<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
		Connection conn = null;
	
		PreparedStatement pstmt = null;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_EX?serverTimezone=Asia/Seoul", "root", "0000");
			
			pstmt = conn.prepareStatement("DELETE FROM PRODUCT WHERE PRODUCT_CD = ?");
			pstmt.setString(1, request.getParameter("productCd"));
			
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
	<h3>상품이 삭제되었습니다.</h3>
	<a href="jdbcEx11_연습1.jsp">상품삭제 화면으로 이동하기</a>
</body>
</html>