<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제</title>
</head>
<body>		
			
	<%-- 
	
		# 회원가입
		
		- 폼 전송 데이터를 formEx09Pro_정답.jsp에서 출력해보시오. 
	
	--%>			
	
	<form>
		<fieldset>
			<legend>회원가입 폼</legend>
			<p>아이디 :   <input type="text" /></p>
			<p>비밀번호 : <input type="password" /></p>
			<p>이름 :     <input type="text" /></p>
			<p>나이 :     <input type="text" /></p>
			<p>
				성별 : <input type="radio" value="m"/>남자
			   		   <input type="radio" value="f"/>여자
			</p>
			<p>
				취미 : <input type="checkbox" value="운동"/>운동
					   <input type="checkbox" value="잠자기"/>잠자기
					   <input type="checkbox" value="공부하기"/>공부하기
			</p>
			<p>
				가고 싶은 여행지는
				<select>
					<option>괌</option>
					<option>다낭</option>
					<option>나트랑</option>
					<option>코타키나발루</option>
					<option>대만</option>
					<option>푸꾸옥</option>
				</select>
			</p>
			<p>
				메모<br/>
				<textarea rows="10" cols="50" ></textarea>
			</p>
			<p>
				<input type="submit" value="회원가입"/>
				<input type="reset" value="다시쓰기"/>
			</p>
		</fieldset>
	</form>
	
</body>
</html>
</body>
</html>