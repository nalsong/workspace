<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>체크리스트2</title>
</head>
<body>
	<h2>회원정보</h2>

	<c:set var="User" value="SelectUserNum"/>
	<table border="1">
		<tr>
			<th>회원번호</th>
			<th>회원아이디</th>
			<th>회원이름</th>
			<th>회원나이</th>
		</tr>
		<tr>
			<th>${User.userNumber}</th>
			<th>${User.userId}</th>
			<th>${User.userName}</th>
			<th>${User.userAge}</th>
		</tr>
		
	</table>
	
</body>
</html>