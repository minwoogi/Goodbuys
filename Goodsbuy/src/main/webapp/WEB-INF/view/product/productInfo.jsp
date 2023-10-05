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
<section class="py-5">
    <div class="container px-4 px-lg-5 my-5">
        <div class="row gx-4 gx-lg-5 align-items-center">
            <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0"
                    <c:choose>
                        <c:when test="${not empty product.productImageUrl}">
                            src="/multipartImg/productImage/${product.productImageUrl}"
                        </c:when>
                        <c:otherwise>
                            src="https://dummyimage.com/600x700/dee2e6/6c757d.jpg"
                        </c:otherwise>
                    </c:choose> alt="..."/></div>
            <div class="col-md-6">
                <div class="small mb-1">${product.nickname}님</div>
                <h1 class="display-5 fw-bolder">${product.productName}</h1>
                <div class="fs-5 mb-5">
                    <span><br> <i class="bi bi-heart-fill"></i> ${dibsCount}&nbsp;&nbsp;|
                        <i class="bi bi-eye-fill"></i> ${product.view}&nbsp;&nbsp;|
                        <i class="bi bi-clock-fill"></i> 17시간전<br><br></span>
                    <span id="priceSpan"><script>
                        function formatKoreanCurrency(number, id) {
                            document.getElementById(id).textContent = new Intl.NumberFormat('ko-KR').format(number) + '원';
                        }

                        formatKoreanCurrency(${product.productPrice}, 'priceSpan');
                    </script></span>
                </div>
                <p class="lead"> ${product.productInfo}</p>

                <c:set var="userNo" value="${loginMember.userNo}"/>
                <c:choose>
                    <c:when test="${userNo eq product.userNo}">

                        <div class="d-grid gap-3 d-sm-flex justify-content-sm-center justify-content-xl-start">
                            <a id="modifyBtn" class="btn btn-primary btn-lg px-4 me-sm-3"
                               href="/product/update?productNo=${productNo}">
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
                            <a class="btn btn-outline-light btn-lg px-4" href="#!" style="background-color: #4E00FF">찜하기
                                <i
                                        class="bi bi-heart"></i></a>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</section>
<section class="py-5 bg-light">
    <div class="container px-4 px-lg-5 mt-5">
        <h2 class="fw-bolder mb-4">다른 상품</h2>
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">

            <c:choose>
                <c:when test="${not empty productList}">
                    <c:forEach var="product" items="${productList}">
                        <div class="col mb-5">
                            <div class="card h-100">


                                <!-- Product image-->
                                <img class="card-img-top"
                                        <c:choose>
                                            <c:when test="${not empty product.productImageUrl}">
                                                src="/multipartImg/productImage/${product.productImageUrl}"
                                            </c:when>
                                            <c:otherwise>
                                                src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg"
                                            </c:otherwise>
                                        </c:choose>
                                     alt="..."/>
                                <!-- Product details-->
                                <div class="card-body p-4">
                                    <div class="text-center">
                                        <h5 class="fw-bolder"><c:out value="${product.productName}"/></h5>
                                        <c:out value="${product.productPrice}"/> <br>
                                        <c:out value="${product.nickname}"/>
                                    </div>
                                </div>
                                <!-- Product actions-->
                                <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                    <div class="text-center"><a class="btn btn-outline-dark mt-auto"
                                                                href="/product/${product.productNo}">
                                        상품보기</a></div>
                                </div>
                            </div>
                        </div>


                    </c:forEach>
                </c:when>
                <c:otherwise>
                    등록된 상품이 없습니다.
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</section>
<jsp:include page="../common/footer.jsp"></jsp:include>

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
