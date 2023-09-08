<%@ page import="com.tu.goodsbuy.dto.MemberProfile" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko" data-dark="false" class="root">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>GoodsBuy</title>

</head>
<body style="background-color: #EEEEEE">

<%
    MemberProfile memberProfile = (MemberProfile) request.getAttribute("memberProfile");
%>

<%=memberProfile.toString()%>

</body>
</html>