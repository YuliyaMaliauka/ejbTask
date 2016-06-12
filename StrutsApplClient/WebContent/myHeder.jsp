<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>


<div class="row bg-success">

	<div class="col-md-4"><html:link action="/destroy/reservation">
            <h3 class="text-center text-uppercase"> <bean:message key="myHeder.jsp.reservation"/> </h3>
        </html:link></div>
        <div class="col-md-4"><html:link action="/destroy/customer">
            <h3 class="text-center text-uppercase"><bean:message key="myHeder.jsp.customer"/></h3>
        </html:link></div>
    <div class="col-md-4"><html:link action="/destroy/family">
            <h3 class="text-center text-uppercase"><bean:message key="myHeder.jsp.family"/></h3>
        </html:link></div>
 </div>
        