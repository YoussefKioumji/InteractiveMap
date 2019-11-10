<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <body>
        <c:set var="pageTitle" value="Delete Page"/>
        <jsp:include page="header.jsp">
            <jsp:param name="title" value="${pageTitle}"/>
        </jsp:include>
        <h2>Choose property's code to delete</h2>
        <form action="${pageContext.request.contextPath}/interactive-map/delete" method="post">
            <select name="id">
                <c:forEach items="${properties}" var="property">
                            <option value="${property.id}"><c:out value="${property.id}"/></option>
                </c:forEach>
            </select>
            <br><input type="submit" value="Delete"/>
        </form>
        <c:if test="${not empty message}">
            <c:out value="${message}"/>
        </c:if>
    </body>
</html>