<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>함수</title>
</head>
<body>

	<%-- 
	
		# fn ( function ) 
	
		- function 태그로 문자열 함수에 관련된 태그이다.
		- <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 태그라이브러리를 선언한 뒤 사용한다.
	
			fn:contains(A, B)			: 문자열 A에 문자열B가 포함되어 있는지 확인한다
			fn:containsIgnoreCase(A, B)	: 대소문자 구분없이 A에 B가 포함되어 있는지 확인한다
			fn:endWith(A, B)  			: 문자열 A의 끝이 B로 끝나는지 확인한다.
			fn:escapeXml(A)  			: A가 XML과 HTML에서 정의된 문자열이 포함되어 있을경우, 엔티티 코드로 변환하여 준다.
			fn:indexOf(A, B)  			: 문자열 A에서 B가 처음으로 위치하는 index를 반환한다
			fn:join(A[], B)  			: 문자열 배열A를 구분자를 붙여 하나의 문자열로 변환
			fn:length(A)  				: Collection 객체(List,ArrayList)의 전체 길이를 반환한다
			fn:replace(A, B, C)  		: 문자열 A에서 B에 해당하는 문자를 찾아 C로 변환한다
			fn:split(A, B)  			: A에서 B에서 지정한 문자열로 나눠 배열로 반환한다.
			fn:startsWith(A, B)  		: 문자열 A의 시작이 B로 시작하는지 확인한다
			fn:substring(A, B, C)  		: A에서 index 번호 B부터 C까지 해당하는 문자열을 반환
			fn:substringAfter(A, B)   	: A에서 B가 나타내는 이후의 문자열을 반환한다.
			fn:substringBefore(A, B)  	: A에서 B가 나타내는 이전의 문자열을 반환한다.
			fn:toLowerCase(A)  			: A를 모두 소문자로 변환한다.
			fn:toUpperCase(A)  			: A를 모두 대문자로 변환한다.
			fn:trim(A)  				: 문자열 A에서 앞 뒤 공백을 제거한다.
	
	 --%>
	 
	 <p>${fileName }</p>
	 <p>length : ${fn:length(fileName)}</p> 
	 <p>indexOf : ${fn:indexOf(fileName , ".") } </p>
	 <p>contains : ${fn:contains(fileName , ".png") }</p>
	 <p>
	 	<c:choose>
	 		<c:when test="${fn:contains(fileName , '.png')}">
	 			png 확장자 입니다.
	 		</c:when>
	 		<c:otherwise>
	 		    png 확장자가 아닙니다.
	 	    </c:otherwise>
	 	</c:choose>
	 </p>
	 <p>substring : ${fn:substring(fileName , 10 , 13)}</p>
	 <c:set var="extention" value="${fn:substring(fileName , 10 , 13)}"/>
	 <p>extention : ${extention }</p>
	 
	
	
</body>
</html>