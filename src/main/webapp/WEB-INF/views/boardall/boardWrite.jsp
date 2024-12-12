<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>게시글 작성</title>
    <link rel="stylesheet" href="<c:url value='/css/board/boardWrite.css'/>">
</head>
<body>
<div class="board-container">
    <div class="write-header">
        <h1>${board == null ? '새 글 작성' : '게시글 수정'}</h1>
    </div>
    <form action="${board == null ? '/board/create' : '/board/edit'}" method="post" enctype="multipart/form-data" class="write-form">
        <c:if test="${board != null}">
            <input type="hidden" name="member_id" value="${board.member_id}">
        </c:if>
        <div class="form-group">
            <label for="title" class="form-label">제목</label>
            <input type="text" id="title" name="board_title" class="form-input" placeholder="제목을 입력하세요" required>
        </div>

        <div class="form-group">
            <label for="content" class="form-label">내용</label>
            <textarea id="content" name="board_content" class="form-textarea" placeholder="내용을 입력하세요" required></textarea>
        </div>

        <div class="button-group">
            <button type="submit" class="btn-submit">완료</button>
            <button type="button" class="btn-cancel" onclick="history.back()">취소</button>
        </div>
    </form>
</div>
<script src="<c:url value='/js/board/boardMain.js' />"></script>
</body>
</html>
