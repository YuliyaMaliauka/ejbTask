<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib  uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib  uri="/WEB-INF/typeTag.tld" prefix="type"%>


        <type:customer typeCustomer="customer"/>
        
           <table class="table table-bordered table-hover bg-warning">
                <tr>               
                    <td><h3 class="text-danger">FirstName</h3></td>
                    <td><h3 class="text-danger">LastName</h3></td>
                    <td><h3 class="text-danger">CustomerDocID</h3></td>
                </tr>
                <tbody>
                    <tr>
                        <td><h4 class="text-success"><c:out value="${customer.getFirstName()}"/></h4></td>
                        <td><h4 class="text-success"><c:out value="${customer.getLastName()}"/></h4></td>
                        <td><h4 class="text-success"><c:out value="${customer.getCustomerDocID()}"/></h4></td>
                    </tr>
                </tbody>
            </table>
        
        
            <table class="table table-bordered table-hover bg-warning">
                <tr>               
                    <td><h3 class="text-danger">EmailAddress</h3></td>
                    <td><h3 class="text-danger">EmailType</h3></td>
                    <td><h3 class="text-danger">SyncStatus</h3></td>
                </tr>
                <tbody>
                    <tr>
                        <td><h4 class="text-success"><c:out value="${customer.getEmail().getEmailAddress()}"/></h4></td>
                        <td><h4 class="text-success"><c:out value="${customer.getEmail().getEmailType()}"/></h4></td>
                        <td><h4 class="text-success"><c:out value="${customer.getEmail().getSyncStatus()}"/></h4></td>
                    </tr>
                </tbody>
            </table >
        
        
            <table class="table table-bordered table-hover bg-warning">
                <tr>               
                    <td><h3 class="text-danger">PhoneNumber</h3></td>
                    <td><h3 class="text-danger">PhoneType</h3></td>
                    <td><h3 class="text-danger">SyncStatus</h3></td>
                </tr>
                <tbody>
                    <tr>
                        <td><h4 class="text-success"><c:out value="${customer.getPhone().getPhoneNumber()}"/></h4></td>
                        <td><h4 class="text-success"><c:out value="${customer.getPhone().getPhoneType()}"/></h4></td>
                        <td><h4 class="text-success"><c:out value="${customer.getPhone().getSyncStatus()}"/></h4></td>
                    </tr>
                </tbody>
            </table>
        
        
            <table class="table table-bordered table-hover">
                <tr>               
                    <td>#</td>
                    <td><h2 class="text-danger">AmountPaid</h2></td>
                    <td><h2 class="text-danger">FormOfPaymentTypeCode</h2></td>
                    <td><h2 class="text-danger">CurrencyCode</h2></td>
                </tr>
                <tbody>
                    <c:forEach items="${customer.getPayment()}" var="payment" varStatus="iterator">
                        <tr>
                            <td><h3 class="text-success"><c:out value="${iterator.index + 1}"/></h3></td>
                            <td><h3 class="text-success"><c:out value="${payment.getAmountPaid()}"/></h3></td>
                            <td><h3 class="text-success"><c:out value="${payment.getFormOfPaymentTypeCode()}"/></h3></td>
                            <td><h3 class="text-success"><c:out value="${payment.getCurrencyCode()}"/></h3></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
       
