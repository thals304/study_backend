<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%-- 24.04.15 time 22:34-22:49
	today 소감문
	일단 톰캣이 자꾸만 404를 띄우고 clean을 해도 껐다가 켜도 지웠다가 다시 설치해도 
	이 모양이라 내가 정답예시와 다른 식으로 풀었을 때 확인할 수 있는 방법이 없다.
	그래서 너무 답답하고 얼른 해결을 해야될 것 같다.
 --%>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제</title>
</head>
<body>

	<!-- 
	
		# 데이터 출력
		
		- JstlEx14_정답예시 Servlet에서 pdCdList를 전달받고 데이터를 화면에 테이블 형식으로 출력해보시오.
		Ex) 
		
		    No  PdCd
			1 "0x001" 
			2 "0x002"  
			3 "0x003"  
			4 "0x004" 
			5 "0x005"  
			6 "0x006" 
			7 "0x007"	
		
	 -->
	 <table border="1">
	 	<tr>
	 		<th>No</th>
	 		<th>PdCd</th>
	 	</tr>
	 	<c:set var="cnt" value="0"/>
	 		<c:forEach var="pdCd" items="${pdCdList}">
	 			<tr>
	 				<td>cnt</td>
	 				<td>${pdCd }</td>
	 			</tr>
	 		<c:set var="cnt" value="${cnt + 1 }"/>
	 		</c:forEach>
	 	
	 </table>
	 
</body>
</html>