<%--
<a href="https://www.flaticon.com/kr/free-animated-icons/"
title="사용자 애니메이션 아이콘">사용자 애니메이션 아이콘 제작자: Freepik - Flaticon</a><--%>

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
            <img alt="profile" width="400" src="/img/profile.gif">
        </div>

        <div class="lbl-div">
            <i>닉네임 설정</i>
        </div>

        <div class="input-div">
            <form id="nicknameForm" action="/users/nickname" method="POST">
                <input id="nickname" name="nickname" type="text" placeholder="4~10자 내 (*특수문자 제외)" required>
            </form>
        </div>

        <div class="btn-div">
            <button id="nickCheck" class="btn btn-primary btn-block" type="button">변경하기</button>
        </div>


    </div>
</div>

<jsp:include page="../common/footer.jsp"></jsp:include>


<script>
    $('#nickCheck').click(isValidNickname);

    function isValidNickname() {

        var pattern = /^[a-zA-Z0-9]{4,12}$/;

        if (pattern.test($('#nickname').val())) {
            checkNicknameExists();
        } else {
            sweetAlert('Invalid Nickname', '닉네임은 알파벳 소문자, 대문자, 숫자로 이루어진 4자에서 12자까지의 문자열이어야 합니다.', 'error');
        }
    }

    function checkNicknameExists() {
        $.ajax({
            type: 'POST',
            url: '/users/nickname/duplicated',
            data: JSON.stringify({nickname: $('#nickname').val()}),
            contentType: 'application/json',
            success: function (flag) {
                console.log(flag);
                if (flag) {
                    sweetAlert('사용중인 닉네임', ' 다른 닉네임을 사용해주세요.', 'warning');
                } else {
                    confirmDialog('사용가능한 닉네임', '해당닉네임을 사용 하시겠습니까?')
                }
            },
            error: function (e) {
                console.log(e);
            }
        });
    }

    function sweetAlert(tle, msg, icn) {
        Swal.fire({
            title: tle,  // 제목
            text: msg,  // 메시지 내용
            icon: icn,  // 아이콘 (success, error, warning, info)
            confirmButtonText: '확인'  // 확인 버튼 텍스트
        });
    }

    function confirmDialog(tle, msg) {
        Swal.fire({
            title: tle,
            text: msg,
            icon: 'question',
            showCancelButton: true,  // 취소 버튼 표시
            confirmButtonText: '확인',
            cancelButtonText: '취소'
        }).then((result) => {
            if (result.isConfirmed) {
                $('#nicknameForm').submit();
            }
        });
    }
</script>

</body>
</html>


