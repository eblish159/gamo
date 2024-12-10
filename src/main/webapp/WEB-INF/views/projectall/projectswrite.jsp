<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>게시글 작성</title>
    <link rel="stylesheet" href="<c:url value='/css/project/projectswrite.css'/>">
</head>
<body>
<div class="projects-container">
    <div class="write-header">
        <h1>프로젝트 작성</h1>
    </div>
    <form action="/projects/save" method="post" enctype="multipart/form-data" class="write-form">
        <div class="form-group">
            <label for="title" class="form-label">제목</label>
            <input type="text" id="title" name="title" class="form-input" placeholder="제목을 입력하세요" required>
        </div>



        <div class="form-group">
            <label for="content" class="form-label">내용</label>
            <textarea id="content" name="content" class="form-textarea" placeholder="내용을 입력하세요" required></textarea>
        </div>



        <div class="button-group">
            <button type="submit" class="btn-submit" onclick="location.href='/project'">완료</button>
            <button type="button" class="btn-cancel" onclick="history.back()">취소</button>
        </div>
    </form>
</div>
</body>
</html>
