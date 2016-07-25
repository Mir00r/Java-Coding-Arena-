<%-- 
    Document   : einfo
    Created on : Jul 19, 2016, 3:11:15 PM
    Author     : Abdur Razzak <abdur.razzaq06@ail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--        <h1>${edetails}</h1>-->
        <form>
            <table>
                <tr>
                    <td>Employee Name : </td>
                    <td>${employee.ename}</td>
                </tr>
                <tr>
                    <td>Employee Address : </td>
                    <td>${employee.eaddress}</td>
                </tr>
                <tr>
                    <td>Employee Email : </td>
                    <td>${employee.email}</td>
                </tr>
                <tr>
                    <td>Employee Mobile : </td>
                    <td>${employee.empMobile}</td>
                </tr>
                <tr>
                    <td>Date of Birth : </td>
                    <td>${employee.empDOB}</td>
                </tr>
                <tr>
                    <td>Skills : </td>
                    <td>${employee.skillList}</td>
                </tr>
                
                <tr>
                    <td>Department Id : </td>
                    <td>${employee.department.deptId}</td>
                </tr>
                <tr>
                    <td>Department Name : </td>
                    <td>${employee.department.deptName}</td>
                </tr>
            </table>
        </form>
    </body>
</html>
