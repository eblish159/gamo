<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
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

                <input type="text" class="search-input" placeholder="검색어 입력" name="searchKeyword" />

                <select class="search-select" name="searchCondition">
                    <option value="title">아이디</option>
                    <option value="author">이름</option>
                </select>

                <button type="button" class="btn-search" onclick="submit_search()">검색</button>
            </div>
        <button class="btn-new-post" onclick="openAddMemberModal()">직원추가</button>
        </div>
    </div>

    <table class="board-table">

        <thead>
        <tr>
            <th class="col-title">아이디</th>
            <th class="col-author">이름</th>
            <th class="col-phone">전화번호</th>
            <th class="col-date">가입일</th>
            <th class="col-del">퇴사처리</th>
        </tr>
        </thead>

        <tbody>
            <c:if test="${empty members}">
                <tr>
                    <td colspan="5" align="center">회원정보가 없습니다.</td>
                </tr>
            </c:if>
            <c:forEach var="member" items="${members}">
                <tr>
                    <td>${member.member_id}</td>
                    <td>${member.name}</td>
                    <td>${member.phone}</td>
                    <td>${member.created_date}</td>
                    <td>
                        <a href="${contextPath}/admin/delMember?id=${member.member_id}" onclick="return confirm('퇴사 처리하시겠습니까?')">퇴사승인</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

<%--    <div class="board-pagination">
        <a href="#" class="page-link">이전</a>
        <a href="#" class="page-link active">1</a>
        <a href="#" class="page-link">2</a>
        <a href="#" class="page-link">3</a>
        <a href="#" class="page-link">다음</a>
    </div>--%>
    <div class="board-pagination">
        <c:if test="${totalPages > 1}">
            <div class="pagination">
                <c:if test="${currentPage > 1}">
                    <a class="page-link" href="/admin?page=${currentPage - 1}">
                        이전
                    </a>
                </c:if>
                <c:if test="${currentPage == 1}">
                    <a class="page-link" href="/admin?page=${currentPage}">
                        이전
                    </a>
                </c:if>

                <c:forEach var="i" begin="1" end="${totalPages}">
                    <a class="page-link ${currentPage == i ? 'active' : ''}" href="/admin?page=${i}">${i}</a>
                </c:forEach>
                <c:if test="${currentPage < totalPages}">
                    <a class="page-link" href="/admin?page=${currentPage + 1}">
                        다음
                    </a>
                </c:if>
                <c:if test="${currentPage == totalPages}">
                    <a class="page-link" href="/admin?page=${totalPages}">
                        다음
                    </a>
                </c:if>
            </div>
        </c:if>
    </div>

     <!-- 회원 추가 모달 -->
    <div id="add-member-modal" class="modal">
        <div class="modal-content">
            <span class="close-btn">&times;</span>
            <h2>회원 추가</h2>
            <form id="add-member-form" action="/admin/addMember" method="post">
                <label for="member-id">아이디</label>
                <input type="text" id="member-id" name="member_id" placeholder="아이디를 입력하세요" />

                <label for="member-password">패스워드</label>
                <input type="password" id="member-password" name="member_pw" placeholder="패스워드를 입력하세요" />

                <label for="member-name">이름</label>
                <input type="text" id="member-name" name="name" placeholder="이름을 입력하세요" />

                <label for="member-phone">핸드폰번호</label>
                <input type="text" id="member-phone" name="phone" placeholder="핸드폰번호를 입력하세요" />

                <label for="member-date">입사일</label>
                <input type="date" id="member-date" name="created_date" />

                <label for="member-game">게임</label>
                <select id="member-game" name="gameonoff">
                    <option value="y">ON</option>
                    <option value="n">OFF</option>
                </select>

                <label for="member-role">권한</label>
                <select id="member-role" name="role">
                    <option value=1>사원</option>
                    <option value=0>임원</option>
                </select>

                <button type="submit" class="btn-add-member">추가</button>
            </form>
        </div>
    </div>
    <script src="<c:url value='/js/admem/admem.js'/>"></script>
</div>
</body>
</html>