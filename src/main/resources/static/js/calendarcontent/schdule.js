document.querySelectorAll('.day').forEach(day => {
    day.addEventListener('click', function () {
        const selectedDate = this.dataset.date; // 클릭한 날짜 가져오기
        const modal = document.querySelector('.schedule-modal');
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

// 모달 닫기 함수
function closeModal() {
    const modal = document.querySelector('.schedule-modal');
    modal.style.display = 'none';
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
