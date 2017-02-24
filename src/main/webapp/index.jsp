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
</head>
<body >
<div>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div ng-include="'/resources/js/share/navbar/_nav.html'"></div>
            <ui-view></ui-view>
        </div>

    </div>
</div>
<script src="/resources/js/jquery/jquery.js"></script>
<script src="/resources/js/angular-1.6.2/angular.min.js"></script>
<script src="/resources/js/angular-1.6.2/angular-resource.min.js"></script>
<script src="/resources/js/angular-1.6.2/angular-route.min.js"></script>
<script src="/resources/css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="/resources/js/angular-ui-bootstrap/angular-ui.js"></script>
<script src="/resources/js/app.js"></script>
<script src="/resources/js/share/navbar/navCtrl.js"></script>
</body>
</html>
