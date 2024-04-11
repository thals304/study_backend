<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>process</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	
		String sendAccount = request.getParameter("sendAccount");
		int sendMoney = Integer.parseInt(request.getParameter("sendAccount"));
		
		String myAccount = request.getParameter("myAccount");
		String yourAccount = request.getParameter("yourAccount");
		
		int myMoney = Integer.parseInt(request.getParameter("myMoney"));
		
		String result = "";
		int restMoney = 0;
		if (yourAccount.equals(sendAccount)){
			if (sendMoney > myMoney){
				restMoney = sendMoney - myMoney;
				result =  myAccount + "님 계좌에 잔액이 " + restMoney + "만큼 부족합니다.";
			}
			else {
				restMoney = myMoney - sendMoney;
				result = yourAccount + "님의 계좌에 " + sendMoney + "원을 이체 완료했습니다. 남아있는 금액은 " + restMoney + "원 입니다.";
			}
		}
		else {
			result = "없는 계좌입니다.";
		}
	
	%>
	<h3>결과 : <%= result %></h3>
</body>
</html>