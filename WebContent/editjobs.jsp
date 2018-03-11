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
<title>Post Jobs</title>
<style>
body{
background-color: #f3efed;
}
</style>
</head>
<body>
<br>
          
                        	
<form action="updatejob" method="post" name="f1" onsubmit="return checkdata()">
<%ArrayList<Object> job = (ArrayList<Object>)request.getAttribute("job"); %>

<div class="col-md-4"></div>
 <div class="col-md-4">
  <div class="panel panel-success">
  <div class="panel-heading" style="text-align:center;"><h4>Post Result</h4></div>
  <div class="panel-body" style="text-align:center;" >
  <p style="color:red;text-align:center">${zc}</p>
  <div class="form-group" style="text-align:left">
 <label id="name">Enter Details of job:</label>
 <input type="hidden" name="id" value="<%=request.getParameter("x")%>">
 <textarea rows="3" cols="4" class="form-control" name="job"><%=job.get(0) %></textarea>
<p><label for="location">Location:</label>
<select class="form-control" name = "location" >
       <option value = "">SELECT LOCATION</option>
        <option value = "On-Campus">On-Campus</option>
        <option value = "Off-Campus">Off-Campus</option>
        </select>
        </p>
</div>
<div id="optional" style="display: none;">
  <div class="form-group" style="text-align:left">
 <label id="member">Link:</label>
 <input class="form-control" name="link" type="text">
 </div>
 </div>
  <div id="other" style="display: none;">
  <div class="form-group" style="text-align:left">
 <label id="member">Email:</label>
 <input class="form-control" name="link" type="email">
 </div>
 </div>
 <button type="submit" class="btn btn-primary" >Modify</button>
 </div>
  
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
$("select").change(function () {
    // hide all optional elements
   

    $("select option:selected").each(function () {
        if($(this).val() == "On-Campus") {
            $('#optional').css('display','block');
            $('#other').css('display','none');
        } else if($(this).val() == "Off-Campus") {
            $('#other').css('display','block');
            $('#optional').css('display','none');
        }
    });
});
function checkdata()
{
    var p=document.f1.job.value;
    var l=document.f1.location.value;
    var t=document.f1.link.value;
   
    
    if(p=="")
  	{
  	  alert("Job Details cannot be null");
        return false;
  	}
    if(l=="")
  	{
  	  alert("Select Location");
        return false;
  	}
    if(t=="")
  	{
  	  alert("Link/Email cannot be null");
        return false;
  	}
}
  
</script>
</html>