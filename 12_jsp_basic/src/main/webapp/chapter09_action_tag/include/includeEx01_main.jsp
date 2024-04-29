<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>include 액션태그</title>
</head> 
<body>	
	
	<!-- 
	
		# include 
		
		
		- 주로 화면의 레이아웃을 구성할때 사용한다. 
		
		- 주로 상위파트는 header 하위파트는 footer 메뉴파트는 side,aside,menu 본문파트는 content,article,body 로 사용한다.
		
		- 동적 include 방식으로 포함하는 문서와 상관없이 동적으로 컴파일 된다. 
		
		- 파일들이 완전히 별도로 동작하므로 완성된 문서의 형태를 포함해야 한다.
		
		- param 액션 태그를 통해 데이터를 전달할 수 있다.
		
		- 스프링 JSP개발환경으로는 Tiles3 및 Sitemesh로 구현하고
		  스프링 Thymeleaf개발환경으로는 Thymeleaf include를 사용한다.

	-->	
 
    <!-- 고정 화면 -->
    <jsp:include page="includeEx01_header.jsp"/>
    
    <!-- 수정 화면 -->
    <jsp:include page="includeEx01_body2.jsp"/>
    
    <!-- 고정 화면 -->
    <jsp:include page="includeEx01_header.jsp"/>
    
</body>
</html>



