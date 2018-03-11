<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>	
<%@ page import="pack.fsregistration" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Edit Profile</title>
<style>
body{
background-color: #f3efed;
}
</style>
</head>
<body>
<% fsregistration fs=(fsregistration)request.getAttribute("fsdata");
%>
<br>
<form action="updateprofile" method="post" name="f1" onsubmit="return checkdata()">


<div class="col-md-4"></div>
 <div class="col-md-4">
  <div class="panel panel-success">
  <div class="panel-heading" style="text-align:center;"><h4>Profile</h4></div>
  <div class="panel-body" style="text-align:center;" >
    <p style="color:red;text-align:center">${zc}</p>
  <div class="form-group" style="text-align:left">
 <label id="name">Netid:</label>
 <input class="form-control" name="name" type="text"  value="<%=fs.getNetid()%>" readonly>
 </div>
 <div class="form-group" style="text-align:left">
 <label id="member">Password:</label>
 <input class="form-control" name="password" type="text" value="<%=fs.getPassword()%>">
 </div>
  <div class="form-group" style="text-align:left">
 <label id="member">Confirm Password:</label>
 <input class="form-control" name="p2" type="text"  value="<%=fs.getPassword()%>">
 </div>
 <div class="form-group" style="text-align:left">
 <label id="netid">Firstname:</label>
 <input class="form-control" name="firstname" type="text"  value="<%=fs.getFirstname()%>">
 </div>
 <div class="form-group" style="text-align:left">
 <label id="netid">Lastname:</label>
 <input class="form-control" name="lastname" type="text"  value="<%=fs.getLastname()%>">
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

</body>
<script>
function checkdata()
{
	 var p=document.f1.password.value;
	 var p2=document.f1.p2.value;
    var name=document.f1.name.value;
    
    var firstname=document.f1.firstname.value;
    var lastname=document.f1.lastname.value;
    
    var regularExpression = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,16}$/;
    
    if(name=="")
  	{
  	  alert("Netid cannot be null");
        return false;
  	}
    
     if(regularExpression.test(p)==false)
  	  {
  	  alert("Password must be 8 or more and should contain at least 1 letter,1 number and 1 special character");
        return false;
  	  }
     if(p!=p2)
    	 {
    	 alert("Password didn't match");
         return false;
    	 }
     if(firstname=="")
 	{
 	  alert("firstname cannot be null");
       return false;
 	}
     if(lastname=="")
 	{
 	  alert("lastname cannot be null");
       return false;
 	}
    
    
}
</script>
</html>