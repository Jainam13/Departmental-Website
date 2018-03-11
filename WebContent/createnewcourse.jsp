<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="pack.dbconnection"%>
<%@page  import="java.sql.*" %>
</div>
</div>
<div class="container-fluid">

<form action="createnewcourse" method="post">
<br>
<div class="col-md-4"></div>
 <div class="col-md-4">
  <div class="panel panel-success">
  <div class="panel-heading" style="text-align:center;"><h4>CREATE NEW COURSE</h4></div>
  <div class="panel-body" style="text-align:center;" >
 <p style="color:red;text-align:center">${zc}</p>
  <div class="form-group" style="text-align:left">
 <label id="netid">CSI:</label>
 <input class="form-control" name="csi" type="text" placeholder="CSI" required>
 </div>
 <div class="form-group" style="text-align:left">
 <label for="password">Coursename:</label>
 <input class="form-control" name="cname" type="text" placeholder="Coursename" size="50" / required>
 </div>
 <button type="submit" class="btn btn-default" >Create</button>
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
