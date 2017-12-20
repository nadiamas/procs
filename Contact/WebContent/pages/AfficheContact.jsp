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

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html:base/>
<script type="text/javascript">

function demarage(){
	
	var x = document.getElementById('numSiret');
	var checkbox = document.getElementById('checkBoxEntreprise');
	if(x.value == 0){
		checkbox.checked = false;
		document.getElementById('divNumSiret').style.visibility = 'hidden';
		
	} else{
		checkbox.checked = true;
	}
}



function activeNumSiret(){
	var checkBox = document.getElementById('checkBoxEntreprise');
	var numSiret = document.getElementById('divNumSiret');
    if (checkBox.checked) {
    	numSiret.style.visibility = 'visible';
    	
    } else{
    	numSiret.style.visibility = 'hidden';
    	document.getElementById('numSiretTextBox').value = 0;
    }
	
	
}
	</script>
</head>
<body onload="demarage()">

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
        <li><a href="<%= ctxPath %>/listeContact.do">Liste des contacts</a></li>
        <li><a href="<%= ctxPath %>/CreationGroupe.do">Créer un groupe</a></li>
        <li><a href="<%= ctxPath %>/ContactCreation.do">Créer un contact</a></li>
        <li><a href="<%= ctxPath %>/listGroupe.do">Gestion des contacts</a></li>
      </ul>
      
    </div>
  </div>
</nav>

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
long siret =(long) request.getAttribute("siret");
%>


<table>
<html:hidden property="idm"  value="<%=String.valueOf(c.getNum())%>" />
<tr >
<td>
Entreprise <input  id="checkBoxEntreprise" type="checkbox" onclick="activeNumSiret()">
</td>
<td id="divNumSiret">
Num Siret 				
<html:text  styleId="numSiret" property="numSiret" size="20" maxlength="20"  styleClass="form-control" value="<%=String.valueOf(siret)%>" />
</td>
</tr>

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
