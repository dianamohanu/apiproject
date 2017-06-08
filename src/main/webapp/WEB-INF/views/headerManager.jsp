<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:url var="managerStyle" value="/resources/style/manager.css"/>
    <link rel="stylesheet" type="text/css" href="${managerStyle}">

    <c:url var="logoutUrl" value="/j_spring_security_logout"/>
</head>

<body>
<jsp:include page="bootstrapImports.jsp"/>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">LOGO image here</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-home"></span> Hotel Info</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-star"></span> Our Reservations</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-plus"></span> New Reservation</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-user"></span> My Account</a></li>
            <li><a href="${logoutUrl}"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
        </ul>
    </div>
</nav>
</body>
</html>
