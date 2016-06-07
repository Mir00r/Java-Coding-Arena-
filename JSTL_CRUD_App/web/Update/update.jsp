<%-- 
    Document   : update
    Created on : Jun 7, 2016, 1:58:53 AM
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
        <title>Update Page</title>
        <link rel="stylesheet" href="../css/update.css">
    </head>
    <body>

        <sql:setDataSource var="dbsource" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost:3306/loginapp"
                           user="root"  password="password"/>

        <sql:query dataSource="${dbsource}" var="result">
            SELECT * from product where id=?;
            <sql:param value="${param.id}" />
        </sql:query>

        <form action="updatedb.jsp" method="post">
            <center>
                <h1 id="head">Update Product</h1>
                <table border="0" width="40%">
<!--                    <caption>Update Product</caption>-->
<!--                    <tr>
                        <th>Product Name</th>
                        <th>Quantity</th>
                    </tr>-->
                    <c:forEach var="row" items="${result.rows}">
                        <tr>
                            <td><label>Product Name</label></td>
                            <td><input class="input__field input__field--minoru" type="hidden" value="${param.id}" name="id"/>
                                <input class="input__field input__field--minoru" type="text" value="${row.pname}" name="pname"/></td>
                        </tr>
                        <tr>
                            <td><label>Quantity</label></td>
                            <td><input class="input__field input__field--minoru" type="text" value="${row.quantity}" name="qty"/></td>
                            
                        </tr>
                        <div id="faka"></div>
                        <tr>
                            <td id="but"><button type="submit" class="button button--ujarak 
                                        button--border-thin button--text-thick">Update</button></td>
                        </tr>
                    </c:forEach>
                </table><br>
                <a href="../index.jsp" id="hlink">Go Home</a>
            </center>
            
        </form>
    </body>
</html>
