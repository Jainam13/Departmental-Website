<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>	
<%@ page import="pack.alumnidata" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
<script>
function checkdata()
{
	var p=document.f1.name.value;
	var m=document.f1.member.value;
	var f=document.f1.founded.value;
	var l=document.f1.link.value;
	if(p=="")
		{
		alert("Name cannot be null");
		return false;
		}
	if(m=="")
	{
	alert("Member cannot be null");
	return false;
	}
	
	if(f=="")
	{
	alert("Founded Field cannot be null");
	return false;
	}
	if(l=="")
	{
	alert("Link field cannot be null");
	return false;
	}
	}

</script>
<style>
body{
background-color: #f3efed;
}
</style>
</head>
<body>
<% alumnidata alumni=(alumnidata)request.getAttribute("editalumni");
%>

<form action="updatealumni" method="post" name="f1" onsubmit="return checkdata()">
<input type="hidden" name="alumniid" value="<%=request.getParameter("x")%>">
<h1><p>${zc}</p></h1>
<div class="col-md-4"></div>
 <div class="col-md-4">
  <div class="panel panel-success">
  <div class="panel-heading" style="text-align:center;"><h4>Alumni Info</h4></div>
  <div class="panel-body" style="text-align:center;" >
  <div class="form-group" style="text-align:left">
 <label id="name">Name:</label>
 <input class="form-control" name="name" type="text" placeholder="Name" value="<%=alumni.getname()%>">
 </div>
 <div class="form-group" style="text-align:left">
 <label id="member">Member/s:</label>
 <input class="form-control" name="member" type="text" placeholder="Member/s" value="<%=alumni.getmembers()%>">
 </div>
 <div class="form-group" style="text-align:left">
 <label id="netid">Founded:</label>
 <input class="form-control" name="founded" type="text" placeholder="Founded" value="<%=alumni.getfounded()%>">
 </div>
 <div class="form-group" style="text-align:left">
 <label id="netid">Link:</label>
 <input class="form-control" name="link" type="text" placeholder="Link" value="<%=alumni.getlink()%>">
 </div>
 <button type="submit" class="btn btn-primary" >Post</button>
 </div>
 <div class="panel-footer">
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

	<div class="col-md-4"><%@include file="header1.jsp" %></div>
<%@include file="footer.jsp" %>
<% }else{%>
	<div class="col-md-4"><%@include file="header.jsp" %></div>
<%@include file="footer.jsp" %>
<%}
%>
