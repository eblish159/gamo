<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판</title>
    <script src="https://kit.fontawesome.com/c39c442009.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/todomain.css">
</head>
<body>
    <script src="https://kit.fontawesome.com/1e52e7745d.js" crossorigin="anonymous"></script>
<div>
    <h1>스케줄</h1>
</div>

<table>
    <thead>
        <tr>
            <th>일</th>
            <th>월</th>
            <th>화</th>
            <th>수</th>
            <th>목</th>
            <th>금</th>
            <th>토</th>
        </tr>
    </thead>
    <tbody>
        <thead>
        <tr>
            <td>1</td>
            <th>2</th>
            <th>3</th>
            <th>4</th>
            <th>5</th>
            <th>6</th>
            <th>7</th>
        </tr>
        </thead>
        <tr>
            <td>8</td>
            <td>9</td>
            <td>10</td>
            <td>11</td>
            <td>12</td>
            <td>13</td>
            <td>14</td>
        </tr>
        <tr>
            <td>15</td>
            <td>16</td>
            <td>17</td>
            <td>18</td>
            <td>19</td>
            <td>20</td>
            <td>21</td>
        </tr>
        <tr>
            <td>22</td>
            <td>23</td>
            <td>24</td>
            <td>25</td>
            <td>26</td>
            <td>27</td>
            <td>28</td>
        </tr>
        <tr>
            <td>29</td>
            <td>30</td>
            <td>31</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    </tbody>
</table>
<div class="card">
    <img src="img/level30.png">
    <div class="level">LV - 30</div>
    <div>문진배</div>
    <div>exp</div>
    <div class="exp-bar">
        <div class="exp-fill"></div>
    </div>
</div>
<div class="search-container">
    <input class="date" type="date" id="date" max="2070-12" min="2024-10" value="2024-10">
    <button class="todo" type="submit">할 일 추가</button>
</div>

<ul class="pagination">
    <li><a href="#">&lt;&lt;</a></li>
    <li><a href="#">&lt;</a></li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li><a href="#">&gt;</a></li>
    <li><a href="#">&gt;&gt;</a></li>
</ul>
</body>
</html>