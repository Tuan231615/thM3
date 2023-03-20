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
<h2>Staff manager</h2>
<a href="/staffs?action=create">Create staff</a>
<table border="1">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>email</td>
        <td>address</td>
        <td>phone number</td>
        <td>Salary</td>
        <td>Department</td>
        <td>Action</td>
    </tr>
    <c:forEach var="staff" items="${staffs}">
        <tr>
            <td><c:out value="${staff.id}"/></td>
            <td><c:out value="${staff.name}"/></td>
            <td><c:out value="${staff.email}"/></td>
            <td><c:out value="${staff.address}"/></td>
            <td><c:out value="${staff.phoneNumber}"/></td>
            <td><c:out value="${staff.salary}"/></td>
            <td><c:out value="${staff.department.name}"/></td>
            <td>
                <a href="/staffs?action=edit&id=${staff.id}">Edit</a>
                <a href="/staffs?action=delete&id=${staff.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
