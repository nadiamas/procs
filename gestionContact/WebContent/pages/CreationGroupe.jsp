<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title></title>
<html:base/>
</head>
<body style="background-color:#FFFACD; ">
<div class="container">

<html:form action="/AddGroup">
<html:errors/>
<br>
<br>
<br>
<center>
<div style="width: 30%">
<div class="form-group">
  <label for="nomgroupe">Nom du Groupe:</label>
<html:text property="nomgroupe" styleClass="form-control"/>
</div>
</div>

<html:submit property="btn" value="save" styleClass="btn btn-warning"></html:submit>
</center>
<br>
<br>
<br>
<hr>
<html:submit property="btn" value="retour" styleClass="btn btn-default"></html:submit>
</html:form>
</div>


</body>
</html:html>
