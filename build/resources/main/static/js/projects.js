document.addEventListener('DOMContentLoaded', () => {
  const projectList = document.querySelector('.project-list');
  const searchInput = document.querySelector('#search-input');
  const categoryButton = document.querySelector('.category-btn');
  const categoryDropdown = document.querySelector('.category-dropdown-content');
  const categoryOptions = document.querySelectorAll('.category-option');
  let selectedCategory = null;

//   페이지 표시 함수
  const showPage = (list, page) => {
    const itemsPerPage = 10;
    const startIndex = page * itemsPerPage;
    const endIndex = startIndex + itemsPerPage;

    list.forEach((item, index) => {
      item.style.display = index >= startIndex && index < endIndex ? 'block' : 'none';
    });
  };

  // 페이지 링크 생성 함수
  const appendPageLinks = (list) => {
    const totalPages = Math.ceil(list.length / 10);
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
        showPage(list, i);
      });

      li.appendChild(link);
      ul.appendChild(li);
    }

    ul.firstChild.firstChild.classList.add('active');
    showPage(list, 0);
  };

  // 카테고리 선택 함수
  const filterProjects = () => {
    const projects = document.querySelectorAll('.project-item');
    projects.forEach(project => {
      if (selectedCategory === null || selectedCategory === 'all' || project.getAttribute('data-category') === selectedCategory) {
        project.style.display = 'block';
      } else {
        project.style.display = 'none';
      }
    });
  };

  // 검색 기능
  const searchProjects = () => {
    const searchTerm = searchInput.value.toLowerCase();
    const projects = document.querySelectorAll('.project-item');

    projects.forEach(project => {
      const projectTitle = project.querySelector('.project-link').textContent.toLowerCase();
      const projectDescription = project.querySelector('.status').textContent.toLowerCase();

      if (projectTitle.includes(searchTerm) || projectDescription.includes(searchTerm)) {
        project.style.display = 'block';
      } else {
        project.style.display = 'none';
      }
    });

    // 필터링된 프로젝트에 맞게 페이지 링크 갱신
    appendPageLinks(Array.from(projects).filter(project => project.style.display === 'block'));
  };

  // 검색 이벤트 처리
  searchInput.addEventListener('input', searchProjects);

  // 카테고리 버튼 클릭 이벤트 처리
  categoryButton.addEventListener('click', () => {
    // 드롭다운 토글
    categoryDropdown.style.display = categoryDropdown.style.display === 'block' ? 'none' : 'block';
  });

  // 카테고리 선택 후 필터링
  categoryOptions.forEach(option => {
    option.addEventListener('click', (e) => {
      selectedCategory = e.target.getAttribute('data-category'); // 선택된 카테고리
      filterProjects(); // 필터링
      categoryDropdown.style.display = 'none'; // 드롭다운 닫기
    });
  });

  // "추가" 버튼 클릭 이벤트 처리
  addButton.addEventListener('click', () => {
    const newProjectItem = document.createElement('li');
    newProjectItem.classList.add('project-item', 'cf');
    newProjectItem.setAttribute('data-category', 'in-progress'); // 기본값은 "진행중"

    const newProjectDetails = document.createElement('div');
    newProjectDetails.classList.add('project-details');

    const newProjectLink = document.createElement('a');
    newProjectLink.href = '#';
    newProjectLink.classList.add('project-link');
    newProjectLink.textContent = '새로운 프로젝트';

    const newstatus = document.createElement('span');
    newstatus.classList.add('status');
    newstatus.textContent = 'new.status@example.com';

    const newJoinedDetails = document.createElement('div');
    newJoinedDetails.classList.add('joined-details');

    const newDate = document.createElement('span');
    newDate.classList.add('date');
    newDate.textContent = 'Joined 12/07/24';

    newJoinedDetails.appendChild(newDate);
    newProjectDetails.appendChild(newProjectLink);
    newProjectDetails.appendChild(newstatus);
    newProjectDetails.appendChild(newJoinedDetails);
    newProjectItem.appendChild(newProjectDetails);

    projectList.appendChild(newProjectItem);
    appendPageLinks(projectList.children); // 새 항목이 추가된 후 페이지 링크 갱신

    // 필터링과 페이지 업데이트
    filterProjects();
  });

  appendPageLinks(projectList.children); // 초기 페이지 링크 설정
});
