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

        if (!memberId || !memberPassword || !memberName || !memberPhone || !memberDate) {
            alert("모든 필드를 입력해주세요!");
            return;
        }

        console.log("회원 추가:", {
            아이디: memberId,
            패스워드: memberPassword,
            이름: memberName,
            핸드폰번호: memberPhone,
            입사일: memberDate,
            게임: memberGame,
        });

        alert("회원이 성공적으로 추가되었습니다.");
        modal.classList.remove("show");
    });

    document.querySelectorAll(".btn-delete-member").forEach(function(button) {
        button.addEventListener("click", function() {
            const member_id = button.getAttribute("data-id");
            console.log("삭제 요청:", member_id);
            if (confirm("정말로 삭제하시겠습니까?")) {
                fetch(`/admin/delMember?member_id=${member_id}`, {
                    method: 'POST'
                }).then((response) => {
                    console.log("서버 응답 상태:", response.status);
                    if (response.ok) {
                        alert("삭제 성공!");
                        location.reload();
                    } else {
                        alert("삭제 실패");
                    }
                });
            }
        });
    });
});