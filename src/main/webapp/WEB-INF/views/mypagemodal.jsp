<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>외계알 모달</title>
<link rel="stylesheet" href="mypagemodal.css">
</head>
<body>
<div class="container">
<!-- 모달 버튼 -->
<button id="openModal" class="open-modal-btn">정보 수정</button>

<!-- 모달 -->
<div id="infoModal" class="modal">
    <div class="modal-content">
    <span class="close-btn">&times;</span>
    <div class="modal-header">
        <h2>외계알 Lv 1 (환생 2번)</h2>
    </div>
    <div class="modal-body">
        <div class="info-item">
        <label>아이디</label>
        <input type="text" value="wood@daum.net" disabled>
        </div>
        <div class="info-item">
        <label>비밀번호:</label>
        <input type="password" value="********" disabled>
        </div>
        <div class="info-item">
        <label>이름:</label>
        <input type="text" value="고길동" disabled>
        </div>
        <div class="info-item">
        <label>전화번호:</label>
        <input type="text" value="010-1111-1111" disabled>
        </div>
        <div class="radio-group">
        <label>로그인게임:</label>
        <label><input type="radio" name="gameStatus" checked> On</label>
        <label><input type="radio" name="gameStatus"> Off</label>
        </div>
    </div>
    <div class="modal-footer">
        <button class="edit-btn">수정</button>
        <button class="cancel-btn">취소</button>
        <button class="save-btn">저장</button>
    </div>
    </div>
</div>
</div>
<script src="<c:url value='/js/mypage/mypagemodal.js'/>"></script>
</body>
</html>