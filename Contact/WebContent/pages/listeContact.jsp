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

 <html:form action="/Search">
 <center>
   <table style="margin-top:10%;
		border: medium solid #6495ed;
		border-collapse: collapse;
		width: 10%;">
		      <tr>
         
          <td align="left" style="font-family: sans-serif;
			border: thin solid #6495ed;
			width: 10%;
			padding: 3px;
			text-align: left;
			background-color: #ffffff;">
            <html:text property="search" size="30" maxlength="30"/>
          </td>
           <td align="right">
            <html:submit  property="submit" value="Chercher par identifiant">Rechercher</html:submit>
          </td>
    </tr>
    <tr>
         
          <td align="left" style="font-family: sans-serif;
			border: thin solid #6495ed;
			width: 10%;
			padding: 3px;
			text-align: left;
			background-color: #ffffff;">
            <html:text property="searchName" size="30" maxlength="30"/>
          </td>
           <td align="right">
            <html:submit  property="submit" value="Chercher par nom">Rechercher</html:submit>
          </td>
    </tr>
    </table>
    </center>
    
       </html:form>
    
       <br>
       <br>
<table class="table" >
<thead class="thead-inverse">
<tr><th>Id </th>
	<th>Nom</th>
	<th>Prenom </th>
	<th>mail</th>
	<th>Groupe</th>
	<th>Modifier Groupe</th>
	<th>Affichage</th>
	 </tr> 
	 </thead>

<%
ServiceContact sc = (ServiceContact)MyApplicationContext.getApplicationContext().getBean("ServiceContact");
List<Contact> l = sc.listContact();
for(Contact c :l){
%>

<tr>
<html:form action="/AfficheContact">
<td><%=c.getNum()%></td>
<td><%=c.getNom()%></td>
<td><%=c.getPrenom()%></td>
<td><%=c.getMail()%></td>
<td>
<% 
Set<Groupe> groups = sc.listGRP(c.getNum());
for(Groupe g : groups){
%> <%=g.getNomGroupe() + groups.size()%>
<%} %>
</td>
<td>
<html:submit property="submit" value="Modifier Groupe" styleClass="btn btn-warning">Modifier Groupe</html:submit>
</td>
<td>
<html:submit property="submit" value="afficher" styleClass="btn btn-warning">Afficher</html:submit>
</td>
<html:hidden property="idm"  value="<%=String.valueOf(c.getNum())%>" />
</html:form>
</tr>

<%} %>

</table>

</body>
</html:html>