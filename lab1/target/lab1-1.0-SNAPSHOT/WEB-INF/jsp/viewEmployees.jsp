<%--
  Created by IntelliJ IDEA.
  User: utkin
  Date: 24.02.2020
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p align="center">Список сотрудников: </p>
<table border="3" width="50%" cellpadding="2" align="center">
    <tr>
        <th>ID</th>
        <th>ИМЯ</th>
        <th>ВОЗРАСТ</th>
        <th>ДОЛЖНОСТЬ</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach var="employee" items="${list}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.age}</td>
            <td>${employee.role}</td>
            <td><a href="editEmployee/${employee.id}">Редактировать</a></td>
            <td><a href="deleteEmployee/${employee.id}">Удалить</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="index">Назад</a>
