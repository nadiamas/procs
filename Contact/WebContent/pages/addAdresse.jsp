<%@page import="domain.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<html:html>
<head>
<title>Ajouter une adresse</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html:base/>
</head>
<body style="background-color:#FFFACD">
<div class="container">

<html:form action="/AddAdresse" styleClass="form-horizontal">
<div style="color: red">
<html:errors/>
</div>

<h3>Entrez les informations suivantes S'il vous plaît </h3>

<br><br>
<center>
<table>
<td align="right">
Rue
</td>
<td align="left">
<div class="col-sm-10">
<html:text property="rue" size="30" maxlength="30" styleClass="form-control" />
</div>
</td>
</tr>
<tr>
<td align="right">
Code Postal
</td>
<td align="left">
<div class="col-sm-10">
<html:text property="codePostal" size="30" maxlength="30" styleClass="form-control" />
</div>
</td>
</tr>
<tr>
<td align="right">
ville
</td>
<td align="left">
<div class="col-sm-10">
<html:text property="ville" size="30" maxlength="30" styleClass="form-control" />
</div>
</td>
</tr>
<tr>
<td align="right">
pays
</td>
<td align="left">
<div class="col-sm-10">
<html:text property="pays" size="30" maxlength="30" styleClass="form-control" />
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
