<%@ page import="com.tu.goodsbuy.model.dto.MemberUser" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Goodsbuy</title>


    <link rel="shortcut icon" href="/img/fav.ico">
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/productInfo.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<jsp:include page="../common/header.jsp"></jsp:include>

<header class="bg-dark py-5">
    <div class="container px-5">
        <div class="row gx-5 align-items-center justify-content-center">
            <div class="col-lg-8 col-xl-7 col-xxl-6">
                <div class="my-5 text-center text-xl-start">
                    <h1 class="display-5 fw-bolder text-white mb-2">${product.productName}</h1>
                    <p class="lead fw-normal text-white-50 mb-4">${product.nickname}</p>
                    <p class="lead fw-normal text-white-50 mb-4">
                        <i class="bi bi-heart-fill"></i> ${dibsCount}&nbsp;&nbsp;|
                        <i class="bi bi-eye-fill"></i> ${product.view}&nbsp;&nbsp;|
                        <i class="bi bi-clock-fill"></i> 17시간전
                    </p>

                    <c:set var="userNo" value="${loginMember.userNo}"/>

                    <c:choose>
                        <c:when test="${userNo eq product.userNo}">
                            <div class="d-grid gap-3 d-sm-flex justify-content-sm-center justify-content-xl-start">
                                <a id="modifyBtn" class="btn btn-primary btn-lg px-4 me-sm-3" href="#features">
                                    수정하기 <i class="bi bi-cloud-arrow-up"></i></a>
                                <a id="deleteBtn" class="btn btn-primary btn-lg px-4 me-sm-3" href="#"
                                   onclick="confirmAndRedirect('삭제 하시겠습니까?'
                                           ,'/product/delete.do','productNo','${productNo}');">
                                    삭제하기 <i class="bi bi-trash"></i></a>
                            </div>
                        </c:when>
                        <c:otherwise>

                            <div class="d-grid gap-3 d-sm-flex justify-content-sm-center justify-content-xl-start">
                                <a id="chatBtn" class="btn btn-primary btn-lg px-4 me-sm-3" href="#features">채팅하기</a>
                                <a class="btn btn-outline-light btn-lg px-4" href="#!">찜하기 <i
                                        class="bi bi-heart"></i></a>
                            </div>
                        </c:otherwise>
                    </c:choose>

                </div>
            </div>
            <%--<div class="col-xl-5 col-xxl-6 d-none d-xl-block text-center"><img class="img-fluid rounded-3 my-5"
                                                                               src="https://dummyimage.com/600x400/343a40/6c757d"
                                                                               alt="..."/></div>--%>
            <div class="col-xl-5 col-xxl-6 d-none d-xl-block text-center">
                <div id="carouselExampleFade" class="carousel slide carousel-fade" data-bs-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="https://dummyimage.com/600x400/343a40/6c757d" class="d-block w-100" alt="...">
                        </div>
                        <div class="carousel-item">
                            <img src="/multipartImg/productImage/test.png" width="600" height="400"
                                 class="d-block w-100" alt="...">
                        </div>
                        <div class="carousel-item">
                            <img src="/img/banner3.jpg" width="600" height="400" class="d-block w-100" alt="...">
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade"
                            data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade"
                            data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </div>
        </div>
    </div>
</header>

<div class="py-5 bg-light">
    <div class="container px-5 my-5">
        <div class="row gx-5 justify-content-center">
            <div class="col-lg-10 col-xl-7">
                <div class="text-center">
                    <h1 id="jinvley">상품 정보</h1>
                    <hr class="my-2">


                    <div id="info" class="fs-4 m-4">
                        ${product.productInfo}
                    </div>
                    <div class="d-flex align-items-center justify-content-center">
                        <img class="rounded-circle me-3" src="https://dummyimage.com/40x40/ced4da/6c757d" alt="..."/>
                        <div class="fw-bold">
                            ${product.nickname}
                            <span class="fw-bold text-primary mx-1">/</span>
                            ${product.location} <i class="bi bi-geo-alt"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    function confirmAndRedirect(msg, path, name, value) {
        Swal.fire({
            title: msg,
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: '확인',
            cancelButtonText: '취소'
        }).then((result) => {
            if (result.isConfirmed) {

                const form = document.createElement('form');
                form.method = 'POST';
                form.action = path;
                form.style.display = 'none';

                const productNoInput = document.createElement('input');
                productNoInput.type = 'hidden';
                productNoInput.name = name;
                productNoInput.value = value;
                form.appendChild(productNoInput);
                // Append the form to the body and submit
                document.body.appendChild(form);
                form.submit();
            }
        });
    }
</script>
</body>
</html>
