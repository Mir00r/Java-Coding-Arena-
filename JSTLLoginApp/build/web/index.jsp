<%-- 
    Document   : index
    Created on : Jun 6, 2016, 7:08:02 PM
    Author     : Abdur Razzak <abdur.razzaq06@gmail.com>
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         
        <title>Index Page</title>
    </head>
    <body>
        <h1>Hello <%=session.getAttribute("loginUser")%></h1>
        <%@include file="header.jsp" %>
    </body>
</html>
