<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제</title>
</head>
<body>
	<% 
		
		/* 
			form09_문제.jsp와 name값만 일치하면 됩니다.
			아래의 name명은 예시 입니다.
		*/
	
		request.setCharacterEncoding("utf-8");
	
		String name      = request.getParameter("name");
		String id        = request.getParameter("id");
		String pwd       = request.getParameter("pwd");
		String age       = request.getParameter("age");
		String gender    = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobbies");
		String travel    = request.getParameter("travel");
		String content   = request.getParameter("content");
	
	%>
	<fieldset>
		<p>아이디   : <%=id %></p>
		<p>비밀번호 : <%=pwd %></p>
		<p>이름     : <%=name %></p>
		<p>나이     : <%=age %></p>
		<p>성별     : <%=gender %></p>
		<p>취미 : 
			<% 
				for (int i=0; i<hobbies.length; i++) {		
			%>
					<%=hobbies[i] %> &nbsp;
			<% 
				}
			%>
		</p>
		<p>가고 싶은 여행지 : <%=travel %></p>
		<p>메모 : <%=content %></p>
	</fieldset>

</body>
</html>