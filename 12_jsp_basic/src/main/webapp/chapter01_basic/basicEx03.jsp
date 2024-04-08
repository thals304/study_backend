<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>import</title>
</head>
<body>
		
	<%
	   Random ran = new Random();
	   String[] languages = {"java" , "HTML5" ,"CSS3" , "javascript" , "MySQL" , "jQuery"};
	   
	   int r = ran.nextInt(6); // [0-5]
	%>
	<h3><%=languages[r] %>언어가 재밌다.</h3>
	
	<%
	   Date temp = new Date();
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	   String time = sdf.format(temp);
	%>
	<h3>현재시간 : <%=temp %></h3>
	<h3>현재시간 : <%=time %></h3>
	
</body>
</html>