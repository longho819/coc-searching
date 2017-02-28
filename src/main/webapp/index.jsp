<%--
  Created by IntelliJ IDEA.
  User: leho
  Date: 2/24/17
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp">
<head>
    <title>COC Searching</title>
    <link rel="stylesheet" href="/resources/css/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <%--<link rel="stylesheet" href="/resources/css/custom/landing-page.css">--%>
    <link rel="stylesheet" href="/resources/css/common/navbar-static-top.css"/>
    <%--<link rel="stylesheet" href="/resources/css/font-awesome/css/font-awesome.min.css">--%>
</head>
<body>
    <header></header>
    <ui-view></ui-view>
    <%--library javascript--%>
    <script src="/resources/js/jquery/jquery.js"></script>
    <script src="/resources/js/angular-1.2.32/angular.min.js"></script>
    <script src="/resources/css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="/resources/js/angular-ui-router/angular-ui-router.min.js"></script>
    <%--<script src="/resources/js/angular-1.2.32/angular-route.min.js"></script>--%>
    <script src="/resources/js/angular-ui-bootstrap/angular-ui.js"></script>
    <%--custome javascript--%>
    <script src="/resources/js/app/app.js"></script>
    <script src="/resources/js/app/share/navbar/HeaderCtrl.js"></script>
    <script src="/resources/js/app/home/HomeCtrl.js"></script>
    <script src="/resources/js/app/services/coc-service.js"></script>
    </body>
</html>
