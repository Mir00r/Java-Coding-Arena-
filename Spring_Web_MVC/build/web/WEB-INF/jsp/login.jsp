<%-- 
    Document   : login
    Created on : Jul 22, 2016, 2:01:30 AM
    Author     : Abdur Razzak <abdur.razzaq06@ail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>

<!DOCTYPE html>

<html xmlns:form="http://www.springframework.org/tags/form" >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <center>
             <h1>Welcome our Login page</h1>
             <form action="${flowExecutionUrl}&_eventId=loginCredentialsEntered" 
                   method="post">
                 
                 <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
                 <br />
                 
                 <table>
                     <tr>
                         <td>Login Name : </td>
                         <td> <input type="text" name="loginName" /> </td>
                     </tr>
                     <tr>
                         <td>Password : </td>
                         <td> <input type="password" name="password" /> </td>
                     </tr>
                 </table>
                 <br />
                 <input type="submit" value="Login" />
             </form>
                 <a href="${flowExecutionUrl}&_eventId=newAccountRequest">Create New Account</a>
        </center>
    </body>
</html>
