<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	    request.setCharacterEncoding("utf-8");
	
		Connection conn = null;
	
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_EX?serverTimezone=Asia/Seoul", "root", "0000");
			
			pstmt = conn.prepareStatement("SELECT * FROM PRODUCT WHERE PRODUCT_NM LIKE CONCAT('%' , ? , '%')");
			pstmt.setString(1, request.getParameter("productNm"));
			
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				String productCd = rs.getString("PRODUCT_CD");
				String productNm = rs.getString("PRODUCT_NM");
				int price = rs.getInt("PRICE");
				Date regDt = rs.getDate("REG_DT");
				
				System.out.println("=== 조회 결과 ===");
				System.out.println("상품 코드 : " + productCd);
				System.out.println("상품 이름 : " + productNm);
				System.out.println("상품 가격 : " + price);
				System.out.println("reg_dt : " + regDt);
				
				System.out.println();
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
	%>	
	<h3>상품이 조회되었습니다</h3>
	<a href="jdbcEx07_연습1.jsp">상품조회 화면으로 돌아가기</a>
</body>
</html>