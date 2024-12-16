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
    <c:if test='${board != null}'>
        <form action="${pageContext.request.contextPath}/board/update/${board.board_no}" method="post" class="write-form">
        <input type="hidden" name="board_no" value="${board.board_no}">
    </c:if>
    <c:if test='${board == null}'>
        <form action="${pageContext.request.contextPath}/board/boardWrite" method="post" enctype="multipart/form-data" class="write-form">
    </c:if>
        <div class="form-group">
            <c:if test='${board != null}'>
                <label for="title" class="form-label">수정할 제목</label>
            </c:if>
            <c:if test='${board == null}'>
                <label for="title" class="form-label">제목</label>
            </c:if>
            <input type="text"
                   id="title"
                   name="board_title"
                   class="form-input"
                   maxlength="50"
                   value="${board != null ? board.board_title : ''}"
                   placeholder="제목을 입력하세요" required>
        </div>

        <div class="form-group">
            <c:if test='${board != null}'>
                <label for="content" class="form-label">수정할 내용</label>
            </c:if>
            <c:if test='${board == null}'>
                <label for="content" class="form-label">내용</label>
            </c:if>
            <textarea id="content"
                      name="board_content"
                      class="form-textarea"
                      maxlength="600"
                      placeholder="내용을 입력하세요" required>${board != null ? board.board_content : ''}</textarea>
        </div>

        <div class="button-group">
            <c:choose>
                <c:when test="${board != null}">
                    <button type="submit" class="btn-submit">수정</button>
                </c:when>
                <c:otherwise>
                    <button type="submit" class="btn-submit">작성</button>
                </c:otherwise>
            </c:choose>
            <button type="button" class="btn-cancel" onclick="history.back()">취소</button>
        </div>
    </form>
</div>
<script src="<c:url value='/js/board/boardMain.js' />"></script>
</body>
</html>