<%-- 
    Document   : loginAuthentication
    Created on : Jun 6, 2016, 7:26:41 PM
    Author     : Abdur Razzak <abdur.razzaq06@gmail.com>
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authentication Page</title>
    </head>
    <body>
        <c:if test="${empty param.uname or empty param.pass}">
            <c:redirect url="login.jsp">
                <c:param name="errMsg" value="Please Enter UserName and Password" />
            </c:redirect>
        </c:if>
        
        <c:if test="${not empty param.uname and not empty param.pass}">
            <s:setDataSource var="ds" driver="com.mysql.jdbc.Driver"
                             url="jdbc:mysql://localhost:3306/loginapp"
                             user="root" password="password"/>
            
            <s:query dataSource="${ds}" var="selectQ">
                select count(*) as kount from users
                where username = '${param.uname}'
                and password = '${param.pass}'
            </s:query>
                
            <c:forEach items="${selectQ.rows}" var = "r">
                <c:choose>
                    <c:when test="${r.kount gt 0}">
                        <c:set scope = "session"
                               var = "loginUser"
                               value = "${param.uname}"/>
                        <c:redirect url="index.jsp" />
                    </c:when>
                    <c:otherwise>
                        <c:redirect url="login.jsp">
                            <c:param name="errMsg" value="Username or Password does not match" />
                        </c:redirect>
                    </c:otherwise>
                </c:choose>

            </c:forEach>
        </c:if>
    </body>
</html>
