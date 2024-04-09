<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Process</title>
</head>
<body>
	
	<%
		 request.setCharacterEncoding("utf-8");
	
		 String data1 = request.getParameter("data1");
		 String data2 = request.getParameter("data2");
		 String data3 = request.getParameter("data3");
		 String data4 = request.getParameter("data4");
		 String data5 = request.getParameter("data5");
		 String data6 = request.getParameter("data6");
		 String data7 = request.getParameter("data7");
		 String data8 = request.getParameter("data8");
		 String data9 = request.getParameter("data9");
		 // checkbox는 문자열 배열로 받아와야함
		 String[] data10 = request.getParameterValues("data10"); 
		 
	%>
	<filedset>
		<p>1. 텍스트 : <%=data1 %></p>
		<p>2. 패스워드 : <%=data2 %></p>
		<p>3. 텍스트에어리어 : <%=data3 %></p>
		<p>4. 히든 : <%=data4 %></p>
		<p>5. 이메일 : <%=data5 %></p>
		<p>6. 날짜 : <%=data6 %></p>
		<p>7. 숫자 : <%=data7 %></p>
		<p>8. 라디오 : <%=data8 %></p>
		<p>9. 셀렉트 : <%=data9 %></p>
		<p>10. 체크박스 :
		<%
		    if (data10 != null){
				for (int i = 0; i < data10.length; i++){
					out.println(data10[i]);
				}
		    }
		    else {
		    	out.println("none");
		    }
		%>
		</p>
		
	</filedset>
</body>
</html>