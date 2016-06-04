<%-- 
    Document   : index
    Created on : Jun 1, 2016, 12:57:58 AM
    Author     : Abdur Razzak <abdur.razzaq06@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <form method="post" action="registration.jsp">
            <center>
                <table border = "1" width = "30%" cellpadding = "5">
                    <thead>
                        <tr>
                            <th colspan="2">Enter Information Here</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>First Name</td>
                            <td> <input type="text" name="fname" value="" /> </td>
                        </tr>
                        
                        <td>Last Name</td>
                            <td> <input type="text" name="lname" value="" /> </td>
                        </tr>
                        
                        <td>Email</td>
                            <td> <input type="text" name="email" value="" /> </td>
                        </tr>
                        
                        <td>User Name</td>
                            <td> <input type="text" name="uname" value="" /> </td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td> <input type="password" name="pass" value="" /> </td>
                        </tr>
                        <tr>
                            <td> <input type="submit" value="Submit" /> </td>
                            <td> <input type="reset"  value="Reset" /> </td>
                        </tr>
                        <tr>
                            <td colspan="2">Already Registered!! <a href="index.jsp">Login Here</a></td>
                        </tr>
                    </tbody>

                </table>
            </center>
        </form>
    </body>
</html>
