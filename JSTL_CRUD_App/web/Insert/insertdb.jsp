<%-- 
    Document   : insertdb
    Created on : Jun 7, 2016, 1:57:15 AM
    Author     : Abdur Razzak <abdur.razzaq06@gmail.com>
--%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
 
<html>
    <head>
        <title>INSERT Operation</title>
    </head>
    <body>
        <c:if test="${ empty param.pname or empty param.qty}">
            <c:redirect url="insert.jsp" >
                <c:param name="errMsg" value="Please Enter Product and Quantity" />
            </c:redirect>
        </c:if>
        
        <sql:setDataSource var="dbsource" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost:3306/loginapp"
                           user="root"  password="password"/>
 
        <sql:update dataSource="${dbsource}" var="result">
            INSERT INTO product(pname, quantity) VALUES (?,?);
            <sql:param value="${param.pname}" />
            <sql:param value="${param.qty}" />
        </sql:update>
            
        <c:if test="${result>=1}">
            <font size="5" color='green'> 
                Congratulations ! Data inserted successfully.
            </font>
 
            <c:redirect url="insert.jsp" >
                <c:param name="susMsg" value="Congratulations ! Data inserted
            successfully." />
            </c:redirect>
        </c:if> 

    </body>
</html>
