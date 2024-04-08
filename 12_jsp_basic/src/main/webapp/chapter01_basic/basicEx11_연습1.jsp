<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 24.04.08 time 16:25-16:43
	today 소감문
	이번에는 selected도 넣어야 되었어서 중간에 이것 저것 넣느라고 너무 복잡했던 것 같다.
	그래도 조금만 더 고민하면 문제에서 원하는대로 바로 바로 나오니까 기분은 너무 좋았다.
 -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
	[문제 설명]<br><br>
	1. 1월부터 12월까지 셀렉트 태그를 만든다.<br>
	2. <br>
	1,3,7,8,10,12월은 1~31일 <br>
	2월은 1~28일 <br>
	4,6,9,11월은 1~30일 <br>
	3. 마지막일자에 selected 옵션을 선택한다.
	</p>
	
	<%
		for (int i = 1; i <= 12; i++){
    %>
    	<%= i %>월 : 
        
        <% 
        	if (i == 2){
        %>
        	<select>
        	<% 
        		for (int j = 1; j <= 28; j++){
        	
        			if (j == 28){
        	%>
        	     <option value=<%=j %> selected><%= j %></option>
        	<% 
        			}
        			else {
        	%>
        		 <option value=<%=j %>><%= j %></option>
        	<% 
        			}
        	 		
        		}
        	%>
        	</select>
        <% 		
        	}
        	else if (i == 4 || i == 6 || i == 9 || i == 11){
        %>
        	<select>
        	<% 
        		for(int j = 1; j <= 30; j++){
        	%>
        	<%
        			if (j == 30){
        	%>
        		 <option value=<%=j %> selected><%= j %></option>	
        	<% 		
        			}
        			else {
        	%>
        		 <option value=<%=j %>><%=j %></option>
        	<% 
        			}
        		}
        	
        	%>
        	</select>
        <% 
        	}
        	else{
        %>
        	<select>
        	<%
        		for(int j = 1; j <= 31; j++){
        			if (j == 31){
        	%>
        		<option value=<%= j %> selected><%= j %></option>
        	<% 
        			}
        			else {
        	%>
        		<option value=<%= j %>><%= j %></option>
        	<% 
        			}
        		}
        	%>
        	</select>
        <% 
        	}
    	%>
    	일<br>
    	<% 
		}
        %>
        
    
</body>
</html>