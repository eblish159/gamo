const updown_info = document.querySelector(".updown_info");
const updown_button = document.querySelector(".updown_button");
const updown_input = document.querySelector(".updown_input");
const updown_content = document.querySelector(".updown_content");
const start_updown = document.querySelector(".start_updown");

let cnt;
let random;
updown_button.addEventListener("click", () => {
    let val = updown_input.value;
    if (val == random) {
        updown_info.textContent = "정답입니다!";
        updown_input.classList.add("hide");
        setTimeout(function () {
            updown_info.textContent = "메인페이지로 이동중..";
            updown_input.value = "";
        }, 1000);
        setTimeout(function () {
            location.href = "/";
            updown_toggle();
        }, 3000);
    } else if (val < random) {
        updown_info.innerHTML = "<h1>UP!</h1>";
        cnt--;
        final_chance();
    } else if (val > random) {
        cnt--;
        updown_info.innerHTML = "<h1>DOWN!</h1>";
        final_chance();
    }
});

function final_chance() {
    if (cnt == 0) {
        updown_info.innerHTML = `실패!!<br>3회 모두 끝났습니다.`;
        setTimeout(function () {
            updown_info.textContent = "메인페이지로 이동중..";
            updown_input.value = "";
        }, 1000);
        setTimeout(function () {
            location.href = "/";
            updown_toggle();
        }, 2000);
    } else {
        setTimeout(function () {
            updown_info.innerHTML = `UP!<br>남은 기회: ${cnt}회`;
            updown_input.value = "";
        }, 1500);
    }
}

function updown_toggle() {
    updown_content.classList.toggle("show");
    start_updown.classList.toggle("hide");
    updown_input.classList.remove("hide");
    random = Math.floor(Math.random() * 10) + 1;
    cnt = 3;
    updown_info.textContent = "범위는 1~10입니다.";
}
