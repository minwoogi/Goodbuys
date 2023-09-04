<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko" data-dark="false" class="root">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>GoodsBuy</title>
    <%--link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">--%>
    <link rel="stylesheet" type="text/css" href="/css/login.css">

</head>
<body style="background-color: #EEEEEE">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script>
    $(document).ready(function () {
        let message = "${msg}";
        if (message.startsWith("계정")) {
            swal.fire({
                title: "알림",
                text: message,
                icon: "error",
            });
        }
    })
</script>


<div id="container-doc">
    <div class="inner_container">

        <main class="doc_main">
            <a href="/goodsbuy/list">
                <div class="doc-title">
                    <img alt="mainLogo" width="400" src="/img/mainLogo.png" title="goodsbuy">
                </div>
            </a>

            <form id="login-form" action="/login" method="post">
                <div class="id_input">
                    <input type="text" size="" name="username"
                           placeholder="아이디" class="member_user_signIn">
                </div>
                <div class="pwd_input">
                    <input type="password" name="password"
                           placeholder="비밀번호" class="member_user_signIn">
                </div>
                <div class="signInBtn-group">
                    <button id="loginBtn" submit="button">로그인
                    </button>
                </div>
                <div class="info_user">
                    <ul class="list_user">
                        <li>
                            <b>계정 찾기</b>
                        </li>
                        <li>
                            <b>회원가입</b>
                        </li>
                    </ul>
                </div>

                <div class="social-login">
                    SNS계정으로 간편 로그인/회원가입
                </div>
            </form>

        </main>
    </div>
</div>
</body>
</html>