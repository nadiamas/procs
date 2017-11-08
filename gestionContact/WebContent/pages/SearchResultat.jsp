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
<table class="table" >
<thead class="thead-inverse">

<tr><th>Numero </th>
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
List<Contact> l = (List<Contact>) request.getAttribute("list");
for(Contact c :l){
%>
<tr>
<html:form action="/UpdateContact">
<td><%=c.getNum()%></td>
<td><html:text property="nom" size="30" maxlength="30" value="<%=c.getNom()%>" /></td>
<td><html:text property="prenom" size="30" maxlength="30" value="<%=c.getPrenom()%>" /></td>
<td><html:text property="mail" size="30" maxlength="30" value="<%=c.getMail()%>" /></td>
<td><html:text property="rue" size="30" maxlength="30" value="<%=c.getAdresse().getRue()%>"/> </td>
<td><html:text property="ville" size="30" maxlength="30" value="<%=c.getAdresse().getVille()%>"/> </td>
<td><html:text property="codepostal" size="30" maxlength="30" value="<%=c.getAdresse().getCodepostal()%>"/> </td>
<td><html:text property="pays" size="30" maxlength="30" value="<%=c.getAdresse().getPays()%>"/> </td>
<td>
<% List<Telephone> tel =dao.listTel(c.getNum());
for(Telephone t :tel){
%> 
<%=t.getTypeTel()%>:<html:text property="tel" value="<%=t.getNumTel()%>"/><br>
<html:hidden property="typetel"  value="<%=t.getTypeTel()%>" />
<%} %>
</td>
<td>
<html:submit property="submit" value="suppression"  styleClass="btn btn-default">Supprimer</html:submit>
</td>
<td>
<html:submit property="submit" value="modification"  styleClass="btn btn-default">Modifier</html:submit>
<html:hidden property="idm"  value="<%=String.valueOf(c.getNum())%>" />
</html:form>
</tr>
<%} %>

</table>
</body>
</html:html>