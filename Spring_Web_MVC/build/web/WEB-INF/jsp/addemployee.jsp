<%-- 
    Document   : addEmployee
    Created on : Jul 19, 2016, 2:14:17 AM
    Author     : Abdur Razzak <abdur.razzaq06@ail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Employee</title>
    </head>
    <body>
        <a href="/Spring_Web_MVC/addemp/?locale=en">English</a>
        <a href="/Spring_Web_MVC/addemp/?locale=fr">French</a>
        <a href="/Spring_Web_MVC/addemp/?locale=bn">Bengali</a>
        <a href="/Spring_Web_MVC/loginFlow?loginView">Login</a>
        
        <form:errors path="employee.*" />
        <form method="post" action="/Spring_Web_MVC/addemp">
            <table>
                <tr>
                    <td><label><spring:message code="label.ename" /> : </label></td>
                    <td><input type="text" name="ename" /></td>
                </tr>
                <tr>
                    <td><label><spring:message code="label.eaddress" /> : </label></td>
                    <td><input type="text" name="eaddress" /></td>
                </tr>
                 <tr>
                    <td><label><spring:message code="label.email" /> : </label></td>
                    <td><input type="text" name="email" /></td>
                </tr>
                <tr>
                    <td><label><spring:message code="label.empMobile" /> : </label></td>
                    <td><input type="text" name="empMobile" /></td>
                </tr>
                <tr>
                    <td><label><spring:message code="label.empDOB" /> : </label></td>
                    <td><input type="text" name="empDOB" /></td>
                </tr>
                <tr>
                    <td><label><spring:message code="label.skillList" /> : </label></td>
                    <td><select name="skillList" multiple="">
                            <option value="Spring Core" >Spring Core</option>
                            <option value="Spring AOP">Spring AOP </option>
                            <option value="Spring JDBC">Spring JDBC</option>
                            <option value="Spring Web">SPring Web</option>
                            
                        </select> 
                    
                    </td>
                </tr>
                
                
            </table>
            
            <table>
                <tr>
                    <td><label><spring:message code="label.deptId" /> : </label></td>
                    <td><input type="text" name="department.deptId" /></td>
                </tr>
                <tr>
                    <td><label><spring:message code="label.deptName" /> : </label></td>
                    <td><input type="text" name="department.deptName" /></td>
                </tr>
                
                <tr>
                    <td><input type="submit" value="Submit" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
