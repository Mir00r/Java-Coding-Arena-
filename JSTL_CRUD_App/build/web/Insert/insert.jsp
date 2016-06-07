<%-- 
    Document   : insert
    Created on : Jun 7, 2016, 12:36:44 AM
    Author     : Abdur Razzak <abdur.razzaq06@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Page</title>
        <link rel="stylesheet" href="../css/insert.css">
    </head>
    <body>
        <div id="top"></div>
        <center>
            <form action="insertdb.jsp" method="post">
                <table border = "0" cellspacing = "2" cellpadding = "5">
                    <thead>
                        <tr>
                            <th colspan = "2" id="head">Purchase Product</th>
                        </tr>
                    </thead>
                    
                    <tbody>
                        <tr>
                            <td><label>Product Name</label></td>
<!--                            <td><input type="text" name="pname" /></td>-->
                            <td><input name="pname" class="input__field input__field--minoru" type="text" id="input-14" /></td>
                        </tr>
                        <tr>
                            <td><label>Quantity</label></td>
                            <td><input type="text" name="qty" class="input__field input__field--minoru" /></td>
                        </tr>
                        <tr>
<!--                            <td><input type="reset" value="Reset"  /></td>
                            <td><input type="submit" value="Save"  /></td>-->
                            <td><button type="reset" class="button button--ujarak 
                                        button--border-thin button--text-thick">Reset</button></td>
                            <td><button type="submit" class="button button--ujarak 
                                        button--border-thin button--text-thick">Save</button></td>
                        </tr>
                        
                    </tbody>
                </table>
            </form><br>
            <a href="../index.jsp" id="hlink">Go Home</a>
            <font color="red">
                <c:if test="${not empty param.errMsg}">
                    <c:out value="${param.errMsg}"></c:out>
<!--                    <a href="../index.jsp" id="hlink">Go Back</a>-->
                </c:if>
            </font>
        
            <font color="green">
                <c:if test="${not empty param.susMsg}">
                    <c:out value="${param.susMsg}"></c:out>
<!--                    <a href="../index.jsp" id="hlink">Go Back</a>-->
                    <a href="../Display/display.jsp" id="hlink">Display Record</a>
                </c:if>
            </font>
        </center>
         
        
    </body>
</html>
