<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>로그인 게임 - 업다운</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/rest/rest_game_1.css">
    </head>
    <body>
        <select class="sel">
            <option value="updown">업다운게임</option>
            <option value="rps">가위바위보</option>
            <option value="Slot">슬롯머신</option>
        </select>
        <div class="updown_form">
            <p class="updown_title">업다운</p>
            <p class="updown_info">범위는 1~10입니다.</p>
            <input class="updown_input" type="text" maxlength="2" />
            <button type="button" class="updown_button" onclick="">확인</button>
        </div>
        <script src="${pageContext.request.contextPath}/js/rest/rest_game_1.js"></script>
    </body>
</html>
