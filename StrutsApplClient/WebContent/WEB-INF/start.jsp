<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

  <h1 class="text-success text-center form-signin-heading"><bean:message key="login.jsp.title"/></h1>
        <div class="container">

            <html:form   action="/login" >
                <bean:write name="LoginForm" property="error" filter="false"/>
                <div class="form-group">
                    <label class="control-label" for="login"><bean:message key="login.jsp.form.enter.login"/></label>
                    <html:text value="user" styleClass="form-control" styleId="login" property="login" />

                </div>
                <div class="form-group">
                    <label class="control-label" for="pass"><bean:message key="login.jsp.form.enter.password"/></label>
                    <html:password  styleClass="form-control" styleId="pass" property="password" />
                </div>
                <html:submit styleClass="btn btn-success">
                    <bean:message key="login.jsp.submit.login"/>
                </html:submit>
            </html:form>

        </div>