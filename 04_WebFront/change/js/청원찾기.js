// 서비스약관 체크하려고 할 때 팝업으로 약관 볼 수 있게 하기
const searchButton = document.getElementById("searchButton");
const searchPetitions = document.getElementById("searchPetitions");

searchButton.addEventListener("click", () => {
    // window.open(url);


    // 검색 키워드가 포함된 패티션의 유무에 따라 창이 열리도록????
    if(searchPetitions.value){
        location.href="브라우저게시글조회.html"; 

    }else{
        location.href="청원_Not_found.html"; 

    }


    
});  


