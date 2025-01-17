<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>비밀번호 찾기</title>

    <link rel="stylesheet" href="/resources/css/login/searchPw.css">

</head>
<body>
    
    <main>
        <%-- header --%>
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>
        
        
        <section>
            <div id="searchPw">
                Forget Password?
            </div>


            <div>
                Enter your email address here, then check your inbox <br>
                for a link to reset your password.
            </div>

            
            <div>
                <input type="text" id="email" placeholder=" Email">
            </div>


            <div>
                <button id="resetPw">Reset password</button>
            </div>
        </section>
        <%-- footer --%>
        <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    </main>


    <script src="/resources/js/login/searchPw.js"></script>
</body>
</html>