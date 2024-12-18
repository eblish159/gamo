<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calendar</title>
    <link rel="stylesheet" href="/css/calendarcontent/calendar.css">
    <link rel="stylesheet" href="/css/calendarcontent/schedule.css">
    <link rel="stylesheet" href="/css/calendarcontent/todo.css">
</head>
<body>
    <div class="calendar-container">
        <div>
        <input type="month" class="calendar-header" id="calendar-date">
        </div>
        <div class="calendar-grid">
            <!-- Days of the week -->
            <div class="day-name">일</div>
            <div class="day-name">월</div>
            <div class="day-name">화</div>
            <div class="day-name">수</div>
            <div class="day-name">목</div>
            <div class="day-name">금</div>
            <div class="day-name">토</div>
    <!-- Calendar days -->
            <div class="empty"></div> <!-- For empty cells -->
            <div class="empty"></div>
            <div id="day-2024-12-1" class="day">1<div></div></div>
            <div id="day-2024-12-2" class="day" data-date="2024-12-02">2</div>
            <div id="day-2024-12-3" class="day">3</div>
            <div id="day-2024-12-4" class="day">4<div></div></div>
            <div id="day-2024-12-5" class="day">5</div>
            <div id="day-2024-12-6" class="day">6</div>
            <div id="day-2024-12-7" class="day">7<div></div></div>
            <div id="day-2024-12-8" class="day">8<div></div>
            <div></div></div>
            <div id="day-2024-12-9" class="day">9<div></div></div>
            <div id="day-2024-12-10" class="day">10</div>
            <div id="day-2024-12-11" class="day">11<div></div></div>
            <div id="day-2024-12-12" class="day">12</div>
            <div id="day-2024-12-13" class="day">13
                <c:forEach var="day" items="${eventcal}">
                <div class="todo-item">
                <strong>${day.calTitle}</strong>
                </div>
                </c:forEach>
            </div>
            <div id="day-2024-12-14" class="day">14</div>
            <div id="day-2024-12-15" class="day">15<div></div></div>
            <div id="day-2024-12-16" class="day">16</div>
            <div id="day-2024-12-17" class="day">17</div>
            <div id="day-2024-12-18" class="day">18<div></div></div>
            <div id="day-2024-12-19" class="day">19</div>
            <div id="day-2024-12-20" class="day">20</div>
            <div id="day-2024-12-21" class="day">21</div>
            <div id="day-2024-12-22" class="day">22</div>
            <div id="day-2024-12-23" class="day">23<div></div></div>
            <div id="day-2024-12-24" class="day">24<div></div></div>
            <div id="day-2024-12-25" class="day">25<div></div></div>
            <div id="day-2024-12-26" class="day">26</div>
            <div id="day-2024-12-27" class="day">27</div>
            <div id="day-2024-12-28" class="day">28<div></div></div>
            <div id="day-2024-12-29" class="day">29<div></div></div>
            <div id="day-2024-12-30" class="day">30</div>
            <div id="day-2024-12-31" class="day">31</div>
        </div>
      <div class="search-container">
          <a href="javascript:void(0);" id="add-todo-btn" class="todo">할 일 추가</a>
      </div>
    </div>

     <div class="todo-modal" id="todo-modal">
         <div class="modal-header">
             <select id="header-dropdown" class="dropdown-menu" name="gubun">
                 <option value=1 selected>ToDo</option>
                 <option value=0>Schedule</option>
             </select>
          <button class="schedule-close-btn" onclick="closetodoModal()">X</button>
         </div>

         <div class="modal-body">
            <form action="/addEvent" method="post">
             <label for="todo-title" class="labell">Title</label>
             <input type="text" id="todo-title" name="cal_title" class="input-field" placeholder="내가 할 일">

             <label for="todo-details" class="labell">Details</label>
             <textarea id="todo-details" name="cal_details" class="textarea-field" placeholder="내가 할 일 상세 글"></textarea>

             <label for="start-date" class="labell">Start Date</label>
             <div class="date-range">
                 <input type="datetime-local" name="start_date" id="start-date" class="date-input">
             </div>

             <label for="end-date" class="labell">End Date</label>
             <div class="date-range">
                 <input type="datetime-local" name="end_date" id="end-date" class="date-input">
             </div>

             <div class="options-input">
                 <input type="checkbox" id="private-option">
                 <label for="private-option" class="labell">비공개</label>
             </div>
            <div class="modal-footer">
                <button type="submit" class="action-btn add-btn" id="addTodoButton" onclick="updateTodo()">추가</button>
                <button class="action-btn delete-btn" onclick="deleteTodo()">삭제</button>
            </div>
            </form>
         </div>
     </div>

<div class="schedule-modal">
    <div class="modal-header">
        <h2>상세내용</h2>
        <button class="schedule-close-btn" onclick="closescheduleModal()">X</button>
    </div>
     <h2 id="selected-date">24.12.08</h2>
        <div class="select-day">
           프로젝트 내용 추가해야함
        </div>
        <h2>할일목록</h2>
        <div class="schdule-calendar-container">
           <div class="calendar-scroll">
               <!-- 1일부터 31일까지 날짜 반복 -->
               <div class="schdule-calendar-item" id="day-8">
                   <span class="date">2024.12.8(todo)</span>
                   <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                   <div class="task-details">회사 중요 스케줄 입니다.</div>
               </div>
               <div class="schdule-calendar-item" id="day-9">
                   <span class="date">2024.12.9(schedule)</span>
                   <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                   <div class="task-details">회사 중요 스케줄 입니다.</div>
               </div>
               <div class="schdule-calendar-item" id="day-10">
                   <span class="date">2024.12.10(todo)</span>
                   <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                   <div class="task-details">회사 중요 스케줄 입니다.</div>
               </div>
               <div class="schdule-calendar-item" id="day-11">
                   <span class="date">2024.12.11(schedule)</span>
                   <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                   <div class="task-details">회사 중요 스케줄 입니다.</div>
               </div>
        </div>
       <div class="progress-container">
           <h3>EXP</h3>
           <div class="progress-bar">
               <div class="progress-fill" id="progress-fill"></div>
           </div>
           <p id="progress-text">0%</p>
               </div>
            </div>
        <div class="modal-body">
            <c:forEach var="day" items="${eventcal}" varStatus="status">
            <c:if test="${status.index == 0}">
                <span class="date">${day.date} ${day.dayOfWeek}</span>
                <div class="details">
                    <p>${day.description}</p>
                    <p>${day.time}</p>
                </div>
            </c:if>
        </c:forEach>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/calendarcontent/schdule.js"></script>
</body>
</html>
