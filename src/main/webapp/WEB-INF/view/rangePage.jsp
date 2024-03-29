<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <body>
        <c:set var="pageTitle" value="Range Page"/>
        <jsp:include page="header.jsp">
            <jsp:param name="title" value="${pageTitle}"/>
        </jsp:include>
        <div class="w3-row-padding w3-margin-top">
            <h2>Properties within range</h2>
            <form action="${pageContext.request.contextPath}/interactive-map/range/page=1" method="get">
                <label>X coordinate:</label>
                <input type="number" min="0" name="x">
                <br>
                <label>Y coordinate:</label>
                <input type="number" min="0" name="y">
                <br>
                <button>Submit</button>
            </form>
        </div>
    </body>
</html>