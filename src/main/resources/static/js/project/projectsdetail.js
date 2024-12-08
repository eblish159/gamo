// 할일 목록 저장 기능
document.getElementById('saveTodo').addEventListener('click', function() {
  const description = document.getElementById('todoDescription').value;
  const user = document.getElementById('todoUser').value;

  if (description && user) {
    const todoContainer = document.querySelector('.todoprojects');
    const newTodo = document.createElement('div');
    newTodo.classList.add('todoproject-box');
    newTodo.innerHTML = `
      <div class="todoproject-content">
        <div class="todoproject-header">
          <input type="checkbox" class="todo-checkbox">
          <div class="name">${user}</div>
        </div>
        <p class="todoproject-line">${description}</p>
        <p class="todoproject-line status">진행률: <span class="progress-status">0%</span></p>
        <div class="progress-container">
          <button class="progress-btn" data-progress="0">0%</button>
          <button class="progress-btn" data-progress="25">25%</button>
          <button class="progress-btn" data-progress="50">50%</button>
          <button class="progress-btn" data-progress="75">75%</button>
          <button class="progress-btn" data-progress="100">100%</button>
        </div>
      </div>
    `;
    todoContainer.appendChild(newTodo);

    document.getElementById('todoDescription').value = ''; // 입력창 초기화
    document.getElementById('todoUser').value = ''; // 사용자명 초기화
    document.querySelector('.todo-input').style.display = 'none'; // 입력 폼 숨김

    updateTotalProgress(); // 할일 추가 후 진행률 갱신
  } else {
    alert('할일 내용을 입력하세요.');
  }
});

// 진행률 선택 기능
document.querySelector('.todoprojects').addEventListener('click', function(e) {
  if (e.target.classList.contains('progress-btn')) {
    const progressValue = e.target.getAttribute('data-progress');
    const progressStatus = e.target.closest('.todoproject-box').querySelector('.progress-status');
    progressStatus.textContent = `${progressValue}%`;

    updateTotalProgress(); // 진행률 업데이트 시 총 진행률 갱신
  }
});

// 할일 목록 삭제 기능
document.querySelector('.remove-todo-btn').addEventListener('click', function() {
  const checkedItems = document.querySelectorAll('.todoproject-box input[type="checkbox"]:checked');

  checkedItems.forEach(item => {
    const todoBox = item.closest('.todoproject-box');
    todoBox.remove();
  });

  updateTotalProgress(); // 할일 삭제 후 총 진행률 갱신
});

// 할일 목록 추가 기능
document.querySelector('.add-todo-btn').addEventListener('click', function() {
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

  progressStatuses.forEach(function(progressStatus) {
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
