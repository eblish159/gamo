const start = document.querySelector('.start');
const view = document.querySelector('.view');
const result = document.querySelector('.result');
const select = document.querySelector('.select');
const btns = document.querySelectorAll('.btn');
const imgResult = document.querySelector('.imgResult');

const imgCom = document.createElement('img');
const imgUser = document.createElement('img');
let com = 0;
let setPic = ['scissors.png', 'rock.png', 'paper.png'];
let show;
let i = 0;

function showUp() {
    if (i === setPic.length) {
        i = 0;
    } else {
        view.src = `../img/${setPic[i]}`;
        i++;
    }
}

start.addEventListener('click', (e) => {
    imgResult.classList.remove('on');
    result.innerText = '가위 바위 보 중 하나를 선택하세요!';
    gameOn();
    show = setInterval(showUp, 150);
    view.src = `../img/${setPic[2]}`;
    e.target.classList.add('none');
    const gameStart = e.currentTarget.parentElement;
    com = Math.floor(Math.random() * 3);
    view.classList.add('open');
    view.innerText = '가위 바위 보 중 하나를 선택하세요.';
    function a() {
        document.img1.src = '../img/' + setPic[cnt % 3];
        cnt++;
    }

    btns.forEach((btn) => {
        btn.addEventListener('click', (e) => {
            imgResult.classList.add('on');
            clearInterval(show);
            const id = e.target.dataset.id;
            let arry = { 0: '가위', 1: '바위', 2: '보' };
            viewPic(id);
            if (com == 0 && id == 2) {
                result.innerText = `컴퓨터 [${arry[com]}] vs 유저 [${arry[id]}]\n이런!.. 컴퓨터가 이겼네요....`;
                gameOff();
            } else if (id == 0 && com == 2) {
                result.innerText = `컴퓨터 [${arry[com]}] vs 유저 [${arry[id]}]\n축하합니다!! 컴퓨터를 이기셨습니다!`;
                gameOff();
            } else if (com < id) {
                result.innerText = `컴퓨터 [${arry[com]}] vs 유저 [${arry[id]}]\n축하합니다!! 컴퓨터를 이기셨습니다!`;
                gameOff();
            } else if (id < com) {
                result.innerText = `컴퓨터 [${arry[com]}] vs 유저 [${arry[id]}]\n이런!.. 컴퓨터가 이겼네요...`;
                gameOff();
            } else {
                result.innerText = `컴퓨터 [${arry[com]}] vs 유저 [${arry[id]}]\n컴퓨터와 동심일체?? 무승부!`;
                gameOff();
            }
        });
    });
});
function viewPic(id) {
    imgCom.src = `../img/${setPic[com]}`;
    imgUser.src = `../img/${setPic[id]}`;
    imgResult.appendChild(imgCom);
    imgResult.appendChild(imgUser);
}

function gameOn() {
    start.classList.add('on');
    view.classList.add('on');
    select.classList.add('on');
    result.classList.add('on');
}

function gameOff() {
    start.classList.remove('on');
    start.innerText = '다시\n시작';
    select.classList.remove('on');
    view.classList.remove('on');
}