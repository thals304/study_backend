<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 24.04.08 time 14:40-14:45 15:37-15:39
	today 소감문
	처음에는 그냥 글만 쓰고 체크 박스를 만드라는 문제인 줄 알았으나
	문제 설명처럼 조건을 나눠서 화면에 보이도록 하는 것이었다.
	뭔가 앞에 내가 자신없는 js, jquery를 하다가 자바를 하니까 아직은
	쉽게 느껴진다.
	
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
     <input type="radio" name="subject" value="HTML5">HTML5
     <input type="radio" name="subject" value="CSS3">CSS3
     <input type="radio" name="subject" value="JAVASCRIPT">JAVASCRIPT
     <%	 
     }
     %>
</body>
</html>