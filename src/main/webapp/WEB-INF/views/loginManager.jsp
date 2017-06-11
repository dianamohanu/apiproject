<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>HotelBook Management Console</title>
    <c:url var="favicon" value="/resources/images/favicon.png"/>
    <link rel="shortcut icon" href="${favicon}">

    <jsp:include page="bootstrapImports.jsp"/>

    <c:url var="loginLogoutStyle" value="/resources/style/loginLogout.css"/>
    <link rel="stylesheet" type="text/css" href="${loginLogoutStyle}">
</head>

<body style="background-color: #3e4e51;">

<div class="container-fluid jumbotron" style="background-color: #3e4e51;">
    <div class="row">
        <div class="col-xs-2 col-sm-4 col-md-5 col-lg-5"></div>
        <div class="col-xs-8 col-sm-4 col-md-2 col-lg-2">
            <div class="logo"></div>

            <form action="j_spring_security_check" name="f" method="post">
                <c:if test="${not empty isLogout}">
                    <div class="form-group">
                        <label class="successfulLogout"><span class="glyphicon glyphicon-ok"></span>&nbsp;You have been successfully logged out!</label>
                    </div>
                </c:if>

                <div class="form-group">
                    <input type="text" name="j_username" value="" class="form-control" placeholder="Username">
                </div>
                <div class="form-group">
                    <input type="password" name="j_password" class="form-control" placeholder="Password">
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-login" name="Submit" value="Login">
                    <input type="reset" class="btn btn-login" name="Reset">
                </div>
            </form>
        </div>
        <div class="col-xs-2 col-sm-4 col-md-5 col-lg-5"></div>
    </div>

    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <c:if test="${not empty error}">
                <div class="errorblock">
                    Your login was unsuccessful. <br/>
                    Cause: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message }
                </div>
            </c:if>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>

</body>
</html>

