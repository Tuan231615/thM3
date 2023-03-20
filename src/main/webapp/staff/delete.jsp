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
            <td>ID</td>
            <td><c:out value="${staff.id}"/></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><c:out value="${staff.name}"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><c:out value="${staff.email}"/></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><c:out value="${staff.address}"/></td>
        </tr>
        <tr>
            <td>Phone number</td>
            <td><c:out value="${staff.phoneNumber}"/></td>
        </tr>
        <tr>
            <td>Salary</td>
            <td><c:out value="${staff.salary}"/></td>
        </tr>

        <table>
            <h3>Are you sure?</h3>
            <tr>
                <td><input type="submit" value="Delete staff"></td>
                <td><a href="<c:url value="/staffs"/>">Back to list</a></td>
            </tr>
        </table>
    </table>
</form>
</body>
</html>
