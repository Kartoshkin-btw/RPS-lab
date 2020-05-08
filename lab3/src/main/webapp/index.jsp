<%-- 
    Document   : index
    Created on : 08.05.2020, 0:09:18
    Author     : utkin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>        
    <h1>List of flights
        <form action = "ListOfFlights" method="get">
            <input type="submit" value="ListOfFlights">
        </form>
    </h1>
        <h1>List of routes
        <form action = "ListOfRoutes" method="get">
            <input type="submit" value="ListOfRoutes">
        </form>
    </h1>
    </body>
</html>
