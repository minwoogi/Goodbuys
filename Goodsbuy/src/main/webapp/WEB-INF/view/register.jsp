<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GoodsBuy Reigster</title>

    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"
            integrity="sha512-T/tUfKSV1bihCnd+MxKD0Hm1uBBroVYBOYSk1knyvQ9VyZJpc/ALb4P0r6ubwVPSGB2GvjeoMAJJImBG12TiaQ=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css"
          integrity="sha512-mSYUmp1HYZDFaVKK//63EcZq4iFWFjxSL+Z3T/aCt4IO9Cejm03q3NKKYN6pFQzY0SBOr8h+eCIAZHPXcpZaNw=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/locales/bootstrap-datepicker.ko.min.js"
            integrity="sha512-L4qpL1ZotXZLLe8Oo0ZyHrj/SweV7CieswUODAAPN/tnqN3PA1P+4qPu5vIryNor6HQ5o22NujIcAZIfyVXwbQ=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>


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
            <a href="/goodsbuy/list">
                <div class="mb-5 d-flex justify-content-center"><img src="/img/mainLogo.png"
                                                                     style="width:259.5px; height:40px;"
                                                                     class="img-responsive"></div>
            </a>
            <h5 class="mb-5 d-flex justify-content-left">사용자 정보를 입력하세요</h5>
            <form class="validation-form" novalidate action="/register.do" method="post">
                <div class="mb-3">
                    <label for="identify">아이디</label>
                    <input type="text" class="form-control" id="identify" name="userId"
                           placeholder="아이디는 (a-z, A-Z), 숫자(0-9) 4~12자만 가능합니다."
                    <c:if test="${not empty registerForm and not empty registerForm.userId}">
                           value="${registerForm.userId}"
                    </c:if>
                           required>
                    <div>
                        <c:if test="${not empty errors and errors.hasFieldErrors('userId')}">
                            <div class="error">${errors.getFieldError('userId').defaultMessage}</div>
                        </c:if>
                    </div>
                    <div class="invalid-feedback">
                        아이디를 입력해주세요.
                    </div>
                </div>

                <div class="mb-3">
                    <label for="password1">비밀번호</label>
                    <input type="password" class="form-control" id="password1" name="userPwd"
                           placeholder="최소 8자에서 20자 이하이어야 하며, 대문자, 소문자, 숫자 및 특수 문자를 모두 포함해야 합니다."
                    <c:if test="${not empty registerForm and not empty registerForm.userPwd}">
                           value="${registerForm.userPwd}"
                    </c:if>
                           required>
                    <div>
                        <c:if test="${not empty errors and errors.hasFieldErrors('userPwd')}">
                            <div class="error">${errors.getFieldError('userPwd').defaultMessage}</div>
                        </c:if>
                    </div>
                    <div class="invalid-feedback">
                        비밀번호를 입력해주세요.
                    </div>
                </div>


                <div class="mb-3">
                    <label for="password2">비밀번호 확인</label>
                    <input type="password" class="form-control" id="password2" name="confirmPassword"
                           placeholder="최소 8자에서 20자 이하이어야 하며, 대문자, 소문자, 숫자 및 특수 문자를 모두 포함해야 합니다."
                    <c:if test="${not empty registerForm and not empty registerForm.confirmPassword}">
                           value="${registerForm.confirmPassword}"
                    </c:if>
                           required>
                    <div>
                        <c:if test="${not empty errors and errors.hasFieldErrors('confirmPassword')}">
                            <div class="error">${errors.getFieldError('confirmPassword').defaultMessage}</div>
                        </c:if>
                    </div>
                    <div class="invalid-feedback">
                        비밀번호를 확인해주세요.
                    </div>
                </div>

                <div class="mb-3">
                    <label for="birthday">생년 월일</label>
                    <input type="text" id="birthday" name="birth" class="form-control"
                           placeholder="ex : 19990101"
                    <c:if test="${not empty registerForm and not empty registerForm.birth}">
                           value="${registerForm.birth}"
                    </c:if>
                           required>
                    <div>
                        <c:if test="${not empty errors and errors.hasFieldErrors('birth')}">
                            <div class="error">${errors.getFieldError('birth').defaultMessage}</div>
                        </c:if>
                    </div>
                    <div class="invalid-feedback">
                        생년 월일을 입력해주세요.
                    </div>
                </div>

                <div class="mb-3">
                    <label for="root">성별</label>
                    <select class="custom-select d-block w-100" id="root" name="nickname">
                        <option value=""></option>
                        <option>남자</option>
                        <option>여자</option>
                    </select>
                    <div class="invalid-feedback">
                        가입 경로를 선택해주세요.
                    </div>
                </div>
                <hr class="mb-4">
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="aggrement" required>
                    <label class="custom-control-label" for="aggrement">개인정보 수집 및 이용에
                        동의합니다.</label>
                </div>
                <div class="mb-4"></div>
                <button class="btn btn-primary btn-lg btn-block" type="submit">다음</button>
            </form>
        </div>
    </div>
    <footer class="my-3 text-center text-small">
        <p class="mb-1">&copy; 2023 Goodsbuy</p>
    </footer>
</div>
<script type='text/javascript'>
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