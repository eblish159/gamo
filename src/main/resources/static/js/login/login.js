document.addEventListener('DOMContentLoaded', () => {
    const spaceship = document.getElementById('spaceship');
    const loginForm = document.getElementById('loginForm');
    const loginButton = document.getElementById('loginButton');
    const body = document.body;

    // 로그인 버튼 클릭 시 동작
    loginButton.addEventListener('click', () => {
        // 버튼 중복 클릭 방지
        loginButton.disabled = true;

        // 우주선 표시 및 애니메이션 실행
        body.style.overflow = 'hidden';
        spaceship.style.display  = 'block';
        spaceship.style.animation = 'fly 5s linear forwards';

        // 애니메이션 완료 후 폼 제출
        spaceship.addEventListener('animationend', () => {
            spaceship.style.display = 'none';
            body.style.overflow = '';
            loginForm.submit(); // 서버로 폼 제출
        });
    });
});