<%-- 
    Document   : dbcon
    Created on : 25-Jul-2022, 5:15:04 PM
    Author     : CDAC
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> DB Connection </title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    </head>
    <body>
        <%  
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/test";
        String uname="root";
        String pwd=""; 
        Connection con = DriverManager.getConnection(url, uname, pwd);
        Statement st=null;
        if(con != null)
        %>
        <h1 style="color:rosybrown"> Connection established! </h1>
        <% st = con.createStatement();
         ResultSet rs = st.executeQuery("select * from customers"); %>
         <div class="container">
         <table class="table">
         <tr class="info"><th>CID</th> <th> CNAME</th> <th>Balanace</th> <th> CITY</th></tr>    
         <% while (rs.next()){ %>
         <tr class="success"><td><%= rs.getInt(1) %></td><td><%= rs.getString(2) %></td><td><%= rs.getDouble(3) %></td><td><%= rs.getString(4) %></td></tr>      
         <% } %>
         </table>
         </body>
</html>
