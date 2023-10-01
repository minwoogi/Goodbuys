<%--<a href="https://www.flaticon.com/kr/free-animated-icons/" title="위치 애니메이션 아이콘">
    위치 애니메이션 아이콘 제작자: Freepik - Flaticon</a>--%>
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
            <img alt="profile" width="400" src="/img/location.gif">
        </div>

        <div class="lbl-div">
            <i>지역 설정</i>
        </div>

        <div class="input-div">
            <div class="lbl-div">
                <input id="location" name="location" type="text"
                <c:if test="${not empty memberProfile.location}">
                       value="설정된 동네 : ${memberProfile.location}"
                </c:if>
                       disabled style="margin-top:1em; text-align: center; width: auto ">
            </div>
            <select class="form-select mx-auto mt-4" style="width: 20%; font-size: 1em">
                <option value="부산광역시">부산광역시</option>
                <option value="대구광역시">대구광역시</option>
                <option value="인천광역시">인천광역시</option>
                <option value="광주광역시">광주광역시</option>
                <option value="대전광역시">대전광역시</option>
                <option value="울산광역시">울산광역시</option>
                <option value="세종특자치시">세종특자치시</option>
                <option value="경기도">경기도</option>
                <option value="강원특별자치도">강원특별자치도</option>
                <option value="충청북도">충청북도</option>
                <option value="충청남도">충청남도</option>
                <option value="전라북도">전라북도</option>
                <option value="전라남도">전라남도</option>
                <option value="경상북도">경상북도</option>
                <option value="경상남도">경상남도</option>
                <option value="제주특별자치도">제주특별자치도</option>
            </select>
        </div>

        <div class="btn-div">
            <button id="nickCheck" class="btn btn-primary btn-block" type="button">변경하기</button>
        </div>


    </div>
</div>

<jsp:include page="../common/footer.jsp"></jsp:include>


<script>
    document.getElementById("nickCheck").addEventListener("click", function () {

        var selectedLocation = document.querySelector(".form-select").value;


        var form = document.createElement("form");
        form.setAttribute("method", "POST");
        form.setAttribute("action", "/profile/location");

        // 선택한 지역 값을 hidden input 필드로 추가
        var input = document.createElement("input");
        input.setAttribute("type", "hidden");
        input.setAttribute("name", "location");
        input.setAttribute("value", selectedLocation);

        form.appendChild(input);
        document.body.appendChild(form);
        form.submit();
    });

</script>
</body>
</html>


