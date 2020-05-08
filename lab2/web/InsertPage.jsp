<%--
  Created by IntelliJ IDEA.
  User: utkin
  Date: 05.05.2020
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new Employee</title>
</head>
<body>
<form action="insertPage" method="post">
    <table align="center" border="3">
        <tr>
            <td>Введите имя:</td>
            <td><input required type="text" name="name" /></td>
        </tr>
        <tr>
            <td>Введите возраст :</td>
            <td><input required type="number" name="age" /></td>
        </tr>
        <tr>
            <td>Введите должность :</td>
            <td><input required type="text" name="role" /></td>
        </tr>
        <tr>
            <td>
                <input required type="submit" value="Сохранить"/>
            </td>
        </tr>
    </table>
</form>
</body>

</html>

