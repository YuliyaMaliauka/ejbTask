<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Hello </title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    </head>
    <body class="bg-success">       
        <table class="table">
            <tr><td> <tiles:insert attribute="header"/> </td></tr>
            <tr><td> <tiles:insert attribute="local"/> </td></tr>
            <tr><td> <tiles:insert attribute="body"/> </td></tr>
            <tr><td> <tiles:insert attribute="footer"/> </td></tr>
        </table>
    </body>
</html>
