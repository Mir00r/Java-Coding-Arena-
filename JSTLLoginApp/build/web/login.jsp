<%-- 
    Document   : index
    Created on : Jun 6, 2016, 7:08:02 PM
    Author     : Abdur Razzak <abdur.razzaq06@gmail.com>
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd"> 

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
<!--        <h1>Please Login</h1>-->
        
        <form action="loginAuthentication.jsp">
            <center>
                <table border = "1" width = "30%" cellpadding = "3">
                    <thead>
                        <tr>
                            <th colspan="2"><h2>Login Here</h2></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>User Name</td>
                            <td> <input type="text" name="uname" value="" /> </td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td> <input type="password" name="pass" value="" /> </td>
                        </tr>
                        <tr>
                            <td> <input type="reset" value="Reset" /> </td>
                            <td> <input type="submit"  value="Login" /> </td>
                        </tr>
                        <tr>
                            <font color="red" >
                                <c:if test="${not empty param.errMsg}">
                                    <c:out value="${param.errMsg}"></c:out>
                                </c:if>
                            </font>
                        </tr>
                    </tbody>
                    
                </table>
            </center>
        </form>
    </body>
</html>
