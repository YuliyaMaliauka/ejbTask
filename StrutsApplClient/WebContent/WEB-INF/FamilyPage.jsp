<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib  uri="/WEB-INF/c.tld" prefix="c"%>

<%@ taglib  uri="typeTag.tld" prefix="type"%>

 <type:fareFamily typeFamily="fareFamily"/>
        <table>
            <tr>               
                <td><h3 class="text-danger">FareFamilyCode</h3></td>
            </tr>
            <tbody>
                <tr>
                    <td><h4 class="text-success"><c:out value="${fareFamily.getFareFamilyCode()}"/></h4></td>
                </tr>
            </tbody>
        </table>
        <br>
        <table class="table table-bordered table-hover">
            <tr>               
                <td>#</td>
                <td><h3 class="text-danger">AncillaryAirComponentCode</h3></td>
            </tr>
            <tbody>
                <c:forEach items="${fareFamily.getAncillaryAirComponent()}" var="family" varStatus="iterator">
                <tr>
                    <td><h4 class="text-success"><c:out value="${iterator.index + 1}"/></h4></td>
                    <td><h4 class="text-success"><c:out value="${family.getAncillaryAirComponentCode()}"/></h4></td>
                 </tr>
                </c:forEach>
            </tbody>
        </table>