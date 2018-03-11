<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
<style>
body{
background-color: #f3efed;
}
</style>
</head>
<body>
<br>
<form action="alumnipost" method="post">

<div class="col-md-4"></div>
 <div class="col-md-4">
  <div class="panel panel-success">
  <div class="panel-heading" style="text-align:center;"><h4>Post Alumni</h4></div>
  <div class="panel-body" style="text-align:center;" >
  <p style="color:red;text-align:center">${zc}</p>
  <div class="form-group" style="text-align:left">
 <label id="name">Name:</label>
 <input class="form-control" name="name" type="text" placeholder="Name">
 </div>
 <div class="form-group" style="text-align:left">
 <label id="member">Member/s:</label>
 <input class="form-control" name="member" type="text" placeholder="Member/s">
 </div>
 <div class="form-group" style="text-align:left">
 <label id="netid">Founded:</label>
 <input class="form-control" name="founded" type="text" placeholder="Founded">
 </div>
 <div class="form-group" style="text-align:left">
 <label id="netid">Link:</label>
 <input class="form-control" name="link" type="text" placeholder="Link">
 </div>
 <button type="submit" class="btn btn-primary" >Post</button>
 </div>
 <div class="panel-footer">
</div>
</div>
</div>
</form>
<%@page import="pack.Alist"%>
<%

String netid=session.getAttribute("id").toString();
Alist a=new Alist();
String role;
role=a.role(netid);
System.out.println("Role:"+role);
if(role.equals("Staff")){%>

	<div class="col-md-4"><%@include file="header1.jsp" %></div>
<%@include file="footer.jsp" %>
<% }else{%>
	<div class="col-md-4"><%@include file="header.jsp" %></div>
<%@include file="footer.jsp" %>
<%}
%>
