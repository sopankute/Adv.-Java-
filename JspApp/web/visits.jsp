<%-- 
    Document   : visits
    Created on : 25-Jul-2022, 5:09:06 PM
    Author     : CDAC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page to count no of visits</title>
    </head>
    <body>
       <%! int count = 0; %>
       <h1> No of Visits: <%= ++ count %> </h1>
        
    </body>
</html>
