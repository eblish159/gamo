<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>프로젝트 관리</title>
    <link rel="stylesheet" href="<c:url value='/css/project/projectsdetail.css'/>">
</head>
<body>
<div class="projecttwo">
    <div class="app-container">
        <div class="projects-and-todoprojects">
            <!-- 프로젝트 섹션 -->
            <div class="projects-section">
                <div class="projects-section-header">
                    <p style="color: black;">프로젝트</p>
                    <p class="status">프로젝트 진행률: <span id="total-progress">0%</span></p>
                </div>

                <div class="project-boxes">
                    <div class="project-box-wrapper">
                        <div class="project-box" style="background-color: rgba(231, 224, 218, 0.89);">
                            <div class="project-box-header">
                                <span>프로젝트 제목: ${project.projectTitle}</span>
                            </div>
                            <div class="project-box-content-header">
                                <p class="box-content-header">프로젝트 기간</p>
                                <p class="box-content-subheader">프로젝트 내용: ${project.projectContent}</p>
                            </div>
                            <div class="box-progress-wrapper">
                                <div class="box-progress-bar">
                                    <span class="box-progress" style="width: 60%; background-color: rgb(192, 197, 241);"></span>
                                </div>
                                <div class="participants"></div>
                                <div class="days-left" style="color: skyblue;"></div>

                            </div>
                        </div>
                    </div>

                    <div class="project-box-wrapper">
                        <div class="project-box" style="background-color: rgb(192, 197, 241);">
                            <div class="project-box-header">
                                <span>참여자</span>
                            </div>
                            <div class="project-box-content-header">
                                <p class="box-content-header">참여자들</p>
                            </div>
                            <div class="box-progress-wrapper">
                                <div class="box-progress-bar">
                                    <span class="box-progress" style="width: 40%; background-color: skyblue"></span>
                                </div>
                            </div>
                            <div class="project-box-footer">
                                <div class="participants">
                                    <button class="add-participant" style="color: black">참여하기</button>
                                </div>
                                <div class="days-left" style="color: #4f94d1;"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="save-delete-project">
                    <!-- 저장 및 삭제 버튼 -->
                    <button id="saveProjectBtn" class="btn-save">저장</button>
                    <button id="deleteProjectBtn" class="btn-delete">삭제</button>
                </div>

            </div>

            <!-- 할일 목록 섹션 -->
            <div class="todoprojects-section">
                <div class="projects-section-header">
                    <p style="color: black;">할일 목록</p>
                </div>
                <div class="todoprojects">
                    <!-- 이미 존재하는 할일 항목 -->
                    <c:forEach var="todo" items="${todoList}">
                        <div class="todoproject-box">
                            <div class="todoproject-content">
                                <div class="todoproject-header">
                                    <input type="checkbox" class="todo-checkbox">
                                    <div class="name">${todo.todoName}</div>
                                </div>
                                <p class="todoproject-line">${todo.description}</p>
                                <p class="todoproject-line status">진행률: <span class="progress-status">${todo.progress}%</span></p>
                                <div class="progress-container">
                                    <button class="progress-btn" data-progress="0">0%</button>
                                    <button class="progress-btn" data-progress="25">25%</button>
                                    <button class="progress-btn" data-progress="50">50%</button>
                                    <button class="progress-btn" data-progress="75">75%</button>
                                    <button class="progress-btn" data-progress="100">100%</button>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="todo-actions">
                    <button class="add-todo-btn">추가</button> <!-- 할일 추가 버튼 -->
                    <button class="remove-todo-btn">삭제</button> <!-- 할일 삭제 버튼 -->
                </div>
                <div class="todo-input" style="display:none;">
                    <textarea id="todoDescription" placeholder="할일 내용을 입력하세요"></textarea>
                    <input type="text" id="todoUser" placeholder="할일 이름" />
                    <button class="save-todo-btn" id="saveTodo">저장</button>
                </div>
            </div>
        </div>
    </div>
    </div>

<script src="<c:url value='/js/project/projectsdetail.js'/>"></script>
</body>
</html>
