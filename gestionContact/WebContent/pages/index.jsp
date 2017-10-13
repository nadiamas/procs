<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="s" uri="http://struts.apache.org/tags-nested" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html:html>
 
<head>
	<title>Index</title>
		<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>
		<style type="text/css"> <%@ include file="css/animate.css" %> </style>
		<style type="text/css"> <%@ include file="css/style.css" %> </style>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

</head>

<body style="background-color: #F5F5DC ;">
	<div class="container">
		<div class="top">
			<h1 id="title" class="hidden"><span id="logo">Gérer vos <span>Contacts</span></span></h1>
		</div>
		<html:form action="/Login">
		<div class="login-box animated fadeInUp">
			<div class="box-header">
				<h2>Log In</h2>
			</div>
			<label for="userName">Username</label>
			<br/>
			<html:text property="userName" size="30" maxlength="30"/>
			<br/>
			<label for="password">Password</label>
			<br/>
            <html:password property="password" size="30" maxlength="30"/>
			<br/>
			 <html:submit>Save</html:submit>
			<br/>
		
		</div>
		 </html:form>
	</div>
	
</body>

<script>
	$(document).ready(function () {
    	$('#logo').addClass('animated fadeInDown');
    	$("input:text:visible:first").focus();
	});
	$('#userName').focus(function() {
		$('label[for="userName"]').addClass('selected');
	});
	$('#userName').blur(function() {
		$('label[for="userName"]').removeClass('selected');
	});
	$('#password').focus(function() {
		$('label[for="password"]').addClass('selected');
	});
	$('#password').blur(function() {
		$('label[for="password"]').removeClass('selected');
	});
</script>

 </html:html>