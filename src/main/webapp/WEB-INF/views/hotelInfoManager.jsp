<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>HotelBook Management Console</title>
    <c:url var="favicon" value="/resources/images/favicon.png"/>
    <link rel="shortcut icon" href="${favicon}">

    <jsp:include page="bootstrapImports.jsp"/>

    <c:url var="formBtnStyle" value="/resources/style/formBtnStyle.css"/>
    <link rel="stylesheet" type="text/css" href="${formBtnStyle}">
    <c:url var="tableStyle" value="/resources/style/tableStyle.css"/>
    <link rel="stylesheet" type="text/css" href="${tableStyle}">

    <c:url var="mainImage" value="${hotelInfo.mainImageURL}"/>
</head>
<body>
<jsp:include page="headerManager.jsp"/>

<div class="container">
    <div class="col-md-2"></div>
    <div class="col-md-8" style="color: #3E4E51;">
        <h4>HOTEL INFORMATION</h4>

        <div class="table-responsive">
            <table class="table table-condensed">
                <tbody>
                <tr>
                    <td><strong>Name:</strong></td>
                    <td>${hotelInfo.name}</td>
                </tr>
                <tr>
                    <td><strong>Description:</strong></td>
                    <td>${hotelInfo.description}</td>
                </tr>
                <tr>
                    <td><strong>Contact phone number:</strong></td>
                    <td>${hotelInfo.contactPhoneNumber}</td>
                </tr>
                <tr>
                    <td><strong>Email:</strong></td>
                    <td>${hotelInfo.email}</td>
                </tr>
                <tr>
                    <td><strong>Address Details:</strong></td>
                    <td>
                        <table class="table table-condensed">
                            <tbody>
                            <tr>
                                <td><strong>Street:</strong></td>
                                <td>${hotelInfo.address.street}</td>
                            </tr>
                            <tr>
                                <td><strong>Number:</strong></td>
                                <td>${hotelInfo.address.number}</td>
                            </tr>
                            <tr>
                                <td><strong>Postal Code:</strong></td>
                                <td>${hotelInfo.address.postalCode}</td>
                            </tr>
                            <tr>
                                <td><strong>City:</strong></td>
                                <td>${hotelInfo.address.city}</td>
                            </tr>
                            <tr>
                                <td><strong>Region:</strong></td>
                                <td>${hotelInfo.address.region}</td>
                            </tr>
                            <tr>
                                <td><strong>Country:</strong></td>
                                <td>${hotelInfo.address.country}</td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td><strong>Number of stars:</strong></td>
                    <td>${stars} </td>
                </tr>
                <tr>
                    <td><strong>Check-in hours:</strong></td>
                    <td>${hotelInfo.checkInHours}</td>
                </tr>
                <tr>
                    <td><strong>Check-out hours:</strong></td>
                    <td>${hotelInfo.checkOutHours}</td>
                </tr>
                <tr>
                    <td><strong>Hotel Features:</strong></td>
                    <td>${hotelInfo.hotelFeatures}</td>
                </tr>
                <tr>
                    <td><strong>Room Features:</strong></td>
                    <td>${hotelInfo.roomFeatures}</td>
                </tr>
                <tr>
                    <td><strong>Rooms:</strong></td>
                    <td>
                        <table class="table table-condensed">
                            <thead>
                            <th>Room number</th>
                            <th>Capacity</th>
                            <th>Price in lei</th>
                            <th>Price in euro</th>
                            <th>Price in dollars</th>
                            <th>Price in pounds</th>
                            </thead>
                            <tbody>
                            <c:forEach var="room" items="${hotelInfo.roomsList}">
                                <tr>
                                    <td>${room.roomNumber}</td>
                                    <c:if test="${room.capacity == 1}">
                                        <td>${room.capacity} adult</td>
                                    </c:if>
                                    <c:if test="${room.capacity > 1}">
                                        <td>${room.capacity} adults</td>
                                    </c:if>
                                    <td>${room.pricePerNight.priceInLei} lei</td>
                                    <td>${room.pricePerNight.priceInEuro} €</td>
                                    <td>${room.pricePerNight.priceInDollars} $</td>
                                    <td>${room.pricePerNight.priceInPounds} £</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td><strong>Image: </strong></td>
                    <td><img class="img-responsive" src="${mainImage}"></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="col-md-2"></div>
</div>

</body>
</html>
