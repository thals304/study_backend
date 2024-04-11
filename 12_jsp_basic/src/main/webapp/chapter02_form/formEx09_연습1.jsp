<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 24.04.10 time 20:00-20:13
	today 소감문
	체크박스를 getParameterValues로 표현하고 for문을 통해 
	html에 출력할 수 있냐? 라는 게 이 문제의 핵심이었던 것 같다.
	앞에서 체크박스가 한 번도 안나오다가 갑자기 나오니까 당황스러워서
	개념을 다시 보고 문제를 풀었던 것 같다.
 -->
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
	
	<form action="formExPro_연습1정답.jsp" method="post">
		<fieldset>
			<legend>회원가입 폼</legend>
			<p>아이디 :   <input type="text" name="id" /></p>
			<p>비밀번호 : <input type="password" name="password"/></p>
			<p>이름 :     <input type="text" name="name"/></p>
			<p>나이 :     <input type="text" name="age" /></p>
			<p>
				성별 : <input type="radio" name="gender" value="m"/>남자
			   		   <input type="radio" name="gender" value="f"/>여자
			</p>
			<p>
				취미 : <input type="checkbox" name="hobby" value="운동"/>운동
					   <input type="checkbox" name="hobby" value="잠자기"/>잠자기
					   <input type="checkbox" name="hobby" value="공부하기"/>공부하기
			</p>
			<p>
				가고 싶은 여행지는
				<select name="travel">
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
				<textarea rows="10" cols="50" name="memo" ></textarea>
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