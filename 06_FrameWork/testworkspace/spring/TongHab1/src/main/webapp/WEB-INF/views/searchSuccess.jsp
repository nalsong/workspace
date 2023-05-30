<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>게시글 검색 결과</h1>
    <c:set var="board" value="boardList"/>
    <table>

        <th>
            <td>번호</td>
            <td>제목</td>
            <td>작성자</td>
            <td>내용</td>
            <td>조회수</td>
            <td>작성날짜</td>
        </th>
        <c:forEach items="board" var="board">
        <tr>
            <td>
                ${board.boardNo}
            </td>
            <td>
                ${board.boardTitle}
            </td>
            <td>
                ${board.userId}
            </td>
            <td>
                ${board.boardContent}
            </td>
            <td>
                ${board.boardReadCount}
            </td>
            <td>
                ${board.boardDate}
            </td>
        </tr>
        </c:forEach>

    </table>

</body>
</html>