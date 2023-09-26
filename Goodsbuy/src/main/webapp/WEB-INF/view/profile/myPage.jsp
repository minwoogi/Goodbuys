<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko" data-dark="false" class="root">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>GoodsBuy</title>
    <link rel="shortcut icon" href="/img/fav.ico">
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
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>




</body>
</html>