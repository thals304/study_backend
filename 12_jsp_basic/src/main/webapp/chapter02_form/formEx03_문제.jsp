<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>연습문제</title>
</head>
<body>

	<%-- 
		 
	  # 가위 바위 보 게임
	 
	  1. com은 '바위'만 낼 수 있다.
	  
	  2. me에게 가위 바위 보 중 한개의 값을 입력받는다. 
	  	 me와 com값을 formEx03Pro_정답.jsp 파일로 넘긴다. 
	  
	  3. com과 me를 비교해
	  	
	  	나 : 00
	  	컴퓨터 : 바위
	  	
	  	(가위바위보의 결과에 따라서)
	  	1) 비겼다.
   		2) 내가 이겼다.
		3) 내가 졌다.
		4) 잘못된 입력값 입니다. 가위 혹은 바위 혹은 보를 입력해주세요.	
	    를  formEx03Pro_정답.jsp에서 출력한다. 
	
	--%>
	
	<%
		String com = "바위";
	%>
	<form>
		가위 바위 보 : <input type="text" name="me" /> 
		<input type="hidden" name="com" value="<%=com %>" /> 
		<input type="submit" value="확인" />
	</form>

</body>
</html>