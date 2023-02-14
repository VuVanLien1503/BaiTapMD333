<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Student</title>
</head>
<body>
<h1>CreateStudent</h1>
<form action="/student?action=create" method="post">
  <table>
    <tr>
      <td>name</td>
      <td><input type="text" name="name"></td>
    </tr>
    <tr>
      <td>Date</td>
      <td><input type="text" name="date"></td>
    </tr>
    <tr>
      <td>Address</td>
      <td><input type="text" name="address"></td>
    </tr>
    <tr>
      <td>phone</td>
      <td><input type="text" name="phone"></td>
    </tr>
    <tr>
      <td>email</td>
      <td><input type="text" name="email"></td>
    </tr>
    <tr>
      <td>Classroom</td>
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
             <span> <a href="/student">${message} Back List</a></span>
            </c:if>
          </i>
        </h6>
      </td>
    </tr>

    <tr>
      <td colspan="2">
        <button>Create</button>
      </td>
    </tr>
  </table>
</form>
</body>
</html>
