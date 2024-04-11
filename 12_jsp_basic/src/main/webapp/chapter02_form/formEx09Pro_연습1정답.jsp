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
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobby");
		String travel = request.getParameter("travel");
		String memo = request.getParameter("memo");
		
	%>
	<h3>아이디 : <%=id %></h3>
	<h3>비밀번호 <%= password %></h3>
	<h3>이름 : <%=name %></h3>
	<h3>나이 : <%=age %></h3>
	<h3>성별 : <%=gender %></h3>
	<h3>취미 : 
	<%
		if (hobby != null){
			for (int i = 0; i < hobby.length; i++){
		
	%>
			<%=hobby[i] %> &nbsp;
	<%
			}
		}
		else {
	%>
		     none
	<% 
		}
	%>
	</h3>
	<h3>가고싶은 여행지는 : <%=travel %></h3>
	<h3>메모 : <%=memo %></h3>
	<h3></h3>
	<h3></h3>
</body>
</html>