<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>연습문제</title>
</head>
<body>

	<%
	 
		request.setCharacterEncoding("utf-8");
	
       	String com = request.getParameter("com");
		String me  = request.getParameter("me");
		
		String result = "";
		
		if (com.equals(me)) 		result = "비겼다.";
		else if (me.equals("가위")) result = "내가 졌다.";
		else if (me.equals("보")) 	result = "내가 이겼다.";
		else 						result = "잘못된 입력값 입니다. 가위 혹은 바위 혹은 보를 입력해주세요.";
	
		
	%>

	<h4>나 : <%=me%></h4>
	<h4>컴퓨터 : <%=com%></h4> <br>
	
	<h2><%=result%></h2>
	

</body>
</html>