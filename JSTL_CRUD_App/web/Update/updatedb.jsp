<%-- 
    Document   : updatedb
    Created on : Jun 7, 2016, 1:59:34 AM
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
        <title>UpdateDB Page</title>
        <link rel="stylesheet" href="../css/updatedb.css">
    </head>
    <body>
        <sql:setDataSource var="dbsource" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost:3306/loginapp"
                           user="root"  password="password"/>
        
        <sql:update dataSource="${dbsource}" var="count">
            UPDATE product SET pname = ?, quantity=?
            WHERE id='${param.id}'
            <sql:param value="${param.pname}" />
            <sql:param value="${param.qty}" />
        </sql:update>
            
        <center>
            <c:if test="${count>=1}">
                <font size="5" color='green'><h1> Congratulations ! Data updated
                    successfully.</h1></font><br><br>
                  <a href="../index.jsp" id="hlink">Go Home</a>
                  <a href="../Display/display.jsp" id="hlink">Display Record</a>
            </c:if>
        </center>
        
    </body>
</html>