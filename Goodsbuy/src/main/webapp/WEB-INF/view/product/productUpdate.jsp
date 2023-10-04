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
    <link rel="stylesheet" href="/css/productUpdate.css">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<jsp:include page="../common/header.jsp"></jsp:include>

<header class="bg-dark py-5">
    <div class="container px-5">
        <div class="row gx-5 align-items-center justify-content-center">
            <div class="col-lg-8 col-xl-7 col-xxl-6">
                <div class="my-5 text-center text-xl-start">
                    <h3 class="display-10 fw-bolder text-white mb-2">상품 제목 수정</h3>
                    <input class="input-form bg-dark" placeholder="${product.productName}" required style="font-size: 36px">

                    <h3 class="display-10 fw-bolder text-white mb-2"><br>상품 가격 수정</h3>
                    <input class="input-form bg-dark" placeholder="${product.productPrice}" required style="font-size: 36px">

                    <p class="lead fw-normal text-white-50 mb-4"><br>${product.nickname}</p>
                    <p class="lead fw-normal text-white-50 mb-4">
                        <i class="bi bi-heart-fill"></i> ${dibsCount}&nbsp;&nbsp;|
                        <i class="bi bi-eye-fill"></i> ${product.view}&nbsp;&nbsp;|
                        <i class="bi bi-clock-fill"></i> 17시간전
                    </p>

                </div>
            </div>

            <div class="col-md-6">
                <label for="file">
                    <img id="productImg" class="card-img-top mb-5 mb-md-0" src="/img/productCamera.png"
                         alt="..." style="width: 600px; height: 700px;"/>
                </label>
                <form action="/profile/update.do" method="POST" enctype="multipart/form-data">
                    <input id="file" type="file" name="file" accept="image/jpeg, image/png">
                </form>
            </div>




        </div>
    </div>
</header>

<div class="py-5 bg-white">
    <div class="container px-5 my-5">
        <div class="row gx-5 justify-content-center">
            <div class="col-lg-10 col-xl-7">
                <div class="text-center">
                    <h1 id="jinvley">상품 정보 수정</h1>
                    <hr class="my-2">


                    <textarea class="mt-3" id="introduction" spellcheck="false">${product.productInfo}</textarea>

                    <%--<div id="info" class="fs-4 m-4">
                        ${product.productInfo}
                    </div>--%>


                    <div class="d-flex align-items-center justify-content-center pb-4 pt-5">
                        <a id="modifyBtn" class="btn btn-primary btn-lg px-4 me-sm-3"
                           href="#features" style="background-color: #4E00FF; border: #4E00FF">
                            변경완료 <i class="bi bi-flag"></i>
                        </a>
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


    document.getElementById('file').addEventListener('change', function () {
        var selectedFile = this.files[0];

        if (selectedFile) {
            // 파일 확장자 확인
            var allowedExtensions = ['jpg', 'jpeg', 'png']; // 허용된 이미지 확장자들
            var fileExtension = selectedFile.name.split('.').pop().toLowerCase();

            if (allowedExtensions.indexOf(fileExtension) === -1) {
                sweetAlert("파일 선택 오류", "이미지 파일을 선택하세요.", "error");
                // 파일 입력란 초기화 (선택한 파일 지우기)
                this.value = "";
            } else {
                var productImg = document.getElementById('productImg');
                productImg.src = URL.createObjectURL(selectedFile);
            }
        }
    });
</script>
</body>
</html>
