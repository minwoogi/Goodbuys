<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<header id="messageHeader">
    <img src="/img/profile.png" alt="" style="width: 55px; height: 55px">
    <div>
        <h2><a href="#" style="text-decoration: none; color: inherit;">닉네임</a></h2>
        <h3>생성일</h3>
    </div>
</header>
<ul id="chat">
    <div class="container pt-3">
        <div class="row ps-4 pb-1">
            <div class="col-auto">
                <div>
                    <img src="/img/noProduct.png" style="height: 55px; width: 55px">
                </div>
            </div>
            <div class="col">
                <div class="pt-1" id="productInfo">
                    <a href="#" style="text-decoration: none; color: inherit;">상품이름</a><br>
                    <fmt:formatNumber type="number" value="상품가격"
                                      pattern="#,###원"/>
                </div>
            </div>
        </div>
        <hr class="my-2">
    </div>
</ul>
<footer>
    <textarea id="content" placeholder="Type your message"></textarea>
    <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1940306/ico_picture.png" alt="">
    <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1940306/ico_file.png" alt="">
    <a id="send-button">Send</a>
</footer>