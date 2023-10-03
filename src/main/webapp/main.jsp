<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/29/2023
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
<jsp:include page="static/additional/helper.jsp"/>
<h3 autofocus style="animation: forwards">Book Store</h3>
<a href="/library/add" class="btn btn-success">Add new Book</a>
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Title</th>
        <th scope="col">Pages</th>
        <th scope="col">Author</th>
        <th scope="col">Publisher</th>
        <th scope="col">Published date</th>
        <th scope="col">Description</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="temp">
        <tr>
            <td><c:out value="${temp.getId()}"/></td>
            <td><c:out value="${temp.getTitle()}"/></td>
            <td><c:out value="${temp.getPages()}"/></td>
            <td><c:out value="${temp.getAuthorName()}"/></td>
            <td><c:out value="${temp.getPublisher()}"/></td>
            <td><c:out value="${temp.getPublishedAt()}"/></td>
            <td><c:out value="${temp.getDescription()}"/></td>
            <td>
                <a href="/library/update/${temp.getId()}" class="btn btn-warning">Edit</a> |
                <a href="/library/delete/${temp.getId()}" class="btn btn-danger">Delete</a>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
