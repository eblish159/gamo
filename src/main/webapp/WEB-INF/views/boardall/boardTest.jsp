<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>글 목록 조회</title>
</head>
<body>
<table border="1"  align="center"  width="80%">
    <tr align="center" bgcolor="coral">
      <td><b>제목</b></td>
      <td><b>내용</b></td>
      <td><b>작성자</b></td>
      <td><b>작성일</b></td>
   </tr>
<c:if test="${empty boardList or boardList == null}">
    <tr>
        <td colspan="5" align="center">게시글이 없습니다.</td>
    </tr>
</c:if>
<c:forEach var="board" items="${boardList}" >
    <tr align="center">
        <td>${board.board_title}</td>
        <td>${board.board_content}</td>
        <td>${board.member_id}</td>
        <td>${board.created_date}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
