<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/css/CustomStyle.css" rel="stylesheet">
<title>Add Exam</title>
<script>
function checkdata()
{
	var name=document.f1.name.value;
	var date=document.f1.date.value;
	if(name=="")
		{
		alert("Name of Exam cannot be null");
		return false;
		}
	if(date=="")
	{
	alert("Date cannot be null");
	return false;
	}	
	}
</script>
<style>
body{
background-color: #f3efed;
}
</style>
<div class="container-fluid">

	
<br>
<form action="addexam" method="post" name="f1" onsubmit="return checkdata()">
<div class="col-md-4"></div>
 <div class="col-md-4">
  <div class="panel panel-success">
  <div class="panel-heading" style="text-align:center;"><h4>Add Exam</h4></div>
  <div class="panel-body" style="text-align:center;" >
  <p style="color:red;text-align:center">${zc}</p>
  <div class="form-group" style="text-align:left">
 <label id="netid">Name of Exam:</label>
 <input class="form-control" name="name" type="text" placeholder="Name of Exam">
 </div>
 <div class="form-group" style="text-align:left">
 <label for="password">Date of Exam:</label>
 <input class="form-control" name="date" type="date" placeholder="Date of Exam" size="50" />
 </div>
 <div class="form-group" style="text-align:left">
 <label for="password">Optional Link:</label>
 <input class="form-control" name="link" type="text" placeholder="Link(optional)" size="50" />
 </div>
 <button type="submit" class="btn btn-primary" >Add</button>
 </div>
  
</div>
</div>

<%@page import="pack.Alist"%>
<%

String netid=session.getAttribute("id").toString();
Alist a=new Alist();
String role;
role=a.role(netid);
System.out.println("Role:"+role);
if(role.equals("Staff")){%>

	<div class="col-md-4"><%@include file="header1.jsp" %></div><%@include file="footer.jsp" %>

<% }else{%>
	<div class="col-md-4"><%@include file="header.jsp" %></div>
<%@include file="footer.jsp" %>
<%}
%>
