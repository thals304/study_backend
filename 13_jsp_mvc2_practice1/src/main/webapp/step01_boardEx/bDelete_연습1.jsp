<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bDelete</title>
</head>
<body>
	<div align="center">
		<h3>게시글 삭제</h3>
		<p><span style="color:red;">삭제된 게시글은 다시는 복구 할 수 없습니다. 정말 삭제하시겠습니까?</span></p>
		<!-- bDelete serlvet의 doPost메서드로 패스받은 boardId 전송  -->
		<form action="bDelete_연습1" method="post">
			<input type="hidden" name="boardId" value="${boardId }" />
			<input type="submit" value="삭제하기">
			<input type="button" value="취소" onclick="location.href='bDetail_연습1?boardId=${boardId}';">
		</form>
	</div>
</body>
</html>