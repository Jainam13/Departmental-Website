<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>	
<%@ page import="pack.topic" %>
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
<% ArrayList<topic> topic = (ArrayList<topic>)request.getAttribute("topic"); 
%>
<br>
 <div class="col-md-4"></div>
            <div class="col-md-4">
            <h4 align="center">Topics</h4>
            <p style="color:red;text-align:center">${zc}</p>
                          <table class="table table-striped" style="text-align:center">
                            <thead>
                                <tr>
									
                                    <th style="text-align:center">Topic Name</th>
                                </tr>
                            </thead>
                        <tbody>
                        <% for (int i=0;i<topic.size();i++) {
                        	%>
                        <tr>
                            <td><a href="viewtopicpost?x=<%=topic.get(i).getName()%>"><%=topic.get(i).getName()%></a></td>
                        </tr>
                        <%} %>
      
                        </tbody>
                </table>
      
         
</div>
<%@page import="pack.Alist"%>
<%

String netid=session.getAttribute("id").toString();
System.out.println("Netid:"+netid);
Alist a=new Alist();
String role;
role=a.role(netid);
System.out.println("Role:"+role);
String staff="Staff";
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
