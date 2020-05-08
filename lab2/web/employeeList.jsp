<%--
  Created by IntelliJ IDEA.
  User: utkin
  Date: 05.05.2020
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>List of employees</h1>
<table border="3" width="50%" cellpadding="2" align="center">>
    <tr>
        <th>ID</th>
        <th>ИМЯ</th>
        <th>ВОЗРАСТ</th>
        <th>ДОЛЖНОСТЬ</th>
    </tr>
    <c:forEach var="employee" items="${list}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.age}</td>
            <td>${employee.role}</td>
            <td>
                <form action="updateEmployee" method="get">
                    <input type="hidden" name="id" value="${employee.getId()}">
                    <input type="submit" value="Редактировать">
                </form>
            </td>
            <td>
                <form action="deleteEmployee" method="post">
                    <input type="hidden" name="id" value="${employee.getId()}">
                    <input type="submit" value="Удалить">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<form action = "insertPage" method="get">
    <input type="submit" value="Insert new employee">
</form>
</body>

</html>

