<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<link rel="stylesheet" href="/css/main-style.css">

<!-- fonts wesone 라이브러리 추가 + key 등록 -->
<script src="https://kit.fontawesome.com/f7459b8054.js" crossorigin="anonymous"></script>

<script src="/resources/js/header.js"></script>

<header>
    <section>
        <!-- 클릭 시 메인페이지로 이동하는 로고 -->
        <a href="/">

            <img src="/resources/images/대장이.png" alt="로고" id="homeLogo">
        </a>
    </section>
    <section>
        <!-- 검색어 입력할 수 있는 요소 배치 -->
        <article class="search-area">

            <!-- 
                action: 내부 input에 작성된 값을 제출할 경로/주소 
                method: 어떤 방식으로 제출할지 지정
                - GET : input태그 값을 주소에 담아서 제출(주소에 보임)
                - POST: input태그 값을 주소에 담지 않고 제출(주소에 안보임)
                        -> HTTP Body에 담아서 제출
            -->

            <form action="/board/2" method="GET">
                <fieldset> <!-- form태그 내 영역 구분 -->

                    <!-- 
                        input의 name속성 == 제출 시 key값
                        input에 입력된 내용 == 제출 시 value

                        autocomplete="off" 브라우저 제공 자동완성 끔
                    -->
                    <input type="search" name="query" id="query" placeholder="검색어를 입력해주세요." autocomplete="off" value="${param.query}">

                    <%-- 제목 검색 --%>
                    <input type="hidden" name="key" value="t">
                    <!-- 검색 버튼 -->
                    <!-- button type="submit" 이면 기본값 -->
                    <button id="searchBtn" class="fa-solid fa-magnifying-glass"></button>
                </fieldset>
            </form>

            <ul id="searchResult" class="close"></ul>
        </article>

    </section>
    <section></section>

    <!-- 우측 상단 드롭다운 메뉴 -->
    <div class="header-top-menu">

        
                <%-- 로그인 안 했을 때 --%>
                <a href="/">메인페이지</a> | <a href="/member/login">로그인</a> 
            
        
                <%-- 로그인 했을 때 --%>
                <label for="headerMenuToggle">
                    ${loginMember.memberNickname} <i class="fa-solid fa-caret-down"></i>
                </label>

                <input type="checkbox" id="headerMenuToggle">
                <div class="header-menu">
                    <a href="/myPage/info">내 정보</a>
                    <a href="/member/logout">로그아웃</a>
                </div>
            </div>
        





</header>

<nav>
    <ul>
        <%-- 
            <li><a href="#">공지사항</a></li>
            <li><a href="#">자유게시판</a></li>
            <li><a href="#">질문게시판</a></li>
            <li><a href="#">FAQ</a></li>
            <li><a href="#">1:1문의</a></li> 
        --%>

        <%-- 
            interceptor를 이용해서 조회된 boardTypeList를 application에서 얻어와 화면에 출력
        --%>
        <c:forEach var="boardType"  items="${boardTypeList}" >
            <li>
                <a href="/board/${boardType.BOARD_CODE}">${boardType.BOARD_NAME}</a>
            </li>
        </c:forEach>


        <%--  --%>
        <c:if test="${not empty loginMember}" >
            <li><a href="/chatting">채팅</a></li>
        </c:if>

    </ul>
</nav>