<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판</title>
    <link rel="stylesheet" href="<c:url value='/css/board/boardMain.css'/>">
</head>
<body>
<div class="board-container">

    <div class="board-header">
        <h1>게시판</h1>
        <div style="display: flex; align-items: center;">
            <div class="search-container">
                <input type="text" class="search-input" placeholder="검색어 입력" />
                <select class="search-select">
                    <option value="title">제목</option>
                    <option value="author">작성자</option>
                    <option value="date">날짜</option>
                    <option value="number">번호</option>
                </select>
                <button class="btn-search">검색</button>
            </div>
            <button class="btn-new-post" onclick="location.href='/boardWrite'">새 글 작성</button>
        </div>
    </div>

    <table class="board-table">
        <thead>
        <tr>
            <th><input type="checkbox" id="select-all" /></th>
            <th class="col-no">번호</th>
            <th class="col-title">제목</th>
            <th class="col-author">작성자</th>
            <th class="col-date">작성일</th>
        </tr>
        </thead>

        <tbody>
            <c:if test="${empty boardPage}">
                <tr>
                    <td colspan="5" align="center">게시글이 없습니다.</td>
                </tr>
            </c:if>
            <c:forEach var="board" items="${boardPage}">
                <tr>
                    <td><input type="checkbox" id="select-all" /></td>
                    <td>${board.board_no}</td>
                    <td>
                        <a href="/board/${board.board_no}">
                                ${board.board_title}
                        </a>
                    </td>
                    <td>${board.member_id}</td>
                    <td><fmt:formatDate value="${board.created_date}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div class="board-pagination">
        <c:if test="${totalPages > 1}">
            <div class="pagination">
                <c:if test="${currentPage > 1}">
                    <a class="page-link" href="/board?page=${currentPage - 1}">
                        이전
                    </a>
                </c:if>
                <c:if test="${currentPage == 1}">
                    <a class="page-link" href="/board?page=${currentPage}">
                        이전
                    </a>
                </c:if>

                <c:forEach var="i" begin="1" end="${totalPages}">
                    <a class="page-link ${currentPage == i ? 'active' : ''}" href="/board?page=${i}">${i}</a>
                </c:forEach>
                <c:if test="${currentPage < totalPages}">
                    <a class="page-link" href="/board?page=${currentPage + 1}">
                        다음
                    </a>
                </c:if>
                <c:if test="${currentPage == totalPages}">
                    <a class="page-link" href="/board?page=${totalPages}">
                        다음
                    </a>
                </c:if>
            </div>
        </c:if>
    </div>



</div>
<script src="<c:url value='/js/board/boardMain.js'/>"></script>

</body>
</html>
