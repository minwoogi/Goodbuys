<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>GoodsBuy</title>
    <!-- Favicon-->
    <link rel="shortcut icon" href="/img/fav.ico">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet"/>
    <link href="/css/chat.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="css/sidebar.css">


</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>


<div class="custom-container">
    <div class="custom-sidebar">
        <jsp:include page="../common/sidebar.jsp"></jsp:include>
    </div>

    <div class="custom-content">
        <div id="container" class="mt-5 mb-5">
            <aside id="bside">
                <header>
                    <input type="text" placeholder="search">
                </header>
                <ul id="chatUl">
                    <li id="test">
                        <img src="/multipartImg/productImage/macbook.png" alt="profile">
                        <div>
                            <h2>하요</h2>
                            <h3>
                                <span class="status orange"></span>
                                오후 07:50
                            </h3>
                        </div>
                        <div id="unread-messages" class="rounded-circle ms-4 text-white text-center"
                             style="width:30px; background-color: #FF725D;">
                            <span class="number ">10+</span>
                        </div>
                    </li>
                    <li>
                        <img src="/multipartImg/productImage/airpod.png" alt="profile">
                        <div>
                            <h2>더존</h2>
                            <h3>
                                <span class="status green"></span>
                                오후 05:30
                            </h3>
                        </div>
                    </li>
                    <li>
                        <img src="/multipartImg/productImage/airpod.png" alt="">
                        <div>
                            <h2>더존</h2>
                            <h3>
                                <span class="status orange"></span>
                                offline
                            </h3>
                        </div>
                    </li>
                    <li>
                        <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1940306/chat_avatar_04.jpg" alt="">
                        <div>
                            <h2>더존</h2>
                            <h3>
                                <span class="status green"></span>
                                online
                            </h3>
                        </div>
                    </li>
                    <li>
                        <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1940306/chat_avatar_05.jpg" alt="">
                        <div>
                            <h2>더존</h2>
                            <h3>
                                <span class="status orange"></span>
                                offline
                            </h3>
                        </div>
                    </li>
                    <li>
                        <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1940306/chat_avatar_06.jpg" alt="">
                        <div>
                            <h2>더존</h2>
                            <h3>
                                <span class="status green"></span>
                                online
                            </h3>
                        </div>
                    </li>
                    <li>
                        <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1940306/chat_avatar_07.jpg" alt="">
                        <div>
                            <h2>더존</h2>
                            <h3>
                                <span class="status green"></span>
                                online
                            </h3>
                        </div>
                    </li>
                    <li>
                        <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1940306/chat_avatar_08.jpg" alt="">
                        <div>
                            <h2>더존</h2>
                            <h3>
                                <span class="status green"></span>
                                online
                            </h3>
                        </div>
                    </li>
                    <li>
                        <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1940306/chat_avatar_09.jpg" alt="">
                        <div>
                            <h2>더존</h2>
                            <h3>
                                <span class="status green"></span>
                                online
                            </h3>
                        </div>
                    </li>
                    <li>
                        <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1940306/chat_avatar_10.jpg" alt="">
                        <div>
                            <h2>더존맨</h2>
                            <h3>
                                <span class="status orange"></span>
                                offline
                            </h3>
                        </div>
                    </li>
                </ul>
            </aside>
            <main>
                <header>
                    <img src="/multipartImg/productImage/macbook.png" alt="" style="width: 55px; height: 55px">
                    <div>
                        <h2>하요</h2>
                        <h3>오후 07:50</h3>
                    </div>
                </header>
                <ul id="chat">
                    <li class="you">
                        <div class="entete">
                            <span class="status green"></span>
                            <h2>Vincent</h2>
                            <h3>10:12AM, Today</h3>
                        </div>
                        <div class="triangle"></div>
                        <div class="message">
                            에어팟 구매하고싶은데요?
                        </div>
                    </li>
                    <li class="me">
                        <div class="entete">
                            <h3>10:12AM, Today</h3>
                            <h2>Vincent</h2>
                            <span class="status blue"></span>
                        </div>
                        <div class="triangle"></div>
                        <div class="message">
                            싫어용
                        </div>
                    </li>
                    <li class="me">
                        <div class="entete">
                            <h3>10:12AM, Today</h3>
                            <h2>Vincent</h2>
                            <span class="status blue"></span>
                        </div>
                        <div class="triangle"></div>
                        <div class="message">
                            메세지당
                        </div>
                    </li>
                    <li class="you">
                        <div class="entete">
                            <span class="status green"></span>
                            <h2>Vincent</h2>
                            <h3>10:12AM, Today</h3>
                        </div>
                        <div class="triangle"></div>
                        <div class="message">
                            네고 가능한가여???네고 가능한가여???네고 가능한가여???네고 가능한가여???
                        </div>
                    </li>
                    <li class="me">
                        <div class="entete">
                            <h3>10:12AM, Today</h3>
                            <h2>Vincent</h2>
                            <span class="status blue"></span>
                        </div>
                        <div class="triangle"></div>
                        <div class="message">
                            출근 하자
                        </div>
                    </li>
                    <li class="me">
                        <div class="entete">
                            <h3>10:12AM, Today</h3>
                            <h2>Vincent</h2>
                            <span class="status blue"></span>
                        </div>
                        <div class="triangle"></div>
                        <div class="message">
                            OK
                        </div>
                    </li>
                </ul>
                <footer>
                    <textarea placeholder="Type your message"></textarea>
                    <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1940306/ico_picture.png" alt="">
                    <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1940306/ico_file.png" alt="">
                    <a href="#">Send</a>
                </footer>
            </main>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>