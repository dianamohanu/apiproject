<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <jsp:include page="bootstrapImports.jsp"/>

    <c:url var="managerStyle" value="/resources/style/manager.css"/>
    <link rel="stylesheet" type="text/css" href="${managerStyle}"/>

    <c:url var="logoImage" value="/resources/images/logo.png"/>

    <c:url var="logoutUrl" value="/j_spring_security_logout"/>
    <c:url var="reservationsURL" value="/backoffice/reservation/getAll"/>
</head>

<body>
<nav class="navbar navbar-default navbar-custom">
    <div class="container-fluid">
        <div class="navbar-header">
            <img src="${logoImage}" class="img-responsive" width="160" height="70">
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="${reservationsURL}"><span class="glyphicon glyphicon-calendar"></span> Reservations</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#" style="color: #eee8e8"><span class="glyphicon glyphicon-user"></span> Hi, <sec:authentication property="name"/>!</a></li>
            <li><a href="${logoutUrl}"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
        </ul>
    </div>
</nav>
</body>
</html>
