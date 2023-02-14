<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Student</title>
</head>
<body>
<h1 style="margin-left: 500px">List Student</h1>
<h3 style="margin-left: 600px"><a href="/student?action=create"> Create New Student</a></h3>
<div style="margin-left: 350px; margin-top: 50px">
    <table border="1" style="border-collapse: collapse">
        <tr>
            <th>STT</th>
            <th>Name</th>
            <th>Birth</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Classroom</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${listStudent}" var="element" varStatus="stt">
            <tr>
                <td>${stt.index+1}</td>
                <td>${element.name}</td>
                <td>${element.birth}</td>
                <td>${element.phone}</td>
                <td>${element.email}</td>
                <td>${element.address}</td>
                <td>
                    <c:forEach items="${listClassroom}" var="classroom">
                        <c:if test="${classroom.id == element.classroom_id}">
                            ${classroom.name}
                        </c:if>
                    </c:forEach>
                </td>
                <td><a href="/student?action=edit&id=${element.id}">Edit</a></td>
                <td><a href="/student?action=delete&id=${element.id}">delete</a></td>
            </tr>

        </c:forEach>
    </table>
</div>
</body>
</html>
