<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>MANAGEMENT CONSOLE</title>

        <c:url var="loginLogoutStyle" value="/resources/style/loginLogout.css"/>
        <link rel="stylesheet" type="text/css" href="${loginLogoutStyle}">

        <c:url var="managerLoginImage" value="/resources/images/managerLogin.png"/>
    </head>

    <body style="background-color: #008080;">
        <jsp:include page="bootstrapImports.jsp" />

        <div class="col-md-4"></div>

        <div class="col-md-4">
            <div class="col-md-1"></div>

            <div class="col-md-10">
                <c:if test="${not empty error}">
                    <div class="errorblock">
                        Your login was unsuccessful. <br/>
                        Cause: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message }
                    </div>
                </c:if>

                <img src="${managerLoginImage}">

                <form action="j_spring_security_check" name="f" method="post">
                    <div class="row">
                        <label style="color: #ffffff">Username:</label>
                        <input type="text" name="j_username" value="" class="form-control">
                    </div>
                    <div class="row">
                        <label style="color: #ffffff">Password:</label>
                        <input input type="password" name="j_password" class="form-control">
                    </div>
                    <br/>
                    <div class="row">
                        <input type="submit" class="btn btn-info" name="Submit" value="Submit">
                        <input type="reset" class="btn btn-info" name="Reset">
                    </div>
                </form>
            </div>

            <div class="col-md-1"></div>
        </div>

        <div class="col-md-4"></div>
    </body>
</html>
