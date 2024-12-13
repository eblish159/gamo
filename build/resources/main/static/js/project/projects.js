// 종료된 프로젝트 버튼 클릭 시 동작
document.querySelector('.end-project-btn')?.addEventListener('click', function () {
  // 종료된 프로젝트 페이지로 이동
  window.location.href = '/endprojects'; // 종료된 프로젝트 페이지로 리디렉션
});

document.addEventListener('DOMContentLoaded', () => {
  const projectList = document.querySelector('.project-list');
  const searchInput = document.querySelector('#search-input');
  const categoryButton = document.querySelector('.category-btn');
  const categoryDropdown = document.querySelector('.category-dropdown-content');
  const categoryOptions = document.querySelectorAll('.category-option');
  let selectedCategory = null;

  // 페이지 표시 함수
  const showPage = (list, page) => {
    const itemsPerPage = 10;
    const startIndex = page * itemsPerPage;
    const endIndex = startIndex + itemsPerPage;

    // 배열로 변환 후 처리
    const arrayList = Array.from(list);

    arrayList.forEach((item, index) => {
      item.style.display = index >= startIndex && index < endIndex ? 'block' : 'none';
    });
  };

  // 페이지 링크 생성 함수
  const appendPageLinks = (list) => {
    const arrayList = Array.from(list); // 배열로 변환
    const totalPages = Math.ceil(arrayList.length / 10);
    const paginationDiv = document.querySelector('.pagination');
    paginationDiv.innerHTML = ''; // 기존 페이지 링크 삭제
    const ul = document.createElement('ul');
    paginationDiv.appendChild(ul);

    for (let i = 0; i < totalPages; i++) {
      const li = document.createElement('li');
      const link = document.createElement('a');
      link.href = '#';
      link.textContent = i + 1;

      link.addEventListener('click', (e) => {
        e.preventDefault();
        document.querySelectorAll('.pagination a').forEach((a) => a.classList.remove('active'));
        e.target.classList.add('active');
        showPage(arrayList, i); // 배열을 전달
      });

      li.appendChild(link);
      ul.appendChild(li);
    }

    if (ul.firstChild?.firstChild) {
      ul.firstChild.firstChild.classList.add('active');
    } else {
      console.warn('ul 또는 ul.firstChild.firstChild가 존재하지 않아 active 클래스를 추가하지 못했습니다.');
    }

    showPage(arrayList, 0); // 배열을 전달
  };

  // 초기 실행 시
  if (projectList && projectList.children.length > 0) {
    const projects = projectList.children;
    appendPageLinks(projects); // 초기 페이지 링크 설정
  } else {
    console.warn('projectList가 비어 있거나 존재하지 않습니다.');
  }

  // 카테고리 선택 함수
  const filterProjects = () => {
    const projects = document.querySelectorAll('.project-item');
    projects.forEach((project) => {
      if (
        selectedCategory === null ||
        selectedCategory === 'all' ||
        project.getAttribute('data-category') === selectedCategory
      ) {
        project.style.display = 'block';
      } else {
        project.style.display = 'none';
      }
    });
  };

  // 검색 기능
  const searchProjects = () => {
    const searchTerm = searchInput?.value.toLowerCase();
    const projects = document.querySelectorAll('.project-item');

    projects.forEach((project) => {
      const projectTitle = project.querySelector('.project-link')?.textContent.toLowerCase() || '';
      const projectDates = project.querySelector('.project-dates')?.textContent.toLowerCase() || '';

      if (projectTitle.includes(searchTerm) || projectDates.includes(searchTerm)) {
        project.style.display = 'block';
      } else {
        project.style.display = 'none';
      }
    });

    // 필터링된 프로젝트에 맞게 페이지 링크 갱신
    appendPageLinks(Array.from(projects).filter((project) => project.style.display === 'block'));
  };

  // 검색 이벤트 처리
  searchInput?.addEventListener('input', searchProjects);

  // 카테고리 버튼 클릭 이벤트 처리
  categoryButton?.addEventListener('click', () => {
    // 드롭다운 토글
    if (categoryDropdown) {
      categoryDropdown.style.display = categoryDropdown.style.display === 'block' ? 'none' : 'block';
    }
  });

  // 카테고리 선택 후 필터링
  categoryOptions.forEach((option) => {
    option.addEventListener('click', (e) => {
      selectedCategory = e.target.getAttribute('data-category'); // 선택된 카테고리
      filterProjects(); // 필터링
      if (categoryDropdown) {
        categoryDropdown.style.display = 'none'; // 드롭다운 닫기
      }
    });
  });

  // "추가" 버튼 클릭 이벤트 처리
  document.querySelector('.add-project-btn')?.addEventListener('click', () => {
    const newProjectItem = document.createElement('li');
    newProjectItem.classList.add('project-item', 'cf');
    newProjectItem.setAttribute('data-category', 'in-progress'); // 기본값은 "진행중"

    const newProjectDetails = document.createElement('div');
    newProjectDetails.classList.add('project-details');

    const newProjectLink = document.createElement('a');
    newProjectLink.href = '#';
    newProjectLink.classList.add('project-link');
    newProjectLink.textContent = '새로운 프로젝트';

    const newProjectDates = document.createElement('span');
    newProjectDates.classList.add('project-dates');
    newProjectDates.textContent = '생성일: YYYY-MM-DD, 시작일: YYYY-MM-DD, 종료일: YYYY-MM-DD';

    newProjectDetails.appendChild(newProjectLink);
    newProjectDetails.appendChild(newProjectDates);
    newProjectItem.appendChild(newProjectDetails);

    if (projectList) {
      projectList.appendChild(newProjectItem);
      appendPageLinks(projectList.children); // 새 항목이 추가된 후 페이지 링크 갱신

      // 필터링과 페이지 업데이트
      filterProjects();
    }
  });

  // 메뉴 활성화 기능
  const menuItems = document.querySelectorAll('.sidebar-menu__link');
  menuItems.forEach((menuItem) => {
    menuItem.addEventListener('click', (e) => {
      const activeItem = document.querySelector('.sidebar-menu__link.active');
      if (activeItem) activeItem.classList.remove('active');
      e.target.classList.add('active');
    });
  });
});
