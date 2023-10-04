<%--<a href="https://www.flaticon.com/kr/free-icons/" title="사용자 아이콘">사용자 아이콘  제작자: Becris - Flaticon</a>--%>
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
    <link rel="stylesheet" href="css/myPage.css">
    <link rel="stylesheet" type="text/css" href="css/sidebar.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
</head>
<body style="background-color: #EEEEEE">
<jsp:include page="../common/header.jsp"></jsp:include>

<div class="custom-container">
    <div class="custom-sidebar">
        <jsp:include page="../common/sidebar.jsp"></jsp:include>
    </div>
    <div class="custom-content">

        <div class="d-flex">
            <div class="flex-grow-1">
                <div id="profileImgDiv" class="img-div mt-4" style="position: relative;">
                    <img id="profileImg" class="img-fluid" alt="profile"
                    <c:choose>
                    <c:when test="${not empty memberProfile.imageURL}">
                         src="/img/multipartImg/profileImage/${memberProfile.imageURL}"
                    </c:when>
                    <c:otherwise>
                         src="/img/multipartImg/profileImage/profile.png"
                    </c:otherwise>
                    </c:choose>
                         style="border-radius: 50%; border: 3px solid black;">
                    <div class="position-absolute color-bg-default rounded-2 color-fg-default px-2 py-1"
                         style="right: 25px; bottom: 25px;">

                        <label for="file">
                            <img id="avatar" src="/img/camera.png">
                        </label>
                        <form action="/profile/update.do" method="POST" enctype="multipart/form-data">
                            <input id="file" type="file" name="file" accept="image/jpeg, image/png">
                        </form>
                    </div>
                </div>
            </div>

            <div id="intro" class="flex-grow-1 mx-5">
                <div class="mt-4">
                    <p class="nick" style="text-align: center">${memberProfile.nickName}님</p>
                    <hr class="my-2">
                    <textarea class="mt-3" id="introduction" spellcheck="false">${memberProfile.introduction}
                    </textarea>
                </div>
            </div>
        </div>

        <div class="mt-5">
            <button type="button" class="subb">설정 완료</button>
        </div>


    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<script>

    function sweetAlert(tle, msg, icn) {
        Swal.fire({
            title: tle,  // 제목
            text: msg,  // 메시지 내용
            icon: icn,  // 아이콘 (success, error, warning, info 중 선택)
            confirmButtonText: '확인'  // 확인 버튼 텍스트
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
                var profileImg = document.getElementById('profileImg');
                profileImg.src = URL.createObjectURL(selectedFile);
            }
        }
    });

    document.querySelector('.subb').addEventListener('click', function () {
        var introduction = document.getElementById('introduction').value;

        // FormData 객체를 사용하여 form 데이터를 생성
        var formData = new FormData();
        formData.append('introduction', introduction);

        // 파일 input 필드에서 선택한 파일
        var fileInput = document.getElementById('file');
        if (fileInput.files.length > 0) {
            formData.append('file', fileInput.files[0]);
        }


        // 새로운 폼 엘리먼트 생성
        var form = document.createElement('form');
        form.method = 'POST';
        form.action = '/profile/update.do';
        form.enctype = 'multipart/form-data';

        // FormData를 폼에 추가
        for (var pair of formData.entries()) {
            var input = document.createElement('input');
            input.type = 'hidden';
            input.name = pair[0];
            input.value = pair[1];
            form.appendChild(input);
        }

        fetch('/profile/update.do', {
            method: 'POST',
            body: formData
        })
            .then(function (response) {
                if (response.ok) {
                    sweetAlert("설정 완료", "프로필이 업데이트되었습니다.", "success");
                } else {
                    response.text().then(function(errorMessage) {
                        sweetAlert("오류", errorMessage, "error");
                    });
                }
            })
            .catch(function (error) {
                console.error(error);
                sweetAlert("오류", "프로필 업데이트 중 오류가 발생했습니다.", "error");
            });
    });




</script>

</body>
</html>