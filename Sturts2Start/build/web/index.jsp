<%-- 
    Document   : index
    Created on : Jul 4, 2016, 1:58:19 AM
    Author     : Abdur Razzak <abdur.razzaq06@gmail.com>
--%>

<%@ taglib uri="/struts-tags" prefix="s" %>  
<s:form action="product">  
    <s:textfield name="id" label="Product Id"></s:textfield>  
    <s:textfield name="name" label="Product Name"></s:textfield>  
    <s:textfield name="price" label="Product Price"></s:textfield>  
    <s:submit value="save"></s:submit> 

        <a href="autoform">AJAX AutoComplete Example</a>
</s:form>
