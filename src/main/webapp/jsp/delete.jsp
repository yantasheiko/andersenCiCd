<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="bootstrapJs.jsp" %>

<html>
<head>
    <title>Deletion list</title>
</head>
<body>
<div class="jumbotron">
    <h2 class="display-4">Deletion list</h2>
</div>
<c:choose>
    <c:when test="${requestScope.userDel != null}">
        <div class="alert alert-success" role="alert">
            <li>User with name ${requestScope.userDel} was deleted from DB</li>
        </div>
    </c:when>
</c:choose>
<div class="alert alert-secondary" role="alert">
    Back to user list <a href='/andersenCiCd/test' class="alert-link">click here</a>
</div>
</body>
</html>
