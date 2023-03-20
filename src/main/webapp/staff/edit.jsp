<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 20/03/2023
  Time: 9:15 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
<table border="1">
    <tr>
    <th>ID</th>
    <td><input type="text" name="id" id="id" value="<c:out value='${staff.id}'/>"></td>
    </tr>
    <tr>
        <th>Name</th>
        <td><input type="text" name="name" id="name" value="<c:out value='${staff.name}'/>"></td>
    </tr>
    <tr>
        <th>Email</th>
        <td><input type="text" name="email" id="email" value="<c:out value='${staff.email}'/>"></td>
    </tr>
    <tr>
        <th>Address</th>
        <td><input type="text" name="address" id="address" value="<c:out value='${staff.address}'/>"></td>
    </tr>
    <tr>
        <th>Phone number</th>
        <td><input type="text" name="phoneNumber" id="phoneNumber" value="<c:out value='${staff.phoneNumber}'/>"></td>
    </tr>
    <tr>
        <th>Salary</th>
        <td><input type="text" name="salary" id="salary" value="<c:out value='${staff.salary}'/>"></td>
    </tr>
    <tr>
        <th>Department</th>
            <td><input type="text" name="id_der" id="id_der" value="<c:out value='${staff.department.id_der}'/>"></td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input type="submit" value="Save"/>
            <a href="/staffs">Back to list</a>
        </td>
    </tr>
</table>
</form>
</body>
</html>
