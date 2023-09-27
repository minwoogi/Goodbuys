<%@ page import="com.tu.goodsbuy.model.dto.MemberUser" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<!DOCTYPE html>--%>
<%--<html lang="ko" data-dark="false" class="root">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"--%>
<%--          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">--%>
<%--    <title>GoodsBuy</title>--%>

<%--</head>--%>
<%--<body>--%>
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
                        글쓰기
                    </button>
                </div>
                <%}%>
            </form>
        </div>
    </div>
</nav>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        const logOutLink = document.getElementById('logOut');

        if (logOutLink) {
            logOutLink.addEventListener('click', function (event) {
                event.preventDefault(); // 링크의 기본 동작 중지

                Swal.fire({
                    title: '로그아웃',
                    text: '정말로 로그아웃하시겠습니까?',
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonText: '확인',
                    cancelButtonText: '취소'
                }).then((result) => {
                    if (result.isConfirmed) {
// 사용자가 확인을 눌렀을 때 POST 요청 전송
                        const form = document.createElement('form');
                        form.method = 'POST';
                        form.action = '/logout.do';
                        document.body.appendChild(form);
                        form.submit();
                    }
                });
            });
        }
    });
</script>
<%--</body>--%>
<%--</html>--%>