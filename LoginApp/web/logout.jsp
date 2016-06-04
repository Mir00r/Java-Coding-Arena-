<%-- 
    Document   : logout
    Created on : Jun 1, 2016, 2:05:07 AM
    Author     : Abdur Razzak <abdur.razzaq06@gmail.com>
--%>

<%
    session.setAttribute("userid", null);
    session.invalidate();
    response.sendRedirect("index.jsp");
%>
