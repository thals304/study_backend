<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mDelete</title>
<script src="resources/jquery/jquery-3.7.1.min.js"></script>
<script>

	function checkFormValidation() {
		
		let memberId = $("#memberId").text();
		let confirmMemberId = $("#confirmMemberId").val();
		
		if (memberId != confirmMemberId) {
			alert("컴펌 워드를 확인하세요.");
			return false;
		}
		
	}

</script>
</head>
<body>

	<div align="center">
		<form action="deleteMember" method="post" onsubmit="return checkFormValidation();">
			<h3>회원 탈퇴</h3>
			<p><span style="color:red;">삭제된 계정은 다시는 복구 할 수 없습니다.</span> </p>
			<p>회원탈퇴를 원하시는 경우  <strong><span id="memberId">${sessionScope.memberId }</span></strong>를 입력하세요.</p>
			<p><input type="text" id="confirmMemberId"></p>
			<input type="submit" value="삭제하기" >
		</form>
	</div>

</body>
</html>