<%-- 
    Document   : ListOfFlights
    Created on : 07.05.2020, 23:27:05
    Author     : utkin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flights</title>
    </head>
    <body>
        <h1>This is list of flights</h1>
        <form action = "CreateFlight" method="get">
            <input type="submit" value="Create new flight">
        </form>
        <table align="left" style="border-spacing: 30px 11px;" >
            <tr>
                <th>Date</th>
                <th>Time</th>
                <th>Id Route</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach items="${flights}" var="flight">
                <tr>
                    <td>${flight.date}</td>
                    <td>${flight.time}</td>
                    <td>${flight.id_Route}<td>
                    <td><form action="DeleteFlight" method="post">
                            <input type="hidden" name="id" value="${flight.id}">
                            <input type="submit" value="delete"> </form>
            </td>
            <td>
                <form action="EditFlight" method="get">
                            <input type="hidden" name="id" value="${flight.id}">
                            <input type="submit" value="Edit">
                </form>
            </td>
                </tr>
            </c:forEach>        
        </table>
    </body>
</html>

