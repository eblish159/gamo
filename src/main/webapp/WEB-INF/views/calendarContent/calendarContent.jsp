<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/calendarcontent/calendarContent.css">
    <link rel="stylesheet" href="/css/calendarcontent/schedule.css">
    <title>캘린더</title>
</head>
<body>
<div class="todos">
    <div>
        <h1>스케줄</h1>
    </div>
    <table>
        <thead class="back">
            <tr>
                <th>일</th>
                <th>월</th>
                <th>화</th>
                <th>수</th>
                <th>목</th>
                <th>금</th>
                <th>토</th>
            </tr>
        </thead>
        <tbody>
            <tr>
               <td class="day" data-day="1">1 <br> 프로젝트 화면 구현</td>
               <td class="day" data-day="2">2 <br> 코드 리뷰</td>
               <td class="day" data-day="3">3 <br> 팀 미팅</td>
               <td class="day" data-day="4">4 <br> 기능 테스트</td>
               <td class="day" data-day="5">5 <br> 문서 작성</td>
               <td class="day" data-day="6">6 <br> 주말 자유 시간</td>
               <td class="day" data-day="7">7 <br> 휴일</td>
            </tr>
            <tr>
               <td class="day" data-day="8">8 <br> 프로젝트 계획 세우기</td>
               <td class="day" data-day="9">9 <br> 회의 준비</td>
               <td class="day" data-day="10">10 <br> 프레젠테이션 준비</td>
               <td class="day" data-day="11">11 <br> 코드 디버깅</td>
               <td class="day" data-day="12">12 <br> 주간 리뷰</td>
               <td class="day" data-day="13">13 <br> 미팅 없음</td>
               <td class="day" data-day="14">14 <br> 프로젝트 마감</td>
            </tr>
            <tr>
               <td class="day" data-day="15">15 <br> 프로젝트보고</td>
               <td class="day" data-day="16">16 <br> 스프린트 회고</td>
               <td class="day" data-day="17">17 <br> 프로젝트 피드백</td>
               <td class="day" data-day="18">18 <br> 신규 요구사항 분석</td>
               <td class="day" data-day="19">19 <br> 디자인 수정</td>
               <td class="day" data-day="20">20 <br> 코드 최적화</td>
               <td class="day" data-day="21">21 <br> 주간 미팅</td>
            </tr>
            <tr>
               <td class="day" data-day="22">22 <br> 테스트 환경 준비</td>
               <td class="day" data-day="23">23 <br> 기능 통합 테스트</td>
               <td class="day" data-day="24">24 <br> 최종 리뷰</td>
               <td class="day" data-day="25">25 <br> 배포 준비</td>
               <td class="day" data-day="26">26 <br> 프로젝트 피드백</td>
               <td class="day" data-day="27">27 <br> 최종 점검</td>
               <td class="day" data-day="28">28 <br> 마감 회의</td>
            </tr>
            <tr>
               <td class="day" data-day="29">29 <br> 프로젝트 발표 준비</td>
               <td class="day" data-day="30">30 <br> 프로젝트 발표</td>
               <td class="day" data-day="31">31 <br> 휴일</td>
               <td></td>
               <td></td>
               <td></td>
               <td></td>
            </tr>
        </tbody>
    </table>
    <div class="search-container">
        <input class="date" type="date" id="date" max="2070-12" min="2024-10" value="2024-10">
        <a href="/todomodal" class="todo">할 일 추가</a>
    </div>

    <ul class="pagination">
        <li><a href="#">&lt;&lt;</a></li>
        <li><a href="#">&lt;</a></li>
        <li><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li><a href="#">&gt;</a></li>
        <li><a href="#">&gt;&gt;</a></li>
    </ul>
</div>

<div class="schedule-modal">
    <div class="modal-header">
        <h2>상세내용</h2>
        <!-- 모달 닫기 버튼 -->
        <button class="close-btn" onclick="closeModal()">X</button>
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
                    <input type="checkbox" <c:if test="${day.checked}"</c:if>>
                     <span class="date">2024.12.1 월요일</span>
                    <div class="details">
                        <p>회사 중요 스케줄 입니다. 10:30 ~ 11:30 내가 할 일</p>
                    </div>
                </div>
                 <div class="checkbox">
                    <input type="checkbox" <c:if test="${day.checked}"></c:if>>
                     <span class="date">2024.12.2 화요일</span>
                    <div class="details">
                       <p>회사 중요 스케줄 입니다. 10:30 ~ 11:30 내가 할 일</p>
                    </div>
                 </div>
                  <div class="checkbox">
                    <input type="checkbox" <c:if test="${day.checked}"></c:if>>
                        <span class="date">2024.12.3 수요일</span>
                        <div class="details">
                        <p>회사 중요 스케줄 입니다. 10:30 ~ 11:30 내가 할 일</p>
                    </div>
                    </div>
                   <div class="checkbox">
                      <input type="checkbox" <c:if test="${day.checked}"></c:if>>
                          <span class="date">2024.12.4 목요일</span>
                          <div class="details">
                         <p>회사 중요 스케줄 입니다. 10:30 ~ 11:30 내가 할 일</p>
                      </div>
                  </div>
                    <div class="checkbox">
                    <input type="checkbox" <c:if test="${day.checked}"></c:if>>
                        <span class="date">2024.12.5 금요일</span>
                        <div class="details">
                       <p>회사 중요 스케줄 입니다. 10:30 ~ 11:30 내가 할 일</p>
                    </div>
                    </div>
                      <div class="checkbox">
                      <input type="checkbox" <c:if test="${day.checked}"></c:if>>
                          <span class="date">2024.12.6 토요일</span>
                          <div class="details">
                         <p>회사 중요 스케줄 입니다. 10:30 ~ 11:30 내가 할 일</p>
                      </div>
                  </div>
                    <div class="checkbox">
                    <input type="checkbox" <c:if test="${day.checked}"></c:if>>
                        <span class="date">2024.12.7 일요일</span>
                        <div class="details">
                       <p>회사 중요 스케줄 입니다. 10:30 ~ 11:30 내가 할 일</p>
                    </div>
                </div>
                    <div class="checkbox">
                        <input type="checkbox" <c:if test="${day.checked}"></c:if>>
                            <span class="date">2024.12.8 월요일</span>
                            <div class="details">
                           <p>회사 중요 스케줄 입니다. 10:30 ~ 11:30 내가 할 일</p>
                        </div>
                    </div>
                        <div class="checkbox">
                            <input type="checkbox" <c:if test="${day.checked}"></c:if>>
                                <span class="date">2024.12.9 화요일</span>
                                <div class="details">
                               <p>회사 중요 스케줄 입니다. 10:30 ~ 11:30 내가 할 일</p>
                            </div>
                        </div>
                            <div class="checkbox">
                            <input type="checkbox" <c:if test="${day.checked}"></c:if>>
                                <span class="date">2024.12.10 수요일</span>
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