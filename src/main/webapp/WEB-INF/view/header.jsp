<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
        <script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>
        <title>${param.title}</title>
    </head>
    <body>
        <div class="w3-top">
            <div class="w3-bar w3-white w3-padding w3-card" style="letter-spacing:1px;">
                <div class="container unauthenticated">
                    <a href="${pageContext.request.contextPath}/interactive-map/home"><c:out value="InteractiveMap"/></a>
                    <div class="w3-right">
                        <a href="${pageContext.request.contextPath}/interactive-map/properties/page=1"><c:out value="Properties"/></a>
                        <a href="${pageContext.request.contextPath}/interactive-map/showRange"><c:out value="Properties within range"/></a>
                        <a href="${pageContext.request.contextPath}/login"><c:out value="Login"/></a>
                    </div>
                </div>
                <div class="container authenticated" style="display:none">
                    <a href="${pageContext.request.contextPath}/interactive-map/home"><c:out value="InteractiveMap"/></a>
                    <div class="w3-right">
                        <a href="${pageContext.request.contextPath}/interactive-map/properties/page=1"><c:out value="Properties"/></a>
                        <a href="${pageContext.request.contextPath}/interactive-map/showRange"><c:out value="Properties within range"/></a>
                        <a href="${pageContext.request.contextPath}/interactive-map/deletePage"><c:out value="Delete property"/></a>
                        <a href="${pageContext.request.contextPath}/interactive-map/createPage"><c:out value="Create property"/></a>
                        <a href="${pageContext.request.contextPath}/interactive-map/updatePage"><c:out value="Update property"/></a>
                        <a href="javascript:logout()"><c:out value="Logout"/></a>
                    </div><br><br>
                    Logged into Facebook as: <span id="user"></span>
                </div>
            </div>
        </div>
        <br><br><br>
        <script type="text/javascript">
            if (window.location.hash == '#_=_') {
                history.replaceState
                    ? history.replaceState(null, null, window.location.href.split('#')[0])
                    : window.location.hash = '';
            }

                $.get("/user", function(data) {
                $("#user").html(data.userAuthentication.details.name);
                $(".unauthenticated").hide()
                $(".authenticated").show()
            });

            var logout = function() {
                $.post("/logout", function() {
                    $("#user").html('');
                    $(".unauthenticated").show();
                    $(".authenticated").hide();
                });
                location.reload();
                return true;
            }
        </script>
    </body>
</html>