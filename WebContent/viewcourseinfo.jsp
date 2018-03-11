<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="pack.dbconnection"%>
<%@page  import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>	
<%@ page import="pack.courses" %>
<% dbconnection db=new dbconnection();
ResultSet rs=db.selectdata("select * from facultypost");
System.out.println(rs);
%>


 <div class="col-md-4"></div>
            <div class="col-md-4">
            <h4 align="center">Courses</h4>
            <p style="color:red;text-align:center">${zc}</p>
                          <table class="table table-condensed" style="text-align:center">
                            <thead>
                                <tr>
									<th style="text-align:center">Faculty</th>
                                    <th style="text-align:center">Post</th>
                                    <th style="text-align:center">Name of course</th>
                                    <th style="text-align:center">TA's Office hours</th>
                                    <th style="text-align:center">Faculty's Office hours</th>
                                    <th style="text-align:center">Course Syllabus</th>
                                </tr>
                            </thead>
                        <tbody>
                        <% while(rs.next()) {
                        	%>
                        <tr>
                            <td><%=rs.getString(2)%></td>
                            <td><%=rs.getString(3)%></td>
                           <td><%=rs.getString(4)%></td>
                            <td><%=rs.getString(5)%></td>
                             <td><%=rs.getString(6)%></td>
                              <td><%=rs.getString(7)%></td>
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
