<%-- 
    Document   : header
    Created on : Jun 6, 2016, 7:52:10 PM
    Author     : Abdur Razzak <abdur.razzaq06@gmail.com>
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<c:if test="${empty sessionScope['loginUser']}">
    <c:redirect url="login.jsp" />
</c:if>

<a href="logout.jsp">Logout
    <c:out value="${sessionScope['loginUser']}" />
</a>
