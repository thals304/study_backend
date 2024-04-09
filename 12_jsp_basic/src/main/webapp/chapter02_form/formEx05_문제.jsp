<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>연습문제</title>
</head>

	<%--
	 
		# 구구단 게임
		
		1. 구구단 문제를 출제하기 위해, 숫자 2개를 지정한다.
		2. 입력받은 숫자의 정답을 입력받는다. 
		3. 모든 값을 formEx05Pro_정답.jsp로 전송하고 정답을 여부를 확인한 후
		
			3 x 7 = 21
			결과 : 정답 or 땡
			을 출력한다.	
		      
	--%>
	
	<form>
		<fieldset>
			<legend>숫자 1 * 숫자 2 = 정답</legend>
			<p>
				<input type="number" name="num1"> &emsp; * &emsp;
				<input type="number" name="num2">  &emsp; = &emsp;
				<input type="text" name="answer">
			</p>
			<p><input type="submit" value="확인"></p>
		</fieldset>		
	</form>
</body>
</html>