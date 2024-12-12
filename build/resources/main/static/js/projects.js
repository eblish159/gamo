document.addEventListener('DOMContentLoaded', () => {
    const projectList = document.querySelector('.project-list');
    const searchInput = document.querySelector('#search-input');
    const categoryButton = document.querySelector('.category-btn');
    const categoryDropdown = document.querySelector('.category-dropdown-content');
    const categoryOptions = document.querySelectorAll('.category-option');
    const addButton = document.querySelector('.add-project-btn');
    const paginationDiv = document.querySelector('.pagination');
    let selectedCategory = null;

    // 페이지 표시 함수
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

        if (ul.firstChild) {
            ul.firstChild.firstChild.classList.add('active');
            showPage(list, 0);
        }
    };

    // 카테고리 필터링
    const filterProjects = () => {
        const projects = Array.from(document.querySelectorAll('.project-item'));
        const filteredProjects = projects.filter((project) => {
            const matchesCategory = selectedCategory === null || selectedCategory === 'all' || project.dataset.category === selectedCategory;
            return matchesCategory;
        });

        appendPageLinks(filteredProjects);
    };

    // 검색 기능
    const searchProjects = () => {
        const searchTerm = searchInput.value.trim().toLowerCase();
        const projects = Array.from(document.querySelectorAll('.project-item'));

        const filteredProjects = projects.filter((project) => {
            const projectTitle = project.querySelector('.project-link').textContent.toLowerCase();
            const projectStatus = project.querySelector('.status').textContent.toLowerCase();
            return projectTitle.includes(searchTerm) || projectStatus.includes(searchTerm);
        });

        appendPageLinks(filteredProjects);
    };

    // 카테고리 선택 후 필터링
    categoryOptions.forEach(option => {
        option.addEventListener('click', (e) => {
            selectedCategory = e.target.dataset.category;
            filterProjects();
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

        const newStatus = document.createElement('span');
        newStatus.classList.add('status');
        newStatus.textContent = '진행중';

        const newJoinedDetails = document.createElement('div');
        newJoinedDetails.classList.add('joined-details');

        const newDate = document.createElement('span');
        newDate.classList.add('date');
        newDate.textContent = `Joined ${new Date().toLocaleDateString()}`;

        newJoinedDetails.appendChild(newDate);
        newProjectDetails.appendChild(newProjectLink);
        newProjectDetails.appendChild(newStatus);
        newProjectDetails.appendChild(newJoinedDetails);
        newProjectItem.appendChild(newProjectDetails);

        projectList.appendChild(newProjectItem);
        appendPageLinks(Array.from(projectList.children)); // 새 항목이 추가된 후 페이지 링크 갱신
    });

    // 드롭다운 토글.
    categoryButton.addEventListener('click', () => {
        categoryDropdown.style.display = categoryDropdown.style.display === 'block' ? 'none' : 'block';
    });

    // 검색 이벤트 처리
    searchInput.addEventListener('input', searchProjects);

    // 초기 페이지 링크 생성
    appendPageLinks(Array.from(projectList.children));
});
