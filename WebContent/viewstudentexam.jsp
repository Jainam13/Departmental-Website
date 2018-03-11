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

<br>
 <div class="col-md-4"></div>
            <div class="col-md-4">
            <h4 align="center">Exams</h4>
            
                          <table class="table table-striped" style="text-align:center">
                            <thead>
                                <tr>
									<th style="text-align:center">Name</th>
                                    <th style="text-align:center">Date</th>
                                    <th style="text-align:center">Link</th>
                                </tr>
                            </thead>
                        <tbody>
                       <% dbconnection db=new dbconnection();

ResultSet rs=db.selectdata("select * from exam");
while(rs.next()) {
ResultSet rs1=db.selectdata("select * from studentexamsignup where nameofexam='"+ rs.getString(2) +"' and netid='"+ session.getAttribute("id") +"'");

%>
                        <tr>
                            <td><%=rs.getString(2)%></td>
                            <td><%=rs.getString(3)%></td>
                            <td><%=rs.getString(4)%></td>
                            
                            <% if(rs1.next()){%>
                            <td> <p style="color:red;text-align:center">Registered</p></td>
                            <%}else{ %>
                            <td><button class="btn btn-default"><a href="registerforexam?name=<%=rs.getString(2)%>&amp;netid=<%=session.getAttribute("id")%>">Register</a></button></td>
                            
                            <%} %>
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
