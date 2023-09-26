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
    <link rel="shortcut icon" href="/img/fav.ico">
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="/css/list.css" rel="stylesheet"/>


</head>
<body>
<!-- Navigation-->
<jsp:include page="../common/header.jsp"></jsp:include>
<header class="py-1">
    <div class="container px-3 px-lg-3 my-5">
        <div class="text-center text-white">
            <div id="carouselExampleFade" class="carousel slide carousel-fade" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="/img/banner2.png" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="/img/banner2.jpg" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="/img/banner3.jpg" class="d-block w-100" alt="...">
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
</header>


<% MemberUser loginUser = (MemberUser) request.getSession(false).getAttribute("loginMember");%>
<div class="container px-1 px-lg-5 mt-1" id="selected_location">
    <a><%
        if (Objects.nonNull(loginUser)) {
            String location = (String) session.getAttribute("location");
    %>
        <i class="bi bi-geo-alt-fill"></i> &nbsp;설정된 동네: <%=location%>
        <%}%></a>
</div>

<section class="py-5">
    <div class="container px-4 px-lg-5 mt-5">
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
            <%if (Objects.isNull(loginUser)) {%>
            <div id="goodsBox">
                <span id="lock_img"></span><br><br>
                <strong id="need_login">로그인 후에 이 서비스를 이용하실 수 있습니다.</strong>
            </div>
            <%
            }else if((Integer)request.getAttribute("emailCheck") == 0){%>
            <div id="goodsBox">
                <span id="lock_img2"></span><br><br>
                <strong id="need_auth">이메일 인증 후에 이 서비스를 이용하실 수 있습니다.</strong>
            </div>

            <%}
            else {%>

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

<jsp:include page="../common/footer.jsp"></jsp:include>

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

</body>
</html>