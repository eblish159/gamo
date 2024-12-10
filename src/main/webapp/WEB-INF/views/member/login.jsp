<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>로그인</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login/login.css">
        <c:choose>
        	<c:when test="${result == 'loginFailed'}">
        	  <script>
        	    window.onload = function(){
        	      alert("아이디나 비밀번호가 틀립니다. 다시 로그인 하세요!");
        	    }
        	  </script>
        	</c:when>
        </c:choose>
    </head>
    <body>
        <form class="login_form" action="${contextPath}/member/login" method="post">
            <p class="login_title">GAMO</p>
            <input type="text" name="member_id" class="input_login" placeholder="아이디">
            <input type="password" name="member_pw"class="input_login" placeholder="비밀번호">
            <button type="submit" class="btn_login">로그인</button>
        </form>
    </body>
</html>