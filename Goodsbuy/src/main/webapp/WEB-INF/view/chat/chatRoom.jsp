<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.time.LocalDate" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


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
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
                        <li id="test" onclick="enterChatRoom(${chatroom.chatRoomNo},${sessionScope.loginMember.userNo})">
                        <c:choose>
                            <c:when test="${sessionScope.loginMember.userNo eq chatroom.userNo}"> <%--내가 판매자일때--%>
                                <img src="/multipartImg/profileImage/${chatroom.purchaseProfileUrl}" alt="profile">
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
                                        <c:set var="formattedDate" value="${chatroom.lastModifiedDate}"/>
                                        <fmt:formatDate value="${formattedDate}" pattern="yyyy-MM-dd"
                                                        var="formattedDateDate"/>
                                        <fmt:formatDate value="${formattedDate}" pattern="HH:mm:ss"
                                                        var="formattedDateTime"/>
                                        <c:set var="todayDate" value="<%= LocalDate.now() %>"/>
                                        <c:choose>
                                            <c:when test="${formattedDateDate == todayDate}">
                                                <!-- 오늘인 경우: 시간만 표시 -->
                                                ${formattedDateTime}
                                            </c:when>
                                            <c:otherwise>
                                                <!-- 오늘이 아닌 경우: 날짜만 표시 -->
                                                ${formattedDateDate}
                                            </c:otherwise>
                                        </c:choose>
                                    </h3>
                                </div>
                                <c:choose>
                                    <c:when test="${chatroom.notReadCount > 0 and chatroom.notReadCount < 10}">
                                        <div id="unread-messages" class="rounded-circle ms-4 text-white text-center"
                                             style="width:25px; background-color: #FF725D;">
                                            <span class="number ">${chatroom.notReadCount}</span>
                                        </div>
                                    </c:when>
                                    <c:when test="${chatroom.notReadCount >= 10 }">
                                        <div id="unread-messages" class="rounded-circle ms-4 text-white text-center"
                                             style="width:30px; background-color: #FF725D;">
                                            <span class="number ">10+</span>
                                        </div>
                                    </c:when>
                                </c:choose>
                                </li>
                            </c:when>


                            <c:otherwise> <%--내가 구매자일때--%>
                                <img src="/multipartImg/profileImage/${chatroom.userProfileUrl}" alt="profile">
                                <div>
                                    <h2>${chatroom.userNickname}</h2>
                                    <h3>
                                        <c:choose>
                                            <c:when test="${chatroom.notReadCount > 0}">
                                                <span class="status orange"></span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="status green"></span>
                                            </c:otherwise>
                                        </c:choose>
                                        <c:set var="formattedDate" value="${chatroom.lastModifiedDate}"/>
                                        <fmt:formatDate value="${formattedDate}" pattern="yyyy-MM-dd"
                                                        var="formattedDateDate"/>
                                        <fmt:formatDate value="${formattedDate}" pattern="HH:mm:ss"
                                                        var="formattedDateTime"/>
                                        <c:set var="todayDate" value="<%= LocalDate.now() %>"/>
                                        <c:choose>
                                            <c:when test="${formattedDateDate == todayDate}">
                                                <!-- 오늘인 경우: 시간만 표시 -->
                                                ${formattedDateTime}
                                            </c:when>
                                            <c:otherwise>
                                                <!-- 오늘이 아닌 경우: 날짜만 표시 -->
                                                ${formattedDateDate}
                                            </c:otherwise>
                                        </c:choose>
                                    </h3>
                                </div>
                                <c:choose>
                                    <c:when test="${chatroom.notReadCount > 0 and chatroom.notReadCount < 10}">
                                        <div id="unread-messages" class="rounded-circle ms-4 text-white text-center"
                                             style="width:25px; background-color: #FF725D;">
                                            <span class="number ">${chatroom.notReadCount}</span>
                                        </div>
                                    </c:when>
                                    <c:when test="${chatroom.notReadCount >= 10 }">
                                        <div id="unread-messages" class="rounded-circle ms-4 text-white text-center"
                                             style="width:30px; background-color: #FF725D;">
                                            <span class="number ">10+</span>
                                        </div>
                                    </c:when>
                                </c:choose>
                                </li>
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>
                </ul>
            </aside>
            <main>
                <div id="chatDots" class="d-flex h-100 align-items-center justify-content-center text-center"
                     style="font-size: 200px;">
                    <i class="bi bi-chat-dots text-secondary"></i>
                </div>

                <div id="chatMessage" style="display: none;">
                    <jsp:include page="chatMessage.jsp"></jsp:include>
                </div>

            </main>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>