<%-- 
    Document   : user
    Created on : Jun 8, 2016, 3:45:27 PM
    Author     : Abdur Razzak <abdur.razzaq06@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new User </title>
        <link rel="stylesheet" href="css/user.css" >
    </head>
    <body>
        <center>
            <form method="post" action="UserController" name="frmAddUser">
                <%
                    String action = request.getParameter("action");
                    System.out.println(action);
                %>
                
                <% if ( action.equalsIgnoreCase("edit")) { %>
                    User Name : <input type="text" name="uname"
                                       class="input-list style-1 clearfix"
                                       value="<c:out value="${user.uname}" />" 
                                       readonly="readonly" /> (You Can't Change this)<br />
                <%} else {%>
                    User Name : <input type="text" name="uname"
                                       class="input-list style-1 clearfix"
                                       value="<c:out value="${user.unam}" /> "/> <br />
                <%}%>
                
                Password : <input
                type="password" name="pass"
                value="<c:out value="${user.password}" />" /> <br /> 
                
                Email : <input
                type="text" name="email"
                value="<c:out value="${user.email}" />" /> <br /> 
 
                <% if (action.equalsIgnoreCase("edit")) {%>
                    Registration Date : <input
                        type="text" name="dob"
                        value="<fmt:formatDate pattern="yyyy/MM/dd" value="${user.registeredon}" />" readonly="readonly"/>(You Can't Change this)  <br />
                <%} else {%>
                    Registration Date : <input
                        type="text" name="dob"
                        value="<fmt:formatDate pattern="yyyy/MM/dd" value="${user.registeredon}" />" />(yyyy/MM/dd)  <br /> 
                <%}%>
                <input  type="submit" value="Submit" />
            </form>
        </center>   
    </body>
</html>
