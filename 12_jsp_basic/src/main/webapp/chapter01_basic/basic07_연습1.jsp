<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 24.04.08 time 14:40-14:45
	today 소감문
	
 -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <p>
     [문제설명] <br>
     1. 랜덤객체를 생성  <br>
     2. 랜덤에서 0이 나올 경우 셀렉트태그 생성 <br>
     3. 랜덤에서 1이 나올 경우 체크박스 생성 <br>
     4. 랜덤에서 2가 나올 경우 라디오 생성 <br>
     </p>
     
     <%
     Random ran = new Random();
     int rNum = ran.nextInt(3); // [0-2]
    		 
     if (rNum == 0){
     %>
     <select>
     	<option>HTML5</option>
     	<option>CSS3</option>
     	<option>JAVASCRIPT</option>
     </select>
     <% 	 
     }
     else if (rNum == 1){
     %>
     <input type="checkbox" name="subject" value="HTML5">HTML5
     <input type="checkbox" name="subject" value="CSS3">CSS3
     <input type="checkbox" name="subject" value="JAVASCRIPT">JAVASCRIPT
     <% 	 
     }
     else if (rNum == 2){
     %>
     
     <%	 
     }
     %>
</body>
</html>