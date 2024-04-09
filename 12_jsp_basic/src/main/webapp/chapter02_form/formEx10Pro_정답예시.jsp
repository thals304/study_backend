<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제</title>
</head>
<body>
	<%
	
		request.setCharacterEncoding("utf-8");  
		
	 	String name               = request.getParameter("name");
		String contact            = request.getParameter("contact");  
		String modelName          = request.getParameter("modelName");
		String email              = request.getParameter("email");	
		String quantity           = request.getParameter("quantity");
		String requestInfo        = request.getParameter("requestInfo");
		String agreeSafeCare      = request.getParameter("agreeSafeCare");
		String agreePrivateInform = request.getParameter("agreePrivateInform");
	
	%>
	<fieldset>
		<p>이름: <%=name %></p>
		<p>연락처: <%=contact %></p>
		<p>주문모델: <%=modelName %></p>
		<p>이메일: <%=email %></p>
		<p>구매수량: <%=quantity %></p>
		<p>요청사항: <%=requestInfo %></p>
		<p>안심케어 여부: <%=agreeSafeCare %></p>
		<p>개인정보보호 동의: <%=agreePrivateInform %></p>
	</fieldset>
	
</body>
</html>