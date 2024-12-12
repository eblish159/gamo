<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="<c:url value='/css/admem/admem.css'/>">
</head>
<body>
<div class="board-container">

    <div class="board-header">
        <h1>회원 리스트</h1>
        <div style="display: flex; align-items: center;">
            <div class="search-container">

                <input type="text" class="search-input" placeholder="검색어 입력" />

                <select class="search-select">
                    <option value="title">아이디</option>
                    <option value="author">이름</option>
                    <option value="date">가입일</option>
                    <option value="number">번호</option>
                </select>

                <button class="btn-search">검색</button>
            </div>
        <button class="btn-new-post" onclick="openAddMemberModal()">회원추가</button>
        </div>
    </div>

    <table class="board-table">

        <thead>
        <tr>
            <th><input type="checkbox" id="select-all" /></th>
            <th class="col-no">번호</th>
            <th class="col-title">아이디</th>
            <th class="col-author">이름</th>
            <th class="col-date">가입일</th>
        </tr>
        </thead>

        <tbody>

        <tr>
            <td><input type="checkbox" class="row-checkbox" /></td>
            <td>1</td>
            <td><a href="/board/view?id=1">wlsqo09</a></td>
            <td>문진배</td>
            <td>2024-12-08</td>
        </tr>

        <tr>
            <td><input type="checkbox" class="row-checkbox" /></td>
            <td>2</td>
            <td><a href="/board/view?id=2">idealtype123</a></td>
            <td>이상형</td>
            <td>2024-12-07</td>
        </tr>
        <!-- 추가적인 글 데이터 -->
        </tbody>
    </table>

    <div class="board-pagination">
        <a href="#" class="page-link">이전</a>
        <a href="#" class="page-link active">1</a>
        <a href="#" class="page-link">2</a>
        <a href="#" class="page-link">3</a>
        <a href="#" class="page-link">다음</a>
    </div>

     <!-- 회원 추가 모달 -->
    <div id="add-member-modal" class="modal">
        <div class="modal-content">
            <span class="close-btn">&times;</span>
            <h2>회원 추가</h2>
            <form id="add-member-form">
                <label for="member-id">아이디</label>
                <input type="text" id="member-id" placeholder="아이디를 입력하세요" />

                <label for="member-password">패스워드</label>
                <input type="password" id="member-password" placeholder="패스워드를 입력하세요" />

                <label for="member-name">이름</label>
                <input type="text" id="member-name" placeholder="이름을 입력하세요" />

                <label for="member-phone">핸드폰번호</label>
                <input type="text" id="member-phone" placeholder="핸드폰번호를 입력하세요" />

                <label for="member-date">입사일</label>
                <input type="date" id="member-date" />

                <label for="member-game">게임</label>
                <select id="member-game">
                    <option value="on">ON</option>
                    <option value="off">OFF</option>
                </select>

                <button type="button" class="btn-add-member">추가</button>
            </form>
        </div>
    </div>

</div>

<script src="<c:url value='/js/admem/admem.js'/>"></script>

</body>
</html>