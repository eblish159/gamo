<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>리스트쇼</title>
	</head>
	<body>
		<table border="1"  align="center"  width="80%">
			<tr align="center"   bgcolor="lightgreen">
				<td ><b>아이디</b></td>
				<td><b>비밀번호</b></td>
			</tr>
   
			<c:forEach var="member" items="${membersList}" >     
			<tr align="center">
				<td>${member.id}</td>
				<td>${member.pwd}</td>
				<td>${member.name}</td>
				<td>${member.email}</td>
				<td>${member.joinDate}</td>
				<td><a href="${contextPath}/member/removeMember.do?id=${member.id }">삭제하기</a></td>
			</tr>
			</c:forEach>   
		</table>
	</body>
</html>