<%@ page contentType="text/html;charset=UTF-8" language="java" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <c:if test="${ !empty message }">
            <script>
                alert("${message}");
            </script>
        </c:if>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>로그인</title>
        <link rel="stylesheet" href="<c:url value='/css/login/login.css'/>">
    </head>
    <body>
        <form id="loginForm" class="login_form" action="${contextPath}/login" method="post">
            <p class="login_title">GAMO</p>
            <input type="text" name="member_id" class="input_login" placeholder="아이디">
            <input type="password" name="member_pw"class="input_login" placeholder="비밀번호">
            <button type="submit" id="loginButton" class="btn_login">로그인</button>
        </form>
        <div id="spaceship"></div>
        <script src="${pageContext.request.contextPath}/js/login/login.js"></script>
    </body>
</html>