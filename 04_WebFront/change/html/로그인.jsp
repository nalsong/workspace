

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>

    <link rel="stylesheet" href="../css/로그인.css">
</head>
<body>
    
    <main>
        <header>

        </header>

        <section>
            <form action="/../lagin" method="post" id="loginFrm">
            <div id="logIn">Log in</div>
            <br>
            
            <div id="DontHaveAccount">Don't have an account? <a href="#" id="SignUp">Sign up</a></div>
            <br>
            
            <button type="button" id="kakao"><img src="../image/kakao_login_medium_wide.png"></button>

            
            <br>

            
            
            <div class="or"> OR </div>
            <br>
            
            <div>
                <input type="text" id="email" placeholder=" Email"><br>
                <input type="password" id="password" placeholder=" Password">
            </div>

        
            <div class="searchPw">
                <a href="#"  id="searchPw">Forget Password</a>
            </div>
            

            <div>
                <button id="loginSubmit">Login</button>
            </div>
            </form>
        </section>
    </main>



    <script src="../js/로그인.js"></script>
    
</body>
</html>