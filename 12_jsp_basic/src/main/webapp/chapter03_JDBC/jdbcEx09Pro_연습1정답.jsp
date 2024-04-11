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
		request.setCharacterEncoding("utf-8");
	
		Connection conn = null;

		PreparedStatement pstmt = null;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_EX?serverTimezone=Asia/Seoul", "root", "0000");
			
			String sql = "UPDATE PRODUCT SET PRICE = PRICE - (PRICE * ?) ";
			 
			pstmt = conn.prepareStatement(sql);
			
			double discountRate = Integer.parseInt(request.getParameter("discountRate")) * 0.01;
			pstmt.setDouble(1, discountRate);
			
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
	<h3>상품이 수정되었습니다.</h3>
	<a href="jdbcEx09_연습1.jsp">상품수정 화면으로 이동하기</a>
</body>
</html>