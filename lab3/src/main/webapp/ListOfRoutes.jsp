<%-- 
    Document   : ListOfRoutes
    Created on : 07.05.2020, 23:27:36
    Author     : utkin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Routes</title>
    </head>
    <body>
        <h1>This is list of routes</h1>
        <form action = "CreateRoute" method="get">
            <input type="submit" value="Create new route">
        </form>
        <table align="left" style="border-spacing: 30px 11px;" >
            <tr>
                <th>Number</th>
                <th>Instal stop</th>
                <th>Final stop</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach items="${routes}" var="route">
                <tr>
                    <td>${route.number}</td>
                    <td>${route.instalStop}</td>
                    <td>${route.finalStop}<td>
                    <td><form action="DeleteRoute" method="post">
                            <input type="hidden" name="id" value="${route.id}">
                            <input type="submit" value="delete"> </form>
            </td>
            <td>
                <form action="EditRoute" method="get">
                            <input type="hidden" name="id" value="${route.id}">
                            <input type="submit" value="Edit">
                </form>
            </td>
                </tr>
            </c:forEach>        
        </table>
    </body>
</html>
