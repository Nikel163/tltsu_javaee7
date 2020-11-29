<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Student groups</title>
</head>
<body>
    <form method="GET" action="/lab71-1">
        <input type="submit" value="back to homepage">
    </form>
    <form method="POST">
        <select name="specialtyId">
            <option selected disabled>Select specialty</option>
            <c:forEach items="${allSpecs}" var="spec">
                <option value="${spec.getId()}">${spec.getSpecName()}</option>
            </c:forEach>
        </select>
        <input type="submit" value="find groups">
    </form>
    <p></p>
    <c:if test="${groups != null}">
        <h3>Student groups</h3>
        <table border="1">
            <thead>
                <tr>
                    <th>Group code</th>
                </tr>
            </thead>
            <c:forEach items="${groups}" var="course">
                <tr>
                    <td>${course.getGroupCode()}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>
