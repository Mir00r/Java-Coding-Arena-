<%-- 
    Document   : editinfo
    Created on : Jun 4, 2016, 3:20:33 PM
    Author     : Abdur Razzak <abdur.razzaq06@gmail.com>
--%>
<%@page import="java.sql.*" %>

<%
    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
%>
You are not logged in<br/>
<a href="index.jsp">Please Login</a>

<%} else {
    String action = request.getParameter("edit");
    System.out.println(action);

    if (action.equals("Edit")) {
        System.out.println("Ediiitttttttt-------");
        String pwd = request.getParameter("pass");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");

        Class.forName("com.mysql.jdbc.Driver"); // Load mysql jdbc driver

        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginapp", "root", "password");

        Statement myStm = myConn.createStatement();

        // get result set
        String sql;
        sql = "update members set first_name='" + fname + "', "
                + "last_name='" + lname + "', "
                + "email='" + email + "', "
                + "pass='" + pwd + "' where uname='" + session.getAttribute("userid") + "' ";

        System.out.println(sql);

        int col = myStm.executeUpdate(sql);
        if (col > 0) {
            response.sendRedirect("editinfo.jsp");

        } else {
            out.print("Edit Unsuccessfull!" + "<a href='editinfo.jsp'>Go to edit again</a>");
        }
    } else {
        out.print("You have no permission to delete this record" + "<a href='editinfo.jsp'>Go to edit page</a>");
    }
%>

