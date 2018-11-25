<%--
  Created by IntelliJ IDEA.
  User: 986758
  Date: 11/14/2018
  Time: 2:18 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title></title>
    <script type="text/javascript"
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="resources/js/script.js"></script>
</head>
<body>
<h1>Ready for the Quiz?</h1>
<form method="post">
    Select Quiz : <select name="type">
        <option selected="selected">Select</option>
        <c:forEach var="type" items="${types}">
            <option value="${type.id}">${type.name}</option>
        </c:forEach>
    </select>
<button type="submit" >Start Quiz</button>
</form>
</body>
</html>