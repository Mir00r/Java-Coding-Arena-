<%-- 
    Document   : index
    Created on : Jul 6, 2016, 2:39:00 AM
    Author     : Abdur Razzak <abdur.razzaq06@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
    <center>
        <h1>Struts 2 Hibernate Login Example</h1>
        <s:actionerror/>
        <s:form action="login">
            <s:textfield name="user.uname" label="Name"/>
            <s:password name="user.pwd" label="Password"/>
            <s:submit value="Login"/>
        </s:form>
    </center>
</body>
</html>