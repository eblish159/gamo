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
            <select id="header-dropdown" class="dropdown-menu">
                <option value="todo" selected>ToDo</option>
                <option value="schedule">Schedule</option>
            </select>
            <button class="close-btn" onclick="closeModal()">X</button>
        </div>
        <div class="modal-body">
            <label for="todo-title" class="labell">Title</label>
            <input type="text" id="todo-title" class="input-field" placeholder="내가 할 일">

            <label for="todo-details" class="labell">Details</label>
            <textarea id="todo-details" class="textarea-field" placeholder="내가 할 일 상세 글"></textarea>

            <label for="start-date" class="labell">Start Date</label>
            <div class="date-range">
                <input type="datetime-local" id="start-date" class="date-input">
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
    <script>
        document.getElementById('header-dropdown').addEventListener('change', function () {
            const selectedValue = this.value;
            if (selectedValue === 'todo') {
                console.log('ToDo 선택됨');
            } else if (selectedValue === 'schedule') {
                console.log('Schedule 선택됨');
            }
        });

        function closeModal() {
            console.log("모달 닫기");
        }

        function updateTodo() {
            console.log("할 일 추가");
        }

        function deleteTodo() {
            console.log("할 일 삭제");
        }
    </script>
</body>
</html>