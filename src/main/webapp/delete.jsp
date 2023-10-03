<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/29/2023
  Time: 6:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title> Delete </title>
</head>
<body>
<jsp:include page="static/additional/helper.jsp"/>
<form method="post">
    <div class="alert alert-danger">
        <h3>Are you sure for delete book named "<i> <c:out value="${deletingBook.getTitle()}"/></i>" ?</h3>
    </div>
    <a href="/library" class="btn btn-warning">Back</a>
    <button type="submit" class="btn btn-danger">Delete</button>
</form>

</body>
</html>
