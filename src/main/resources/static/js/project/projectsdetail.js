// 할일 목록 저장 기능
const saveTodoButton = document.getElementById('saveTodo');
saveTodoButton?.addEventListener('click', function () {
  console.log('저장 버튼 클릭됨');
  const description = document.getElementById('todoDescription')?.value.trim();
  const user = document.getElementById('todoUser')?.value.trim();

  if (description && user) {
    // 서버에 데이터 전송
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
    const todoInput = document.querySelector('.todo-input');
    if (todoInput) {
      todoInput.style.display = 'none'; // 요소가 존재할 경우만 실행
    }
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
      if (!todoContainer) return;

      todoContainer.innerHTML = ''; // 기존 목록 초기화

      data.forEach((todo) => {
        const todoBox = document.createElement('div');
        todoBox.classList.add('todoproject-box');
        todoBox.setAttribute('data-todo-id', todo.todoId); // todoId 저장
        todoBox.innerHTML = `
          <div class="todoproject-content">
            <div class="todoproject-header">
              <input type="checkbox" class="todo-checkbox" data-id="${todo.todoId}">
              <div class="name">${todo.todoName || '알 수 없음'}</div>
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
    })
    .catch((error) => console.error('Error loading todo list:', error));
}

// 진행률 선택 기능
document.querySelector('.todoprojects')?.addEventListener('click', function (e) {
  if (e.target.classList.contains('progress-btn')) {
    const progressValue = e.target.getAttribute('data-progress');
    const progressStatus = e.target.closest('.todoproject-box')?.querySelector('.progress-status');
    if (progressStatus) {
      progressStatus.textContent = `${progressValue}%`;
    }

    updateTotalProgress(); // 진행률 업데이트
  }
});

// 할일 목록 삭제 기능
document.querySelector('.remove-todo-btn')?.addEventListener('click', function () {
  console.log('삭제 버튼 클릭됨');
  const checkedItems = document.querySelectorAll('.todoproject-box input[type="checkbox"]:checked');
  const todoIds = Array.from(checkedItems).map(item => item.getAttribute('data-id'));

  if (todoIds.length === 0) {
    alert('삭제할 할일을 선택하세요.');
    return;
  }

  fetch('/todo/delete', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ todoIds }) // ID 배열을 전송
  })
    .then(response => response.text())
    .then(result => {
      if (result === 'SUCCESS') {
        alert('선택한 할일이 삭제되었습니다.');
        loadTodoList(1); // 목록 갱신 (프로젝트 번호는 1로 가정)
      } else {
        alert('삭제에 실패했습니다.');
      }
    })
    .catch(error => console.error('Error deleting todo:', error));
});

// 할일 추가 폼 표시/숨기기 기능
document.querySelector('.add-todo-btn')?.addEventListener('click', function () {
  console.log('추가 버튼 클릭됨');
  const todoInput = document.querySelector('.todo-input');
  if (todoInput) {
    todoInput.style.display = todoInput.style.display === 'flex' ? 'none' : 'flex';
  }
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
  const totalProgressElement = document.getElementById('total-progress');
  if (totalProgressElement) {
    totalProgressElement.textContent = `${averageProgress}%`;
  }
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
