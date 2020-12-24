<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../jsp/bootstrapJs.jsp" %>
<link href="${pageContext.request.contextPath}/styles.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="../WEB-INF/style.css">

<html>
<head>
    <title>Users list</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <!--change this fucking sh**t-->
        <a class="navbar-brand" href="/andersenCiCd/test">Andersen</a>
        <form action="/registration" method="post">
            <table>
                <tr>
                    <td>

                            <input type="text" class="form-control" name="email" maxlength="30"
                                   pattern="^[^\s]+[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" placeholder="Enter email"
                                   required>

                    </td>
                    <td>

                            <input type="text" pattern="[\w*\S]*" title="Only letters"
                                   class="form-control" name="name" maxlength="30" placeholder="Enter your name"
                                   required>

                    </td>
                    <td>

                            <input type="text" pattern="[\w*\S]*" title="Only letters"
                                   class="form-control" name="surname" maxlength="30"
                                   placeholder="Enter your surname" required>

                    </td>
                    <td>
                        <input type="submit" class="btn btn-secondary" value="Submit">
                        <input type="reset" class="btn btn-secondary" value="Clear fields">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</nav>
<table class="table table-dark">
    <thead>
    <tr>
        <th>user email</th>
        <th>user name</th>
        <th>user surname</th>
        <th></th>
    </tr>
    </thead>
    <c:forEach items="${requestScope.users}" var="user">
        <tr>
            <td><c:out value="${user.getEmail()}"/></td>
            <td><c:out value="${user.getName()}"/></td>
            <td><c:out value="${user.getSurname()}"/></td>
            <form action="deleteUser" method="POST">
                <td>
                    <button type="submit" class="btn btn-secondary" name="deleteUserId"
                            value="${user.getId()}">Delete
                    </button>
                </td>
            </form>
        </tr>
    </c:forEach>
</table>
</body>
</html>
