<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ToDo</title>
    <link rel="stylesheet" href="/css/schedule.css">
    <script src="https://kit.fontawesome.com/c39c442009.js" crossorigin="anonymous"></script>
</head>
<body>
    <div class="schedule-modal">
        <div class="modal-header">
            <h2>상세내용</h2>
            <!-- 모달 닫기 버튼 -->
            <button class="close-btn" onclick="closeModal()">X</button>
        </div>
        <div class="modal-body">
            <div class="schedule-item">
                <span class="date">2024.12.16 월요일</span>
                <div class="details">
                    <p>회사 중요 스케줄 입니다.</p>
                    <p>10:30 ~ 11:30 내가 할 일</p>
                </div>
                <div class="checkbox">
                    <input type="checkbox">
                </div>
            </div>
            <div class="schedule-item">
                <span class="date">2024.12.17 수요일</span>
                <div class="details">
                    <p>회사 중요 스케줄 입니다.</p>
                    <p>10:30 ~ 11:30 내가 할 일</p>
                </div>
                <div class="checkbox">
                    <input type="checkbox">
                </div>
            </div>
            <div class="schedule-item">
                <span class="date">2024.12.18 수요일</span>
                <div class="details">
                    <p>회사 중요 스케줄 입니다.</p>
                    <p>10:30 ~ 11:30 내가 할 일</p>
                </div>
                <div class="checkbox">
                    <input type="checkbox" checked>
                </div>
            </div>
            <div class="schedule-item">
                <span class="date">2024.12.19 목요일</span>
                <div class="details">
                    <p>내가 할 일</p>
                    <p>10:30 ~ 11:30 내가 할 일</p>
                </div>
                <div class="checkbox">
                    <input type="checkbox">
                </div>
            </div>
        </div>
    </div>
    <script src="/js/todo.js"></script>
</body>
</html>
