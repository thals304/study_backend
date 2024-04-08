<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 24.04.08 time 14:33-14:38
	today 소감문
	다른 건 어려움이 없었는데 backgroung-color를 어디에 써야하고 어떻게 써야하는지
	까먹은 것이었다. 그래서 이 부분은 정답 예시를 참고 했다.
 -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
      
      <table border="1">
      <%
          for(int i = 1; i <= 10; i++ ){
        	  if (i % 2 == 0){
      %>
          <tr>
          	<td style ="background-color : skyblue"><%=i %>번</td>
          </tr>
      <% 
        	  }
        	  else if (i % 2 == 1){
      %>
          <tr>
          	<td style ="background-color :yellow"><%=i %>번</td>
          </tr>
      <% 
        	  }
          }
      %>
      </table>
</body>
</html>