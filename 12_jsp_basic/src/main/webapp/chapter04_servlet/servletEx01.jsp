<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>servletEx01</title>
</head>
<body>
	
	
	<h3>데이터 전송</h3>
	<form action="servletEx01" method="post" >		<!-- (중요)jsp파일명이 아닌 서블렛 URL을 작성한다. -->
		<table border="1">
			<tr>
				<th>데이터1</th>
				<td><input type="text" name="data1"></td>
			</tr>
			<tr>
				<th>데이터2</th>
				<td><input type="text" name="data2"></td>
			</tr>
			<tr>
				<th>데이터3</th>
				<td><input type="text" name="data3"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="전송">
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>