<%@ page import="com.tu.goodsbuy.dto.Item" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Objects" %>
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
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="/css/list.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@10">

</head>
<body>
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
                <%--                <li class="nav-item dropdown">--%>
                <%--                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>--%>
                <%--                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">--%>
                <%--                        <li><a class="dropdown-item" href="#!">All Products</a></li>--%>
                <%--                        <li><hr class="dropdown-divider" /></li>--%>
                <%--                        <li><a class="dropdown-item" href="#!">Popular Items</a></li>--%>
                <%--                        <li><a class="dropdown-item" href="#!">New Arrivals</a></li>--%>
                <%--                    </ul>--%>
                <%--                </li>--%>
            </ul>
            <form class="d-flex m-3 mb-3">
                <div class="p-2">
                    <input class="form-control form-control-sm w-auto" type="search" placeholder="검색창"
                           aria-label="Search">
                </div>

                <% if (request.getSession().getAttribute("loginMember") == null) {%>
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
<!-- Header class="bg-dark py-5"-->
<header style="height: 400px; width: 1235px; margin: 0 auto; text-align: center; overflow: hidden">
    <%--    <div class="container px-4 px-lg-5 my-5">--%>
    <%--        <div class="text-center text-white">--%>
    <%--            --%>
    <%--            <h1 class="display-4 fw-bolder">배너</h1>--%>
    <%--            <p class="lead fw-normal text-white-50 mb-0">배너가 들어가는 공간입니다.</p>--%>
    <%--        </div>--%>
    <%--    </div>--%>
    <img alt="banner" src="/img/bannerImsi.png" style="width: 100%; height: 100%; object-fit: cover">


</header>
<!-- Section-->
<section class="py-5">
    <div class="container px-4 px-lg-5 mt-5">
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
            <%if (Objects.isNull(request.getSession().getAttribute("loginMember"))) {%>
            <%} else {%>
            <div class="col mb-5">
                <div class="card h-100">
                    <!-- Product image-->
                    <img class="card-img-top" src="https://dummyimage.com/500x500/dee2e6/6c757d.jpg" alt="..."/>
                    <!-- Product details-->
                    <div class="card-body p-4">
                        <div class="text-center">
                            <!-- Product name-->
                            <h5 class="fw-bolder">상품1</h5>
                            <!-- Product price-->
                            10,000원<br>
                            남구 대연동<br>
                            찜 1 · 채팅 5
                        </div>
                    </div>
                    <!-- Product actions-->
                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">상품보기</a></div>
                    </div>
                </div>
            </div>
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
<script src="/js/scripts.js" type="application/javascript"></script>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        const logOutLink = document.getElementById('logOut');

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
    });
</script>

</body>
</html>