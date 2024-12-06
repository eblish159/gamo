<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="../../resources/css/login.css" />
	</head>
	<body>
        <form class="login_form">
            <p class="login_title">GAMO</p>
            <input type="text" placeholder="아이디" />
            <input type="password" placeholder="비밀번호" />
            <button type="button" onclick="not_yet()">확인</button>
        </form>
        <script type="text/javascript">
        	function not_yet() {
				alert("아직이요~");
			}
        </script>
	</body>
</html>