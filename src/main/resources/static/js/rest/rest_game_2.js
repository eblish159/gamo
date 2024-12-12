const rps_start = document.querySelector(".rps_start");
const rps_content = document.querySelector(".rps_content");
const rps_dec = document.querySelector(".rps_dec");
const rps_button = document.querySelectorAll(".rps_button");

let com;
let user;
let setPic = ['scissors.png', 'rock.png', 'paper.png'];

function start() {
    rps_start.classList.toggle("hide");
    rps_content.classList.toggle("show");
    rps_dec.classList.remove("show");
    com = Math.floor(Math.random() * 3);
}

rps_button.forEach((btn) => {
    btn.addEventListener("click", () => {
        user = btn.value;
        rps_check();
    });
});
// 가위 0 바위 1 보 2
function rps_check() {
    let arry = { 0: '가위', 1: '바위', 2: '보' };
    if (com == 0 && id == 2) {
        rps_start.classList.toggle("hide");
        rps_content.classList.toggle("show");
        rps_dec.classList.add("show");
        rps_dec.innerHTML = `컴퓨터 승!!<br>
        컴퓨터:${arry[com]} vs 유저:${arry[user]}`;
    } else if (id == 0 && com == 2) {
        rps_start.classList.toggle("hide");
        rps_content.classList.toggle("show");
        rps_dec.classList.add("show");
        rps_dec.innerHTML = `유저 승!!<br>
        컴퓨터:${arry[com]} vs 유저:${arry[user]}`;
    } else if (com < id) {
        rps_start.classList.toggle("hide");
        rps_content.classList.toggle("show");
        rps_dec.classList.add("show");
        rps_dec.innerHTML = `유저 승!!<br>
        컴퓨터:${arry[com]} vs 유저:${arry[user]}`;
    } else if (id < com) {
        rps_start.classList.toggle("hide");
        rps_content.classList.toggle("show");
        rps_dec.classList.add("show");
        rps_dec.innerHTML = `컴퓨터 승!!<br>
        컴퓨터:${arry[com]} vs 유저:${arry[user]}`;
    } else {
        rps_start.classList.toggle("hide");
        rps_content.classList.toggle("show");
        rps_dec.classList.add("show");
        rps_dec.innerHTML = `무승부!<br>
        컴퓨터:${arry[com]} vs 유저:${arry[user]}`;
    }
}
