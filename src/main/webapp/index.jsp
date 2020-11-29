<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homepage</title>
</head>
<body>
    <form method="POST">
        <input type="submit" value="init database"/>
    </form>

    <form method="GET" action="/lab71-1/specs">
        <input type="submit" value="specialties">
    </form>

    <form method="GET" action="/lab71-1/groups">
        <input type="submit" value="groups">
    </form>

    <form method="GET" action="/lab71-1/st_group">
        <input type="submit" value="students by group">
    </form>

    <form method="GET" action="/lab71-1/st_course">
        <input type="submit" value="students by course">
    </form>
</body>
</html>
