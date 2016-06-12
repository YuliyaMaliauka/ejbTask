<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<div>
    <div class="bg-warning">
        <h1 class="text-center text-success"> <bean:message key="success.jsp.title"/> </h1>
        <h2 class="text-center text-danger"><bean:message key="success.jsp.user"/>
        
        
        <bean:write name="LoginForm" property="login" />.       
        
        </h2>
    </div>
</div>