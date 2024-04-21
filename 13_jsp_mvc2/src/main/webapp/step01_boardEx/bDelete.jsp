<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete</title>
</head>
<body>

	<div align="center">
		<h3>게시글 삭제</h3>
		<p><span style="color:red;">삭제된 게시글은 다시는 복구 할 수 없습니다. 정말 삭제하시겠습니까?</span></p>
		<!-- bDelete serlvet의 doPost메서드로 패스받은 boardId 전송  -->
		<form action="bDelete" method="post">
			<input type="hidden" name="boardId" value="${boardId }" />
			<input type="submit" value="삭제하기">
			<!-- bDetail로 가는 건데 boardId도 같이 보내주는 이유? 
			     그러면 목록보기도 boardId를 써줘야 하나?
			     그리고 deleteBoard & updateBoard에서 수정/삭제되었습니다 하고 
			     bList로 보낼 때는?
			 -->
			<input type="button" value="취소" onclick="location.href='bDetail?boardId=${boardId}';">
		</form>
	</div>
	
</body>
</html>


