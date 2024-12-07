<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>${pageTitle}</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <div class="app">
        <!-- Sidebar -->
        <div class="sidebar">
            <div class="user">
                <div class="user-name">Gamo</div>
            </div>
            <div class="sidebar-menu">
                <a href="/calendar" class="sidebar-menulink active">Todo 스케줄</a>
                <a href="/project" class="sidebar-menulink">프로젝트</a>
                <a href="#" class="sidebar-menulink">게시판</a>
                <a href="#" class="sidebar-menulink">휴식 하기</a>
                <a href="#" class="sidebar-menulink">마이 페이지</a>
                <a href="#" class="sidebar-menulink">회원 관리</a>
            </div>
        </div>
        <!-- Main Content -->
        <div class="main">
            <div class="main-header">
                <div class="main-header-nav">
                    <a href="#" class="nav-logout">로그아웃</a>
                </div>
            </div>
            <div id="content">
                <jsp:include page="${contentPage}.jsp" />
            </div>
        </div>
    </div>
</body>
</html>
