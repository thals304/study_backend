<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 24.04.08 time 14:22-14:26
	today 소감문
	그냥 <%%>를 중간 중간 구분해서 써줘야 하는 불편함 때매 조금
	문제 풀기 싫었던 것 같다.
 -->
<html>
<head>
<meta charset="UTF-8">
<title>연습문제</title>
</head>
<body>

	<!--  
		
		// 문제 1) 1부터 5까지 출력
		// 정답 1) 1 2 3 4 5
		

		// 문제 2) 1부터 10까지 반복해 5~9까지 출력
		// 정답 2) 5 6 7 8 9
		
		
		// 문제 3) 10부터 1까지 반복해 6~3까지 출력
		// 정답 3) 6 5 4 3
		

	-->
	<h3>문제1</h3>
	<%
		for (int i = 1; i <= 5; i++ ){
    %>
        <%= i %>
    <% 			
		}
	%>
	
	<hr/>
	<h3>문제2</h3>
	
	<%
	   for (int i = 1; i <= 10; i++){
		   if (i >= 5 && i < 10){
	%>
	   <%= i %>
	<%   
		   }
	   }
	%>
	
	<hr/>
	<h3>문제3</h3>
	
	<%
	   for (int i = 10; i > 0 ; i--){
		   if (i <=6 && i >= 3){
    %>
        <%= i %>
    <% 
		   }
	   }
	%>
</body>
</html>