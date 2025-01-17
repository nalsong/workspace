<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>브라우저 게시글 View</title>

    <link rel="stylesheet" href="../css/browse/petitionView/comment.css">
    
</head>

<body>
    <%-- header --%>
    <jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <main>
        
        
        <!-- 상단메뉴 -->
        <section class="top">
            <div id="menu">
                <div><a href="/browse//petitionView/details" id="details">Petition details</a></div>
                <div id="comments">Comments</div>
                <div ><a href="#" id="Updates">updates</a></div>
            </div>
        </section>

        <!-- comment -->
        <section id="comment">
            <div id="comment1">Reasons for signing</div>
            <div id="comment2">See why other supporters are signing, why this petition is important to them, and share your reason for signing (this will mean a lot to the starter of the petition).</div>
            <div id="comment3">
                <div id="commentFrame">
                    <div id="cImage">
                        <a href="#"><img src="../image/순덕이.png" alt="프로필사진" id="profileImg"></a>
                    </div>
                    <div>
                        <div id="cNickname">닉네임</div>
                        <div id="cDate">등록시간</div>
                    </div>
                </div>
                <div id="cContent">
                    <div>
                        내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용
                        내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용
                        내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용
                        내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용
                    </div>
                </div>
                <div id="commentLike">
                    <div id="cHeart">하트</div>
                    <div id="count">하트갯수</div>
                </div>
                <div>
                    <a href="#" id="report">신고하기</a>
                </div>
            </div>
        </section>






        
    </main>

    <script src="https://kit.fontawesome.com/f7459b8054.js"crossorigin="flag"></script>


    <%-- footer --%>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <%-- comment.js --%>
    <script src="../js/browse/petitionView/comment.js"></script>
</body>
</html>