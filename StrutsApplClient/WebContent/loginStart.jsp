<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<tiles:insert page="/WEB-INF/layout/imple-layout.jsp">
<tiles:put name="header" value="/startHeder.jsp" />
<tiles:put name="local" value="/pusto.jsp" />
<tiles:put name="body" value="/WEB-INF/start.jsp" />
<tiles:put name="footer" value="/pusto.jsp" />
</tiles:insert>