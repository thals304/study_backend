<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin</title>
</head>
<body>

	<%-- view(jsp)에서 session객체에 접근하는 방법 : ${sessionScope.속성명} --%>
	<%-- view(jsp)에서 request객체에 접근하는 방법 : ${reuqestScope.속성명} or ${속성명}--%>

	<h3>'${sessionScope.id}'님의 운영자화면 (${sessionScope.role } 권한)</h3>
	<h5>상품관리 : ${productList }</h5>
	<h5>유저관리 : ${userList }</h5>
	<h5>결제관리 : ${orderList }</h5>

</body>
</html>