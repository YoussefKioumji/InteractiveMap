<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <title>${param.title}</title>
    </head>
    <body>
        <div class="w3-top">
            <div class="w3-bar w3-white w3-padding w3-card" style="letter-spacing:1px;">
                <a href="${pageContext.request.contextPath}/interactive-map/home"><c:out value="InteractiveMap"/></a>
                <div class="w3-right">
                    <a href="${pageContext.request.contextPath}/interactive-map/properties/page=1"><c:out value="Properties"/></a>
                    <a href="${pageContext.request.contextPath}/interactive-map/showRange"><c:out value="Properties within range"/></a>
                    <a href="${pageContext.request.contextPath}/interactive-map/deletePage"><c:out value="Delete property"/></a>
                    <a href="${pageContext.request.contextPath}/interactive-map/createPage"><c:out value="Create property"/></a>
                </div>
            </div>
        </div>
        <br>
    </body>
</html>