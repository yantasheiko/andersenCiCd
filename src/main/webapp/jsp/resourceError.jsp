<%@ include file="../jsp/bootstrapJs.jsp" %>
<link href="${pageContext.request.contextPath}/styles.css" rel="stylesheet" type="text/css">

<html>
<head>
    <title>Wrong resource error</title>
</head>
<body>
<div class="alert alert-success" role="alert">
    ${requestScope.resourceError}
</div>
<div class="alert alert-secondary" role="alert">
    Back to user list <a href='/andersenCiCd/test' class="alert-link">click here</a>
</div>
</body>
</html>
