const rps_start = document.querySelector(".rps_start");
const rps_content = document.querySelector(".rps_content");
const rps_dec = document.querySelector(".rps_dec");
const rps_button = document.querySelectorAll(".rps_button");

let com;
let user;

function start() {
    rps_start.classList.toggle("hide");
    rps_content.classList.toggle("show");
    rps_dec.classList.remove("show");
    com = Math.floor(Math.random() * 3) + 1;
}

rps_button.forEach((btn) => {
    btn.addEventListener("click", () => {
        user = btn.value;
        rps_check();
    });
});
// 가위 1 바위 2 보 3
function rps_check() {
    if (com == user) {
        rps_start.classList.toggle("hide");
        rps_content.classList.toggle("show");
        rps_dec.classList.add("show");
        rps_dec.innerHTML = `무승부!!<br>
        컴퓨터:${com} vs 유저:${user}`;
    } else if (com < user && user != 2) {
        rps_start.classList.toggle("hide");
        rps_content.classList.toggle("show");
        rps_dec.classList.add("show");
        rps_dec.innerHTML = `컴퓨터 승!!<br>
        컴퓨터:${com} vs 유저:${user}`;
    } else if (com < user && user != 2) {
        rps_start.classList.toggle("hide");
        rps_content.classList.toggle("show");
        rps_dec.classList.add("show");
        rps_dec.innerHTML = `컴퓨터 승!!<br>
        컴퓨터:${com} vs 유저:${user}`;
    } else if (com == 1 && user == 2) {
        rps_start.classList.toggle("hide");
        rps_content.classList.toggle("show");
        rps_dec.classList.add("show");
        rps_dec.innerHTML = `유저 승!!<br>
        컴퓨터:${com} vs 유저:${user}`;
    } else {
        rps_start.classList.toggle("hide");
        rps_content.classList.toggle("show");
        rps_dec.classList.add("show");
        rps_dec.innerHTML = `유저 승!!<br>
        컴퓨터:${com} vs 유저:${user}`;
    }
}
