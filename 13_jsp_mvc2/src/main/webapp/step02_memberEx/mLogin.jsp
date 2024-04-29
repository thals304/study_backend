<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mLogin</title>
<script src="resources/jquery/jquery-3.7.1.min.js"></script>
<script>
	
	$(function(){
		// 로그인 버튼이 눌러졌을 때
		$("#loginBtn").click(function(){
			// 속성은 [속성='변수명']
			let param = {
				"memberId" : $('[name="memberId"]').val(),
				"passwd" : $('[name="passwd"]').val()
			}
			
			$.ajax({
				url : "loginMember",
				type : "post",
				data : param ,
				success : function(isAuthorized) {
					
					if (isAuthorized == "true") {
						location.href = "detailMember"; // 회원 정보로 이동
					}
					else {
						$("#resultMsg").html("<span style='color:red;'>아이디와 패스워드를 확인하세요.</span>");
					}
					
				}
			});
			
		});
	});

</script>
</head>
<body>

	<div align="center">
		<h3>로그인</h3>
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="memberId" autofocus required></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td>
					<input type="password" name="passwd" required><br>
					<span id="resultMsg"></span>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="button" id="loginBtn" value="로그인"></td>
			</tr>
		</table>
	</div>
	
</body>
</html>