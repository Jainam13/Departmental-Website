<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<script src="assets/js/sidebar.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit News</title>
<style>
body{
background-color: #f3efed;
}
</style>
</head>
<body>
<br>
                        	
<form action="updatenews" method="post" name=""f1" onsubmit="return checkdata()">
<%ArrayList<Object> news = (ArrayList<Object>)request.getAttribute("news"); %>

<div class="col-md-4"></div>
 <div class="col-md-4">
  <div class="panel panel-success">
  <div class="panel-heading" style="text-align:center;"><h4>Edit News</h4></div>
  <div class="panel-body" style="text-align:center;" >
  <p style="color:red;text-align:center">${zc}</p>
  <div class="form-group" style="text-align:left">
 <label id="name">News:</label>
 <input type="hidden" name="x" value="<%=request.getParameter("x")%>">
 <textarea rows="3" cols="4" class="form-control" name="news"><%=news.get(0) %></textarea>

 </div>
  
 
 <button type="submit" class="btn btn-primary" >Modify</button>
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

</body>
<script>
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
</html>