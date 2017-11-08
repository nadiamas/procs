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
	<th>Mail </th>
	<th>Rue</th>
	<th>Ville</th>
	<th>Code Postal</th>
	<th>Pays</th>
	<th>tel</th>
	<th>Suppression</th>
	<th>Modification</th>
	 </tr> 
	 </thead>

<%

DAOContact dao = new DAOContact();
List<Contact> l = dao.listContact();
for(Contact c :l){
%>

<tr>
<html:form action="/UpdateContact">
<td><%=c.getNum()%></td>
<td><html:text property="nom"  value="<%=c.getNom()%>" size="10"/></td>
<td><html:text property="prenom"  value="<%=c.getPrenom()%>" size="10"/></td>
<td><html:text property="mail"  value="<%=c.getMail()%>" /></td>
<td><html:text property="rue"  value="<%=c.getAdresse().getRue()%>" size="15"/> </td>
<td><html:text property="ville"  value="<%=c.getAdresse().getVille()%>" size="8"/> </td>
<td><html:text property="codepostal"  value="<%=c.getAdresse().getCodepostal()%>" size="5"/> </td>
<td><html:text property="pays" value="<%=c.getAdresse().getPays()%>" size="10"/> </td>
<td>
<% List<Telephone> tel =dao.listTel(c.getNum());
for(Telephone t :tel){
%> 
<%=t.getTypeTel()%>:<html:text property="tel" value="<%=t.getNumTel()%>"/><br>
<html:hidden property="typetel"  value="<%=t.getTypeTel()%>" />
<%} %>
</td>
<td>
<html:submit property="submit" value="supprimer" styleClass="btn btn-default">Supprimer</html:submit>
</td>
<td>
<html:submit property="submit" value="modifier" styleClass="btn btn-default">Modifier</html:submit>
<html:hidden property="idm"  value="<%=String.valueOf(c.getNum())%>" />
</html:form>
</tr>

<%} %>


</table>

</body>
</html:html>