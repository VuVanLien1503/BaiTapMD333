<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Student</title>
</head>
<body>
<h1 style="margin-left: 500px">List Student</h1>
<h3 style="margin-left: 600px"><a href="/student"> Back To List</a></h3>

<div style="margin-left: 350px; margin-top: 50px">
    <table border="1" style="border-collapse: collapse">

        <tr>
            <th>Name</th>
            <td>${student.name}</td>
        </tr>
        <tr>
            <th>Birth</th>
            <td>${student.birth}</td>
        </tr>
        <tr>
            <th>Phone</th>
            <td>${student.phone}</td>
        </tr>
        <tr>
            <th>Email</th>
            <td>${student.email}</td>
        </tr>
        <tr>
            <th>Address</th>
            <td>${student.address}</td>
        </tr>
        <tr>
            <th>Classroom</th>
            <td>
                <c:forEach items="${listClassroom}" var="classroom">
                    <c:if test="${classroom.id == student.classroom_id}">
                        ${classroom.name}
                    </c:if>
                </c:forEach>
            </td>
        </tr>
    </table>
</div>

</body>
</html>
