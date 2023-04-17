const createBtn = document.getElementById("createBtn");
const lottoBoard = document.getElementById("lottoBoard");

//로또판 생성하기 버튼 클릭 시 로ㄸ 판에 1~45번호 생성
createBtn.addEventListener("click", () => {
    lottoBoard.innerHTML = ""; //이전에 생성된 내용을 모두 삭제
                                // 클릭할 때마다 계속 번호가 생성되는 것 방지
    for (let i = 1; i <= 45; i++) { // 1 ~ 45까지 증가

        // 로또판에 들어갈 div요소 생성
        const innerDiv = document.createElement("div");

        // div요소에 i(1~45)값
        innerDiv.innerText = i;

        // innerDiv에 number추가
        innerDiv.classList.add("number");

        innerDiv.addEventListener("click", e => {
            // 클래스가 있다면 제거
            if(e.target.classList.contains("active")){
                // e.target.classList.remove("active");
                e.target.classList.toggle("active");
            }else{ // 클래스가 없다면 추가
                // e.target.classList.add("active");

                // active 클래스를 가진 요소가 6개 이상인 경우
                if(document.getElementsByClassName("active").length >= 6){
                    alert("6개까지만 선택할 수 있습니다.");
                }else{ // active클래스를 가진 요소가 6개 미만인 경우
                    e.target.classList.toggle("active");
                }
            }
        });
        lottoBoard.append(innerDiv);
    }
    
});
