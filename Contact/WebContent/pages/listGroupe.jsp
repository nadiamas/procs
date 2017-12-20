<%@page import="util.MyApplicationContext"%>
<%@page import="services.ServiceContact"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.* ,domain.*" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>

<html:html>
<% 
String ctxPath = request.getContextPath(); 
%>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Mon Agenda</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></head>
<body>

<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-user"></span>
       Mon Agenda</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
        <li ><a href="<%= ctxPath %>/listeContact.do">Liste des contacts</a></li>
        <li><a href="<%= ctxPath %>/CreationGroupe.do">Créer un groupe</a></li>
        <li><a href="<%= ctxPath %>/ContactCreation.do">Créer un contact</a></li>
        <li class="active"><a href="<%= ctxPath %>/listGroupe.do">Gestion des contacts</a></li>
      </ul>
      
    </div>
  </div>
</nav>
<div style="padding-top: 80px;" class="container">
<h1>Liste des contacts</h1><hr>
<br>
<br>
<%
ServiceContact sc = (ServiceContact)MyApplicationContext.getApplicationContext().getBean("ServiceContact");
List<Groupe> l = sc.listGroupe();
if(l.size()>0){

%>
<table class="table table-striped table-hover table-bordered">
			<%for(Groupe g :l){ %>
<tr><th>Id Groupe </th>
	<th>Groupe</th>
	<th>Contacts</th>
	<th>Suppression</th>
	<th>Modification</th>
	 </tr> 

<tr>
<html:form action="/UpdateGroupe">

<td><%=g.getIdGroupe()%></td>
<td><html:text property="nomGroupe" value="<%=g.getNomGroupe()%>" /></td>
<td>
<html:submit property="submit" value="Gérer Contactes" styleClass="btn btn-default">Gérer Contactes</html:submit>
</td>
<td>
<html:submit property="submit" value="Supprimer" styleClass="btn btn-default">Supprimer</html:submit>
</td>
<td>
<html:submit property="submit" value="Modifier" styleClass="btn btn-default">Modifier</html:submit>
<html:hidden property="idm"  value="<%=String.valueOf(g.getIdGroupe())%>" />
</td>
</html:form>
</tr>
<%} %>
</table>
<%}
else{
%>
<div class="alert alert-danger">
  No data in BDD.
</div>
<%} %>
</div>
</body>
</html:html>