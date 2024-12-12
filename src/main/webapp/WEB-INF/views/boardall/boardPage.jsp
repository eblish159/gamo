<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>게시물 상세</title>
    </head>
    <body>
        <h1>${board.board_title}</h1>
        <p>${board.board_content}</p>
        <p>작성자: ${board.member_id}</p>
        <c:if test="${isEditable}">
            <a href="/board/${board.board_no}/edit">수정</a>
            <form action="/board/${board.board_no}/delete" method="post" style="display:inline;">
                <button type="submit">삭제</button>
            </form>
        </c:if>
        <a href="/board">목록으로</a>
    </body>
</html>