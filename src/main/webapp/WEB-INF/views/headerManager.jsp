<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="bootstrapImports.jsp"/>

    <c:url var="managerStyle" value="/resources/style/manager.css"/>
    <link rel="stylesheet" type="text/css" href="${managerStyle}"/>

    <c:url var="logoImage" value="/resources/images/logo.png"/>

    <c:url var="logoutUrl" value="/j_spring_security_logout"/>
    <c:url var="hotelInfoURL" value="/backoffice/hotel/hotelInfo"/>
    <c:url var="addReservationURL" value="/backoffice/reservation/add"/>
</head>

<body>
<nav class="navbar navbar-default navbar-custom">
    <div class="container-fluid">
        <div class="navbar-header">
            <img src="${logoImage}" class="img-responsive" width="160px" height="70px">
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="${hotelInfoURL}"><span class="glyphicon glyphicon-home"></span> Hotel Info</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-star"></span> Reservations</a></li>
            <li><a href="${addReservationURL}"><span class="glyphicon glyphicon-plus"></span> Add Reservation</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="${logoutUrl}"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
        </ul>
    </div>
</nav>
</body>
</html>
