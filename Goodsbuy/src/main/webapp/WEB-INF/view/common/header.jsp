<%@ page import="com.tu.goodsbuy.model.dto.MemberUser" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko" data-dark="false" class="root">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://unpkg.com/@popperjs/core@2"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.js"
            integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
    <title>GoodsBuy</title>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="/goodsbuy/list">
            <img alt="mainLogo" width="200" src="/img/mainLogo.png" title="goodsbuy"
                 class="d-inline-block align-text-top">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item"><a class="nav-link" aria-current="page" href="#!">카테고리</a></li>
                <li class="nav-item"><a class="nav-link" href="#!">동네소식</a></li>
                <li class="nav-item"><a class="nav-link" href="#!">알바</a></li>
            </ul>
            <form class="d-flex m-3 mb-3" action="/goodsbuy/list/search" method="get">
                <div class="p-2">
                    <input name="productName" class="form-control form-control-sm w-auto" type="search"
                           placeholder="상품명 검색"
                           aria-label="Search" maxlength='18'
                    <c:if test="${not empty searchProductName}">
                           value="${searchProductName}"
                    </c:if>>
                </div>

                <% MemberUser loginUser = (MemberUser) request.getSession(false).getAttribute("loginMember");
                    if (Objects.isNull(loginUser)) {
                %>
                <div class="p-1">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a href="/login" class="nav-link" aria-current="page">로그인</a></li>
                        <li class="nav-item"><a class="nav-link" href="/register">회원가입</a></li>
                    </ul>
                </div>
                <%} else {%>

                <div class="p-1">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a id="logOut" href="/logout.do" class="nav-link"
                                                aria-current="page">로그아웃</a></li>
                        <li class="nav-item"><a class="nav-link" href="/profile">마이페이지</a></li>
                    </ul>
                </div>
                <div class="p-1">
                    <button type="button" class="btn" style="background-color: #4E00FF; color: white;">
                        <%--                    <i class="bi-cart-fill me-1"></i>--%>
                        글쓰기
                        <%--                    <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>--%>
                    </button>
                </div>
                <%}%>
            </form>
        </div>
    </div>
</nav>
</body>
</html>