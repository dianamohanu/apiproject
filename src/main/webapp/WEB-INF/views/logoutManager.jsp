<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>HotelBook Management Console</title>
    <c:url var="favicon" value="/resources/images/favicon.png"/>
    <link rel="shortcut icon" href="${favicon}">

    <c:url var="loginLogoutStyle" value="/resources/style/loginLogout.css"/>
    <link rel="stylesheet" type="text/css" href="${loginLogoutStyle}">

    <c:url var="managerLoginImage" value="/resources/images/managerLogin.png"/>
</head>

<body style="background-color: #3e4e51;">
<jsp:include page="bootstrapImports.jsp"/>

<div class="container-fluid jumbotron" style="background-color: #3e4e51;">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <div class="logo center-block"></div>

            <h3 class="logoutMessage">GOOD BYE!</h3>
            <h4 class="logoutMessage">You have been
                <mark>successfully logged out!</mark>
            </h4>
            <h4 class="logoutMessage">Thank you for using our application.</h4>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
</body>
</html>
