<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body{
background-color: #f3efed;
}
</style>
<script type="text/javascript">
function checkdata()
{
    var p=document.f1.news.value;
   
    
    if(p=="")
  	{
  	  alert("News cannot be null");
        return false;
  	}
   
}
</script>


</head>

<form action="postnews" method="post" name="f1" onsubmit="return checkdata()">
<br>
 <div class="col-md-4"></div>
  <div class="col-md-4">
  <div class="panel panel-success">
  <div class="panel-heading" style="text-align:center;"><h4>Post News</h4></div>
  <div class="panel-body" style="text-align:center;" >
  <p style="color:red;text-align:center">${zc}</p>
  <div class="form-group" style="text-align:left">
 <label id="name">News:</label>
 <input type="hidden" name="x" value="<%=session.getAttribute("id")%>">
 <textarea rows="3" cols="4" class="form-control" name="news"></textarea>

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

