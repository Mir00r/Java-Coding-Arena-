<%-- 
    Document   : display
    Created on : Jun 7, 2016, 1:57:58 AM
    Author     : Abdur Razzak <abdur.razzaq06@gmail.com>
--%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
    <head>
        <title>SELECT Operation</title>
        <script>
            function confirmGo(m, u) {
                if (confirm(m)) {
                    window.location = u;
                }
            }
        </script>
        <link rel="stylesheet" href="../css/display.css">
    </head>
    <body>

        <sql:setDataSource var="dbsource" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost:3306/loginapp"
                           user="root"  password="password"/>

        <sql:query dataSource="${dbsource}" var="result">
            SELECT * from product;
        </sql:query>

        <center>
            <form>
                <h1 id="head">Product List</h1>
                <table border="1" width="40%" class="responstable">
<!--                    <caption id="cap">Product List</caption><br>-->
                    <tr>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Quantity</th>
                        <th colspan="2">Action</th>
                    </tr>
                    <c:forEach var="row" items="${result.rows}">
                        <tr>
                            <td> <c:out value="${row.id}"/> </td>
                            <td> <c:out value="${row.pname}"/> </td>
                            <td> <c:out value="${row.quantity}"/> </td>
                            <td> <a id = "up" href="../Update/update.jsp?id=<c:out value="${row.id}"/>">Update</a> </td>
                            <td> <a id = "del" href="javascript:confirmGo('Are you Sure to delete this record?','../Delete/deletedb.jsp?id=<c:out value="${row.id}"/>')">Delete</a> </td>

                        </tr>
                    </c:forEach>
                </table>
            </form>
            <a href="../index.jsp" id="hlink">Go Home</a>
        </center>
    </body>
</html>
