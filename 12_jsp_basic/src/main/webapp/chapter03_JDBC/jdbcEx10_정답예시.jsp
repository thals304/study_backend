<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
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
			
			String sql = "INSERT INTO PRODUCT VALUES (? , ? , ? , NOW())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("productCd"));
			pstmt.setString(2, request.getParameter("productNm"));
			pstmt.setInt(3, Integer.parseInt(request.getParameter("price")));
			pstmt.executeUpdate();
			
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			conn.close();
		}
	
	%>

	<h3>상품이 추가되었습니다.</h3>
	<a href="jdbcEx10_문제.jsp">상품추가 화면으로 이동하기</a>

</body>
</html>