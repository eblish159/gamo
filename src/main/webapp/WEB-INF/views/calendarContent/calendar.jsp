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
            <div class="day">1<div class="event red"></div></div>
            <div class="day">2</div>
            <div class="day">3</div>
            <div class="day">4<div class="event red"></div></div>
            <div class="day">5</div>
            <div class="day">6</div>
            <div class="day">7<div class="event red"></div></div>

            <div class="day">8<div></div>
            <div class="event green"></div></div>

            <div class="day">9<div class="event green"></div></div>
            <div class="day">10</div>
            <div class="day">11<div></div></div>
            <div id="day-2024-12-12" class="day">12</div>
            <div id="day-2024-12-13" class="day">13</div>
            <div id="day-2024-12-14" class="day">14</div>
            <div class="day">15<div class="event green"></div></div>
            <div class="day">16</div>
            <div class="day">17</div>
            <div class="day">18<div></div></div>
            <div class="day">19</div>
            <div class="day">20</div>
            <div class="day">21</div>
            <div class="day">22</div>
            <div class="day">23<div></div></div>
            <div class="day">24<div class="event yellow"></div></div>
            <div class="day">25<div></div></div>
            <div class="day">26</div>
            <div class="day">27</div>
            <div class="day">28<div class="event yellow"></div></div>
            <div class="day">29<div class="event green"></div></div>
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
                <button class="action-btn add-btn" id="addTodoButton" onclick="updateTodo()">추가</button>
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
                    <div class="schdule-calendar-container">
                           <div class="calendar-scroll">
                               <!-- 1일부터 31일까지 날짜 반복 -->
                               <div class="schdule-calendar-item" id="day-1">
                                   <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                                   <span class="date">2024.12.1</span>
                                   <div class="task-details">회사 중요 스케줄 입니다.</div>
                               </div>
                               <div class="schdule-calendar-item" id="day-2">
                                   <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                                   <span class="date">2024.12.2</span>
                                   <div class="task-details">회사 중요 스케줄 입니다.</div>
                               </div>
                               <div class="schdule-calendar-item" id="day-3">
                                   <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                                   <span class="date">2024.12.3</span>
                                   <div class="task-details">회사 중요 스케줄 입니다.</div>
                               </div>
                               <div class="schdule-calendar-item" id="day-4">
                                   <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                                   <span class="date">2024.12.4</span>
                                   <div class="task-details">회사 중요 스케줄 입니다.</div>
                               </div>
                               <div class="schdule-calendar-item" id="day-5">
                                   <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                                   <span class="date">2024.12.5</span>
                                   <div class="task-details">회사 중요 스케줄 입니다.</div>
                               </div>
                               <div class="schdule-calendar-item" id="day-6">
                                   <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                                   <span class="date">2024.12.6</span>
                                   <div class="task-details">회사 중요 스케줄 입니다.</div>
                               </div>
                               <div class="schdule-calendar-item" id="day-7">
                                   <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                                   <span class="date">2024.12.7</span>
                                   <div class="task-details">회사 중요 스케줄 입니다.</div>
                               </div>
                               <div class="schdule-calendar-item" id="day-8">
                                   <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                                   <span class="date">2024.12.8</span>
                                   <div class="task-details">회사 중요 스케줄 입니다.</div>
                               </div>
                               <div class="schdule-calendar-item" id="day-9">
                                   <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                                   <span class="date">2024.12.9</span>
                                   <div class="task-details">회사 중요 스케줄 입니다.</div>
                               </div>
                               <div class="schdule-calendar-item" id="day-10">
                                   <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                                   <span class="date">2024.12.10</span>
                                   <div class="task-details">회사 중요 스케줄 입니다.</div>
                               </div>
                               <div class="schdule-calendar-item" id="day-11">
                                   <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                                   <span class="date">2024.12.11</span>
                                   <div class="task-details">회사 중요 스케줄 입니다.</div>
                               </div>
                                <div class="schdule-calendar-item" id="day-12">
                                   <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                                   <span class="date">2024.12.12</span>
                                   <div class="task-details">회사 중요 스케줄 입니다.</div>
                               </div>
                                <div class="schdule-calendar-item" id="day-13">
                                  <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                                  <span class="date">2024.12.13</span>
                                  <div class="task-details">회사 중요 스케줄 입니다.</div>
                              </div>
                               <div class="schdule-calendar-item" id="day-14">
                                 <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                                 <span class="date">2024.12.14</span>
                                 <div class="task-details">회사 중요 스케줄 입니다.</div>
                             </div>
                              <div class="schdule-calendar-item" id="day-15">
                                    <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                                    <span class="date">2024.12.15</span>
                                    <div class="task-details">회사 중요 스케줄 입니다.</div>
                                </div>
                                 <div class="schdule-calendar-item" id="day-16">
                                   <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                                   <span class="date">2024.12.16</span>
                                   <div class="task-details">회사 중요 스케줄 입니다.</div>
                               </div>
                                <div class="schdule-calendar-item" id="day-17">
                                  <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                                  <span class="date">2024.12.17</span>
                                  <div class="task-details">회사 중요 스케줄 입니다.</div>
                              </div>
                               <div class="schdule-calendar-item" id="day-18">
                                 <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                                 <span class="date">2024.12.18</span>
                                 <div class="task-details">회사 중요 스케줄 입니다.</div>
                             </div>
                            <div class="schdule-calendar-item" id="day-19">
                                <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                                <span class="date">2024.12.19</span>
                                <div class="task-details">회사 중요 스케줄 입니다.</div>
                            </div>
                              <div class="schdule-calendar-item" id="day-20">
                                 <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                                 <span class="date">2024.12.20</span>
                                 <div class="task-details">회사 중요 스케줄 입니다.</div>
                             </div>
                               <div class="schdule-calendar-item" id="day-21">
                           <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                           <span class="date">2024.12.21</span>
                           <div class="task-details">회사 중요 스케줄 입니다.</div>
                       </div>
                         <div class="schdule-calendar-item" id="day-22">
                            <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                            <span class="date">2024.12.22</span>
                            <div class="task-details">회사 중요 스케줄 입니다.</div>
                        </div>
                          <div class="schdule-calendar-item" id="day-23">
                         <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                             <span class="date">2024.12.23</span>
                             <div class="task-details">회사 중요 스케줄 입니다.</div>
                         </div>
                           <div class="schdule-calendar-item" id="day-24">
                          <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                              <span class="date">2024.12.24</span>
                              <div class="task-details">회사 중요 스케줄 입니다.</div>
                          </div>  <div class="schdule-calendar-item" id="day-25">
                             <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                             <span class="date">2024.12.25</span>
                             <div class="task-details">회사 중요 스케줄 입니다.</div>
                             </div>
                               <div class="schdule-calendar-item" id="day-26">
                          <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                          <span class="date">2024.12.26</span>
                              <div class="task-details">회사 중요 스케줄 입니다.</div>
                          </div>
                            <div class="schdule-calendar-item" id="day-27">
                               <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                               <span class="date">2024.12.27</span>
                               <div class="task-details">회사 중요 스케줄 입니다.</div>
                           </div>  <div class="schdule-calendar-item" id="day-28">
                            <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                            <span class="date">2024.12.28</span>
                            <div class="task-details">회사 중요 스케줄 입니다.</div>
                            </div>  <div class="schdule-calendar-item" id="day-29">
                            <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                            <span class="date">2024.12.29</span>
                            <div class="task-details">회사 중요 스케줄 입니다.</div>
                            </div>  <div class="schdule-calendar-item" id="day-30">
                            <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                            <span class="date">2024.12.30</span>
                            <div class="task-details">회사 중요 스케줄 입니다.</div>
                            </div>
                            <div class="schdule-calendar-item" id="day-31">
                            <input type="checkbox" class="task-checkbox" onchange="updateProgress()">
                            <span class="date">2024.12.31</span>
                            <div class="task-details">회사 중요 스케줄 입니다.</div>
                            </div>
                       <!-- 더 많은 날짜 반복 -->
                   </div>
                   <div class="progress-container">
                       <h3>진행률</h3>
                       <div class="progress-bar">
                           <div class="progress-fill" id="progress-fill"></div>
                       </div>
                       <p id="progress-text">0% 완료</p>
                           </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/js/calendarcontent/schdule.js"></script>
        </body>
        </html>
