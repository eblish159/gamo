// 할일 목록 저장 기능
document.getElementById('saveTodo').addEventListener('click', function () {
  const description = document.getElementById('todoDescription').value.trim();
  const user = document.getElementById('todoUser').value.trim();

  if (description && user) {
    // 서버에 데이터 전송.
    fetch('/todo/save', {
      method: 'POST',
      headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
      body: `description=${encodeURIComponent(description)}&userName=${encodeURIComponent(user)}&projectNo=1`, // 프로젝트 번호 1로 가정
    })
      .then((response) => response.text())
      .then((result) => {
        if (result === 'SUCCESS') {
          alert('할일이 저장되었습니다!');
          loadTodoList(1); // 프로젝트 번호를 기준으로 목록 갱신
        } else {
          alert('저장에 실패했습니다.');
        }
      })
      .catch((error) => console.error('Error:', error));

    // 입력 필드 초기화 및 폼 숨김
    document.getElementById('todoDescription').value = '';
    document.getElementById('todoUser').value = '';
    document.querySelector('.todo-input').style.display = 'none';
  } else {
    alert('할일 내용과 사용자 이름을 입력하세요.');
  }
});

// 할일 목록 로드 기능
function loadTodoList(projectNo) {
  fetch(`/todo/list?projectNo=${projectNo}`)
    .then((response) => response.json())
    .then((data) => {
      const todoContainer = document.querySelector('.todoprojects');
      todoContainer.innerHTML = ''; // 기존 목록 초기화

      data.forEach((todo) => {
        const todoBox = document.createElement('div');
        todoBox.classList.add('todoproject-box');
        todoBox.innerHTML = `
          <div class="todoproject-content">
            <div class="todoproject-header">
              <input type="checkbox" class="todo-checkbox">
              <div class="name">${todo.todoName || '알 수 없음'}</div> <!-- todoName 사용 -->
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

      updateTotalProgress(); // 총 진행률 업데이트
    });
}

// 진행률 선택 기능
document.querySelector('.todoprojects').addEventListener('click', function (e) {
  if (e.target.classList.contains('progress-btn')) {
    const progressValue = e.target.getAttribute('data-progress');
    const progressStatus = e.target.closest('.todoproject-box').querySelector('.progress-status');
    progressStatus.textContent = `${progressValue}%`;

    updateTotalProgress(); // 진행률 업데이트
  }
});

// 할일 목록 삭제 기능
document.querySelector('.remove-todo-btn').addEventListener('click', function () {
  const checkedItems = document.querySelectorAll('.todoproject-box input[type="checkbox"]:checked');

  checkedItems.forEach((item) => {
    const todoBox = item.closest('.todoproject-box');
    if (todoBox) {
      todoBox.remove();
    }
  });

  updateTotalProgress(); // 진행률 업데이트
});

// 할일 추가 폼 표시/숨기기 기능
document.querySelector('.add-todo-btn').addEventListener('click', function () {
  const todoInput = document.querySelector('.todo-input');
  todoInput.style.display = todoInput.style.display === 'flex' ? 'none' : 'flex';
});

// 총 진행률 계산
function updateTotalProgress() {
  const progressStatuses = document.querySelectorAll('.progress-status');
  let totalProgress = 0;
  let totalItems = 0;

  progressStatuses.forEach(function (progressStatus) {
    const progress = parseInt(progressStatus.textContent.replace('%', ''), 10);
    totalProgress += progress;
    totalItems++;
  });

  const averageProgress = totalItems > 0 ? Math.round(totalProgress / totalItems) : 0;
  const roundedProgress =
    averageProgress <= 25
      ? 0
      : averageProgress <= 50
      ? 25
      : averageProgress <= 75
      ? 50
      : averageProgress < 100
      ? 75
      : 100;

  document.getElementById('total-progress').textContent = `${roundedProgress}%`;
}

// 메뉴 활성화 기능
document.addEventListener('DOMContentLoaded', () => {
  const menuItems = document.querySelectorAll('.sidebar-menu__link');

  menuItems.forEach((menuItem) => {
    menuItem.addEventListener('click', (e) => {
      const activeItem = document.querySelector('.sidebar-menu__link.active');
      if (activeItem) activeItem.classList.remove('active');
      e.target.classList.add('active');
    });
  });

  // 페이지 로드 시 할일 목록 불러오기
  loadTodoList(1); // 프로젝트 번호 1로 가정
});
