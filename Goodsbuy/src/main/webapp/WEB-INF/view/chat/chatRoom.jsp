<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
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
    <script src="/webjars/sockjs-client/1.0.2/sockjs.min.js"></script>
    <script src="/webjars/stomp-websocket/2.3.3/stomp.min.js"></script>
    <script src="/js/chat.js"></script>


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
                    <c:forEach var="chatroom" items="${chatroom}">

                    <li id="test">
                        <img src="/multipartImg/profileImage/${chatroom.productImageUrl}" alt="profile">
                        <div>
                            <h2>${chatroom.purchaseNickname}</h2>
                            <h3>
                                <c:choose>
                                    <c:when test="${chatroom.notReadCount > 0}">
                                        <span class="status orange"></span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="status green"></span>
                                    </c:otherwise>
                                </c:choose>
                                <c:set var="formatter" value="yyyy-MM-dd HH:mm:ss" />
                                <c:set var="formattedDate" value="${chatroom.lastModifiedDate.format(formatter)}" />
                                ${formattedDate}
                            </h3>
                        </div>
                        <div id="unread-messages" class="rounded-circle ms-4 text-white text-center"
                             style="width:30px; background-color: #FF725D;">
                            <span class="number ">10+</span>
                        </div>
                    </li>
                    </c:forEach>
                </ul>
            </aside>
            <main>
<%--                <div id="chatDots" class="d-flex h-100 align-items-center justify-content-center text-center" style="font-size: 200px;">--%>
<%--                    <i class="bi bi-chat-dots text-secondary"></i>--%>
<%--                </div>--%>
    <jsp:include page="chatMessage.jsp"></jsp:include>
            </main>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>