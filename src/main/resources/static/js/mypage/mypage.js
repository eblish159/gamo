// 내 정보 모달 열기
function showInfoModal(event) {
    event.preventDefault(); // 기본 링크 동작 막기
    const infoModal = document.getElementById('infoModal');
    infoModal.classList.add('show'); // 모달 보이기
}

// 내 정보 모달 닫기
function closeInfoModal() {
    const infoModal = document.getElementById('infoModal');
    infoModal.classList.remove('show'); // 모달 숨기기
}

// 모달 외부 클릭 시 닫기
window.addEventListener('click', function (event) {
    const infoModal = document.getElementById('infoModal');
    if (event.target === infoModal) {
        infoModal.classList.remove('show');
    }
});


