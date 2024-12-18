const menuItems = document.querySelectorAll(".sidebar-menu__link");

menuItems.forEach((menuItem) => {
  menuItem.addEventListener("click", (e) => {
    const activeItem = document.querySelector(".sidebar-menu__link.active");
    if (activeItem) activeItem.classList.remove("active");
    e.target.classList.add("active");
  });
});


//레벨,경험치 창.
// 위젯 열기/닫기 토글
  function toggleWidget() {
    const content = document.querySelector('.widget-content');
    const button = document.querySelector('.widget-header button');
    if (content.style.display === 'block') {
      content.style.display = 'none';
      button.textContent = '펼치기';
    } else {
      content.style.display = 'block';
      button.textContent = '접기';
    }
  }

// 레벨별 이미지 안내 모달 열기
    function showModal() {
        const modal = document.getElementById('levelModal');
        modal.style.display = 'flex';
    }

    // 모달 닫기
    function closeModal() {
        const modal = document.getElementById('levelModal');
        modal.style.display = 'none';
    }

