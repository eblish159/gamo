// 할일 목록 저장 기능
const saveTodoButton = document.getElementById('saveTodo');
saveTodoButton?.addEventListener('click', function () {
    const description = document.getElementById('todoDescription')?.value.trim();
    const user = document.getElementById('todoUser')?.value.trim();
    const projectNo = document.querySelector('.projecttwo')?.getAttribute('data-project-id');

    if (!projectNo) {
        alert('프로젝트 ID가 유효하지 않습니다.');
        return;
    }

    if (description && user) {
        fetch('/todo/save', {
            method: 'POST',
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
            body: `description=${encodeURIComponent(description)}&userName=${encodeURIComponent(user)}&projectNo=${projectNo}`,
        })
            .then((response) => response.text())
            .then((result) => {
                if (result === 'SUCCESS') {
                    alert('할일이 저장되었습니다!');
                    loadTodoList(projectNo); // 프로젝트 번호를 기준으로 목록 갱신
                } else {
                    alert('저장에 실패했습니다.');
                }
            })
            .catch((error) => console.error('Error:', error));
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

      todoContainer.innerHTML = '';

      data.forEach((todo) => {
        const todoBox = document.createElement('div');
        todoBox.classList.add('todoproject-box');
        todoBox.setAttribute('data-todo-id', todo.todoId);
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

      updateTotalProgress();
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

    updateTotalProgress();
  }
});

// 할일 목록 삭제 기능
document.querySelector('.remove-todo-btn')?.addEventListener('click', function () {
  const selectedCheckbox = document.querySelector('.todoproject-box input[type="checkbox"]:checked');
  if (!selectedCheckbox) {
    alert('삭제할 할일을 선택하세요.');
    return;
  }

  const selectedTodoId = selectedCheckbox.getAttribute('data-id');

  fetch(`/todo/delete?todoId=${selectedTodoId}`, {
    method: 'POST'
  })
    .then((response) => response.text())
    .then((result) => {
      if (result === 'SUCCESS') {
        alert('할일이 삭제되었습니다.');
        loadTodoList(1);
      } else {
        alert('삭제에 실패했습니다.');
      }
    })
    .catch((error) => console.error('Error deleting todo:', error));
});

// 프로젝트 삭제 기능
deleteButton?.addEventListener('click', function () {
    const projectId = document.querySelector('.projecttwo').getAttribute('data-project-id');

    if (!projectId) {
        alert('프로젝트 ID를 찾을 수 없습니다.');
        return;
    }

    if (confirm('정말 이 프로젝트를 삭제하시겠습니까?')) {
        fetch(`/projects/delete?projectNo=${projectId}`, {
            method: 'POST',
        })
        .then(response => response.text()) // 서버로부터 텍스트 응답 읽기
        .then(result => {
            if (result === 'SUCCESS') {
                alert('프로젝트가 삭제되었습니다.');
                window.location.href = '/project'; // 삭제 성공 시 프로젝트 리스트 페이지로 이동
            } else if (result === 'FAILURE') {
                alert('프로젝트를 찾을 수 없습니다.');
            } else {
                alert('프로젝트 삭제 중 오류가 발생했습니다.');
            }
        })
        .catch(error => {
            console.error('Error deleting project:', error);
            alert('서버 요청 중 오류가 발생했습니다.');
        });
    }
});


// 할일 추가 폼 표시/숨기기 기능
document.querySelector('.add-todo-btn')?.addEventListener('click', function () {
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

  loadTodoList(1);
});
