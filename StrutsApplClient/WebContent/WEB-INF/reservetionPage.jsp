<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib  uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib  uri="/WEB-INF/typeTag.tld" prefix="type"%>
<div class="table-responsive">
<type:reservation typeReservation="reservation"/>
        <table class="table table-bordered table-hover">               
                
                <tr>               
                    <td>#</td>
                    <td><h2 class="text-danger">Cod </h2></td>
                    <td><h2 class="text-danger">Description</h2></td>
                    <td><h2 class="text-danger">ComponentTypeCode</h2></td>
                    <td><h2 class="text-danger">CreateDateTime</h2></td>
                    <td><h2 class="text-danger">InternalStatus</h2></td>
                    <td><h2 class="text-danger">Sequence</h2></td>
                </tr>
                <tbody>
                    <c:forEach items="${reservation.getResComponent()}" var="resComp" varStatus="iterator">
                        <tr>
                            <td><h3 class="text-success"><c:out value="${iterator.index + 1}"/></h3></td>
                            <td><h3 class="text-success"><c:out value="${reservation.getCode()}"/></h3></td>
                            <td><h3 class="text-success"><c:out value="${reservation.getDescription()}"/></h3></td>
                            <td><h3 class="text-success"><c:out value="${resComp.getComponentTypeCode()}"/></h3></td>
                            <td><h3 class="text-success"><c:out value="${resComp.getCreateDateTime()}"/></h3></td>
                            <td><h3 class="text-success"><c:out value="${resComp.getInternalStatus()}"/></h3></td>
                            <td><h3 class="text-success"><c:out value="${resComp.getSequence()}"/></h3></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
