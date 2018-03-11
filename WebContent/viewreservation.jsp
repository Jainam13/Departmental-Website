<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>	
<%@ page import="pack.reservedresource" %>
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
<% ArrayList<reservedresource> resource = (ArrayList<reservedresource>)request.getAttribute("resource"); 
%>

 <div class="col-md-4"></div>
            <div class="col-md-4">
            <h4 align="center">Courses</h4>
            <p style="color:red;text-align:center">${zc}</p>
                          <table class="table table-striped" >
                            <thead>
                                <tr>
									<th>Resource</th>
                                    <th>Date</th>
                                    <th>Time</th>
                                    <th>&nbsp;</th>
                                </tr>
                            </thead>
                        <tbody>
                        <% for (int i=0;i<resource.size();i++) {
                        	%>
                        <tr>
                            <td><%=resource.get(i).getResourcename()%></td>
                            <td><%=resource.get(i).getDate()%></td>
                            <td><%=resource.get(i).getTime()%></td>
                            
                             <td><a href='cancelreservation?x=<%= resource.get(i).getReservedresource_id()%>'>Cancel Reservation</a></td>
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
