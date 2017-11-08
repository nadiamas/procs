<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
<title>Liste Groupes</title>
</head>
<body  style="background-color:#FFFACD; ">
<div class="container">
<table class="table table-striped">
<tr><th>Id Groupe </th>
	<th>Groupe</th>
	<th>Suppression</th>
	<th>Modification</th>
	 </tr> 
<%
DAOContact dao = new DAOContact();
List<Groupe> l = dao.listGroupe();
for(Groupe g :l){
%>
<tr>
<html:form action="/UpdateGroupe">
<td><%=g.getIdGroupe()%></td>
<td><html:text property="nomGroupe" value="<%=g.getNomGroupe()%>" /></td>
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
</div>
</body>
</html:html>