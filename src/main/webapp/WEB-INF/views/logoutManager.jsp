<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Management Console</title>

    <c:url var="managerLoginImage" value="/resources/images/managerLogin.png"/>
</head>

<body style="background-color: #3e4e51;">
<jsp:include page="bootstrapImports.jsp"/>

<div class="col-md-4"></div>

<div class="col-md-4 jumbotron vertical-center" style="background-color: #3e4e51;">
    <div class="col-md-1"></div>

    <div class="col-md-10">
        <img class="center-block" src="${managerLoginImage}">

        <h3 style="color: #ffffff" class="text-center">GOOD BYE!</h3>
        <h4 style="color: #ffffff" class="text-center">You have been
            <mark>successfully logged out</mark>! Thank you for using our app.</h4>
    </div>

    <div class="col-md-1"></div>
</div>

<div class="col-md-4"></div>
</body>
</html>
