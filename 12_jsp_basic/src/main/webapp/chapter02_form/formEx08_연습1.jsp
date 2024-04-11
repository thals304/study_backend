<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<!-- 24.04.10 time 19:44-19:56
	today 소감문
	정답예시에서는 코드 이해가 더 잘 되게 짠 것 같다.
	그에 반면 나는 이 jsp 파일에 있는 name 순서대로
	request 한거라서 보기에는 친절해 보이지 않은 코드였다고 생각한다.
	그리고 정답예시는 myMoney를 재사용해서 부족한 금액이라던지 남음 금액을
	표현해줬는데 나는 굳이 남은 돈이라는 변수를 하나 더 만들어서 코드를 더 복잡하게 만들지 
	않았나 싶다.
 -->
<html>
<head>
<meta charset="utf-8">
<title>연습문제</title>
</head>
<body>

	<!--  
	
		# ATM : 이체하기
		
		 1. 이체할 계좌번호와 금액을 입력받는다.
			
			 [ 주어진 정보 ]
			 
			 myMoney   = 10000;
			 yourMoney = 10000;
			 myAcc     = "111-111-1111";
			 yourAcc   = "222-222-2222";
		 	
		 	 [ 입력받을 정보 ]
		 	 
		 	 sendAccount
		 	 sendMoney
		 	
		 	
		 [ formEx08Pro_정답.jsp ] (자바스크립트를 이용하여 데이터 전송)
		 
		 2. 계좌번호가 일치 하지 않으면 
		 	> "없는 계좌번호 입니다" 를 출력한다.
		 
		 3. 계좌번호가 일치하고 주어진 금액보다 이체할 금액이 적은경우 (계좌번호는 변수를 사용한다.)
		    
		    > "222-222-2222계좌에 000원을 원을 이체를 완료하였습니다. 남아있는 금액은 000원 입니다"를 출력한다.
		 	
		 4. 계좌번호가 일치하고 주어진 금액보다 이체할 금액이 많은경우 (계좌번호는 변수를 사용한다.)	
		
			> "111-111-1111 계좌에 잔액이 000만큼  부족합니다."를 출력한다.
		 
	-->

	<%
	
		String myAccount   = "111-111-1111";
		String yourAccount = "222-222-2222";
		
		int myMoney   = 10000;
	
	%>

	<form action= "formEx08Pro_연습1정답.jsp" method="post">
		<fieldset>
			<p>이체할 계좌번호를 입력하세요 : <input type="text" name="sendAccount"></p>
			<p>이체할 금액을 입력하세요:      <input type="text" name="sendMoney"></p>
			<p><input type="button" onclick="checkInput();" value="이체"></p>
			<input type="hidden" name="myAccount"   value="<%=myAccount %>">
			<input type="hidden" name="yourAccount" value="<%=yourAccount %>">
			<input type="hidden" name="myMoney"     value="<%=myMoney %>">
		</fieldset>
	</form>

</body>
</html>
