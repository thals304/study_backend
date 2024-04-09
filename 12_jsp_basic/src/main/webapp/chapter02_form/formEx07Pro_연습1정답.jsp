<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>process</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		int num3 = Integer.parseInt(request.getParameter("num3"));
		
		int[] num = {num1 , num2, num3};
		int max = num[0];
		
		for (int i = 0; i < num.length; i++){
			if (max < num[i]){
				max = num[i];
			}
		}
	
	%>
	<h3>가장 큰 값 : <%=max %></h3>
</body>
</html>