// 서비스약관 체크하려고 할 때 팝업으로 약관 볼 수 있게 하기
const openPopup = document.getElementById("agree");
const openWd = window.open("서비스_이용약관_동의.html", "서비스_이용약관_동의", "width=500, hight=500px"); 


openPopup.addEventListener("click", () => {

     // 열기 이벤트
    window.open("서비스_이용약관_동의.html", "서비스_이용약관_동의", "width=500, hight=500px");
    
    openWd.addEventListener("onveforeunload", ()=>{
    
        if(openWd.submit){
            openPopup.checked = true;
        }else{
            openPopup.checked = false;
        }
    });
});  



