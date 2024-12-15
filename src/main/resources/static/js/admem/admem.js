function submit_search() {
    alert("조회 완료!");
    // 검색어와 검색 조건을 가져옵니다.
    var search_kw = document.querySelector('.search-input').value;
    var search_condition = document.querySelector('.search-select').value;

    // 검색어가 비어 있지 않으면, 쿼리 파라미터를 포함한 URL로 이동
    var url = "/admin?searchKeyword=" + encodeURIComponent(searchKeyword) +
              "&searchCondition=" + encodeURIComponent(searchCondition);

    // 페이지를 새로 고침하면서 검색 파라미터를 서버로 전달
    window.location.href = url;
}

document.addEventListener("DOMContentLoaded", function () {
    // 모달 관련 요소 가져오기
    const modal = document.getElementById("add-member-modal");
    const openModalBtn = document.querySelector(".btn-new-post");
    const closeModalBtn = document.querySelector(".close-btn");
    const addMemberBtn = document.querySelector(".btn-add-member");

    // 모달 열기
    openModalBtn.addEventListener("click", function () {
        modal.classList.add("show");
    });

    // 모달 닫기
    closeModalBtn.addEventListener("click", function () {
        modal.classList.remove("show");
    });

    // 모달 외부 클릭 시 닫기
    window.addEventListener("click", function (event) {
        if (event.target === modal) {
            modal.classList.remove("show");
        }
    });

    // 회원 추가 처리
    addMemberBtn.addEventListener("click", function () {
        const memberId = document.getElementById("member-id").value;
        const memberPassword = document.getElementById("member-password").value;
        const memberName = document.getElementById("member-name").value;
        const memberPhone = document.getElementById("member-phone").value;
        const memberDate = document.getElementById("member-date").value;
        const memberGame = document.getElementById("member-game").value;
        const memberRole = document.getElementById("member-role").value;

        if (!memberId || !memberPassword || !memberName || !memberPhone || !memberDate) {
            alert("모든 필드를 입력해주세요!");
            return;
        }

        alert("회원이 성공적으로 추가되었습니다.");
        modal.classList.remove("show");
    });

});