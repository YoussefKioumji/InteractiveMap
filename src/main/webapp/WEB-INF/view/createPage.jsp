<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <body>
        <c:set var="pageTitle" value="Create Page"/>
        <jsp:include page="header.jsp">
            <jsp:param name="title" value="${pageTitle}"/>
        </jsp:include>
        <h2>Create a property:</h2>
        <form action="${pageContext.request.contextPath}/interactive-map/create" method="post" enctype="multipart/form-data">
            <label>Enter the number of rooms:</label>
            <input type="number" min="0" name="rooms">
            <br>
            <label>Enter the area:</label>
            <input type="text" name="area">
            <br>
            <label>Enter the description:</label>
            <input type="text" name="description">
            <br>
            <label>Enter the address:</label>
            <input type="text" name="address">
            <br>
            <label>Enter the X coordinate:</label>
            <input type="text" name="xAxis">
            <br>
            <label>Enter the Y coordinate:</label>
            <input type="text" name="yAxis">
            <br>
            <label>Upload Pictures:</label>
            <input type="file" name="pictures" multiple>
            <br>
            <input type="submit" value="Create"/>
        </form>
        <c:if test="${not empty message}">
            <c:out value="${message}"/>
        </c:if>
    </body>
</html>