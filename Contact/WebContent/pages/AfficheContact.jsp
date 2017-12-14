<%@page import="util.MyApplicationContext"%>
<%@page import="org.apache.catalina.core.ApplicationContext"%>
<%@page import="services.ServiceContact"%>
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

<html:form action="/UpdateContact" styleClass="form-horizontal">
<div style="color: red">
<html:errors/>
</div>

<h3><bean:message key="details.entered"/></h3>

<br><br>
<center>
<%
Contact c = (Contact) request.getAttribute("contact");
%>
<table>
<html:hidden property="idm"  value="<%=String.valueOf(c.getNum())%>" />
<tr>
<td align="right">
Nom
</td>
<td align="left">
<div class="col-sm-10">
<html:text property="nom" size="30" maxlength="30" styleClass="form-control" value="<%=c.getNom()%>" />
</div>
</td>
</tr>
<tr>
<td align="right">
Prenom
</td>
<td align="left">
<div class="col-sm-10">
<html:text property="prenom" size="30" maxlength="30" styleClass="form-control" value="<%=c.getPrenom()%>"/>
</div>
</td>
</tr>
<tr>
<td align="right">
E-mail 
</td>
<td align="left">
<div class="col-sm-10">
<html:text property="mail" size="30" maxlength="30" styleClass="form-control" value="<%=c.getMail()%>"/>
</div>
</td>
</tr>
<tr>
<td align="right">
Rue
</td>
<td align="left">
<div class="col-sm-10">
<html:text property="rue" size="30" maxlength="30" styleClass="form-control" value="<%=c.getAdresse().getRue()%>" />
</div>
</td>
</tr>
<tr>
<td align="right">
Ville
</td>
<td align="left">
<div class="col-sm-10">
<html:text property="ville" size="30" maxlength="30" styleClass="form-control" value="<%=c.getAdresse().getVille()%>" />
</div>
</td>
</tr>
<tr>
<td align="right">
Code Postal
</td>
<td align="left">
<div class="col-sm-10">
<html:text property="codepostal" size="30" maxlength="30" styleClass="form-control" value="<%=c.getAdresse().getCodepostal()%>" />
</div>
</td>
</tr>
<tr>
<td align="right">
Pays
</td>
<td align="left">
<div class="col-sm-10">
<html:text property="pays" size="30" maxlength="30" styleClass="form-control" value="<%=c.getAdresse().getPays()%>"/>
<div class="col-sm-10">
</td>
</tr>
<% 
ServiceContact sc = (ServiceContact) MyApplicationContext.getApplicationContext().getBean("ServiceContact");
String port = sc.getNumTel(c.getNum(),"portable");
String fix = sc.getNumTel(c.getNum(),"fix");
%> 
<tr>
<td align="right">
Mobile :
</td>
<td align="left">
<div class="col-sm-10">
<html:text property="telPort" size="30" maxlength="30" styleClass="form-control" value="<%=port%>"/>
</div>
</td>
</tr>

<tr>
<td align="right">
Domicile :
</td>
<td align="left">
<div class="col-sm-10">
<html:text property="telFix" size="30" maxlength="30" styleClass="form-control" value="<%=fix%>"/>
</div>
</td>
</tr>

</table>
<br>
<br>




<br><br>
<html:submit property="submit" value="modifier" styleClass="btn btn-warning">Modifier</html:submit>
<html:submit property="submit" value="supprimer" styleClass="btn btn-warning">Supprimer</html:submit>
</center>
<br><br>
<hr>
<html:submit property="submit" value="retour" styleClass="btn btn-default"></html:submit>
</html:form>
</div>
</body>
</html:html>
