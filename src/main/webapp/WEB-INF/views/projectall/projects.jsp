<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Projects</title>
    <link rel="stylesheet" href="<c:url value='/css/project/projects.css'/>">
</head>
<body>
<div class="project-wrapper">
    <div class="page">
        <div class="page-header">
            <h2>진행중인 프로젝트</h2>
            <div class="header-buttons">
                <div class="search-bar">
                    <input type="text" id="search-input" placeholder="Search projects...">
                    <button id="search-button">Search</button>
                </div>
                <button class="add-btn" onclick="location.href='/projectswrite'">프로젝트 추가</button>
            </div>
        </div>

        <!-- 프로젝트 리스트 -->
        <ul class="project-list">
            <li class="project-header-row">
                <span class="column-title">제목</span>
                <span class="column-title">등록일</span>
                <span class="column-title">시작일</span>
                <span class="column-title">종료일</span>
                <span class="column-title">진행률</span>
            </li>
            <c:forEach var="project" items="${projectList}">
                <li class="project-row">
                    <span class="project-title">
                        <a href="/projectsdetail?projectNo=${project.projectNo}">${project.projectTitle}</a>
                    </span>
                    <span class="project-date">${project.createdDate}</span>
                    <span class="project-date">${project.startDate}</span>
                    <span class="project-date">${project.endDate}</span>
                    <span class="project-progress">${project.projectProgress}%</span>
                </li>
            </c:forEach>
        </ul>

        <!-- 종료된 프로젝트 버튼 -->
        <div class="end-project-btn-container">
            <button class="end-project-btn" onclick="location.href='/endprojects'">종료된 프로젝트</button>
        </div>

        <!-- 페이지네이션 -->
        <div class="pagination"></div>
    </div>
</div>

<script src="<c:url value='/js/project/projects.js'/>"></script>
</body>
</html>
