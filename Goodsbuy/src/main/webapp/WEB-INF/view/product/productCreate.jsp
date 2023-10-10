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
                    <h3 class="display-10 fw-bolder text-white mb-2">상품 제목</h3>
                    <input id="productNameInput" class="input-form bg-dark" required style="font-size: 36px">

                    <h3 class="display-10 fw-bolder text-white mb-2"><br>상품 가격</h3>
                    <input id="#productPriceInput" type="number" class="input-form bg-dark" required
                           style="font-size: 36px">

                    <h3 class="display-10 fw-bolder text-white mb-2"><br>카테고리</h3>
                    <select id="categorySelect" class="bg-dark text-white" style="font-size:20px;">
                        <option value="1">CD/DVD</option>
                        <option value="2">도서</option>
                        <option value="3">의류</option>
                        <option value="4">테크/IT</option>
                        <option value="5">패션잡화</option>
                        <option value="6">기타</option>
                    </select>
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
                    <h1 id="jinvley">상품 정보</h1>
                    <hr class="my-2">


                    <textarea class="mt-3" id="introduction" spellcheck="false">${product.productInfo}</textarea>

                    <%--<div id="info" class="fs-4 m-4">
                        ${product.productInfo}
                    </div>--%>


                    <div class="d-flex align-items-center justify-content-center pb-4 pt-5">
                        <a id="createBtn" class="btn btn-primary btn-lg px-4 me-sm-3"
                           href="#features" style="background-color: #4E00FF; border: #4E00FF">
                            등록
                        </a>
                    </div>

                    <div class="d-flex align-items-center justify-content-center">
                        <img class="rounded-circle me-3 px-40" src="/multipartImg/profileImage/${profile.imageURL}"
                             alt="profileImage"
                             style="width: 40px; height: 40px;"/>
                        <div class="fw-bold">
                            ${profile.nickName}
                            <span class="fw-bold text-primary mx-1">/</span>
                            ${profile.location} <i class="bi bi-geo-alt"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>

    function sweetAlert(tle, msg, icn) {
        Swal.fire({
            title: tle,  // 제목
            text: msg,  // 메시지 내용
            icon: icn,  // 아이콘 (success, error, warning, info 중 선택)
            confirmButtonText: '확인'  // 확인 버튼 텍스트
        });
    }

    function sweetAlertWithRedirect(tle, msg, icn, redirectUrl) {
        Swal.fire({
            title: tle,  // 제목
            text: msg,  // 메시지 내용
            icon: icn,  // 아이콘 (success, error, warning, info 중 선택)
            showCancelButton: false, // 취소 버튼 표시
            confirmButtonText: '확인',  // 확인 버튼 텍스트
        }).then((result) => {
            if (result.isConfirmed) {
                window.location.href = redirectUrl;
            } else {
                window.location.href = redirectUrl;
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


    document.querySelector('#createBtn').addEventListener('click', function () {
        var productInfo = document.getElementById('introduction').value;
        var productName = document.getElementById('productNameInput').value;
        var productPrice = document.getElementById('#productPriceInput').value;
        var categoryNo = document.getElementById('categorySelect').value;

        if (!productName || !productPrice || !productInfo || !categoryNo) {
            sweetAlert("입력 오류", "모든 필드를 입력하세요.", "error");
            return;
        }


        // FormData 객체를 사용하여 form 데이터를 생성
        var formData = new FormData();
        formData.append('productInfo', productInfo);
        formData.append('productName', productName);
        formData.append('productPrice', productPrice);
        formData.append('categoryNo', categoryNo);

        // 파일 input 필드에서 선택한 파일
        var fileInput = document.getElementById('file');
        if (fileInput.files.length > 0) {
            formData.append('file', fileInput.files[0]);
        }


        // 새로운 폼 엘리먼트 생성
        var form = document.createElement('form');
        form.method = 'POST';
        form.action = '/product/create.do';
        form.enctype = 'multipart/form-data';

        // FormData를 폼에 추가
        for (var pair of formData.entries()) {
            var input = document.createElement('input');
            input.type = 'hidden';
            input.name = pair[0];
            input.value = pair[1];
            form.appendChild(input);
        }

        fetch('/product/create.do', {
            method: 'POST',
            body: formData
        })
            .then(function (response) {
                if (response.ok) {
                    sweetAlertWithRedirect("상품 등록 완료", "", "success", "/goodsbuy/list");
                } else {
                    response.text().then(function (errorMessage) {
                        sweetAlert("오류", errorMessage, "error");
                    });
                }
            })
            .catch(function (error) {
                console.error(error);
                sweetAlert("오류", "상품 등록 중 오류가 발생했습니다.", "error");
            });
    });
</script>
</body>
</html>
