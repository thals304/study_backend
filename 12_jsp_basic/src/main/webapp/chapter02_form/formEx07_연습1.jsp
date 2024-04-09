<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<!-- 24.04.09 time 13:45-13:51
	today 소감문
	사실 배열 값 비교를 for문으로 하는데 익숙해졌는지
	입력한 값 3개를 받아와서 숫자로 바꾸고 배열에 저장하고 max를 인덱스 0으로
	두고 for문을 돌면서 max값을 찾으려고 했는데 버튼을 클릭해도 다음 페이지로
	안넘어가서 다시 다른 방법으로 풀어보든지 해야겠다.
 -->
<html>
<head>
<meta charset="utf-8">
<title>연습문제</title>
</head>
<body>

	<!--  
	
		# 최대값 구하기[2단계]
		
		1. 정수 값 3개를 입력한다.
		2. formEx07Pro_정답.jsp에서 입력받은 3개의 숫자 중 가장 큰 값을 출력한다. (자바스크립트를 이용하여 데이터 전송)
		
	--> 

	<form action="formEx07Pro_연습1정답.jsp" method="post"> 
		<p>값 1: <input type="number" name="num1" ></p>
		<p>값 2: <input type="number" name="num2" ></p>
		<p>값 3: <input type="number" name="num3" ></p>
		<p><input type="button" onclick="checkInput()" value="전송"></p>
	</form>

</body>
</html>