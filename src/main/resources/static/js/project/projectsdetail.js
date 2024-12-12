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
                    loadTodoList(projectNo);
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

      updateTotalProgress(projectNo);
    })
    .catch((error) => console.error('Error loading todo list:', error));
}

// 진행률 선택 기능

document.querySelector('.todoprojects')?.addEventListener('click', function (e) {
    if (e.target.classList.contains('progress-btn')) {
        const progressValue = e.target.getAttribute('data-progress');
        const progressStatus = e.target.closest('.todoproject-box')?.querySelector('.progress-status');
        const todoId = e.target.closest('.todoproject-box')?.getAttribute('data-todo-id');
        const projectNo = document.querySelector('.projecttwo')?.getAttribute('data-project-id'); // projectNo 정의 추가

        if (progressStatus && todoId && projectNo) {
            progressStatus.textContent = `${progressValue}%`;

            // 서버에 진행률 업데이트 요청
            fetch('/todo/updateProgress', {
                method: 'POST',
                headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
                body: `todoId=${todoId}&progress=${progressValue}`,
            })
                .then((response) => response.text())
                .then((result) => {
                    if (result !== 'SUCCESS') {
                        alert('진행률 업데이트 실패.');
                    }
                    updateTotalProgress(projectNo); // projectNo 전달
                })
                .catch((error) => console.error('Error updating progress:', error));
        } else {
            console.error('Missing data for updating progress. Todo ID or Project ID is undefined.');
        }
    }
});




// 참여하기 버튼 클릭 시 로그인 세션에서 정보 가져오기
    document.getElementById('addParticipantBtn')?.addEventListener('click', function () {
        fetch('/member/session')
            .then(response => response.json())
            .then(data => {
                console.log('API 응답 데이터:', data);
                if (data.error) {
                    alert("세션 정보가 없습니다. 로그인 페이지로 이동합니다.");
                    window.location.href = "/login";
                } else {
                    console.log("사용자 ID:", data.member_id);
                    console.log("사용자 이름:", data.name);
                    alert(`참여 성공: ID: ${data.member_id}, 이름: ${data.name}`);

                    // 사용자 정보를 한 줄로 출력
                    const participantInfoElement = document.getElementById('participant-info');
                    if (participantInfoElement) {
                        participantInfoElement.textContent = `사용자 ID: ${data.member_id}  사용자 이름: ${data.name}`;
                    }
                }
            })
            .catch(error => console.error("API 호출 중 오류:", error));
    });





// 총 진행률 계산 및 동기화 함수 (중복 제거)
function updateTotalProgress(projectNo) {
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

    // 서버 동기화
    if (projectNo) {
        fetch('/projects/saveProgress', {
            method: 'POST',
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
            body: `projectNo=${projectNo}&progress=${averageProgress}`,
        }).catch((error) => console.error('Error syncing progress with server:', error));
    } else {
        console.error('Project ID is not defined for syncing progress.');
    }
}

// 메뉴 활성화 및 초기 데이터 로드
document.addEventListener('DOMContentLoaded', () => {
    const menuItems = document.querySelectorAll('.sidebar-menu__link');

    menuItems.forEach((menuItem) => {
        menuItem.addEventListener('click', (e) => {
            const activeItem = document.querySelector('.sidebar-menu__link.active');
            if (activeItem) activeItem.classList.remove('active');
            e.target.classList.add('active');
        });
    });

    const projectNo = document.querySelector('.projecttwo')?.getAttribute('data-project-id');
    if (projectNo) {
        loadTodoList(projectNo);
        fetch(`/todo/projectProgress?projectNo=${projectNo}`)
            .then((response) => response.json())
            .then((progress) => {
                const totalProgressElement = document.getElementById('total-progress');
                if (totalProgressElement) {
                    totalProgressElement.textContent = `${progress}%`;
                }
            })
            .catch((error) => console.error('Error fetching project progress:', error));
    }
});


// 프로젝트 삭제 기능
const deleteButton = document.getElementById('deleteProjectBtn');
deleteButton?.addEventListener('click', function () {
    const projectId = document.querySelector('.projecttwo')?.getAttribute('data-project-id');

    if (!projectId) {
        alert('프로젝트 ID를 찾을 수 없습니다.');
        return;
    }

    if (confirm('정말 이 프로젝트를 삭제하시겠습니까?')) {
        fetch(`/projects/delete?projectNo=${projectId}`, {
            method: 'POST',
        })
        .then(response => response.text())
        .then(result => {
            if (result === 'SUCCESS') {
                alert('프로젝트가 삭제되었습니다.');
                window.location.href = '/project';
            } else if (result === 'FAILURE') {
                alert('프로젝트를 찾을 수 없습니다.');
            } else {
                alert('프로젝트 삭제 중 오류가 발생했습니다.');
            }
        })
        .catch(error => console.error('Error deleting project:', error));
    }
});

// 프로젝트 진행률 저장 기능
const saveProjectButton = document.getElementById('saveProjectBtn');
saveProjectButton?.addEventListener('click', function () {
    const projectId = document.querySelector('.projecttwo')?.getAttribute('data-project-id');
    const totalProgress = document.getElementById('total-progress')?.textContent.replace('%', '').trim();

    if (!projectId || !totalProgress) {
        alert('프로젝트 ID 또는 진행률 정보가 유효하지 않습니다.');
        return;
    }

    // 서버에 프로젝트 진행률 업데이트 요청
    fetch('/projects/saveProgress', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: `projectNo=${encodeURIComponent(projectId)}&progress=${encodeURIComponent(totalProgress)}`,
    })
        .then((response) => response.text())
        .then((result) => {
            if (result === 'SUCCESS') {
                alert('프로젝트 진행률이 성공적으로 저장되었습니다.');
            } else {
                alert('진행률 저장에 실패했습니다.');
            }
        })
        .catch((error) => console.error('Error saving progress:', error));
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

    // 서버와 동기화
    const projectNo = document.querySelector('.projecttwo')?.getAttribute('data-project-id');
    if (projectNo) {
        fetch('/projects/saveProgress', {
            method: 'POST',
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
            body: `projectNo=${projectNo}&progress=${averageProgress}`,
        }).catch((error) => console.error('Error syncing progress with server:', error));
    } else {
        console.error('Project ID is not defined.');
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

  const projectNo = document.querySelector('.projecttwo')?.getAttribute('data-project-id');
   if (projectNo) {
      loadTodoList(projectNo);
      // 서버에서 프로젝트 진행률 가져와서 업데이트
      fetch(`/todo/projectProgress?projectNo=${projectNo}`)
        .then((response) => response.json())
        .then((progress) => {
          const totalProgressElement = document.getElementById('total-progress');
          if (totalProgressElement) {
            totalProgressElement.textContent = `${progress}%`;
          }
        })
        .catch((error) => console.error('Error fetching project progress:', error));
    }
  });
