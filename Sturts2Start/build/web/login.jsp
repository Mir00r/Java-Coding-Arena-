<%-- 
    Document   : index
    Created on : Jul 4, 2016, 1:58:19 AM
    Author     : Abdur Razzak <abdur.razzaq06@gmail.com>
--%>

<%@ taglib uri="/struts-tags" prefix="s" %> 
<s:actionerror />

<s:form action="login">  
    
    <s:textfield name="name" label="Name"></s:textfield>  
    <s:password name="password" label="Password"></s:password>  
    <s:submit value="Login"></s:submit> 

</s:form>
