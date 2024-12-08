<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ToDo</title>
    <!-- FontAwesome 아이콘 -->
    <script src="https://kit.fontawesome.com/c39c442009.js" crossorigin="anonymous"></script>
    <!-- CSS 연결 -->
    <link rel="stylesheet" href="/css/todo.css">
</head>
<body>
    <div class="todo-modal">
        <div class="modal-header">
            <h2>To Do</h2>
            <!-- 모달 닫기 버튼 -->
            <button class="close-btn" onclick="closeModal()">X</button>
        </div>
        <div class="modal-body">
            <!-- 제목 입력 -->
            <label for="todo-title" class="labell">Title</label>
            <input type="text" id="todo-title" class="input-field" placeholder="내가 할 일">

            <!-- 세부사항 입력 -->
            <label for="todo-details" class="labell" >Details</label>
            <textarea id="todo-details" class="textarea-field" placeholder="내가 할 일 상세 글"></textarea>

            <!-- 날짜 선택 -->
            <label for="start-date" class="labell" >Start Date</label>
            <div class="date-range">
                <input type="datetime-local" id="start-date" class="date-input">
                <label for="end-date" class="labell" >End Date</label>
                <input type="datetime-local" id="end-date" class="date-input">
            </div>

            <!-- 옵션 -->
            <label for="private-option">Options</label>
            <div class="options-input">
                <input type="checkbox" id="private-option">
                <label for="private-option" class="labell" >비공개 옵션</label>
            </div>
        </div>
        <div class="modal-footer">
            <!-- 수정 버튼 -->
            <button class="action-btn" onclick="updateTodo()">추가</button>
            <!-- 삭제 버튼 -->
            <button class="action-btn" onclick="deleteTodo()">삭제</button>
        </div>
    </div>
    <script src="/js/todo.js"></script>
</body>
</html>