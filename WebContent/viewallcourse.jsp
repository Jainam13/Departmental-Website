<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ page import="java.util.ArrayList" %>	
<%@ page import="pack.courses" %>
<% ArrayList<courses> course = (ArrayList<courses>)request.getAttribute("course"); 
%>


 <div class="col-md-4"></div>
            <div class="col-md-4">
            <h4 align="center">Courses</h4>
            <p style="color:red;text-align:center">${zc}</p>
                          <table class="table table-striped" >
                            <thead>
                                <tr>
									<th>CSI</th>
                                    <th>Course Name</th>
                                </tr>
                            </thead>
                        <tbody>
                        <% for (int i=0;i<course.size();i++) {
                        	%>
                        <tr>
                            <td><%=course.get(i).getcoursecsi()%></td>
                            <td><%=course.get(i).getcoursename()%></td>
                            
                             <td><a href='addcourse?x=<%= course.get(i).getcoursecsi() %>'>ADD</a></td>
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
