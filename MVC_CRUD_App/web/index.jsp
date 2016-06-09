<%-- 
    Document   : index
    Created on : Jun 8, 2016, 3:37:12 PM
    Author     : Abdur Razzak <abdur.razzaq06@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD Example</title>
    </head>
    <body>
        <jsp:forward page="/UserController?action=listuser" />
    </body>
</html>
