<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page import="java.util.ArrayList" %>	
<%@ page import="pack.studentregistration" %>
<title>PhD student</title>
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/css/CustomStyle.css" rel="stylesheet">
<style>
body{
background-color: #f3efed;
}
</style>
</head>
<body>
<% ArrayList<studentregistration> PhD = (ArrayList<studentregistration>)request.getAttribute("specificPhD"); 
%>

 <%for(int i=0;i<PhD.size();i++){ %>
<form action="modifystatus?x=<%=PhD.get(i).getNetid() %>" method="post" name="f1" onsubmit="return checkdata()">
<br>
 <div class="col-md-4"></div>
            <div class="col-md-4">
            <div class="panel panel-success">
  <div class="panel-heading" style="text-align:center;"><h4>Student Detail</h4></div>
  <div class="panel-body" style="text-align:center;" >
  <p style="color:red;text-align:center">${zc}</p>
  <div class="form-group" style="text-align:left">
 
 <label id="netid">NetID:</label><%=PhD.get(i).getNetid() %>
 </div>
 <div class="form-group" style="text-align:left">
 <label for="password">Firstname:</label><%=PhD.get(i).getFirstname()%>
 </div>
 <div class="form-group" style="text-align:left">
 <label for="password">Lastname:</label><%=PhD.get(i).getLastname() %>
 </div>
 <div class="form-group" style="text-align:left">
 <label for="password">Year_joined:</label><%=PhD.get(i).getYear_joined() %>
 </div>
 <div class="form-group" style="text-align:left">
 <label for="password">Program:</label><%=PhD.get(i).getProgram() %>
 </div>
 <div class="form-group" style="text-align:left">
 <label for="password">Major:</label><%=PhD.get(i).getMajor() %>
 </div>
 <div class="form-group" style="text-align:left">
 <label for="password">Status:</label>
 <input class="form-control"  type="text" name="status" value="<%=PhD.get(i).getStatus() %>">
 </div>
 <button type="submit" class="btn btn-primary" >Modify Status</button>
 </div>
 <%} %>
 
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
	var s=document.f1.status.value;
	if(s==""){
		alert("Status cannot be null")
		return false;
	}
	
	}

</script>
</html>