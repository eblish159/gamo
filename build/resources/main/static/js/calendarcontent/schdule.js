const modal = document.querySelector('.schedule-modal');

document.querySelectorAll('.day').forEach(day => {
    day.addEventListener('click', function () {
        const selectedDate = this.dataset.date; // 클릭한 날짜 가져오기
        const scheduleItems = document.querySelectorAll('.schedule-item');

        // 선택한 날짜의 스케줄만 표시
        scheduleItems.forEach(item => {
            const itemDate = item.dataset.date;
            if (itemDate === selectedDate) {
                item.style.display = 'block';
                if (itemDate === '24') { // 24일의 스케줄 색상 변경
                    item.style.color = 'red';
                }
            } else {
                item.style.display = 'none';
            }
        });
        openModal(modal); // 모달 열기
    });
});

// 모달 열기 함수
function openModal(modal) {
    modal.style.display = 'block';
}

//스케줄 모달 닫기
function closescheduleModal() {
    modal.style.display = 'none'; // 모달 숨기기
}


// 체크박스 상태 변경 이벤트 처리
document.querySelectorAll('.checkbox input[type="checkbox"]').forEach(checkbox => {
    checkbox.addEventListener('change', function () {
        const statusMessage = document.createElement('p');
        statusMessage.className = 'status-message';

        if (this.checked) {
            statusMessage.innerText = `${this.id} 완료되었습니다.`;
        } else {
            statusMessage.innerText = `${this.id} 완료 취소되었습니다.`;
        }

        console.log(statusMessage.innerText); // 콘솔 출력
        document.body.appendChild(statusMessage); // 메시지를 화면에 표시

        // 2초 후 메시지 제거
        setTimeout(() => {
            statusMessage.remove();
        }, 2000);
    });
});

// '할 일 추가' 버튼 클릭 시 모달 표시
document.getElementById('add-todo-btn').addEventListener('click', function () {
    const modal = document.getElementById('todo-modal');
    modal.style.display = 'block'; // 모달 표시
});

// '뒤로가기' 버튼 클릭 시 모달 닫기

function closetodoModal() {
    const modal = document.getElementById('todo-modal');
    modal.style.display = 'none'; // 모달 숨기기
}

function updateTodo() {
    const title = document.getElementById('todo-title').value; // Title 입력값
    const details = document.getElementById('todo-details').value; // Details 입력값
    const startDate = document.getElementById('start-date').value; // Start Date
    const endDate = document.getElementById('end-date').value; // End Date

    if (!title || !startDate) {
        alert('Title과 Start Date를 입력해주세요.');
        return;
    }

    // Start Date로 날짜 요소 찾기
    const formattedDate = startDate.split('T')[0]; // "YYYY-MM-DD" 추출
    const targetDay = document.getElementById(`day-${formattedDate}`);

    if (targetDay) {
        // 달력 날짜에 추가할 내용 생성
        const todoItem = document.createElement('div');
        todoItem.className = 'todo-item';
        todoItem.innerHTML = `
            <strong>${title}</strong>
            <p>${details ? details : ''}</p>
            <small>${startDate} ~ ${endDate ? endDate : ''}</small>
        `;

        targetDay.appendChild(todoItem); // 해당 날짜에 추가
    } else {
        alert('선택한 날짜가 달력에 없습니다.');
    }

    // 입력 값 초기화 및 모달 닫기
    clearTodoModal();
    closetodoModal();
}

function clearTodoModal() {
    document.getElementById('todo-title').value = '';
    document.getElementById('todo-details').value = '';
    document.getElementById('start-date').value = '';
    document.getElementById('end-date').value = '';
    document.getElementById('private-option').checked = false;
}

function closetodoModal() {
    document.getElementById('todo-modal').style.display = 'none';
}

function openTodoModal() {
    document.getElementById('todo-modal').style.display = 'block';
}







 function updateProgress() {
    const allTasks = document.querySelectorAll('.task-checkbox');
    const completedTasks = document.querySelectorAll('.task-checkbox:checked');
    const progressFill = document.getElementById('progress-fill');
    const progressText = document.getElementById('progress-text');

    // 계산된 진행률
    const progressPercentage = Math.round((completedTasks.length / allTasks.length) * 100);

    // 진행률 업데이트
    progressFill.style.width = `${progressPercentage}%`;
    progressText.textContent = `${progressPercentage}% 완료`;

    // 완료된 항목 스타일 변경
    allTasks.forEach((checkbox) => {
        const item = checkbox.closest('.calendar-item');
        if (checkbox.checked) {
            item.classList.add('completed');
        } else {
            item.classList.remove('completed');
        }
    });
}

// 초기화
updateProgress();