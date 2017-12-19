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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>contacts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <!-- Bootstrap CSS -->  
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/css/bootstrap.min.css" integrity="sha384-AysaV+vQoT3kOAXZkl02PThvDr8HYKPZhNT5h/CXfBThSRXQ6jW5DO2ekP5ViFdi" crossorigin="anonymous">


</head>

<body  style="background-color:#FFFACD; ">
<html:errors/>

    
       <center> <h3>Contactes Hors Groupe</h3> </center>
       <br>
   <html:form action="/AddContactToGroupe">    
<table class="table" >
<thead class="thead-inverse">
<tr><th>Id </th>
	<th>Nom</th>
	<th>Prenom </th>
	<th>mail</th>
	<th>Action</th>
	 </tr> 
	 </thead>

<%
ServiceContact sc = (ServiceContact)MyApplicationContext.getApplicationContext().getBean("ServiceContact");
String idGroupe = String.valueOf(request.getAttribute("idm"));
List<Contact> l = sc.listContactOutsideGroup((long)request.getAttribute("idm"));
for(Contact c :l){
%>
<tr>
<td><%=c.getNum()%></td>
<td><%=c.getNom()%></td>
<td><%=c.getPrenom()%></td>
<td><%=c.getMail()%></td>
<td>
<html:submit property="btn" value="Ajouter" styleClass="btn btn-warning">Ajouter</html:submit>
</td>
<html:hidden property="idContact"  value="<%=String.valueOf(c.getNum())%>" />
<html:hidden property="idGroupe"  value="<%=idGroupe%>" />

</tr>

<%} %>

</table>
<br>
<hr><hr>

       <center> <h3>Contactes Appartenant au Groupe </h3></center>
<br>
<table class="table" >
<thead class="thead-inverse">
<tr><th>Id </th>
	<th>Nom</th>
	<th>Prenom </th>
	<th>mail</th>
	<th>Action</th>
	 </tr> 
	 </thead>
<%
List<Contact> li = sc.listContactInGroup((long)request.getAttribute("idm"));
for(Contact c :li){
%>
<tr>
<td><%=c.getNum()%></td>
<td><%=c.getNom()%></td>
<td><%=c.getPrenom()%></td>
<td><%=c.getMail()%></td>
<td>
<html:submit property="btn" value="Supprimer" styleClass="btn btn-warning">Supprimer</html:submit>
<html:hidden property="idContact"  value="<%=String.valueOf(c.getNum())%>" />
<html:hidden property="idGroupe"  value="<%=idGroupe%>" />
</td>
</tr>
<%} %>
</table>
</html:form>
</body>
</html:html>