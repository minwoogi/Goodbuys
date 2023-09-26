<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Goodsbuy Email Auth</title>


    <link rel="shortcut icon" href="/img/fav.ico">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <style>
        body {
            min-height: 100vh;
            background: #eee

        }

        .input-form {
            max-width: 680px;

            margin-top: 80px;
            padding: 32px;

            background: #fff;
            -webkit-border-radius: 10px;
            -moz-border-radius: 10px;
            border-radius: 10px;
            -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
            -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
            box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
        }
    </style>
</head>

<body>

<% if ((Integer) request.getAttribute("emailCheck") == 1) {%>
<script>
    location.href="/goodsbuy/list";
</script>
<%}%>

<div class="container">
    <div class="input-form-backgroud row">
        <div class="input-form col-md-12 mx-auto">
            <div class="mb-5 d-flex justify-content-center"></div>
            <div class="mb-5 d-flex justify-content-center"><a href="/goodsbuy/list"><img src="/img/mainLogo.png"
                                                                                          style="width:259.5px; height:40px;"
                                                                                          class="img-responsive">

            </a></div>
            <h5 class="mb-5 d-flex justify-content-left">이메일을 인증해주세요.</h5>
            <form class="validation-form" novalidate action="/email-code" method="post">

                <label for="email">이메일</label>
                <div class="input-group mb-3">
                    <input type="email" id="email" name="email" class="form-control" placeholder="example@example.com"
                           required>
                    <button class="btn btn-outline-primary" type="button" id="button-addon2"
                            onclick="sendEmailNumber()">인증번호 전송
                    </button>
                    <div class="invalid-feedback">
                        이메일 주소를 입력해주세요.
                    </div>
                    <div id="timer" style="display:none; color: red;">
                    </div>


                </div>
                <label for="auth">인증번호</label>
                <div class="input-group mb-3">
                    <input type="text" id="auth" name="receiveCode" class="form-control" placeholder="" required>
                    <button id="email-code-check" class="btn btn-outline-primary" type="submit">인증번호 확인</button>
                    <div class="invalid-feedback">
                        인증번호를 입력해주세요.
                    </div>
                </div>

                <hr class="mb-4">
                <div class="mb-4"></div>
                <button class="btn btn-primary btn-lg btn-block" type="submit">인증 완료</button>

            </form>
        </div>
    </div>
    <footer class="my-3 text-center text-small">
        <p class="mb-1">&copy; 2023 Goodsbuy</p>
    </footer>
</div>
<script>

    var timerInterval;

    function sendEmailNumber() {
        var email = $("#email").val();
        $.ajax({
            type: "POST",
            url: "/email",
            data: {email: email},
            success: function (response) {
                startTimer();
            },
            error: function (error) {
                console.error("오류 발생:", error);
            }
        });
    }

    function startTimer() {
        // 입력 필드 및 버튼을 비활성화
        $("#email").prop("disabled", true);
        $("#button-addon2").prop("disabled", true);

        var duration = 180; // 타이머의 기간 (초)
        var timer = duration, minutes, seconds;
        var invalidFeedback = $('#email').siblings('.invalid-feedback');
        invalidFeedback.text("남은 시간: 3 : 00");
        invalidFeedback.show();

        function updateTimer() {
            minutes = parseInt(timer / 60, 10);
            seconds = parseInt(timer % 60, 10);
            minutes = minutes < 10 ? "0" + minutes : minutes;
            seconds = seconds < 10 ? "0" + seconds : seconds;

            invalidFeedback.text("남은 시간 " + minutes + " : " + seconds);
        }

        updateTimer();

        timerInterval = setInterval(function () {
            updateTimer();

            if (--timer < 0) {
                clearInterval(timerInterval);
                // 타이머 종료 후 입력 필드와 버튼을 다시 활성화
                $("#email").prop("disabled", false);
                $("#button-addon2").prop("disabled", false);
                invalidFeedback.hide();
            }
        }, 1000);
    }


    $('#email').on('keyup', function () {
        var email = $("#email").val();
        var emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
        var invalidFeedback = $('#email').siblings('.invalid-feedback');

        if (!emailRegex.test(email)) {
            invalidFeedback.text('유효하지 않은 이메일 주소입니다.');
            invalidFeedback.show();
        } else {
            invalidFeedback.hide();
        }
    });


    window.addEventListener('load', () => {
        const forms = document.getElementsByClassName('validation-form');

        Array.prototype.filter.call(forms, (form) => {
            form.addEventListener('submit', function (event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }

                form.classList.add('was-validated');
            }, false);
        });
    }, false);
</script>
</body>

</html>
