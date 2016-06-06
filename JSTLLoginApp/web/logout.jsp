<%-- 
    Document   : logout
    Created on : Jun 6, 2016, 7:56:05 PM
    Author     : Abdur Razzak <abdur.razzaq06@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logged out</title>
    </head>
    <body>
        <%
            session.removeAttribute("loginUser");
        %>
 
        <a href="index.jsp">index.jsp</a>
    </body>
</html>