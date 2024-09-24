<%-- 
    Document   : index.jsp
    Created on : 25-Jul-2022, 4:43:17 PM
    Author     : CDAC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My First JSP Page</title>
    </head>
    <body>
        <% String uname = request.getParameter("name"); %>
        <h1> Hello <%= uname %> </h1>
        
    </body>
</html>

