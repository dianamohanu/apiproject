<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Management Console</title>

    <c:url var="loginLogoutStyle" value="/resources/style/loginLogout.css"/>
    <link rel="stylesheet" type="text/css" href="${loginLogoutStyle}">

    <c:url var="managerLoginImage" value="/resources/images/managerLogin.png"/>
</head>

<body style="background-color: #3e4e51;">
<jsp:include page="bootstrapImports.jsp"/>

<div class="col-md-4"></div>

<div class="col-md-4 jumbotron vertical-center" style="background-color: #3e4e51;">
    <div class="col-md-2"></div>

    <div class="col-md-8">
        <img src="${managerLoginImage}">

        <div class="center-block">
        <form action="j_spring_security_check" name="f" method="post">
            <div class="form-group">
                <input type="text" name="j_username" value="" class="form-control" placeholder="Username">
            </div>
            <div class="form-group">
                <input input type="password" name="j_password" class="form-control" placeholder="Password">
            </div>
            <div class="form-group">
                <input type="submit" class="btn btn-default" name="Submit" value="Submit">
                <input type="reset" class="btn btn-default" name="Reset">
            </div>
        </form>
        </div>

        <c:if test="${not empty error}">
            <div class="errorblock">
                Your login was unsuccessful. <br/>
                Cause: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message }
            </div>
        </c:if>
    </div>

    <div class="col-md-2"></div>
</div>

<div class="col-md-4"></div>
</body>
</html>
