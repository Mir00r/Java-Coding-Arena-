<%-- 
    Document   : success
    Created on : Jun 1, 2016, 2:00:43 AM
    Author     : Abdur Razzak <abdur.razzaq06@gmail.com>
--%>

<%
    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
%>
        You are not logged in<br/>
        <a href="index.jsp">Please Login</a>
    <%} 
    else {
    %>
        Welcome <%=session.getAttribute("userid")%>
        <a href='logout.jsp'>Log out</a><br />
        <a href='editinfo.jsp'>Edit Info</a>
    <%
    }
    %>
