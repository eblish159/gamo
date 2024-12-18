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

//삭제 버튼 구현
document.querySelector('.remove-todo-btn')?.addEventListener('click', function () {
    const projectNo = document.querySelector('.projecttwo')?.getAttribute('data-project-id');
    if (!projectNo) {
        alert("프로젝트 ID가 유효하지 않습니다.");
        return;
    }

    // 선택된 체크박스에서 todoId 추출
    const selectedTodos = Array.from(document.querySelectorAll('.todo-checkbox:checked'))
        .map(checkbox => checkbox.getAttribute('data-id'));

    if (selectedTodos.length === 0) {
        alert("삭제할 할일을 선택하세요.");
        return;
    }

    // 서버로 삭제 요청
    fetch('/todo/deleteMultiple', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(selectedTodos),
    })
        .then(response => response.text())
        .then(result => {
            if (result === 'SUCCESS') {
                alert("선택된 할일이 삭제되었습니다.");
                loadTodoList(projectNo); // 목록 새로고침
            } else {
                alert("할일 삭제에 실패했습니다.");
            }
        })
        .catch(error => console.error('Error deleting todos:', error));
});















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
        const projectNo = document.querySelector('.projecttwo')?.getAttribute('data-project-id');
        if (!projectNo) {
            alert("프로젝트 ID를 찾을 수 없습니다.");
            return;
        }

        fetch('/member/session')
            .then(response => response.json())
            .then(data => {
                if (data.error) {
                    alert("세션 정보가 없습니다. 로그인 페이지로 이동합니다.");
                    window.location.href = "/login";
                } else {
                    const participant = {
                        projectNo: projectNo,
                        memberId: data.member_id,
                    };

                    fetch('/api/participants/add', {
                        method: 'POST',
                        headers: { 'Content-Type': 'application/json' },
                        body: JSON.stringify(participant),
                    })
                        .then(response => response.json())
                        .then(result => {
                            if (result.status === 'SUCCESS') {
                                alert(`참여 성공: ID: ${data.member_id}, 이름: ${data.name}`);
                                loadParticipants(projectNo); // 목록 갱신
                            } else {
                                alert("이미 등록된 참가자입니다.");
                            }
                        })
                        .catch(error => console.error('Error adding participant:', error));
                }
            })
            .catch(error => console.error('Error fetching session data:', error));
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

// loadParticipants 함수 정의 참여자 목록 로드 함수
function loadParticipants(projectNo) {
    fetch(`/api/participants/${projectNo}`)
        .then(response => response.json())
        .then(data => {
            const participantListContainer = document.querySelector('#participant-info');
            if (!participantListContainer) return;

            participantListContainer.innerHTML = ''; // 기존 참여자 목록 초기화

            data.forEach(participant => {
                const participantItem = document.createElement('p');
                participantItem.classList.add('participant-detail');
                participantItem.style.color = 'black';
                participantItem.textContent = `ID: ${participant.memberId},  이름: ${participant.name}`;
                participantListContainer.appendChild(participantItem);
            });
        })
        .catch(error => console.error('Error loading participants:', error));
}










// 메뉴 활성화 및 초기 데이터 로드
document.addEventListener("DOMContentLoaded", () => {
    const projectNo = document.querySelector('.projecttwo')?.getAttribute('data-project-id');

    if (projectNo) {
        loadParticipants(projectNo); // 참여자 목록 로드
        loadTodoList(projectNo); // 할일 목록 로드
        fetch(`/todo/projectProgress?projectNo=${projectNo}`)
            .then(response => response.json())
            .then(progress => {
                const totalProgressElement = document.getElementById('total-progress');
                if (totalProgressElement) {
                    totalProgressElement.textContent = `${progress}%`;
                }
            })
            .catch(error => console.error('Error fetching project progress:', error));
    }

    // 메뉴 활성화 코드
    const menuItems = document.querySelectorAll('.sidebar-menu__link');

    menuItems.forEach((menuItem) => {
        menuItem.addEventListener('click', (e) => {
            const activeItem = document.querySelector('.sidebar-menu__link.active');
            if (activeItem) activeItem.classList.remove('active');
            e.target.classList.add('active');
        });
    });
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
                alert('현재 프로젝트 진행률이 저장되었습니다.');
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
