<%-- 
    Document   : new_account
    Created on : Jul 22, 2016, 2:58:20 AM
    Author     : Abdur Razzak <abdur.razzaq06@ail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>

<!DOCTYPE html>

<html xmlns:form="http://www.springframework.org/tags/form" >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>new Login Page</title>
    </head>
    <body>
        <center>
             <h1>Welcome New user Login page</h1>
             <form action="${flowExecutionUrl}&_eventId=accountInfoEntered" 
                   method="post">
                 
                 <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
                 <br />
                 
                 <table>
                     <tr>
                         <td>New Login Name : </td>
                         <td> <input type="text" name="loginName" /> </td>
                     </tr>
                     <tr>
                         <td>Password : </td>
                         <td> <input type="password" name="password" /> </td>
                     </tr>
                 </table>
                 <br />
                 <input type="submit" value="Submit" />
             </form>
        </center>
    </body>
</html>
