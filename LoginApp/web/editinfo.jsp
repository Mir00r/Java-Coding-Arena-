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
    String fname = "", lname = "", email = "", pass = "", regdate = "";
    Class.forName("com.mysql.jdbc.Driver"); // Load mysql jdbc driver

    Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginapp", "root", "password");

    Statement myStm = myConn.createStatement();

    // get result set
    ResultSet myRs;
    myRs = myStm.executeQuery("select first_name, last_name, email, pass, regdate from members where uname = '" + session.getAttribute("userid") + "' ");

    while (myRs.next()) {
        fname = myRs.getString("first_name");
        lname = myRs.getString("last_name");
        email = myRs.getString("email");
        pass = myRs.getString("pass");
        regdate = myRs.getString("regdate");
    }
%>
<!--<link href="css/default.css" rel="stylesheet" />-->

<form action="edituser.jsp" method="post">
    <center>
        <table border = "1" width = "30%" >
            <thead>
                <tr>
                    <th colspan="2">User Info</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>User Name</td>
                    <td> <%=session.getAttribute("userid")%> </td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td> <input type="text" name="fname" value="<%=fname%>" /> </td>
                </tr>

            <td>Last Name</td>
            <td> <input type="text" name="lname" value="<%=lname%>" /> </td>
            </tr>

            <td>Email</td>
            <td> <input type="text" name="email" value="<%=email%>" /> </td>
            </tr>

            <tr>
                <td>New Password</td>
                <td> <input type="password" name="pass" value="" /> </td>
            </tr>
            <tr>
                <td>Registered on</td>
                <td> <%=regdate%> </td>
            </tr>
            <tr>
                <td> <input type="submit" value="Edit" name="edit"/> </td>
                <td> <input type="submit"  value="Delete" name="edit"/> </td>
            </tr>
            
            </tbody>

        </table>
    </center>
</form>
            <a href="success.jsp">Go Home</a>
            <a href="logout.jsp">Log out</a>

<%
    }
%>
