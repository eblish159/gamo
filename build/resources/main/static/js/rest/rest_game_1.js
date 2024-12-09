const updown_info = document.querySelector(".updown_info");
const updown_button = document.querySelector(".updown_button");
const updown_input = document.querySelector(".updown_input");

let cnt = 2;
let random;
window.onload = function () {
    random = Math.floor(Math.random() * 10) + 1;
    console.log(random);
};

updown_button.addEventListener("click", () => {
    let val = updown_input.value;
    if (cnt == 0) {
        updown_info.textContent = "남은 기회 소진";
        setTimeout(function () {
            updown_input.value = "";
        }, 2000);
    } else if (val == random) {
        updown_info.textContent = "정답입니다!";
        setTimeout(function () {
            updown_input.value = "";
        }, 2000);
    } else if (val < random) {
        updown_info.textContent = "UP!";
        cnt--;
        setTimeout(function () {
            updown_info.innerHTML = `UP!<br>남은 기회: ${cnt + 1}회`;
        }, 1500);
    } else if (val > random) {
        cnt--;
        updown_info.textContent = "DOWN!";
        setTimeout(function () {
            updown_info.innerHTML = `DOWN!<br>남은 기회: ${cnt + 1}회`;
        }, 1500);
    }
    console.log(updown_input.value);
});
