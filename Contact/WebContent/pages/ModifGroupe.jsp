<%@page import="util.MyApplicationContext"%>
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

<html:form action="/ModifGroupe" styleClass="form-horizontal">
<div style="color: red">
<html:errors/>
</div>

<h3><bean:message key="details.entered"/></h3>
<%
Contact c = (Contact) request.getAttribute("contact");
%>
<html:hidden property="idm"  value="<%=String.valueOf(c.getNum())%>" />
<br><br>
<center>
<br>
<br>

<fieldset>
  <legend>Groupes :</legend>
  <%
ServiceContact sc = (ServiceContact)MyApplicationContext.getApplicationContext().getBean("ServiceContact");
  List<Groupe> l = sc.listGroupe();
 for(Groupe p : l){%>
  <div>
    <input type="checkbox" name="groupe" value="<%=p.getNomGroupe()%>"> <%=p.getNomGroupe()%> 
  </div>
<% 
 }
 %>
</fieldset>


<br><br>
<html:submit property="btn" value="Enregistrer" styleClass="btn btn-warning">Enregistrer</html:submit>

</center>
<br><br>
<hr>
<html:submit property="btn" value="retour" styleClass="btn btn-default"></html:submit>
</html:form>
</div>
</body>
</html:html>
