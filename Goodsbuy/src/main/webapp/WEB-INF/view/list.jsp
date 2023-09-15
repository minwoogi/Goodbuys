<%@ page import="com.tu.goodsbuy.model.dto.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Objects" %>
<%@ page import="com.tu.goodsbuy.model.dto.MemberUser" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>GoodsBuy</title>
    <!-- Favicon-->
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link href="/css/list.css" rel="stylesheet"/>

</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<!-- Navigation-->
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
                        <li class="nav-item"><a id="logOut" href="/logOut.do" class="nav-link"
                                                aria-current="page">로그아웃</a></li>
                        <li class="nav-item"><a class="nav-link" href="/goodsbuy/profile">마이페이지</a></li>
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
<header class="py-1">
    <div class="container px-3 px-lg-3 my-5">
        <div class="text-center text-white">
            <div id="carouselExampleFade" class="carousel slide carousel-fade" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="/img/banner1.png" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="/img/banner2.png" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="/img/banner3.png" class="d-block w-100" alt="...">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
    </div>
</header>

<%--</header>--%>
<!-- Section-->

<!-- test -->
<a><%
    if (Objects.nonNull(loginUser)) {
        String location = (String) session.getAttribute("location");
%>
    설정된 동네: <%=location%>
    <%}%></a>


<section class="py-5">
    <div class="container px-4 px-lg-5 mt-5">
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
            <%if (Objects.isNull(loginUser)) {%>
            <div id="goodsBox">
                <span id="lock_img"></span><br><br>
                <strong id="need_login">로그인 후에 이 서비스를 이용하실 수 있습니다.</strong>
            </div>
            <%
            } else {%>

            <c:choose>
                <c:when test="${not empty productList}">
                    <c:forEach var="product" items="${productList}">
                        <div class="col mb-5">
                            <div class="card h-100">
                                <!-- Product image-->
                                <img class="card-img-top" src="https://dummyimage.com/500x500/dee2e6/6c757d.jpg"
                                     alt="..."/>
                                <!-- Product details-->
                                <div class="card-body p-4">
                                    <div class="text-center">
                                        <!-- Product name-->
                                        <h5 class="fw-bolder"><c:out value="${product.productName}"/></h5>
                                        <!-- Product price-->
                                        <c:out value="${product.productPrice}"/> <br>
                                        <c:out value="${product.nickname}"/>
                                    </div>
                                </div>
                                <!-- Product actions-->
                                <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                    <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">상품보기</a>
                                    </div>
                                </div>
                            </div>
                        </div>


                    </c:forEach>
                </c:when>
                <c:otherwise>
                    ${noProduct}
                </c:otherwise>
            </c:choose>
            <%}%>


        </div>
    </div>
</section>

<!-- Footer-->
<footer class="py-5 bg-dark">
    <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Goodsbuy</p></div>
</footer>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->

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
                        form.action = '/logOut.do';
                        document.body.appendChild(form);
                        form.submit();
                    }
                });
            });
        }
    });
</script>

</body>
</html>