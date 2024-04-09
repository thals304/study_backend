<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	    String pw = request.getParameter("pw");
	    String dbId = request.getParameter("dbId");
	    String dbPw = request.getParameter("dbPw");
	    
	    if (dbId.equals(id) && dbPw.equals(pw)){
	         out.print("로그인 완료");
	    }
	    else {
	    	out.println("아이디와 비밀번호를 다시 확인해주세요");
	    }
	
	%>
</body>
</html>