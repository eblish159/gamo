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
<div class="projectone">
    <div class="page">
        <div class="page-header cf">
            <h2>진행중인 프로젝트</h2>

            <div class="project-search">
                <input type="text" id="search-input" placeholder="Search projects...">
                <button id="search-button">Search</button>
            </div>

            <!-- 카테고리 버튼 -->
            <div class="project-category-dropdown">
                <button class="category-btn">카테고리 선택</button>
                <div class="category-dropdown-content">
                    <a href="#" class="category-option" data-category="all">전체</a>
                    <a href="#" class="category-option" data-category="in-progress">진행중</a>
                    <a href="#" class="category-option" data-category="completed">종료</a>
                    <a href="#" class="category-option" data-category="pending">준비중</a>
                </div>
            </div>
            <button class="add-project-btn" onclick="location.href='/projectswrite'">추가</button> <!-- 추가 버튼 추가 -->
        </div>

        <ul class="project-list">
            <!-- 프로젝트 데이터를 반복 출력 -->
            <c:forEach var="project" items="${projectList}">
                <li class="project-item cf" data-category="${project.projectCategory}">
                    <div class="project-details">
                        <a href="/projectsdetail?projectNo=${project.projectNo}" class="project-link">${project.projectTitle}</a>
                        <span class="status">진행률: project.projectProgress</span>
                        <div class="joined-details">
                            <span class="date">등록일: ${project.createdDate}</span>
                            <span class="date">시작일: ${project.startDate}</span>
                            <span class="date">종료일: ${project.endDate}</span>
                            <span class="category">project.projectCategory</span>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>

        <div class="end-project-btn-container">
            <button class="end-project-btn" onclick="location.href='/endprojects'">종료된 프로젝트</button>
        </div>
        <div class="pagination"></div> <!-- 페이지네이션 공간 -->
    </div>
</div>

<script src="<c:url value='/js/project/projects.js'/>"></script>

</body>
</html>
