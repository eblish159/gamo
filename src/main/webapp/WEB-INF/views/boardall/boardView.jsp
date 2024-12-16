<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <title>게시물 상세</title>
        <link rel="stylesheet" href="<c:url value='/css/board/boardView.css'/>">
    </head>
    <body>
        <p>작성자: ${board.member_id}</p>
        <div class="board-container">
            <div class="form-group">
                <label for="title" class="form-label">제목</label>
                <input type="text" id="title" class="form-input" value="${board.board_title}" readonly >
            </div>

            <div class="form-group">
                <label for="content" class="form-label">내용</label>
                <textarea id="content" class="form-textarea" readonly>${board.board_content}</textarea>
            </div>

            <div class="button-group">
                <c:if test="${isEditable}">
                    <a class="btn-submit" href="/board/update/${board.board_no}">수정</a>
                    <form action="<c:url value='/board/delete/${board.board_no}' />" method="post">
                        <button type="submit" class="btn-delete" onclick="return confirm('정말 삭제하시겠습니까?')">삭제</button>
                    </form>
                </c:if>
                <button type="button" class="btn-cancel" onclick="location.href='/board'">목록</button>
            </div>
        </div>
        <script src="<c:url value='/js/board/boardMain.js' />"></script>
    </body>
</html>