<%-- 
    Document   : listuser
    Created on : Jun 8, 2016, 3:44:57 PM
    Author     : Abdur Razzak <abdur.razzaq06@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show All Users</title>
        <link rel="stylesheet" href="css/listuser.css" >
    </head>
    
    <body>
        <section>
            <h1>Record Table</h1>
            <div class="tbl-header">
                <table cellpadding="0" cellspacing="0" border="0">
                    <thead>
                        <tr>
                            <th>User Name</th>
                            <th>Email</th>
                            <th>Registration Date</th>
                            <th colspan=2>Action</th>
                        </tr>
                    </thead>
                </table>
            </div>
                <div class="tbl-content">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <tbody >
                            <c:forEach items="${users}" var="user">
                                <tr>
                                    <td><c:out value="${user.uname}" /></td>
                                    <td><c:out value="${user.email}" /></td>
                                    <td><fmt:formatDate pattern="dd MMM,yyyy" value="${user.registeredon}" /></td>
                                    <td><a id="hlink" href="UserController?action=edit&userId=<c:out value="${user.uname}"/>">Update</a></td>
                                    <td><a id="del" href="UserController?action=delete&userId=<c:out value="${user.uname}"/>">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
               <br> 
            <center id="fotter_button"><a id="hlink" href="UserController?action=insert">Add User</a></center>
        </section>
        
    </body>
</html>