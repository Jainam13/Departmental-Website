<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<br>
<form action="addresource" method="post">

<div class="col-md-4"></div>
 <div class="col-md-4">
  <div class="panel panel-success">
  <div class="panel-heading" style="text-align:center;"><h4>Resource</h4></div>
  <div class="panel-body" style="text-align:center;" >
  <p style="color:red;text-align:center">${zc}</p>
  <div class="form-group" style="text-align:left">
 <label id="name">Name of resource:</label>
 <input class="form-control" name="nameofresource" type="text" placeholder="Resource Name">
 </div>
 <div class="form-group" style="text-align:left">
 <label for="type">Type of Resource:</label>
 <input class="form-control" name="type" type="text" placeholder="Type of Resources" size="50" />
 </div>
  <div class="form-group" style="text-align:left">
 <label for="type">Description:</label>
 <textarea class="form-control" rows="3" name="desc"></textarea>
 </div>
 <button type="submit" class="btn btn-primary" >Add Resource</button>
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
