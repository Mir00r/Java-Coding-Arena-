<%-- 
    Document   : autocomplete
    Created on : Jul 5, 2016, 2:45:57 AM
    Author     : Abdur Razzak <abdur.razzaq06@gmail.com>
--%>

<%@ taglib uri="/struts-tags" prefix="s" %>  
<%@taglib uri="/struts-dojo-tags" prefix="sx" %>

<html>
    <head>
        <sx:head />
    </head>
    <body>
        <h1>Struts 2 Auto Completer Example </h1>
        <s:form action="autoaction" method="post">
            <sx:autocompleter name="country" list="listCountry" 
                              showDownArrow="false" label="Choose Country">      
            </sx:autocompleter>
            
            <sx:datetimepicker name="" label="Registration Date"
                               displayFormat="dd/MM/yyyy"/>
            
            <s:select name="username" label="Username" 
                      list="{'Mike', 'Jhon', 'Smith'}"/>
            
            <s:submit></s:submit>
            
        </s:form>
    </body>
</html>
