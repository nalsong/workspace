function clickCount(btn){
    // 클릭할 때 마다 1씩 증가. 단, 20을 초과하면 다시 0으로 초기화

    // btn = <div id="btn1" onclick="clickCount(this)">0</div>hr

    // console.log(btn.innerText);
    btn.innerText = Number(btn.innerText)+1;

    if(Number(btn.innerText) >= 21){
        btn.innerText = 0;
    }

}


// 익명 함수
const t2 = document.getElementById('target2');
const b2 = document.getElementById('btn2');

const colorList = ['red', 'orange', 'yellow', 'green', 'blue'];
let index = -1;

b2.addEventListener('click', function(){
    // t2.style.color = 'red';

    t2.style.color = colorList[++index];

    if(index == 4) index = -1; // 다시 처음부터 시작~~~
});


//-----------------------------------------------------

// 즉시 실행 함수

// 1) 속도적 우위
function testfn(){
    console.log('일반함수');
}
testfn(); // 함수호출

// 즉시 실행 함수는 정의가 끝나면 바로 실행
(function(){
    console.log('즉시 실행 함수');
})();

// 2) 변수명 중복 문제 해결
const str = "전역변수";
(function(){
    const str = "지역변수";
    console.log(str); //지역변수
})();
console.log(str); // 전역변수



//-----------------------------------------

// 화살표 함수

// 1. 기본형태
// 익명함수 : function(){}
// 화살표함수 : () => {}
document.querySelector("#button1").addEventListener("click", () => {
    alert("화살표 함수의 기본형태입니다.");
});

// 2. 매개변수 1개
// 익명 함수 : function(e){}
// 화살표 함수 : (e) => {}
//               e => {} // ()소괄호 생략가능
//               3. 매개변수가 2개 이상 또는 0개이면 ()생략 불가능!
// document.querySelector("#button2").addEventListener("click", (e) => {
document.querySelector("#button2").addEventListener("click", e => {
    e.target.style.backgroundColor = "skyblue";
});


// 4. 함수 정의 부분에 return 구문만 있을 경우({}, return 생략하기)
document.querySelector("#button4").addEventListener("click", () => {
    // 익명 함수
    printConsole(function(num){return num * 10;});

    // 화살표 함수
    // printConsole((num) => {return num*100;});

    // 매개변수 1개 -> ()생략
    printConsole(num => {return num * 100;}); 
    
    // 함수 정의 부분에 return만 작성 -> {}, return생략
    printConsole(num => num * 100); 

    // 5. 함수 정의 부분에 return 구문만 있지만 자료형이 object인 경우
    const temp = {"price": 100, "name":"사탕"}; // JS객체(object)
    console.log(temp);
    console.log(typeof temp);

    // object를 변수에 저장해서 리턴하는 건 가능
    printConsole( num => temp );

    // return, {}생략 상태에서 object를 직접 작성하면 오류 발생
    // -> JS객체의 {}를 함수 정의 부분의 {}로 인식해서 구문 오류 발생
    // printConsole( num =>  {"price": 100, "name":"사탕"} );
});

function printConsole(fn){
    // 매개변수로 함수를 받아와 수행 결과를 콘솔에 출력
    console.log("-----------------------------------");
    console.log( fn(2) );
    console.log("-----------------------------------");
}



// 화살표 함수 this문제점
const button6 = document.querySelector("#button6");

// 클릭된 요소의 배경색을 검정색으로 변경(익명함수)
button6.addEventListener("click", function(e){
    e.target.style.backgroundColor = "black";
});

// 클릭된 요소의 글자색을 흰색으로 변경(화살표함수)
button6.addEventListener("click", e => {
    e.target.style.color = "white";
});


// 클릭된 요소의 폰트 크기를 25px로 증가(익명, e사용x, this사용O)
button6.addEventListener("click", function(){

    console.log(this);
    // 이벤트 핸들러로 지정된 익명 함수의 this == 이벤트가 발생한 요소
    this.style.fontSize = "25px";
});


// 클릭된 요소의 테두리를 3px실선 pink로 변경(화살표, e사용x, this사용O)
button6.addEventListener("click", () => {
    console.log(this);
    // 화살표 함수에서 this를 작성하면 이벤트가 발생한 요소가 아닌 창 자체를 나타내는 window객체가 반환된다.

    this.style.border = "3px solid pink";
});