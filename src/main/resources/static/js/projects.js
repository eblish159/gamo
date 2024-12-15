document.addEventListener('DOMContentLoaded', () => {
    const searchInput = document.querySelector('#search-input');
    const searchButton = document.querySelector('#search-button');
    const projectRows = document.querySelectorAll('.project-row');
    const paginationDiv = document.querySelector('.pagination');
    const itemsPerPage = 10;

    // 검색 기능
    const searchProjects = () => {
        const searchTerm = searchInput.value.toLowerCase().trim();

        projectRows.forEach(row => {
            const title = row.querySelector('.project-title a').textContent.toLowerCase();
            const dates = Array.from(row.querySelectorAll('.project-date, .project-progress'))
                .map(span => span.textContent.toLowerCase())
                .join(' ');

            // 검색어가 제목, 날짜 또는 진행률에 포함되면 보이기, 아니면 숨기기
            if (title.includes(searchTerm) || dates.includes(searchTerm)) {
                row.style.display = 'grid';
            } else {
                row.style.display = 'none';
            }
        });

        updatePagination(); // 검색 결과에 맞게 페이지네이션 갱신
    };

    // 페이지네이션 기능
    const showPage = (list, page) => {
        const startIndex = page * itemsPerPage;
        const endIndex = startIndex + itemsPerPage;

        list.forEach((item, index) => {
            if (item.style.display !== 'none') {
                item.style.display = index >= startIndex && index < endIndex ? 'grid' : 'none';
            }
        });
    };

    const appendPageLinks = () => {
        const visibleProjects = Array.from(projectRows).filter(
            project => project.style.display !== 'none'
        );

        const totalPages = Math.ceil(visibleProjects.length / itemsPerPage);
        paginationDiv.innerHTML = ''; // 기존 페이지네이션 초기화

        for (let i = 0; i < totalPages; i++) {
            const link = document.createElement('a');
            link.href = '#';
            link.textContent = i + 1;

            link.addEventListener('click', (e) => {
                e.preventDefault();
                showPage(visibleProjects, i);
                document.querySelectorAll('.pagination a').forEach(a => a.classList.remove('active'));
                link.classList.add('active');
            });

            paginationDiv.appendChild(link);
        }

        if (paginationDiv.firstChild) {
            paginationDiv.firstChild.classList.add('active');
        }
        showPage(visibleProjects, 0);
    };

    const updatePagination = () => {
        appendPageLinks();
    };

    // 이벤트 핸들러
    searchButton.addEventListener('click', searchProjects);

    searchInput.addEventListener('keyup', (event) => {
        if (event.key === 'Enter') {
            searchProjects();
        }
    });

    // 초기 페이지네이션 설정
    appendPageLinks();
});
