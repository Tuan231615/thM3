<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 20/03/2023
  Time: 9:58 am
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
            <td>
                <input type="text" name="id" id="id">
            </td>
        </tr>
        <tr>
            <th>Name</th>
            <td><input type="text" name="name" id="name"></td>
        </tr>
        <tr>
            <th>Email</th>
            <td>
                <input type="text" name="email" id="email">
            </td>
        </tr>
        <tr>
            <th>Address</th>
            <td>
                <input type="text" name="address" id="address">
            </td>
        </tr>
        <tr>
            <th>Phone number</th>
            <td>
                <input type="text" name="phoneNumber" id="phoneNumber">
            </td>
        </tr>
        <tr>
            <th>Salary</th>
            <td><input type="text" name="salary" id="salary"></td>
        </tr>
        <tr>
            <th>Id Department</th>
            <td><input type="text" name="id_der" id="id_der"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Save"/>
                <a href="/staffs">Back To List Staff</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
