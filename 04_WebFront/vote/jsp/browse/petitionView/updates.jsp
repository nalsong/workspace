<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>브라우저 게시글 View(updates)</title>

    <link rel="stylesheet" href="../css/browse/petitionView/updates.css">
    <script src="https://kit.fontawesome.com/f7459b8054.js"crossorigin="flag"></script>
</head>

<body>
    
    <main>
        <header>

        </header>
        
        <!-- 상단메뉴 -->
        <section id="top">
            <div id="menu">
                <div><a href="#" id="details">Petition details</a></div>
                <div><a href="#" id="Comments">Comments</a></div>
                <div id="updates">Updates</div>
            </div>
        </section>

        <section id="updatesSection1">
            <div id="updatesBT">최근 소식</div>
        </section>

        

        <!-- updates -->
        <section id="updatesSection2">
            
            <span id="left">&lang;</span>
            
            <div id="updatesFrame">
                <div id="cImage">
                    <a href="#"><img src="../image/순덕이.png" alt="업데이트사진" id="updatesImg"></a>
                </div>
                <div id="updatesT">
                    <a href="#" id="updatesTitle">
                        업데이트 제목
                    </a>
                </div>
                <div id="updatesC">
                    <a href="#" id="updatesContent">
                        업데이트 내용 업데이트 내용업데이트 내용업데이트 내용업데이트 내용업데이트 내용업데이트 내용업데이트 내용업데이트 내용업데이트 내용업데이트 내용업데이트 내용업데이트 내용업데이트 내용업데이트 내용업데이트 내용
                    </a>
                </div>
                <div id="updatesProfile">
                    <div>
                        <a href="#" id="updatesProfileImg">
                            <img src="../image/순덕이.png" alt="프로필사진" id="profileImg">
                        </a>
                    </div>
                    <div>
                        <div id="uNickname">닉네임</div>
                        <div id="uDate">등록시간</div>
                    </div>
                </div>
            </div>
                
            <span id="right">&rang;</span>
        </section>

        <section id="updatesSection3"></section>
    </main>


    <script src="../js/browse/petitionView/updates.js"></script>
</body>
</html>