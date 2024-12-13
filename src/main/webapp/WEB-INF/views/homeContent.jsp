<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>

    <div class="small-calendar-container">
        <div>
            <input type="month" class="small-calendar-header" id="small-calendar-date">
        </div>
        <div class="small-calendar-grid">
            <!-- Days of the week -->
            <div class="small-day-name">일</div>
            <div class="small-day-name">월</div>
            <div class="small-day-name">화</div>
            <div class="small-day-name">수</div>
            <div class="small-day-name">목</div>
            <div class="small-day-name">금</div>
            <div class="small-day-name">토</div>

            <!-- Calendar days -->
            <div class="small-empty"></div> <!-- For empty cells -->
            <div class="small-empty"></div>
            <div class="small-day">1</div>
            <div class="small-day">2</div>
            <div class="small-day">3</div>
            <div class="small-day">4</div>
            <div class="small-day">5</div>
            <div class="small-day">6</div>
            <div class="small-day">7</div>
            <div class="small-day">8</div>
            <div class="small-day">9</div>
            <div class="small-day">10</div>
            <div class="small-day">11</div>
            <div class="small-day">12</div>
            <div class="small-day">13</div>
            <div class="small-day">14</div>
            <div class="small-day">15</div>
            <div class="small-day">16</div>
            <div class="small-day">17</div>
            <div class="small-day">18</div>
            <div class="small-day">19</div>
            <div class="small-day">20</div>
            <div class="small-day">21</div>
            <div class="small-day">22</div>
            <div class="small-day">23</div>
            <div class="small-day">24</div>
            <div class="small-day">25</div>
            <div class="small-day">26</div>
            <div class="small-day">27</div>
            <div class="small-day">28</div>
            <div class="small-day">29</div>
            <div class="small-day">30</div>
            <div class="small-day">31</div>
        </div>
    </div>


    <!-- 랭킹 창 -->
    <div class="ranking-container">
            <div class="ranking-header">
                <h2>랭킹</h2>
            </div>
            <div class="ranking-list">
                <!-- 상위 5위 -->
                <div class="ranking-item">
                    <span class="rank">1</span>
                    <img src="img/lv5.png" alt="레벨 이미지" class="rank-image">
                    <span class="rank-name">문진배</span>
                    <span class="rank-level">LV - 50</span>
                </div>
                <div class="ranking-item">
                    <span class="rank">2</span>
                    <img src="img/lv5.png" alt="레벨 이미지" class="rank-image">
                    <span class="rank-name">설병진</span>
                    <span class="rank-level">LV - 49</span>
                </div>
                <div class="ranking-item">
                    <span class="rank">3</span>
                    <img src="img/lv5.png" alt="레벨 이미지" class="rank-image">
                    <span class="rank-name">조용준</span>
                    <span class="rank-level">LV - 41</span>
                </div>
                <div class="ranking-item">
                    <span class="rank">4</span>
                    <img src="img/lv4.png" alt="레벨 이미지" class="rank-image">
                    <span class="rank-name">이상형</span>
                    <span class="rank-level">LV - 39</span>
                </div>
                <div class="ranking-item">
                    <span class="rank">5</span>
                    <img src="img/lv3.png" alt="레벨 이미지" class="rank-image">
                    <span class="rank-name">홍길동</span>
                    <span class="rank-level">LV - 28</span>
                </div>
            </div>
            <div class="my-ranking">
                <h3>나의 순위</h3>
                <div class="ranking-item">
                    <span class="rank">1</span>
                    <img src="img/lv5.png" alt="레벨 이미지" class="rank-image">
                    <span class="rank-name">문진배</span>
                    <span class="rank-level">LV - 50</span>
                </div>
            </div>
        </div>

        <!-- 공지사항 섹션 -->
            <div class="notice-container">
                <h3 class="notice-header">공지사항</h3>
                <ul class="notice-list">
                    <li class="notice-item">[2024-12-13] 새로운 업데이트가 적용되었습니다.</li>
                    <li class="notice-item">[2024-12-12] 서버 점검 안내: 12월 15일 오전 2시</li>
                    <li class="notice-item">[2024-12-10] 회원가입 이벤트 종료 안내</li>
                    <li class="notice-item">[2024-12-08] 게시판 기능 개선 소식</li>
                    <li class="notice-item">[2024-12-05] 레벨 시스템 변경 사항 안내</li>
                    <li class="notice-item">[2024-12-01] 캘린더 기능 업데이트</li>
                </ul>
            </div>
</div>
