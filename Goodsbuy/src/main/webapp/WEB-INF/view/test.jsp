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


<jsp:include page="common/header.jsp"></jsp:include>

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

<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
