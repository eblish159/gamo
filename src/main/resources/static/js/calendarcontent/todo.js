 function closeModal() {
        document.querySelector('.todo-modal').style.display = 'none';
    }
    function updateTodo() {
        alert('수정 기능은 아직 구현되지 않았습니다.');
    }
    function deleteTodo() {
        alert('삭제 기능은 아직 구현되지 않았습니다.');
    }
    document.getElementById('header-dropdown').addEventListener('change', function () {
        const selectedValue = this.value;
        if (selectedValue === 'todo') {
            console.log('ToDo 선택됨');
        } else if (selectedValue === 'schedule') {
            console.log('Schedule 선택됨');
        }
    });

    function closeModal() {
        console.log("모달 닫기");
    }

    function updateTodo() {
        console.log("할 일 추가");
    }

    function deleteTodo() {
        console.log("할 일 삭제");
    }

    flatpickr("#start-date", {
        enableTime: true,          // 시간을 선택할 수 있도록 설정
        dateFormat: "Y-m-d H:i",   // 날짜와 시간 포맷
        minuteIncrement: 1         // 분 단위로 선택 가능
    });