<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko" data-dark="false" class="root">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>GoodsBuy</title>
    <link rel="shortcut icon" href="/img/fav.ico">
    <link rel="stylesheet" type="text/css" href="/css/sidebar.css">
    <link rel="stylesheet" type="text/css" href="/css/content.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
</head>
<body style="background-color: #EEEEEE">
<jsp:include page="../common/header.jsp"></jsp:include>

<div class="custom-container">
    <div class="custom-sidebar">
        <jsp:include page="../common/sidebar.jsp"></jsp:include>
    </div>
    <div class="custom-content">
        <div class="scrollable">
            <div class="list pt-5 ">
                관심목록
            </div>

            <section class="py-5">
                <div class="container px-4 px-lg-5 mt-5">
                    <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">

                        <c:choose>
                            <c:when test="${not empty dibsProductList}">
                                <c:forEach var="product" items="${dibsProductList}">
                                    <div class="col mb-5">
                                        <div class="card h-100">
                                            <!-- Product image-->
                                            <img class="card-img-top"
                                                 src="/multipartImg/productImage/${product.productImageUrl}"
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
                                                <div class="text-center"><a class="btn btn-outline-dark mt-auto"
                                                                            href="/product/${product.productNo}">상품보기</a>
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

                    </div>
                </div>
            </section>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>


</body>
</html>