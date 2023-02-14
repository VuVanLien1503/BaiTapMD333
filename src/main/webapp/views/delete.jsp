<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="student?action=delete&id=${student.id}" method="post">
    <h1> Bạn có muốn xóa Học Sinh Có Tên Là ${student.name}</h1>
    <button>Delete</button>
</form>


</body>
</html>
