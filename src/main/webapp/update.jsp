<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/29/2023
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Updating Page</title>
    <link href="static/additional/helper.jsp">
</head>
<body>
<jsp:include page="static/additional/helper.jsp"/>
<form method="post">
    <div class="alert alert-danger">
        <h3>Are you sure for update book named "<i> <c:out value="${updatingBook.getTitle()}"/></i>" ?</h3>

        <label>
            Title <input name="title" value="${updatingBook.getTitle()}" size="24">
        </label>
        <br><br>
        <label>
            AuthorName<input name="author" value="${updatingBook.getAuthorName()}" size="24">
        </label>
        <br><br>
        <label>
            Pages Count
            <input type="number" name="pages" value="${updatingBook.getPages()}" size="24">
        </label>
        <br><br>
        <label>
            Publisher
            <input name="publisher" value="${updatingBook.getPublisher()}" size="24">
        </label>
        <br><br>
        <label for="desc">
            Description
            <textarea id="desc" name="fdsf" >
            </textarea>
        </label>
        <br><br>

        <a href="/library" class="btn btn-warning">Back</a>
        <button type="submit" class="btn btn-danger">Edit</button>
    </div>

</form>

</body>




