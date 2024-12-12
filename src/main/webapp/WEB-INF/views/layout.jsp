<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>${pageTitle}</title>
    <link rel="stylesheet" href="/css/styles.css">
     <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
</head>
<body>
    <div class="layout">
    <div class="app1">
        <!-- Sidebar -->
        <div class="sidebar">
            <div class="user">
                <a href="/" class="user-name">GAMO</a>
            </div>
            <div class="sidebar-menu">
                <a href="/calendar" class="sidebar-menulink"><i class="fa-regular fa-calendar-days"></i>   Todo 스케줄</a>
                <a href="/project" class="sidebar-menulink"><i class="fa-solid fa-pen"></i>   프로젝트</a>
                <a href="/board" class="sidebar-menulink"><i class="fa-solid fa-list"></i>   게시판</a>
                <a href="/mypage" class="sidebar-menulink"><i class="fa-solid fa-user"></i>   마이 페이지</a>
                <a href="/rest1" class="sidebar-menulink"><i class="fa-solid fa-gamepad"></i>   휴식 하기</a>
                <c:if test="${loginVO.role == 0}">
                    <a href="/admin" class="sidebar-menulink"><i class="fa-solid fa-address-book"></i>   회원 관리</a>
                </c:if>
            </div>
        </div>
        <!-- Main Content -->
        <div class="main">
            <div class="main-header">
                <div class="main-header-nav">
                    <a href="/logout" class="nav-logout">로그아웃</a>
                </div>
            </div>
            <div id="content">
                <jsp:include page="/WEB-INF/views/${contentPage}.jsp" />
            </div>
        </div>
    </div>
    </div>

    <!-- 레벨,경험치 창 -->
            <div class="floating-widget">
              <div class="widget-header">
                <span>문진배</span>
                <button onclick="toggleWidget()">접기</button>
              </div>
              <div class="widget-content">
                <img src="img/lv5.png" alt="Icon" onclick="showModal()">
                <div class="level">LV - 50</div>
                <div class="progress-bar">
                  <div></div>
                </div>
              </div>
            </div>

    <!-- 레벨별 이미지 안내 모달 -->
    <div class="modal" id="levelModal">
        <div class="modal-content">
            <h3>레벨별 이미지</h3>
            <div>
                <img src="img/lv1.png" alt="LV 1~9"><p>1~9</p>
                <img src="img/lv2.png" alt="LV 10~19"><p>10~19</p>
                <img src="img/lv3.png" alt="LV 20~29"><p>20~29</p>
                <img src="img/lv4.png" alt="LV 30~39"><p>30~39</p>
                <img src="img/lv5.png" alt="LV 40~50"><p>40~50</p>
            </div>
            <button class="modal-close" onclick="closeModal()">닫기</button>
        </div>
    </div>

    <script src="/js/layout.js"></script>
</body>
</html>
