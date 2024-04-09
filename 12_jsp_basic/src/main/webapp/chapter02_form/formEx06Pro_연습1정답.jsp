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
		int height = Integer.parseInt(request.getParameter("height"));
		String withParents = request.getParameter("withParents");
		String result = "";
		
		if ((double)height >= 120.0){
			result = "놀이기구를 이용할 수 있습니다.";
		}
		else {
			if (withParents.equals("yes")){
				result = "놀이기구를 이용할 수 있습니다.";
			}
			else if (withParents.equals("no")) {
				result = "놀이기구를 이용할 수 없습니다.";
			}
		}
	
	%>
	
	<h3>결과 : <%=result %></h3>
	
</body>
</html>