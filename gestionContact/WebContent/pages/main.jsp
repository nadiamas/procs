<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.* ,domain.*" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<html:html>
<head>		
<title></title>
  <!-- Required meta tags always come first -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <!-- Bootstrap CSS -->  
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/css/bootstrap.min.css" integrity="sha384-AysaV+vQoT3kOAXZkl02PThvDr8HYKPZhNT5h/CXfBThSRXQ6jW5DO2ekP5ViFdi" crossorigin="anonymous">

</head>

<body style="background-color:#FFFACD; ">
<div class="container">
<br>
<h1 style="text-shadow: 10px 5px 5px #767676;"><center>Main Menu</center></h1>
<br>
<hr>
<hr>
<br>
<center>
<div class="list-group" style="width: 40%;">
  <a href="CreationGroupe.do" class="list-group-item list-group-item-action list-group-item-success"> <center>Créer un groupe</center> </a>
  <a href="listGroupe.do" class="list-group-item list-group-item-action list-group-item-info"><center><bean:message key="group.management"/></center></a>
  <a href="ContactCreation.do" class="list-group-item list-group-item-action list-group-item-danger">Créer un Contact</center></a>
  <a href="listeContact.do" class="list-group-item list-group-item-action list-group-item-info"><center><bean:message key="list.contact"/></center></a>
</div>


<hr>
<hr>

</center>
</div>

</body>

</html:html>
