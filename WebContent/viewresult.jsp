<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>	
<%@ page import="pack.showresult"%>
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
<% ArrayList<showresult> result = (ArrayList<showresult>)request.getAttribute("result"); 

%>
<br>
 <div class="col-md-4"></div>
            <div class="col-md-4">
            <h4 align="center">Results</h4>
            <p style="color:red;text-align:center">${zc}</p>
                          <table class="table table-striped" style="text-align:center">
                            <thead>
                                <tr>
									<th style="text-align:center">Student Name</th>
                                    <th style="text-align:center">Exam Name</th>
                                    <th style="text-align:center">Result</th>
                                </tr>
                            </thead>
                        <tbody>
                        <% for (int i=0;i<result.size();i++) {
                        	%>
                        <tr>
                            <td><%=result.get(i).getStudentname()%></td>
                            <td><%=result.get(i).getExamname()%></td>
                            <td><%=result.get(i).getResult()%></td>
                            <td><a href='editresult?x=<%= result.get(i).getExamname()%>&amp;name=<%= result.get(i).getStudentname()%>'>Edit</a></td>
                            <td><a href='deleteresult?x=<%= result.get(i).getExamname()%>&amp;name=<%= result.get(i).getStudentname()%>'>Delete</a></td>
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
