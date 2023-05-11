// 서비스약관 체크하려고 할 때 팝업으로 약관 볼 수 있게 하기
const searchButton = document.getElementById("searchButton");
const searchPetitions = document.getElementById("searchPetitions");



searchButton.addEventListener("click", () => {
    // window.open(url);

    const keyword = '내용'

    // 검색창에 입력했을 때
    if(searchPetitions.value.lenght > 0 ){
        // 글씨가 입력됐으면
        location.href="브라우저게시글조회.html"; 

        // 검색 키워드가 포함된 패티션의 유무에 따라 창이 다르게 열리도록????
        if(searchPetitions.value ==  ){
            location.href="브라우저게시글조회.html"; 
    
        }else{
            location.href="청원_Not_found.html"; 
        }
    }else{
        // 아무것도 입력되지 않았으면
        alert("검색어를 입력해주세요.");
    }




    
});  


