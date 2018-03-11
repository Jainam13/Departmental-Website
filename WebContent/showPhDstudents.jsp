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
<% ArrayList<studentregistration> PhD = (ArrayList<studentregistration>)request.getAttribute("PhD"); 
%>
<br>
 <div class="col-md-4"></div>
            <div class="col-md-4">
            <h4 align="center">PhD students</h4>
            
                          <table class="table table-striped" style="text-align:center">
                            <thead>
                                <tr>
                                    <th style="text-align:center">Name</th>
                                    <h1><p style="color:red;text-align:center">${zc}</p></h1>
                                </tr>
                            </thead>
                        <tbody>
                        <% for (int i=0;i<PhD.size();i++) {
                        	%>
                        <tr>
                       		<td><a href="viewPhDdetails?x=<%=PhD.get(i).getNetid()%>"><%=PhD.get(i).getFirstname()%>&nbsp;<%=PhD.get(i).getLastname()%></a></td>
                        </tr>
                        
                        <%} %>
      
                        </tbody>
                </table>
      
         
</div>
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
