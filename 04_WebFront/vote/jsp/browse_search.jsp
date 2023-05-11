<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>브라우저 게시글 조회</title>

    <link rel="stylesheet" href="../css/browse_search.css">
</head>
<body>
    
    <main>
        <header>

        </header>
        
        
        <section class="top">
            <div id="discoverP">
                Discover petitons to sign
            </div>
            <div class="menu" id="menu">
                <div id="featured"><a href="#">Featured</a></div>
                <div id="popular"><a href="#">Popular</a></div>
                <div id="recent"><a href="#">Recent</a></div>
                <div id="victories"><a href="#">Victories</a></div>
            </div>
        </section>

        <section class="middle">
            
            <div class="result">
                <div class="row" id="rowPicture">
                    <img src="../image/순덕이.png" class="picture">
                </div>
                <div class="row">
                    <div class="column" id="column-1">
                        <div id="title">
                            서울시 종로구 순덕이 출현
                        </div>
                        <div id="content">
                            내용내용내용내용내용내용내용내용내용내용내용내용내
                            <a href="#" id="readMore"> Read more</a>
                        </div>
                    </div>
                    <div class="column" id="column-2">
                        <progress id="progress" value="35000" min="0" max="50000" ></progress>
                        <div id="value"></div>
                        <div id="goal">
                            of 50,000 goal
                        </div>
                    </div>
                </div>
                
            </div>
        </section>
        <section>
            <div>
                <button type="button" id="moreView">더보기</button>
            </div>
        </section>
    </main>




    <footer>
        <article>
                <dl>
                    <dt id="conpany">C O M P A N Y
                    <dd>
                        <a href="#">About</a>
                    </dd>
                    <dd>
                        <a href="#">impact</a>
                    </dd>
                    <dd>
                        <a href="#">Careers</a>
                    </dd>
                    <dd>
                        <a href="#">Team</a>
                    </dd>
                    </dt>
                </dl>    
                <dl>
                    <dt id="community">C O M M U N I T Y
                    <dd>
                        <a href="#">Blog</a>
                    </dd>
                    <dd>
                        <a href="#">Community Guigelines</a>
                    </dd>
                    </dt>
                </dl>
                <dl>    
                    <dt id="support">S U P P O R T
                    <dd>
                        <a href="#">Help</a>
                    </dd>
                    <dd>
                        <a href="#">Guides</a>
                    </dd>
                    <dd>
                        <a href="#">Privacy</a>
                    </dd>
                    <dd>
                        <a href="#">Policies</a>
                    </dd>
                    <dd>
                        <a href="#">Cookies</a>
                    </dd>
                    </dt>
                </dl>
                <dl>    
                    <dt id="connect">C O N N E C T
                    <dd>
                        <a href="#">Twitter</a>
                    </dd>
                    <dd>
                        <a href="#">Facebook</a>
                    </dd>
                    </dt>
                </dl>
        </article>
        <hr>
        <div>
            <p>
                Copyright &copy; KH Information Educational Institute A-Class NoJo
            </p>
        </div>
    </footer>

    <script src="../js/browse_search.js"></script>
</body>
</html>