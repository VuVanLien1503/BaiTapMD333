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
    <form action="student?action=edit&id=${student.id}" method="post">
        <table border="1" style="border-collapse: collapse">

            <tr>
                <th>Name</th>
                <td><input type="text" name="name" value="${student.name}"></td>
            </tr>
            <tr>
                <th>Birth</th>
                <td><input type="text" name="date" value="${student.birth}"></td>
            </tr>
            <tr>
                <th>Phone</th>
                <td><input type="text" name="phone" value="${student.phone}"></td>
            </tr>
            <tr>
                <th>Email</th>
                <td><input type="text" name="email" value="${student.email}"></td>
            </tr>
            <tr>
                <th>Address</th>
                <td><input type="text" name="address" value="${student.address}"></td>
            </tr>
            <tr>
                <th><label for="classroom">Classroom:</label></th>
                <td>
                    <select name="classroom" id="classroom">
                        <c:forEach items="${listClassroom}" var="classroom">
                                <option value="${classroom.id}">${classroom.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr style="text-align: center;color: red">
                <td colspan="2">
                    <h6>
                        <i>
                            <c:if test="${message!=null}">
                                ${message}
                            </c:if>
                        </i>
                    </h6>
                </td>
            </tr>

            <tr>
                <td colspan="2" style="text-align: center">
                    <button>Edit</button>
                </td>
            </tr>
        </table>

    </form>
</div>

</body>
</html>
