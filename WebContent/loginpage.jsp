<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="pack.dbconnection"%>
<%@page  import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/css/CustomStyle.css" rel="stylesheet">
<title>Insert title here</title>
<style>
body{
background-color: #f3efed;
}
</style>
</head>
<body>
  
<div class="container-fluid">


<div class="col-md-4"></div>
<div class="col-md-4">
<div class="headerStyle">
          <span>
          <h1><img src="assets/images/UAlbany.jpg" style="height:100px;width:150px;"></h1>
            </span>    
              
                
            
      </div>

</div>
<div class="container-fluid">
<form action="checklogin" method="post">
<div class="col-md-4"></div>
 <div class="col-md-4">
  <div class="panel panel-success">
  <div class="panel-heading" style="text-align:center;"><h4>Login</h4></div>
  <div class="panel-body" style="text-align:center;" >
  <p style="color:red;text-align:center">${zc}</p>
  <div class="form-group" style="text-align:left">
 <label id="netid">NetID:</label>
 <input class="form-control" name="netid" type="text" placeholder="NetID">
 </div>
 <div class="form-group" style="text-align:left">
 <label for="password">Password:</label>
 <input class="form-control" name="password" type="password" placeholder="Password" size="50" />
 </div>
 <button type="submit" class="btn btn-primary" >Login</button>
 </div>
 <div class="panel-footer">
 
<a href="registration.jsp" style="text-align:center">Register here</a>
</div>
</div>
</div>
</form>
</div>
 <%@include file="footer.jsp" %>