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
		
		String name                 = request.getParameter("name");
		String contact              = request.getParameter("contact");
		String email                = request.getParameter("email");
		String modelName            = request.getParameter("modelName");
		int quantity                = Integer.parseInt(request.getParameter("quantity"));
		String[] agreeSafeCare      = request.getParameterValues("agreeSafeCare");
		String requestInfo          = request.getParameter("requestInfo");
		String[] agreePrivateInform = request.getParameterValues("agreePrivateInform");
		
	%>
	<h3>이름 : <%=name %></h3>
	<h3>전화번호 : <%=contact %></h3>
	<h3>이메일 : <%=email %></h3>
	<h3>주문 모델 : <%=modelName %></h3>
	<h3>구매 수량 : <%=quantity %></h3>
	<h3> 안심케어 서비스
		<%
			for (int i = 0; i < agreeSafeCare.length; i++){
				out.println(agreeSafeCare[i]);
			}
		%>
	</h3>
	<h3>주문시 요청 사항 : <%=requestInfo %></h3>
	<h3>개인정보 수집 동의 :
		<%
			for(int i = 0; i < agreePrivateInform.length; i++){
				out.println(agreePrivateInform[i]);
			}
		%>
	</h3>
</body>
</html>