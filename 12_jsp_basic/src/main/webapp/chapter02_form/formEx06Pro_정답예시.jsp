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
	
		double height      = Double.parseDouble(request.getParameter("height"));
		String withParents = request.getParameter("withParents");
		
		String result = ""; 
		
		if (height >= 120.0) {
			result = "놀이기구를 이용할 수 있습니다.";
		}
		
		if (height < 120.0) {
			if (withParents.equals("yes")) 	result= "놀이기구를 이용할 수 있습니다.";
			if (withParents.equals("no")) 	result= "놀이기구를 이용할 수 없습니다.";
		}
	
	%>
	<h2> <%=result %> </h2>

</body>
</html>