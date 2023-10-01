<%--<a href="https://www.flaticon.com/kr/free-animated-icons/" title="이메일 애니메이션 아이콘">
    이메일 애니메이션 아이콘 제작자: Freepik - Flaticon</a>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko" data-dark="false" class="root">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>GoodsBuy</title>
    <link rel="shortcut icon" href="/img/fav.ico">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="/css/sidebar.css">
    <link rel="stylesheet" type="text/css" href="/css/nicknameUpdate.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>


</head>
<body style="background-color: #EEEEEE">
<jsp:include page="../common/header.jsp"></jsp:include>


<div class="custom-container">
    <div class="custom-sidebar">
        <jsp:include page="../common/sidebar.jsp"></jsp:include>
    </div>
    <div class="custom-content">

        <div class="img-div">
            <img alt="profile" width="400" src="/img/email.gif">
        </div>

        <div class="lbl-div">
            <i>이메일 등록 및 변경</i>
        </div>

        <div class="input-div">
            <c:choose>
                <c:when test="${not empty memberProfile.email}">
                    <div class="lbl-div">
                        <input id="email" name="email" type="text"
                               value="등록한 이메일 : ${memberProfile.email}" disabled style="margin-top:1em; ">
                    </div>
                    <button id="nickCheck" class="btn btn-primary btn-block mt-5" type="button">이메일 변경</button>
                </c:when>
                <c:otherwise>
                    <button id="nickCheck" class="btn btn-primary btn-block mt-2" type="button">이메일 등록</button>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="btn-div">

        </div>


    </div>
</div>

<jsp:include page="../common/footer.jsp"></jsp:include>

<script>
    document.getElementById("nickCheck").addEventListener("click", function () {
        var redirectTo = "/email";
        window.location.href = redirectTo;
    });
</script>


</script>

</body>
</html>


