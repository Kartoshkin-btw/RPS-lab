<%-- 
    Document   : EditRoute
    Created on : 08.05.2020, 0:06:00
    Author     : utkin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EditRoute</title>
    </head>
    <body>
        <h1>Edit Route</h1>
        <form action="CreateRoute" method="POST">
            <table align="left">
                <tr>
                    <td>Number of route</td>
                    <td>
                        <input type="text" required name="number"/>
                    </td>
                </tr>
                <tr>
                    <td>Instal stop</td>
                    <td>
                        <input type="text" required name="instalStop">
                    </td>
                </tr>
                <tr>
                    <td>Final stop</td>
                    <td>
                        <input type="text" required name="finalStop">
                    </td>
                </tr>
            </table>
            <input required type="submit" value="SAVE"/>
        </form>
    </body>
</html>
