<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 24.04.08 time 15:37-16:16
	today 소감문
	엄청 어려운 문제는 아니었는데 내가 실수로 select를 for문 안에 써서 
	select문이 엄청 많이 만들어지는 결과가 나와서 수정하는데 % 개수를 맞추는데
	애를 썼던 것 같다.
 -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
	[문제 설명]<br><br>
	1. 랜덤 객체를 생성하여 1부터 12까지 선택한다.<br>
	2.<br>
	1,3,5,7,8,10,12월은 1~31일<br>
	2월은 1~28일<br>
	4,6,9,11월은 1~30일을 셀렉트에 표기하시오<br>
	</p>
	
	<%
		Random ran = new Random();
		int r = ran.nextInt(12)+ 1; //[0-11] + 1
	%>  
	    <%=r %>월 : 
	<%	
		if (r == 2){
	%>
	<select>
	<%  
	     for (int i = 1; i <= 28; i++){
	%>
	   <option value=<%= i %>><%= i %></option>
	
	<% 		
		}
	%>
	</select> 	
	<% 	
	}
		else if (r == 4 || r == 6 || r == 9 || r == 11){
	 %>
	 <select>
	 <% 
	    	for(int i = 1; i <= 30; i++ ){
	  %>  
	    	<option value=<%= i %>><%= i %></option>
	    <% 		
	    	} 	
	    %>
	  </select>
	    <% 
		}
		else {
		%>
		<select>
		<%
			for(int i = 1; i <= 31; i++){
		%>
		  	<option value=<%= i %>><%= i %></option>
		<% 	
			}
		%>
		</select>
		<% 
		}
	%>일
</body>
</html>