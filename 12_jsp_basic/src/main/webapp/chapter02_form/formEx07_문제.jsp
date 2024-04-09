<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
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

	<form> 
		<p>값 1: <input type="number" name="num1" ></p>
		<p>값 2: <input type="number" name="num2" ></p>
		<p>값 3: <input type="number" name="num3" ></p>
		<p><input type="button" onclick="checkInput()" value="전송"></p>
	</form>

</body>
</html>