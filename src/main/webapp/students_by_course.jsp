<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
</head>
<body>
    <form method="GET" action="/lab71-1">
        <input type="submit" value="back to homepage">
    </form>

    <form method="POST">
        <select name="courseId">
            <option selected disabled>Select course</option>
            <c:forEach items="${allCourses}" var="course">
                <option value="${course.getId()}">${course.getName()}</option>
            </c:forEach>
        </select>
        <input type="submit" value="find students">
    </form>

    <c:if test="${students != null}">
        <h3>Students</h3>
        <table border="1">
            <thead>
                <tr>
                    <th>Surname</th>
                    <th>First name</th>
                    <th>Middle name</th>
                    <th>Group code</th>
                    <th>Course</th>
                    <th>Passport serial</th>
                    <th>Passport number</th>
                    <th>Born date</th>
                </tr>
            </thead>
            <c:forEach items="${students}" var="student">
                <tr>
                    <td>${student.getF()}</td>
                    <td>${student.getI()}</td>
                    <td>${student.getO()}</td>
                    <td>${student.getGroup().getGroupCode()}</td>
                    <td>${student.getCourse().getName()}</td>
                    <td>${student.getPassportSer()}</td>
                    <td>${student.getPassportNum()}</td>
                    <td>${student.bornDateToString()}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>
