<%--
  Created by IntelliJ IDEA.
  User: utkin
  Date: 05.05.2020
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update employee</title>
</head>
<body>

<form action="updatePage" method="post" >
    <table>
        <tr>
            <td>Имя :</td>
            <td><input required type="text" name="name" /></td>
        </tr>
        <tr>
            <td>Возраст :</td>
            <td><input required type="text" name="age" /></td>
        </tr>
        <tr>
            <td>Должность :</td>
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

