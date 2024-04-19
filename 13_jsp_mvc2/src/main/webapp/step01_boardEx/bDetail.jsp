<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bDetail</title>
</head>
<body>

	<div align="center">
		<h3>게시글 상세조회</h3>
		<table border="1">
			<tr>
				<td>조회수</td>
				<td>${boardDTO.readCnt }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${boardDTO.writer }</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td>${boardDTO.enrollDt }</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${boardDTO.email }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${boardDTO.subject }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${boardDTO.content }</td>
			</tr>
			<tr>
				<td colspan="2">
					<!-- 해당 게시글의 boardId와 update 글자 파라메타를 전달하며 bAuthentication 서블렛으로 이동 -->
					<input type="button" value="수정" onclick="location.href='bAuthentication?boardId=${boardDTO.boardId}&menu=update';">
					<!-- 해당 게시글의 boardId와 delete 글자 파라메타를 전달하며 bAuthentication 서블렛으로 이동 -->
					<input type="button" value="삭제" onclick="location.href='bAuthentication?boardId=${boardDTO.boardId}&menu=delete';">
					<input type="button" value="목록보기">
				</td>
			</tr>
		</table>
	</div>
	
</body>
</html>