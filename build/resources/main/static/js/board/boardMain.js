
    document.addEventListener("DOMContentLoaded", function () {
    const selectAllCheckbox = document.getElementById("select-all");
    const rowCheckboxes = document.querySelectorAll(".row-checkbox");

    // 전체 선택 체크박스 클릭 시
    selectAllCheckbox.addEventListener("change", function () {
    rowCheckboxes.forEach(checkbox => {
    checkbox.checked = selectAllCheckbox.checked;
});
});

    // 개별 체크박스 상태 변경 시 "전체 선택" 체크박스 업데이트
    rowCheckboxes.forEach(checkbox => {
    checkbox.addEventListener("change", function () {
    selectAllCheckbox.checked = Array.from(rowCheckboxes).every(cb => cb.checked);
});
});
});


    document.addEventListener("DOMContentLoaded", () => {
        const searchButton = document.querySelector(".btn-search");
        const searchInput = document.querySelector(".search-input");
        const searchSelect = document.querySelector(".search-select");
        const boardBody = document.getElementById("board-body");

        // 검색 버튼 클릭 시
        searchButton.addEventListener("click", () => {
            performSearch();
        });

        // 엔터 키 눌렀을 때 검색 실행
        searchInput.addEventListener("keyup", (event) => {
            if (event.key === "Enter") {
                performSearch();
            }
        });

        // 검색 실행 함수
        function performSearch() {
            const searchValue = searchInput.value.toLowerCase();
            const selectedOption = searchSelect.value;
            const rows = boardBody.querySelectorAll("tr");

            rows.forEach(row => {
                const number = row.querySelector(".board-number").textContent.toLowerCase();
                const title = row.querySelector(".board-title").textContent.toLowerCase();
                const author = row.querySelector(".board-author").textContent.toLowerCase();
                const date = row.querySelector(".board-date").textContent.toLowerCase();

                // 선택된 항목에 맞춰 필터링
                let isMatch = false;
                switch (selectedOption) {
                    case "number":
                        isMatch = number.includes(searchValue);
                        break;
                    case "title":
                        isMatch = title.includes(searchValue);
                        break;
                    case "author":
                        isMatch = author.includes(searchValue);
                        break;
                    case "date":
                        isMatch = date.includes(searchValue);
                        break;
                }

                // 조건에 맞지 않으면 해당 행 숨김
                if (isMatch) {
                    row.style.display = "";
                } else {
                    row.style.display = "none";
                }
            });
        }
    });


    //새글 작성
    document.addEventListener('DOMContentLoaded', function () {
        const newPostButton = document.querySelector('.btn-new-post');

        if (newPostButton) {
            newPostButton.addEventListener('click', function () {
                // 새 글 작성 페이지로 이동
                window.location.href = '/board/boardWrite';
            });
        }
    });





