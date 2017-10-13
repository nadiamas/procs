<%@page import="domain.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<html:html>
<head>
<title>Ajouter un Telephone</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html:base/>
</head>
<body style="background-color:#FFFACD">
<div class="container">

<html:form action="/AddTel" styleClass="form-horizontal">
<div style="color: red">
<html:errors/>
</div>

<h3>Entrez les informations suivantes S'il vous plaît </h3>

<br><br>
<center>
<table>
<td align="right">
Type :Fix/PORT
</td>
<td align="left">
<div class="col-sm-10">
<html:text property="typeTel" size="30" maxlength="30" styleClass="form-control" />
</div>
</td>
</tr>
<tr>
<td align="right">
Tel
</td>
<td align="left">
<div class="col-sm-10">
<html:text property="numTel" size="30" maxlength="30" styleClass="form-control" />
</div>
</td>
</tr>

</table>
<br>
<br><br>
<html:submit property="btn" value="save" styleClass="btn btn-warning">Save</html:submit>

</center>
<br><br>
<hr>
<html:submit property="btn" value="retour" styleClass="btn btn-default"></html:submit>
</html:form>
</div>
</body>
</html:html>
