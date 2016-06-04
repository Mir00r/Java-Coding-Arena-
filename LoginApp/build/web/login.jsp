<%-- 
    Document   : index
    Created on : Jun 1, 2016, 12:57:58 AM
    Author     : Abdur Razzak <abdur.razzaq06@gmail.com>
--%>

<%@page import="java.sql.*" %>

<%
    String userid = request.getParameter("uname");
    String pwd = request.getParameter("pass");

    Class.forName("com.mysql.jdbc.Driver"); // Load mysql jdbc driver

    Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginapp", "root", "password");

    Statement myStm = myConn.createStatement();

    // get result set
    ResultSet myRs;
    myRs = myStm.executeQuery("select * from members where uname = '" + userid + "' and pass = '" + pwd + "' ");
    
    if ( myRs.next() ){
        session.setAttribute("userid", userid);
        //out.println("welcome " + userid);
        //out.println("<a href='logout.jsp'>Log out</a>");
        response.sendRedirect("success.jsp");
        // out.print("Registration Successfull! "+" <a href='index.jsp'>Go to Login </a>");
    }
    else{
         out.println("Invalid password <a href='index.jsp'>try again</a>");
    }
%>