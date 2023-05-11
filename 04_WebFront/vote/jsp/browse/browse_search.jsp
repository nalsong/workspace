<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>브라우저 게시글 조회</title>

    <%-- browse_search.css --%>
    <link rel="stylesheet" href="/resources/css/browse/browse_search.css">
    
</head>
<body>
    
    <main>
        <%-- header --%>
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>
        
        
        <section class="top">
            <div id="discoverP">
                Discover petitons to sign
            </div>
            <div class="menu" id="menu">
                <div id="featured"><a href="#">Featured</a></div>
                <div id="popular"><a href="#">Popular</a></div>
                <div id="recent"><a href="#">Recent</a></div>
                <div id="victories"><a href="#">Victories</a></div>
            </div>
        </section>

        <section class="middle">
            
            <div class="result">
                <div class="row" id="rowPicture">
                    <img src="../image/순덕이.png" class="picture">
                </div>
                <div class="row">
                    <div class="column" id="column-1">
                        <div id="title">
                            서울시 종로구 순덕이 출현
                        </div>
                        <div id="content">
                            내용내용내용내용내용내용내용내용내용내용내용내용내
                            <a href="#" id="readMore"> Read more</a>
                        </div>
                    </div>
                    <div class="column" id="column-2">
                        <progress id="progress" value="35000" min="0" max="50000" ></progress>
                        <div id="value"></div>
                        <div id="goal">
                            of 50,000 goal
                        </div>
                    </div>
                </div>
                
            </div>
        </section>
        <section>
            <div>
                <button type="button" id="moreView">더보기</button>
            </div>
        </section>
        <%-- footer --%>
        <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    </main>

    <%-- browse_search.js --%>
    <script src="/resources/js/browes/browse_search.js"></script>
</body>
</html>