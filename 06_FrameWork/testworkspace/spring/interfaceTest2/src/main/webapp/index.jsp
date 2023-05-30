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
    <h1>회원 정보 조회(회원 번호 검색)</h1>

    <form action="/selectNum">
        <input type="text" name="inputNum" placeholder="회원 번호 입력">
        <button>조회</button>
    </form>

</body>
</html>