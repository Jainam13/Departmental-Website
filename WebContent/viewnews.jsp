<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page import="java.util.ArrayList" %>	
<%@ page import="pack.announ" %>
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
<% ArrayList<announ> ann = (ArrayList<announ>)request.getAttribute("announ"); 
%>
<br>
 <div class="col-md-4"></div>
            <div class="col-md-4">
            <h4 align="center">NEWS</h4>
            
                          <table class="table table-striped" >
                            <thead>
                                <tr>
                                    <th>POSTED BY</th>
                                    <th>News</th>
                                    <th>POSTED ON</th>
                                </tr>
                            </thead>
                        <tbody>
                        <% 
                  
                        for (int i=0;i<ann.size();i++) {
                        	
                        	%>
                        <tr>
                       	<td><%=ann.get(i).getNetid()%></td>
                       		<td><%=ann.get(i).getNews()%></td>
                       		<td><%=ann.get(i).getDate()%></td>
                         <%    String id=request.getParameter("name");
                         //  System.out.println("NAME IN JSP:"+id);
                      		String name=session.getAttribute("name").toString();
                      		System.out.println("netid:"+name);
                      		if(id.equals(ann.get(i).getNetid()))
                       		{%>
                       			<td><a href='editnews?x=<%= ann.get(i).getNews_id() %>'>Edit</a></td>
                       			<td><a href='deletenews?x=<%= ann.get(i).getNews_id() %>'>Delete</a></td>
                       		<%}%>
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
