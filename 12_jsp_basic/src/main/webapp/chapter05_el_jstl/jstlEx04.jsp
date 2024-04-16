<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 포맷</title>
</head>
<body>

	<%--  
		
		# fmt ( format ) 
	
		- Formatting 태그로 포맷에 관련된 태그이다.
		- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 를 선언한 뒤에 사용한다.
		
		[ Attribute ]
		
		requestEncoding : value 속성을 통해 지정한 문자 셋으로 변경 
		setLocale 		: 통화 기호나 시간 대역을 설정한 지역에 맞게 표시 
		timeZone 		: 특정 영역의 시간대를 설정 
		setTimeZone 	: 특정 영역의 시간대 설정 정보를 변수에 저장 
		bundle basename : 속성에 지정된 properties 파일을 읽어옴 
		setBundle 		: properties 파일을 읽어와 다양한 영역에서 참조할 수 있게 설정 
		message bundle  : 태그를 통해 저장된 key로 value를 가져온다 
		formatNumber    : 숫자를 특정 양식에 맞추어 출력 
		parseNumber     : 문자열을 숫자 형식으로 변환 
		formatDate      : 날자 정보를 가진 객체(Date)를 특정 형식으로 변환하여 출력 
		parseDate       : 문자열을 날짜 형식으로 변환하여 출력

	--%>

	<h3>데이터 형변환</h3>
	
	<c:set var="num1" value="7"/>
	<c:set var="num2" value="12"/>
	
	<fmt:parseNumber var="num1" value="${num1 }" />
	<fmt:parseNumber var="num2" value="${num2 }" />
		
	<c:if test="${num1 < num2 }">
			<p>${num2 }(이)가 크다.</p>
	</c:if>
	
	<h3>날짜 형식</h3>
	<p>${now }</p> <!-- 형식 x-->
	<p><fmt:formatDate value="${now }"/></p>
	<p><fmt:formatDate value="${now }" pattern="yyyy-MM-dd"/></p>
	<p><fmt:formatDate value="${now }" pattern="yyyy년MM월dd일 hh시mm분ss초"/></p>
	
	
	<h3>숫자 형식</h3>
	<p>${nData }</p> <!-- 형식 x-->
	<p><fmt:formatNumber value="${nData }"/></p> <!-- 세자리마다 , 표현 -->
	<p><fmt:formatNumber value="${nData }" pattern=".0"/></p> <!-- 소수점 1자리 표현 -->
	<p><fmt:formatNumber value="${nData }" pattern=".00"/></p> <!-- 소수점 2자리 표현 -->
	<p><fmt:formatNumber value="${nData }" pattern="#,##.00"/></p> <!-- 세자리마다 , 표현 / 소수점 1자리 표현 -->
	
</body>
</html>