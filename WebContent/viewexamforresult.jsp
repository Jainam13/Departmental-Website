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
<% ArrayList<exam> exam = (ArrayList<exam>)request.getAttribute("exam"); 

%>
<br>
 <div class="col-md-4"></div>
            <div class="col-md-4">
            <h4 align="center">Exams</h4>
            <p style="color:red;text-align:center">${zc}</p>
                          <table class="table table-striped" style="text-align:center">
                            <thead>
                                <tr>
									<th style="text-align:center">Name</th>
                                    <th style="text-align:center">Date</th>
                                    <th style="text-align:center">Link</th>
                                </tr>
                            </thead>
                        <tbody>
                        <% for (int i=0;i<exam.size();i++) {
                        	%>
                        <tr>
                            <td style="font-size:20px"><a href="showstudentexam?x=<%=exam.get(i).getExam_name()%>"><%=exam.get(i).getExam_name()%></a></td>
                            <td><%=exam.get(i).getDate()%></td>
                            <td><%=exam.get(i).getLink()%></td>
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
