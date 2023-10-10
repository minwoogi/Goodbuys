<%@ page import="com.tu.goodsbuy.model.dto.MemberUser" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                            <%--                            src="https://dummyimage.com/600x700/dee2e6/6c757d.jpg"--%>
                            src="/img/noProductInfo.png"
                        </c:otherwise>
                    </c:choose> alt="..."/></div>
            <div class="col-md-6">
                <div class="small mb-1">${product.nickname}님</div>
                <h1 class="display-5 fw-bolder">${product.productName}</h1>
                <c:choose>
                    <c:when test="${product.saleState == 1}">
                        <br><h2 class="text-danger">판매완료</h2>
                    </c:when>
                </c:choose>
                <div class="fs-5 mb-5">
                    <span><br> <i class="bi bi-heart-fill"></i> ${dibsCount}&nbsp;&nbsp;|
                        <i class="bi bi-eye-fill"></i> ${product.view}&nbsp;&nbsp;|
                        <i class="bi bi-clock-fill"></i> 17시간전<br><br></span>
                    <span id="priceSpan">
                        <fmt:formatNumber type="number" value="${product.productPrice}"
                                          pattern="#,###원"/><br>
                    </span>
                </div>
                <p class="lead"> ${product.productInfo}</p>

                <c:set var="userNo" value="${loginMember.userNo}"/>
                <c:choose>
                    <c:when test="${userNo eq product.userNo}">
                        <div class="d-grid gap-3 d-sm-flex justify-content-sm-center justify-content-xl-start">
                            <a id="modifyBtn" class="btn btn-primary btn-lg px-4 me-sm-3"
                               href="/product/update?productNo=${productNo}">
                                수정하기 <i class="bi bi-receipt"></i></a>
                            <a id="deleteBtn" class="btn btn-primary btn-lg px-4 me-sm-3" href="#"
                               onclick="confirmAndRedirect('삭제 하시겠습니까?'
                                       ,'/product/delete.do','productNo','${productNo}','info');">
                                삭제하기 <i class="bi bi-trash"></i></a>

                            <c:choose>
                                <c:when test="${product.saleState == 0}">
                                    <a id="soldOutBtn" class="btn btn-primary btn-lg px-4 me-sm-3" href="#"
                                       onclick="confirmAndRedirect('이 상품을 더 이상 판매하지 않을까요?'
                                               ,'/product/soldOut.do','productNo','${productNo}','info');">
                                        판매완료 <i class="bi bi-flag"></i></a>
                                </c:when>
                            </c:choose>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="d-grid gap-3 d-sm-flex justify-content-sm-center justify-content-xl-start">
                            <a id="chatBtn" class="btn btn-primary btn-lg px-4 me-sm-3" href="#features">채팅하기</a>
                            <a class="btn btn-outline-light btn-lg px-4" href="#!" style="background-color: #4E00FF"
                                    <c:choose>
                                        <c:when test="${!dibsState}">
                                            onclick="confirmAndRedirect('상품을 찜하시겠습니까?',
                                            '/product/dibs','productNoDibsState','${productNo}/0','info')"> 찜 하기 <i
                                                class="bi bi-heart"></i>
                                        </c:when>
                                        <c:otherwise>
                                            onclick="confirmAndRedirect('관심상품에서 제외시키겠습니까?',
                                            '/product/dibs','productNoDibsState','${productNo}/1','info')"> 찜 해제 <i
                                                class="bi bi-heart-fill"></i>
                                        </c:otherwise>
                                    </c:choose>
                            </a>
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
                                <c:choose>
                                    <c:when test="${product.saleState == 1}">
                                        <div class="badge bg-dark text-white position-absolute"
                                             style="top: 0.5rem; right: 0.5rem">판매완료
                                        </div>
                                    </c:when>
                                </c:choose>
                                <!-- Product image-->
                                <img class="card-img-top"
                                        <c:choose>
                                            <c:when test="${not empty product.productImageUrl}">
                                                src="/multipartImg/productImage/${product.productImageUrl}"
                                            </c:when>
                                            <c:otherwise>
                                                <%--src="https://dummyimage.com/500x500/dee2e6/6c757d.jpg"--%>
                                                src="/img/noProduct.png"
                                            </c:otherwise>
                                        </c:choose>
                                     alt="..."/>
                                <!-- Product details-->
                                <div class="card-body p-4">
                                    <div class="text-center">
                                        <h5 class="fw-bolder"><c:out value="${product.productName}"/></h5>

                                        <fmt:formatNumber type="number" value="${product.productPrice}"
                                                          pattern="#,###원"/><br>
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
    function confirmAndRedirect(msg, path, name, value, icon) {
        Swal.fire({
            title: msg,
            icon: icon,
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
