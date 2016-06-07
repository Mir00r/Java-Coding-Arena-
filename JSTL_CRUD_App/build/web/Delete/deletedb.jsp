<%-- 
    Document   : deletedb
    Created on : Jun 7, 2016, 2:00:21 AM
    Author     : Abdur Razzak <abdur.razzaq06@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DeleteDB Page</title>
    </head>
    <body>
        <sql:setDataSource var="dbsource" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost:3306/loginapp"
                           user="root"  password="password"/>
        
        <sql:update dataSource="${dbsource}" var="count">
            DELETE FROM product
            WHERE id='${param.id}'
        </sql:update>
            
        <c:if test="${count>=1}">
            <font size="5" color='green'> 
                Congratulations ! Data deleted successfully.
            </font>
              <a href="../index.jsp">Go Home</a>          
        </c:if>
    </body>
</html>
