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
            <option value="/test2">가위바위보</option>
            <option value="#">슬롯머신</option>
        </select>
        <div class="rps_form">
            <p class="rps_title">가위바위보</p>
            <div class="rps_content">
                <div class="rps_btns">
                    <button type="button" class="rps_button" value="1">
                        가위
                    </button>
                    <button type="button" class="rps_button" value="2">
                        바위
                    </button>
                    <button type="button" class="rps_button" value="3">
                        보
                    </button>
                </div>
            </div>
            <div class="rps_info">
                <p class="rps_dec"></p>
            </div>
            <div class="rps_start">
                <button class="rps_run" onclick="start()">시작</button>
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/js/rest/rest_game_1.js"></script>
    </body>
</html>