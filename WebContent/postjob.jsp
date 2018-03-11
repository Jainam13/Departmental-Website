
    <%@ page import="java.util.ArrayList" %>	

<script>

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


<title>Post Jobs</title>
<style>
body{
background-color: #f3efed;
}
</style>
</head>
<body>
<br>
                
                        	
<form action="postjobs" method="post" name="f1" onsubmit="return checkdata()">


<div class="col-md-4"></div>
 <div class="col-md-4">
  <div class="panel panel-success">
  <div class="panel-heading" style="text-align:center;"><h4>Post Jobs</h4></div>
  <div class="panel-body" style="text-align:center;" >
  <p style="color:red;text-align:center">${zc}</p>
  <div class="form-group" style="text-align:left">
 <label id="name">Enter Details of job:</label>
 <input type="hidden" name="x" value="<%=session.getAttribute("id")%>">
 <textarea rows="3" cols="4" class="form-control" name="job"></textarea>
 </div>
<div class="form-group" style="text-align:left">
<p><label for="location">Location:</label>
<select class="form-control" name = "location" >
       <option value = "">SELECT LOCATION</option>
        <option value = "On-Campus">On-Campus</option>
        <option value = "Off-Campus">Off-Campus</option>
        </select>
        </p>
</div>
<div class="form-group" style="text-align:left">
 <label id="member">Link/Email:</label>
 <input class="form-control" name="link" type="text">
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


