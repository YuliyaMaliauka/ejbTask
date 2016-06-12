<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<tiles:insert page="/WEB-INF/layout/imple-layout.jsp">
<tiles:put name="header" value="/myHeder.jsp" />
<tiles:put name="local" value="/local.jsp" />
<tiles:put name="body" value="/WEB-INF/reservetionPage.jsp" />
<tiles:put name="footer" value="/myFooter.jsp" />
</tiles:insert>
