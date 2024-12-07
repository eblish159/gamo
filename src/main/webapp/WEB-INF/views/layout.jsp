<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>${pageTitle}</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <div class="maindan">
        <h1>${message}</h1>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/">Gamo</a>
                </div>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">로그인</a></li>
                </ul>
            </div>
        </nav>
        <div id="sidebar">
            <ul>
                <li><a href="#">출결 관리</a></li>
                <li><a href="#">캘린더</a></li>
                <li><a href="#">할 일</a></li>
                <li><a href="#">점심룰렛</a></li>
                <li><a href="#">마이페이지</a></li>
                <li><a href="#">관리자 페이지</a></li>
            </ul>
        </div>
        <!-- 각 JSP에서 컨텐츠를 넣을 공간 -->
        <div id="content">
            <jsp:include page="${contentPage}.jsp" />
        </div>
        <!-- 예제 요소 -->
                <div class="rectangle">
                    예제 텍스트
                </div>
    </div>
</body>
</html>
