<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
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
        <div class="calendar-header">
            <button class="prev-month" aria-label="Previous Month">&lt;</button>
            <h2>2024년 3월</h2>
            <button class="next-month" aria-label="Next Month">&gt;</button>
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
            <div class="day">1<div class="event red">삼일절</div></div>
            <div class="day">2</div>
            <div class="day">3</div>
            <div class="day">4<div class="event yellow">다은</div></div>
            <div class="day">5</div>
            <div class="day">6</div>
            <div class="day">7<div class="event orange">이나래</div></div>

            <div class="day">8<div class="event pink">먹자방</div>
            <div class="event green">가족 모임</div></div>

            <div class="day">9<div class="event green">휴가</div></div>
            <div class="day">10</div>
            <div class="day">11<div class="event blue">프로젝트 회의</div></div>
            <div class="day">12</div>
            <div class="day">13</div>
            <div class="day">14</div>
            <div class="day">15<div class="event green">스터디 모임</div></div>
            <div class="day">16</div>
            <div class="day">17</div>
            <div class="day">18<div class="event purple">제주도 여행</div></div>
            <div class="day">19</div>
            <div class="day">20</div>
            <div class="day">21</div>
            <div class="day">22</div>
            <div class="day">23<div class="event orange">호두집사</div></div>
            <div class="day">24<div class="event yellow">말랑</div></div>
            <div class="day">25<div class="event pink">모모랑 약속</div></div>
            <div class="day">26</div>
            <div class="day">27</div>
            <div class="day">28<div class="event yellow">섭미</div></div>
            <div class="day">29<div class="event green">동물병원 예약</div></div>
            <div class="day">30</div>
            <div class="day">31</div>
        </div>
      <div class="search-container">
          <a href="javascript:void(0);" id="add-todo-btn" class="todo">할 일 추가</a>
      </div>
    </div>
     <div class="todo-modal" id="todo-modal" style="display: none;">
         <div class="modal-header">
             <select id="header-dropdown" class="dropdown-menu">
                 <option value="todo" selected>ToDo</option>
                 <option value="schedule">Schedule</option>
             </select>
          <button class="schedule-close-btn" onclick="closetodoModal()">X</button>
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
            <div class="modal-footer">
                <button class="action-btn add-btn" onclick="updateTodo()">추가</button>
                <button class="action-btn delete-btn" onclick="deleteTodo()">삭제</button>
            </div>
         </div>
     </div>

    <div class="schedule-modal">
            <div class="modal-header">
                <h2>상세내용</h2>
                <!-- 모달 닫기 버튼 -->
                <button class="schedule-close-btn" onclick="closescheduleModal()">X</button>
            </div>
            <div class="modal-body">
                <c:forEach var="day" items="${days}" varStatus="status">
                <c:if test="${status.index == 0}">
                    <span class="date">${day.date} ${day.dayOfWeek}</span>
                    <div class="details">
                        <p>${day.description}</p>
                        <p>${day.time}</p>
                    </div>
                    <div class="checkbox">
                        <input type="checkbox"> <c:if test="${day.checked}"</c:if>
                         <span class="date" 2024.12.1 월요일</span>
                        <div class="details">
                            <p>회사 중요 스케줄 입니다. 10:30 ~ 11:30 내가 할 일</p>
                        </div>
                    </div>
                     <div class="checkbox">
                        <input type="checkbox"> <c:if test="${day.checked}"></c:if>
                         <span class="date" 2024.12.2 화요일</span>
                        <div class="details">
                           <p>회사 중요 스케줄 입니다. 10:30 ~ 11:30 내가 할 일</p>
                        </div>
                     </div>
                      <div class="checkbox">
                        <input type="checkbox"> <c:if test="${day.checked}"></c:if>
                            <span class="date" 2024.12.3 수요일</span>
                            <div class="details">
                            <p>회사 중요 스케줄 입니다. 10:30 ~ 11:30 내가 할 일</p>
                        </div>
                        </div>
                       <div class="checkbox">
                          <input type="checkbox"> <c:if test="${day.checked}"></c:if>
                              <span class="date" 2024.12.4 목요일</span>
                              <div class="details">
                             <p>회사 중요 스케줄 입니다. 10:30 ~ 11:30 내가 할 일</p>
                          </div>
                      </div>
                        <div class="checkbox">
                        <input type="checkbox"> <c:if test="${day.checked}"></c:if>
                            <span class="date" 2024.12.5 금요일</span>
                            <div class="details">
                           <p>회사 중요 스케줄 입니다. 10:30 ~ 11:30 내가 할 일</p>
                        </div>
                        </div>
                          <div class="checkbox">
                          <input type="checkbox"> <c:if test="${day.checked}"></c:if>
                              <span class="date" 2024.12.6 토요일</span>
                              <div class="details">
                             <p>회사 중요 스케줄 입니다. 10:30 ~ 11:30 내가 할 일</p>
                          </div>
                      </div>
                        <div class="checkbox">
                        <input type="checkbox"> <c:if test="${day.checked}"></c:if>
                            <span class="date" 2024.12.7 일요일</span>
                            <div class="details">
                           <p>회사 중요 스케줄 입니다. 10:30 ~ 11:30 내가 할 일</p>
                        </div>
                    </div>
                        <div class="checkbox">
                            <input type="checkbox"> <c:if test="${day.checked}"></c:if>
                                <span class="date" 2024.12.8 월요일</span>
                                <div class="details">
                               <p>회사 중요 스케줄 입니다. 10:30 ~ 11:30 내가 할 일</p>
                            </div>
                        </div>
                            <div class="checkbox">
                                <input type="checkbox"> <c:if test="${day.checked}"></c:if>
                                    <span class="date" 2024.12.9 화요일</span>
                                    <div class="details">
                                   <p>회사 중요 스케줄 입니다. 10:30 ~ 11:30 내가 할 일</p>
                                </div>
                            </div>
                                <div class="checkbox">
                                <input type="checkbox"> <c:if test="${day.checked}"></c:if>
                                    <span class="date" 2024.12.10 수요일</span>
                                    <div class="details">
                                   <p>회사 중요 스케줄 입니다. 10:30 ~ 11:30 내가 할 일</p>
                                </div>
                            </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/js/calendarcontent/schdule.js"></script>
        </body>
        </html>
