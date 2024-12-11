// 할일 목록 저장 기능
const saveTodoButton = document.getElementById('saveTodo');
saveTodoButton.addEventListener('click', function () {
    const description = document.getElementById('todoDescription').value;
    const user = document.getElementById('todoUser').value;
    const projectNo = 1; // 프로젝트 ID는 실제 데이터에 맞게 설정

    if (description && user) {
        fetch('/todo/save', {
            method: 'POST',
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
            body: `projectNo=${projectNo}&description=${encodeURIComponent(description)}&userName=${encodeURIComponent(user)}`
        })
        .then(response => response.text())
        .then(data => {
            if (data === 'SUCCESS') {
                alert('할일이 저장되었습니다!');
                loadTodoList(projectNo); // 저장 후 목록 새로고침
            } else {
                alert('저장 실패!');
            }
        })
        .catch(error => console.error('Error:', error));

        document.getElementById('todoDescription').value = ''; // 입력창 초기화
        document.getElementById('todoUser').value = ''; // 사용자명 초기화
        document.querySelector('.todo-input').style.display = 'none'; // 입력 폼 숨김
    } else {
        alert('할일 내용을 입력하세요.');
    }
});

// 할일 목록 불러오기
function loadTodoList(projectNo) {
    fetch(`/todo/list?projectNo=${projectNo}`)
        .then(response => response.json())
        .then(data => {
            const todoContainer = document.querySelector('.todoprojects');
            todoContainer.innerHTML = ''; // 기존 목록 제거

            data.forEach(todo => {
                const todoBox = document.createElement('div');
                todoBox.classList.add('todoproject-box');
                todoBox.innerHTML = `
                    <div class="todoproject-content">
                        <div class="todoproject-header">
                            <input type="checkbox" class="todo-checkbox">
                            <div class="name">${todo.memberId}</div>
                        </div>
                        <p class="todoproject-line">${todo.description}</p>
                        <p class="todoproject-line status">진행률: <span class="progress-status">${todo.progress}%</span></p>
                        <div class="progress-container">
                            <button class="progress-btn" data-progress="0">0%</button>
                            <button class="progress-btn" data-progress="25">25%</button>
                            <button class="progress-btn" data-progress="50">50%</button>
                            <button class="progress-btn" data-progress="75">75%</button>
                            <button class="progress-btn" data-progress="100">100%</button>
                        </div>
                    </div>
                `;
                todoContainer.appendChild(todoBox);
            });
        });
}

// 진행률 선택 기능
const todoProjects = document.querySelector('.todoprojects');
todoProjects.addEventListener('click', function (e) {
    if (e.target.classList.contains('progress-btn')) {
        const progressValue = e.target.getAttribute('data-progress');
        const progressStatus = e.target.closest('.todoproject-box').querySelector('.progress-status');
        progressStatus.textContent = `${progressValue}%`;

        updateTotalProgress(); // 진행률 업데이트 시 총 진행률 갱신
    }
});

// 할일 목록 삭제 기능
const removeTodoButton = document.querySelector('.remove-todo-btn');
removeTodoButton.addEventListener('click', function () {
    const checkedItems = document.querySelectorAll('.todoproject-box input[type="checkbox"]:checked');

    checkedItems.forEach(item => {
        const todoBox = item.closest('.todoproject-box');
        todoBox.remove();
    });

    updateTotalProgress(); // 할일 삭제 후 총 진행률 갱신
});

// 할일 목록 추가 기능
const addTodoButton = document.querySelector('.add-todo-btn');
addTodoButton.addEventListener('click', function () {
    const todoInput = document.querySelector('.todo-input');
    if (todoInput.style.display === 'none' || todoInput.style.display === '') {
        todoInput.style.display = 'flex';
    } else {
        todoInput.style.display = 'none';
    }
});

// 총 진행률 계산
function updateTotalProgress() {
    const progressStatuses = document.querySelectorAll('.progress-status');
    let totalProgress = 0;
    let totalItems = 0;
    let allCompleted = true;

    progressStatuses.forEach(function (progressStatus) {
        const progress = parseInt(progressStatus.textContent.replace('%', ''), 10);
        if (progress === 100) {
            totalProgress += 100;
        } else if (progress > 0) {
            totalProgress += progress;
        }
        totalItems++;

        // 진행률이 100%가 아닌 항목이 하나라도 있으면 100%로 설정하지 않음
        if (progress !== 100) {
            allCompleted = false;
        }
    });

    let averageProgress = totalProgress / totalItems;

    // 100%가 아닌 진행률 항목이 있으면 총 진행률은 100%가 될 수 없음
    if (allCompleted) {
        document.getElementById('total-progress').textContent = '100%';
    } else {
        // 0, 25, 50, 75, 100 중 가장 가까운 값으로 총 진행률 설정
        if (averageProgress <= 25) {
            document.getElementById('total-progress').textContent = '0%';
        } else if (averageProgress <= 50) {
            document.getElementById('total-progress').textContent = '25%';
        } else if (averageProgress <= 75) {
            document.getElementById('total-progress').textContent = '50%';
        } else if (averageProgress <= 100) {
            document.getElementById('total-progress').textContent = '75%';
        }
    }
}

// 페이지 로드 시 할일 목록 불러오기
document.addEventListener('DOMContentLoaded', function () {
    const projectNo = 1; // 현재 프로젝트 ID (예시)
    loadTodoList(projectNo);

    const menuItems = document.querySelectorAll(".sidebar-menu__link");
    menuItems.forEach((menuItem) => {
        menuItem.addEventListener("click", (e) => {
            const activeItem = document.querySelector(".sidebar-menu__link.active");
            if (activeItem) activeItem.classList.remove("active");
            e.target.classList.add("active");
        });
    });
});
