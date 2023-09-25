<%@ page import="com.tu.goodsbuy.model.dto.MemberUser" %>
<%@ page import="java.util.Objects" %>
<%@ page import="com.tu.goodsbuy.model.dto.MemberProfile" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko" data-dark="false" class="root">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://unpkg.com/@popperjs/core@2"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.js"
            integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
    <title>GoodsBuy</title>

</head>
<body style="background-color: #EEEEEE">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="/goodsbuy/list">
            <img alt="mainLogo" width="200" src="/img/mainLogo.png" title="goodsbuy"
                 class="d-inline-block align-text-top">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item"><a class="nav-link" aria-current="page" href="#!">카테고리</a></li>
                <li class="nav-item"><a class="nav-link" href="#!">동네소식</a></li>
                <li class="nav-item"><a class="nav-link" href="#!">알바</a></li>
            </ul>
            <form class="d-flex m-3 mb-3" action="/goodsbuy/list/search" method="get">
                <div class="p-2">
                    <input name="productName" class="form-control form-control-sm w-auto" type="search"
                           placeholder="상품명 검색"
                           aria-label="Search" maxlength='18'>
                </div>

                <% MemberUser loginUser = (MemberUser) request.getSession(false).getAttribute("loginMember");
                    if (Objects.isNull(loginUser)) {
                %>
                <div class="p-1">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a href="/login" class="nav-link" aria-current="page">로그인</a></li>
                        <li class="nav-item"><a class="nav-link" href="/register">회원가입</a></li>
                    </ul>
                </div>
                <%} else {%>

                <div class="p-1">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a id="logOut" href="/logOut.do" class="nav-link"
                                                aria-current="page">로그아웃</a></li>
                        <li class="nav-item"><a class="nav-link" href="/goodsbuy/profile">마이페이지</a></li>
                    </ul>
                </div>


                <div class="p-1">
                    <button type="button" class="btn" style="background-color: #4E00FF; color: white;">
                        <%--                    <i class="bi-cart-fill me-1"></i>--%>
                        글쓰기
                        <%--                    <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>--%>
                    </button>
                </div>
                <%}%>


            </form>
        </div>
    </div>
</nav>
<%--<%
    MemberProfile memberProfile = (MemberProfile) request.getAttribute("memberProfile");
%>

<%=memberProfile.toString()%>--%>

<div class="container-fluid">
    <div class="row py-3">
        <div class="col-md-12">
            <h3 class="my-3">
                마이 페이지
            </h3>
            <div class="row py-5">
                <div class="col-md-3">
                </div>
                <div class="col-md-2 border border-1 border-dark text-center">
                    <img class="my-5 py-3" alt="" src="/img/lock.png" width="150" height="150">
                </div>
                <div class="col-md-3 border-top border-end border-bottom border-1 border-dark">
                    <dl>
                        <dt class="py-1">
                            프로필 정보
                        </dt>
                        <dd>
                        </dd>
                        <dt>
                            닉네임
                        </dt>
                        <dd>
                            테스트
                        </dd>
                        <dt>
                            지역설정
                        </dt>
                        <dd>
                            부산광역시 남구
                        </dd>
                    </dl>
                    <div class="py-1 mb-3">
                        <button class="btn btn-info" type="button">이메일 인증</button>
                    </div>
                    <dt class="py-1 mb-3">
                        이메일 인증 완료
                    </dt>
                </div>
                <div class="col-md-3">
                </div>
            </div>
            <div class="row py-5">
                <div class="col-md-12">
                    <h3 class="text-center my-3">
                        판매 내역
                    </h3>
                    <div class="row">
                        <div class="col-md-3">
                        </div>
                        <div class="col-md-3 bg-success border border-1">
                            <h3 class="py-3 text-center">
                                판매중
                            </h3>
                            <p class="text-center">
                                1개
                            </p>
                        </div>
                        <div class="col-md-3 bg-success border border-1">
                            <h2 class="py-3 text-center">
                                판매 완료
                            </h2>
                            <p class="text-center">
                                2개
                            </p>
                        </div>
                        <div class="col-md-3">
                        </div>
                    </div>
                </div>
            </div>
            <div class="row py-5">
                <div class="col-md-12">
                    <h3 class="text-center my-3">
                        구매 내역
                    </h3>
                    <div class="row">
                        <div class="col-md-3">
                        </div>
                        <div class="col-md-3 bg-warning border border-1">
                            <h2 class="py-3 text-center">
                                예약 중
                            </h2>
                            <p class="text-center">
                                1개
                            </p>
                        </div>
                        <div class="col-md-3 bg-warning border border-1">
                            <h2 class="py-3 text-center">
                                구매 완료
                            </h2>
                            <p class="text-center">
                                2개
                            </p>
                        </div>
                        <div class="col-md-3">
                        </div>
                    </div>
                </div>
            </div>
            <div class="row py-5">
                <div class="col-md-12 my-3">
                    <h3 class="py-3 text-center">
                        관심 상품
                    </h3>
                    <div class="row">
                        <div class="col-md-12">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>
                                        #
                                    </th>
                                    <th>
                                        상품 이름
                                    </th>
                                    <th>
                                        등록 시간
                                    </th>
                                    <th>
                                        상품 상태
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr class="table-success">
                                    <td>
                                        1
                                    </td>
                                    <td>
                                        상품 이름
                                    </td>
                                    <td>
                                        01/04/2023
                                    </td>
                                    <td>
                                        판매 중
                                    </td>
                                </tr>
                                <tr class="table-danger">
                                    <td>
                                        2
                                    </td>
                                    <td>
                                        상품 이름
                                    </td>
                                    <td>
                                        01/04/2023
                                    </td>
                                    <td>
                                        판매 완료
                                    </td>
                                </tr>
                                <tr class="table-success">
                                    <td>
                                        3
                                    </td>
                                    <td>
                                        상품 이름
                                    </td>
                                    <td>
                                        02/04/2012
                                    </td>
                                    <td>
                                        판매 완료
                                    </td>
                                </tr>
                                <tr class="table-danger">
                                    <td>
                                        4
                                    </td>
                                    <td>
                                        상품 이름
                                    </td>
                                    <td>
                                        03/04/2023
                                    </td>
                                    <td>
                                        판매 완료
                                    </td>
                                </tr>
                                <tr class="table-success">
                                    <td>
                                        5
                                    </td>
                                    <td>
                                        상품 이름
                                    </td>
                                    <td>
                                        04/04/2023
                                    </td>
                                    <td>
                                        판매 중
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<footer class="py-5 bg-dark">
    <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Goodsbuy</p></div>
</footer>
</body>
</html>
