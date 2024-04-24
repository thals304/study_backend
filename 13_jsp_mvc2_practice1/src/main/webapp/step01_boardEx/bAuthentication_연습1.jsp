<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bAuthentication</title>
</head>
<body>
	<div align="center"> 
		<h3>사용자 인증</h3>
		<!-- 
			bAuthentication 서블렛의 doPost메서드로 
			password, boardId, menu 3개의 데이터 전송
		 -->
		<form action="bAuthentication_연습1" method="post">
			<table border="1">
				<tr>
					<td>작성자</td>
					<td>${boardDTO.writer }</td>
				</tr>
				<tr>
					<td>작성일</td>
					<td>${boardDTO.enrollDt }</td>
				</tr>
				<tr>
					<td>제목</td>
					<td>${boardDTO.subject }</td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td><input type="password" name="password"></td>
				</tr>
			</table>
			<p>
				<!-- bAuthentication doPost 메서드로 패스 -->
				<input type="hidden" name="boardId" value="${boardDTO.boardId }"/>
				<input type="hidden" name="menu" value="${menu }"/>
				<input type="submit" value="인증"/>
				<!-- 게시글 전제조회 화면으로 단순 이동 -->
				<input type="button" value="목록보기" onclick="location.href='bList_연습1';"/>
			</p>
		</form>
	</div>
</body>
</html>