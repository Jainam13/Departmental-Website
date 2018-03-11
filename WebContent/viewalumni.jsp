<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>	
<%@ page import="pack.alumni" %>
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body{
background-color: #f3efed;
}
</style>
</head>
<body>
<% ArrayList<alumni> alumni = (ArrayList<alumni>)request.getAttribute("alumni"); 
String netid=session.getAttribute("id").toString();
System.out.println("Netid:"+netid);
Alist a=new Alist();
String role;
role=a.role(netid);
System.out.println("Role:"+role);
String staff="Staff";
String fac="Faculty";
%>
<br>
 <div class="col-md-3"></div>
            <div class="col-md-5">
            <h4 align="center">Alumniinfo</h4>
            
                          <table class="table table-striped" >
                            <thead>
                                <tr>
									<th>Name</th>
                                    <th>Members</th>
                                    <th>Founded</th>
                                    <th>Link</th>
                                    
                                </tr>
                            </thead>
                        <tbody>
                        <% for(int i=0;i<alumni.size();i++) {%>
                        <tr>
                            <td><%=alumni.get(i).getname()%></td>
                            <td><%=alumni.get(i).getmembers()%></td>
                            <td><%=alumni.get(i).getfounded()%></td>
                            <td><%=alumni.get(i).getlink()%></td>
                            <%if(fac.equals(role)) {%>
                           <td><a href='editalumni?x=<%= alumni.get(i).getalumniid() %>'>Edit</a></td>
                            <%}else if(staff.equals(role)){ %>
                            
                            <td><a href='editalumni?x=<%= alumni.get(i).getalumniid() %>'>Edit</a></td>
                           <% }else{ %>
                           <td></td>
                           <%} %>
                        </tr>
                        <%} %>
      
                        </tbody>
                </table>
      
         
</div>
<%@page import="pack.Alist"%>
<%


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