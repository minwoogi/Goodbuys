<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<header>
    <img src="/multipartImg/productImage/macbook.png" alt="" style="width: 55px; height: 55px">
    <div>
        <h2><a href="#" style="text-decoration: none; color: inherit;">하요</a></h2>
        <h3>오후 07:50</h3>
    </div>
</header>

<ul id="chat">
    <div class="container pt-3">
        <div class="row ps-4 pb-1">
            <div class="col-auto">
                <div>
                    <img src="/img/profile.png" style="height: 55px; width: 55px">
                </div>
            </div>
            <div class="col">
                <div class="pt-1" id="productInfo">
                    <a href="#" style="text-decoration: none; color: inherit;">에어팟3세대 맥세이프 미개봉</a><br>
                    35,000원
                </div>
            </div>
        </div>
        <hr class="my-2">
    </div>
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
    <a id="send-button">Send</a>
</footer>