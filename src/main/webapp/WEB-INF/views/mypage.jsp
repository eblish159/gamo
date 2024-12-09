<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>내 정보 페이지</title>
  <link rel="stylesheet" href="/css/mypage.css">
</head>
<body>
<div class="mypage">
  <div class="container">
    <!-- 프로필 섹션 -->
    <div class="profile-section">
      <img src="img/level6.jpg" alt="Profile Image" class="profile-image">
      <div class="profile-title">내 정보</div>
    </div>

    <!-- 프로젝트 섹션 -->
    <div class="projects-section">
      <div class="section-title">프로젝트</div>
    </thead>
      <div class="project-box">
        <div class="project-row ongoing">
          <span class="project-name">프로젝트명</span>
          <span class="project-date">2024.12.01 ~ 2024.12.12</span>
          <span class="project-status">진행중</span>
        </div>
        <div class="project-row ongoing">
          <span class="project-name">프로젝트명</span>
          <span class="project-date">2024.12.01 ~ 2024.12.12</span>
          <span class="project-status">진행중</span>
        </div>
        <div class="project-row completed">
          <span class="project-name">프로젝트명</span>
          <span class="project-date">2024.12.01 ~ 2024.12.12</span>
          <span class="project-status">완료된 프로젝트</span>
        </div>
        <div class="project-row completed">
          <span class="project-name">프로젝트명</span>
          <span class="project-date">2024.12.01 ~ 2024.12.12</span>
          <span class="project-status">완료된 프로젝트</span>
        </div>
        <div class="pagination">1 <span>2</span> 3</div>
      </div>
    </div>

    <!-- 작성한 글 리스트 -->
    <div class="posts-section">
      <div class="section-title">내가쓴 글</div>
      <table class="posts-table">
        <thead>
          <tr>
            <th>날짜</th>
            <th>제목</th>
            <th>조회수</th>
            <th>댓글</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>24.11.22</td>
            <td>자바가 너무 어려움...</td>
            <td>23</td>
            <td>1</td>
          </tr>
          <tr>
            <td>24.10.28</td>
            <td>'정갈디리 휴가를 내다'</td>
            <td>192</td>
            <td>9</td>
          </tr>
          <tr>
            <td>24.09.15</td>
            <td>어느덧 입사한지 한...</td>
            <td>168</td>
            <td>2</td>
          </tr>
          <tr>
            <td>24.08.15</td>
            <td>안녕하세요! 신입사...</td>
            <td>82</td>
            <td>10</td>
          </tr>
        </tbody>
      </table>
      <div class="pagination">1 <span>2</span> 3</div>
    </div>
  </div>
  </div>
</body>
</html>