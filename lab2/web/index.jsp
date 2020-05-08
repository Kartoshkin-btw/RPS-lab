<%--
  Created by IntelliJ IDEA.
  User: utkin
  Date: 05.05.2020
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Employees</title>
</head>
<body>

<form action = "index" method="get">
  <input type="submit" value="Show employees">
</form>
<form action = "insertPage" method="get">
  <input type="submit" value="Insert new employee">
</form>
<form action = "stats" method="get">
  <input type="submit" value="Stats">
</form>
</body>

</html>

