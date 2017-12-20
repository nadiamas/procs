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
        <li class="active"><a href="<%= ctxPath %>/listeContact.do">Liste des contacts</a></li>
        <li><a href="<%= ctxPath %>/CreationGroupe.do">Cr�er un groupe</a></li>
        <li><a href="<%= ctxPath %>/ContactCreation.do">Cr�er un contact</a></li>
        <li><a href="<%= ctxPath %>/listGroupe.do">Gestion des contacts</a></li>
      </ul>
      
    </div>
  </div>
</nav>
<div style="padding-top: 80px;" class="container">
<html:errors/>

 <html:form action="/Search">
 <center>
			<table class="table table-hover">
			<tr>
         <td style="border:0;">
            <html:text styleClass="form-control" property="search" size="30" maxlength="30"/>
          </td>
           <td style="border:0;" align="right">
            <html:submit  property="submit"  value="Chercher par identifiant" styleClass="btn btn-primary">Rechercher</html:submit>
          </td>
    </tr>
    <tr>
         
         <td style="border:0;">
            <html:text styleClass="form-control" property="searchName" size="30" maxlength="30"/>
          </td>
           <td style="border:0;" align="right">
            <html:submit  property="submit" value="Chercher par nom" styleClass="btn btn-primary">Rechercher</html:submit>
          </td>
    </tr>
    </table>
    </center>
    
   </html:form>
    
       <br>
       <br>
       
       <h1>Liste des contacts</h1><hr>
       <%
ServiceContact sc = (ServiceContact)MyApplicationContext.getApplicationContext().getBean("ServiceContact");
List<Contact> l = sc.listContact();
if(l.size()>0){%>

			<table class="table table-striped table-hover table-bordered">
			<%for(Contact c :l){ %>
				<tbody>
					<tr>
						<th>Id </th>
						<th>Type</th>
						<th>Nom</th>
						<th>Prenom </th>
						<th>mail</th>
						<th>Groupe</th>
						<th>Actions</th>
					</tr>
					<tr>
					<html:form action="/AfficheContact">
					<td><%=c.getNum()%></td>
					<td><%=sc.getType(c.getNum())%>
					<html:hidden property="type"  value="<%=sc.getType(c.getNum())%>"/>
					</td>
					<td><%=c.getNom()%></td>
					<td><%=c.getPrenom()%></td>
					<td><%=c.getMail()%></td>
					
					<td>
					<% 
					Set<Groupe> groups = sc.listGRP(c.getNum());
					for(Groupe g : groups){
					%> <%=g.getNomGroupe()%>
					<%} %>
					</td>
					<td>
					<html:submit property="submit" value="afficher" styleClass="btn btn-info">Afficher</html:submit>
					</td>
					<html:hidden property="idm"  value="<%=String.valueOf(c.getNum())%>" />
					</html:form>
					</tr>
				</tbody>
				
					<%}%>
			</table>
			<%}
			else{
			%>
			<div class="alert alert-danger">
			  No data in BDD.
			</div>
			<%} %>

	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html:html>


