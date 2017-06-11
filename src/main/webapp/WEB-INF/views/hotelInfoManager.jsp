<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>HotelBook Management Console</title>
    <c:url var="favicon" value="/resources/images/favicon.png"/>
    <link rel="shortcut icon" href="${favicon}">

    <jsp:include page="bootstrapImports.jsp"/>
</head>
<body>
    <jsp:include page="headerManager.jsp"/>

    <p><strong>Name:</strong></p>
    <p>${hotelInfo.name}</p>
    <p><strong>Description:</strong></p>
    <p>${hotelInfo.description}</p>
    <p><strong>Address Details:</strong></p>
    <p>Street: ${hotelInfo.address.street}</p>
    <p>Number: ${hotelInfo.address.number}</p>
    <p>Postal Code: ${hotelInfo.address.postalCode}</p>
    <p>City: ${hotelInfo.address.city}</p>
    <p>Region: ${hotelInfo.address.region}</p>
    <p>Country: ${hotelInfo.address.country}</p>
    <p><strong>Contact phone number:</strong></p>
    <p>${hotelInfo.contactPhoneNumber}</p>
    <p><strong>Number of stars:</strong></p>
    <p>${hotelInfo.numberOfStars}</p>
    <p><strong>Check-in hours:</strong></p>
    <p>${hotelInfo.checkInHours}</p>
    <p><strong>Check-out hours:</strong></p>
    <p>${hotelInfo.checkOutHours}</p>
    <p><strong>Hotel Features:</strong></p>
    <p>${hotelInfo.hotelFeatures}</p>
    <p><strong>Room Features:</strong></p>
    <p>${hotelInfo.roomFeatures}</p>
    <p><strong>Rooms:</strong></p>
    <p>${hotelInfo.roomsList}</p>
</body>
</html>
