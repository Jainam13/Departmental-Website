<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>	
<%@ page import="pack.fsregistration" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function checkdata()
{
	 var p1=document.f1.p1.value;
	 var p2=document.f1.p2.value;
 
     if(p1!=p2)
    	 {
    	 alert("Password didn't match");
         return false;
    	 }
}
</script>
<title>Edit Profile</title>
<style>
body{
background-color: #f3efed;
}
</style>
</head>
<body>
<% 
String id=request.getParameter("x");
System.out.println(id);
dbconnection db=new dbconnection();
ResultSet rs=db.selectdata("select * from studentregistration where netid='"+ id +"'");

%>
<br>
<form action="updatestudentprofile" method="post" name="f1" onsubmit="return checkdata()">


<div class="col-md-4"></div>
 <div class="col-md-4">
  <div class="panel panel-success">
  <div class="panel-heading" style="text-align:center;"><h4>Profile</h4></div>
  <div class="panel-body" style="text-align:center;" >
    <p style="color:red;text-align:center">${zc}</p>
  <div class="form-group" style="text-align:left">
  <% while(rs.next()){%>
 <label id="name">Netid:</label>
 <input class="form-control" name="name" type="text"  value="<%=session.getAttribute("id")%>" readonly>
 </div>

  
 <div class="form-group" style="text-align:left">
 <label id="netid">Firstname:</label>
 <input class="form-control" name="firstname" type="text"  value="<%=rs.getString(4)%>" readonly>
 </div>
 <div class="form-group" style="text-align:left">
 <label id="netid">Lastname:</label>
 <input class="form-control" name="lastname" type="text"  value="<%=rs.getString(5)%>" readonly>
 </div>
  <div class="form-group" style="text-align:left">
 <label id="member">Status:</label>
 <input class="form-control" name="advisor" type="text"  value="<%=rs.getString(10)%>" required readonly>
 </div>
 <div class="form-group" style="text-align:left">
 <label id="member">Password:</label>
 <input class="form-control" name="p1" type="password"  value="<%=rs.getString(3)%>" required>
 </div>
<div class="form-group" style="text-align:left">
 <label id="member">Confirm Password:</label>
 <input class="form-control" name="p2" type="password"  value="<%=rs.getString(3)%>" required>
 </div>
 <div class="form-group" style="text-align:left">
 <label id="member">Advisor Information:</label>
 <input class="form-control" name="advisor" type="text"  value="<%=rs.getString(11)%>" required>
 </div>
 <div class="form-group" style="text-align:left">
 <label id="member">Email:</label>
 <input class="form-control" name="email" type="email"  value="<%=rs.getString(12)%>" required>
 </div>
 <div class="form-group" style="text-align:left">
 <label id="member">Phone:</label>
 <input class="form-control" name="phone" type="text"  maxlength="10" value="<%=rs.getString(13)%>" required>
 </div>
 
 

 <button type="submit" class="btn btn-primary" >Modify</button>
 </div>
 
</div>
</div>
</form>

 <%} %>
<%@page import="pack.Alist"%>
<%

String netid=session.getAttribute("id").toString();
System.out.println("Netid:"+netid);
Alist a=new Alist();
String role;
role=a.role(netid);
System.out.println("Role:"+role);
String staff="staff";
String fac="Faculty";
if(staff.equals(role)){%>

	<div class="col-md-4"><%@include file="header1.jsp" %></div>
<%@include file="footer.jsp" %>
<% }
else if(fac.equals(role)){%>
	<div class="col-md-4"><%@include file="header.jsp" %></div>
<%@include file="footer.jsp" %>
<%}else
{%>
	<div class="col-md-4"> <%@include file="header2.jsp" %></div>
	<%@include file="footer.jsp" %>
<%}
%>

