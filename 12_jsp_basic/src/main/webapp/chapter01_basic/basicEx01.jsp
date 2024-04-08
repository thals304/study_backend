<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출력함수</title>
</head>
<body>
	<%-- 
  
		# JSP(Java[Jakarta] Server Page)는 html태그 위에 jsp태그가 추가된 형태로 사용되어진다.
		 
	    1) 지시자(Directive) 태그        	<%@    %>
	    2) 스크립트릿(Scriptlet) 태그  	    <%     %>	
	    3) 표현식(Expression) 태그      	<%=    %>

	 --%>
	<!-- html 문법 -->
	<h3>출력함수</h3>
	
	<!-- html 주석 : 개발자도구에서 볼 수 있습니다. -->
	<%-- jsp 주석  : 개발자도구에서 볼 수 없습니다. --%>
	
	<%
	   // 자바 문법
	   String name = "팀 버너스 리";
	   out.println("html 출력결과 : " + name); // 웹브라우저 환경에 데이터 출력
	   System.out.println(name);            // console 환경에 데이터 출력
	%>
	
	<p>출력 결과 : name</p>
	<!-- html에서 자바 변수 표기법 -->
	<p>출력 결과 : <%=name%></p>
	
</body>
</html>