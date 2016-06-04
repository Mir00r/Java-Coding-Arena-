<%-- 
    Document   : index
    Created on : Jun 1, 2016, 12:57:58 AM
    Author     : Abdur Razzak <abdur.razzaq06@gmail.com>
--%>

<%@page import="java.sql.*" %>

<%
    String user = request.getParameter("uname");
    String pwd = request.getParameter("pass");
    String fname = request.getParameter("fname");
    String lname = request.getParameter("lname");
    String email = request.getParameter("email");

    Class.forName("com.mysql.jdbc.Driver"); // Load mysql jdbc driver

    Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginapp", "root", "password");

    Statement myStm = myConn.createStatement();

    // get result set
    int sql = myStm.executeUpdate("insert into members(first_name, last_name, email, uname, pass, regdate) "
            + "values ('" + fname + "','" + lname + "','" + email + "','" + user + "','" + pwd + "', CURDATE()) ");
    
    if ( sql > 0 ){
        //session.setAttribute("userid", user);
        response.sendRedirect("welcome.jsp");
        // out.print("Registration Successfull! "+" <a href='index.jsp'>Go to Login </a>");
    }
    else{
        response.sendRedirect("index.jsp");
    }
%>