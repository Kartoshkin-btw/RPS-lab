<%-- 
    Document   : EditFlight
    Created on : 08.05.2020, 0:05:51
    Author     : utkin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EditFlight</title>
    </head>
    <body>
        <h1>Edit Flight</h1>
        <form action="EditFlight" method="POST">
            <form action="CreateFlight" method="POST">
            <table align="left">
                <tr>
                    <td>Date</td>
                    <td>
                        <input type="text" required name="date"/>
                    </td>
                </tr>
                <tr>
                    <td>Time</td>
                    <td>
                        <input type="text" required name="time">
                    </td>
                </tr>
                <tr>
                    <td>Route</td>
                    <td>
                        <select name="route">
                            <c:forEach items="${routes}" var="route">
                                <option value="${route.id}">${route.number}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
            <input required type="submit" value="SAVE"/>
        </form>
    </body>
</html>

