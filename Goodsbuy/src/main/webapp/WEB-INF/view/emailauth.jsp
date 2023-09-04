<%--
  Created by IntelliJ IDEA.
  User: rodin
  Date: 2023-09-04
  Time: AM 2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Goodsbuy Email Auth</title>

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

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


<div class="container">
  <div class="input-form-backgroud row">
    <div class="input-form col-md-12 mx-auto">
      <div class="mb-5 d-flex justify-content-center"></div>
      <div class="mb-5 d-flex justify-content-center"><img src="/img/mainLogo.png" style="width:259.5px; height:40px;" class="img-responsive"></div>
      <h5 class="mb-5 d-flex justify-content-left">이메일을 인증해주세요.</h5>
      <form class="validation-form" novalidate>

        <label for="email">이메일</label>
        <div class="input-group mb-3">
          <input type="email" id="email" class="form-control" placeholder="example@example.com" required>
          <button class="btn btn-outline-primary" type="button" id="button-addon2">인증번호 전송</button>
          <div class="invalid-feedback">
            이메일 주소를 입력해주세요.
          </div>
        </div>
        <label for="auth">인증번호</label>
        <div class="input-group mb-3">
          <input type="text" id="auth" class="form-control" placeholder=""required>
          <button class="btn btn-outline-primary" type="button" id="button-addon2">인증번호 확인</button>
          <div class="invalid-feedback">
            인증번호를 입력해주세요.
          </div>
        </div>

        <hr class="mb-4">
        <div class="mb-4"></div>
        <button class="btn btn-primary btn-lg btn-block" type="submit">가입 완료</button>

      </form>
    </div>
  </div>
  <footer class="my-3 text-center text-small">
    <p class="mb-1">&copy; 2023 Goodsbuy</p>
  </footer>
</div>
<script>
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
