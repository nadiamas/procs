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

<script type="text/javascript">

function activeNumSiret(){
	var checkBox = document.getElementById('checkBoxEntreprise');
	var numSiret = document.getElementById('numSiret');
    if (checkBox.checked) {
    	numSiret.style.visibility = 'visible';
    	
    } else{
    	numSiret.style.visibility = 'hidden';
    	document.getElementById('numSiretTextBox').value = 0;
    }

}    
    </script>


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
<td></td>
<td>Entreprise <input id="checkBoxEntreprise" type="checkbox" onclick="activeNumSiret()"></td>
</tr>
<tr id="numSiret" style="visibility: hidden;">
<td>N° Serie</td>
<td>
	<div   class="col-sm-10" >
	<!-- rajout du num siret de l'entreprise -->
	<html:text styleId="numSiretTextBox" property="numSiret" size="20" maxlength="20" value="0"
		styleClass="form-control" />

	<span style="color: red"><html:errors
			property="num siret chiffre" /></span>

	<span style="color: red"><html:errors property="numSiret" /></span>
	
	</div>

</tr>

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
<tr>
<td align="right">
Tel Portable
<html:hidden  property="portable" value="portable" styleClass="form-control"/>
</td>
<td align="left">
<div class="col-sm-10">
<html:text property="telport" size="30" maxlength="30" styleClass="form-control" value="0"/>
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
<html:text property="telfix" size="30" maxlength="30" styleClass="form-control" value="0"/>
</div>
</td>
</tr>
</table>
<br>
<br>

<fieldset>
  <legend>Groupes :</legend>
  <select name="groupe" class="custom-select">
   <option selected>Groupes</option>
  <%
ServiceContact sc = (ServiceContact)MyApplicationContext.getApplicationContext().getBean("ServiceContact");
  List<Groupe> l = sc.listGroupe();
 for(Groupe p : l){%>
  <option value="<%=p.getNomGroupe()%>"> <%=p.getNomGroupe() %></option> 
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
