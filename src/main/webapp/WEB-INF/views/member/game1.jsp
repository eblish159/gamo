<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>가위바위보</title>
        <link rel="stylesheet" href="<c:url value='/css/login/game1.css'/>">
    </head>
    <body>
        <h1>컴퓨터와 가위바위보 대결!!</h1>
        <img class="view" />
        <div class="imgResult"></div>
        <span class="result"></span>
        <div class="select">
            <input
                    type="image"
                    class="btn"
                    src="<c:url value='/img/scissors.png'/>"
                    data-id="0"
                    width="120px"
                    height="120px"
            />
            <input
                    type="image"
                    class="btn"
                    src="<c:url value='/img/rock.png'/>"
                    data-id="1"
                    width="120px"
                    height="120px"
            />
            <input
                    type="image"
                    class="btn"
                    src="<c:url value='/img/paper.png'/>"
                    data-id="2"
                    width="120px"
                    height="120px"
            />
        </div>
        <div class="btn-cotainer">
            <button class="start">시작</button>
            <p class="game1_info"></p>
        </div>
        <script src="<c:url value='/js/login/game1.js'/>"></script>
    </body>
</html>