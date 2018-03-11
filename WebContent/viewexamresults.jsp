<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>	
<%@ page import="pack.exam"%>
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
<%System.out.println(session.getAttribute("Firstname")); %>
<br>
 <div class="col-md-4"></div>
            <div class="col-md-4">
            <h4 align="center">Exams</h4>
            <p style="color:red;text-align:center">${zc}</p>
                          <table class="table table-striped" style="text-align:center">
                            <thead>
                                <tr>
									<th style="text-align:center">Name</th>
                                    <th style="text-align:center">Result</th>
                                    
                                </tr>
                            </thead>
                        <tbody>
                       <% dbconnection db=new dbconnection();
						ResultSet rs=db.selectdata("select * from examresult where studentname='"+ session.getAttribute("id") +"'");
						System.out.println(session.getAttribute("Firstname"));
						while(rs.next()) {
						
						%>
                        <tr>
                            <td><%=rs.getString(2)%></td>
                            <td><%=rs.getString(4)%></td>
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
