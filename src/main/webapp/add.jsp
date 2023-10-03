<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/29/2023
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book adding</title>
</head>
<body>
<jsp:include page="static/additional/helper.jsp"/>
<h1 style="color: dodgerblue">Add New Book</h1>

<form method="post" enctype="multipart/form-data" name='registration' onSubmit="return formValidation();">
    <ul>
        <li><label for="title">Title:</label></li>
        <li><input type="text" id="title" name="title" size="12" /></li>

        <li><label for="page">Page: </label></li>
        <li><input type="number" id="page" name="page" size="12" /></li>

        <li><label for="author">Author:</label></li>
        <li><input type="text" id="author" name="author" size="12" /></li>

        <li><label for="publisher">Publisher:</label></li>
        <li><input type="text" id="publisher" name="publisher" size="12"/></li>

        <li><label for="publishDate">Published At:</label></li>
        <li><input type="date" id="publishDate" name="publishDate" size="12"/></li>

        <li><label for="desc">Description:</label></li>
        <li><textarea name="desc" id="desc"></textarea></li>

        <li><label for="file">Upload file: <input type="file" id="file" name="file"></label></li>

        <li><label>
            <div>
                <input type="submit" class="btn btn-success" name="submit" value="Save" />
                <a href="/main.jsp" class="btn btn-warning">Back</a>
            </div>
        </label></li>
    </ul>

</form>

<script src="./static/js/validation.js"></script>


</body>
</html>
