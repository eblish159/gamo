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
        <h1>게시글 작성</h1>
    </div>
    <form action="/board/save" method="post" enctype="multipart/form-data" class="write-form">
        <div class="form-group">
            <label for="title" class="form-label">제목</label>
            <input type="text" id="title" name="title" class="form-input" placeholder="제목을 입력하세요" required>
        </div>

        <div class="form-group">
            <label for="content" class="form-label">내용</label>
            <textarea id="content" name="content" class="form-textarea" placeholder="내용을 입력하세요" required></textarea>
        </div>

        <div class="form-group">
            <label for="file" class="form-labels">파일 첨부</label>
            <input type="file" id="file" name="files" class="form-file" accept="image/*,video/*" multiple>
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
