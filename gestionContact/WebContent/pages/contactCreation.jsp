<%@page import="java.util.List"%>
<%@page import="domain.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<html:html>
<head>
<title><bean:message key="add.contact"/></title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html:base/>
</head>
<body style="background-color:#FFFACD">
<div class="container">

<html:form action="/AddContact" styleClass="form-horizontal">
<div style="color: red">
<html:errors/>
</div>

<h3><bean:message key="details.entered"/></h3>

<br><br>
<center>
<table>
<tr>
<td align="right">
Nom
</td>
<td align="left">
<div class="col-sm-10">
<html:text property="firstName" size="30" maxlength="30" styleClass="form-control" />
</div>
</td>
</tr>
<tr>
<td align="right">
Prenom
</td>
<td align="left">
<div class="col-sm-10">
<html:text property="lastName" size="30" maxlength="30" styleClass="form-control" />
</div>
</td>
</tr>
<tr>
<td align="right">
E-mail 
</td>
<td align="left">
<div class="col-sm-10">
<html:text property="email" size="30" maxlength="30" styleClass="form-control" />
</div>
</td>
</tr>
<tr>
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
Ville
</td>
<td align="left">
<div class="col-sm-10">
<html:text property="ville" size="30" maxlength="30" styleClass="form-control" />
</div>
</td>
</tr>
<tr>
<td align="right">
Code Postal
</td>
<td align="left">
<div class="col-sm-10">
<html:text property="codepostal" size="30" maxlength="30" styleClass="form-control" />
</div>
</td>
</tr>
<tr>
<td align="right">
Pays
</td>
<td align="left">
<div class="col-sm-10">
<html:text property="pays" size="30" maxlength="30" styleClass="form-control"/>
<div class="col-sm-10">
</td>
</tr>
<tr>
<td align="right">
Tel Portable
<html:hidden  property="portable" value="portable" styleClass="form-control"/>
</td>
<td align="left">
<div class="col-sm-10">
<html:text property="telport" size="30" maxlength="30" styleClass="form-control" />
</div>
</td>
</tr>
<tr>
<td align="right">
Tel Fix
<html:hidden  property="fix" value="fix" styleClass="form-control" />
</td>
<td align="left">
<div class="col-sm-10">
<html:text property="telfix" size="30" maxlength="30" styleClass="form-control"/>
</div>
</td>
</tr>
</table>
<br>
<br>

<fieldset>
  <legend>Groupes :</legend>
  <%
  DAOContact dao = new DAOContact();
  List<Groupe> l = dao.listGroupe();
 for(Groupe p : l){%>
  <div>
    <input type="checkbox" name="groupe" value="<%=p.getNomGroupe()%>"> <%=p.getNomGroupe()%> 
  </div>
<% 
 }
 %>
</fieldset>


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
