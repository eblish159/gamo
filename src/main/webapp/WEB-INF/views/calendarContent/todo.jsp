<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/calendarcontent/todo.css">
    <title>ToDo</title>
</head>
<body>
    <div class="todo-modal">
        <div class="modal-header">
            <select id="header-dropdown" class="dropdown-menu">
                <option value="todo" selected>ToDo</option>
                <option value="schedule">Schedule</option>
            </select>
            <button type="button" class="p-back-page" onclick="location.href='/calendar'">
                뒤로가기
            </button>
        </div>
        <div class="modal-body">
            <label for="todo-title" class="labell">Title</label>
            <input type="text" id="todo-title" class="input-field" placeholder="내가 할 일">

            <label for="todo-details" class="labell">Details</label>
            <textarea id="todo-details" class="textarea-field" placeholder="내가 할 일 상세 글"></textarea>

             <label for="start-date" class="labell">Start Date</label>
            <div class="date-range">
                <input type="datetime-local" id="end-date" class="date-input">
            </div>

            <label for="end-date" class="labell">End Date</label>
            <div class="date-range">
                <input type="datetime-local" id="end-date" class="date-input">
            </div>

            <div class="options-input">
                <input type="checkbox" id="private-option">
                <label for="private-option" class="labell">비공개 옵션</label>
            </div>
        </div>
        <div class="modal-footer">
            <button class="action-btn add-btn" onclick="updateTodo()">추가</button>
            <button class="action-btn delete-btn" onclick="deleteTodo()">삭제</button>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/js/calendarcontent/todo.js"></script>
</body>
</html>