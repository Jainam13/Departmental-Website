<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page import="java.util.ArrayList" %>	
<%@ page import="pack.post" %>
<title>Insert title here</title>
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
<% ArrayList<post> post = (ArrayList<post>)request.getAttribute("post"); 
%>
<br>
 <div class="col-md-4"></div>
            <div class="col-md-4">
            <h4 align="center">Posts</h4>
            
                          <table class="table table-striped" >
                            <thead>
                                <tr>
                                    <th>Course Name</th>
                                    <th style="text-align: center">Post</th>
                                </tr>
                            </thead>
                        <tbody>
                        <% for (int i=0;i<post.size();i++) {
                        	%>
                        <tr>
                       		<td><%=post.get(i).getCoursename()%></td>
                            <td><%=post.get(i).getpost()%></td>
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
