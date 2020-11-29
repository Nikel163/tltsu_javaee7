<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Specialties</title>
</head>
<body>
    <form method="GET" action="/lab71-1">
        <input type="submit" value="back to homepage">
    </form>
    <h3>Specialties</h3>
    <table border="1">
        <thead>
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Short name</th>
            </tr>
        </thead>
        <c:forEach items="${allSpecs}" var="spec">
            <tr>
                <td>${spec.getSpecCode()}</td>
                <td>${spec.getSpecName()}</td>
                <td>${spec.getSpecNameShort()}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
