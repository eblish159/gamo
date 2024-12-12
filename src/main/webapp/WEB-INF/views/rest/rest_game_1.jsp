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
        <select class="sel" onchange="location.href = this.value">
            <option>게임선택</option>
            <option value="/rest1">업다운게임</option>
            <option value="/rest2">가위바위보</option>
            <option value="Slot">슬롯머신</option>
        </select>
        <div class="updown_form">
            <p class="updown_title">업다운</p>
            <div class="updown_content">
                <div class="info_div">
                    <p class="updown_info">범위는 1~10입니다.</p>
                </div>
                <input class="updown_input" type="text" maxlength="2" />
                <button type="button" class="updown_button" onclick="">
                    확인
                </button>
            </div>
            <div class="start_updown">
                <button
                    type="button"
                    class="updown_run"
                    onclick="updown_toggle()"
                >
                    시작
                </button>
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/js/rest/rest_game_1.js"></script>
    </body>
</html>