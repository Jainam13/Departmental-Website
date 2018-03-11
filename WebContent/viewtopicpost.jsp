<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>	
<%@ page import="pack.topic" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
<style>
body{
background-color: #f3efed;
}
</style>
</head>
<body>
<% ArrayList<topic> topic = (ArrayList<topic>)request.getAttribute("post");
ArrayList<topic> topicreply = (ArrayList<topic>)request.getAttribute("reply");
%>

<form action="addtopicpost" method="post">
<h2 style="text-align:center"><u>TOPIC NAME</u><br><%=request.getParameter("x") %></h2>
<input type="hidden" name="id" value="<%=request.getParameter("x") %>">
<h1><p>${zc}</p></h1>
 <div class="col-md-4"></div>
 <div class="col-md-4">
  <div class="panel panel-success">
  <div class="panel-heading" style="text-align:center;"><h4>Post</h4></div>
  <div class="panel-body" style="text-align:center;" >
  <div class="form-group" style="text-align:left">
 <label id="netid">Post:</label>
 <input type="text" class="form-control" name="topicpost">
 </div>
 <button type="submit" class="btn btn-primary" >Post</button>
 </div>
 </div>
</form>
 <table class="table table-striped" >
                            <thead>
                                <tr>
                                    <th>Posts</th>
                                    
                                </tr>
                            </thead>
                        <tbody>
                       
                        <% 
                        String reply=request.getParameter("reply");
                        System.out.println("reply:"+reply);
                        for (int i=0;i<topic.size();i++) {
                        	%>
                        	 <form action="topicreply?post=<%=topic.get(i).getBoard_id()%>" method="post">
                        <tr>
                       
                            <td><%=topic.get(i).getPost()%></td>
                             <%if(reply!=null){ %>
                          <td><%=reply %></td>
                          <%  }else{ %>
                          
                          <%} %>
                            <tr>
                           <tr>
                         
                            <td><input type="hidden" name="id" value="<%=request.getParameter("x") %>"></td>
                            <td> <input class="form-control" name="reply" type="text" placeholder="Reply" size="5"></td>
                         <td> <button type="submit" class="btn btn-primary" >Reply</button></td></tr>
                          
                          
                             
                        
                     <%} %>
                      
                        </form>   
                             
                          
                      
                        
                        </tbody>
                </table>    
             
  </div>
 </form>
 
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
                 	
                     
                 
                      	



