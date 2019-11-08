<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <body>
        <c:set var="pageTitle" value="Properties within range"/>
        <jsp:include page="header.jsp">
            <jsp:param name="title" value="${pageTitle}"/>
        </jsp:include>
        <div class="w3-row-padding w3-margin-top">
            <h2>Properties within range</h2>
            <table border="1" class="w3-table w3-bordered w3-striped">
                <thead>
                <tr>
                    <th>Property code</th>
                    <th>Number of rooms</th>
                    <th>Area (m<sup>2</sup>)</th>
                    <th>Description</th>
                    <th>Address</th>
                    <th>Pictures</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${properties}" var="property">
                    <tr>
                        <th><c:out value="${property.id}"/></th>
                        <th><c:out value="${property.rooms}"/></th>
                        <th><c:out value="${property.area}"/></th>
                        <th><c:out value="${property.description}"/></th>
                        <th><c:out value="${property.address}"/></th>
                        <th>
                            <c:forEach items="${property.pictures}" var="image">
                                <img src="/pictures/picture/${image.id}" width="200" height="200"/>
                            </c:forEach>
                        </th>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
            <c:forEach begin="1" end="${numberOfPages}" varStatus="loop">
                <a href="${pageContext.request.contextPath}/interactive-map/range/page=${loop.index}?x=${x}&y=${y}" class="w3-bar-item w3-button w3-theme">${loop.index}</a>
            </c:forEach>
        </div>
    </body>
</html>