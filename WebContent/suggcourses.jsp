
    <%@ page import="java.util.ArrayList" %>	

<%@ page import="pack.resource" %>


<title></title>
<style>
body{
background-color: #f3efed;
}
</style>
</head>
<br>
<form action="showsuggcourse" method="post" name="f1" onsubmit="return checkdata()">
<div class="row" style="margin:10px;">
<div class="col-md-4"></div>
 <div class="col-md-4">
  <div class="panel panel-success">
  <div class="panel-heading" style="text-align:center;"><h4>Courses</h4></div>
  <p style="color:red;text-align:center">${zc}</p>
  <div class="panel-body" style="text-align:center;" >
  <div class="form-group" style="text-align:left">
 <%dbconnection db=new dbconnection();
 ResultSet rs=db.selectdata("select distinct name from scourse");
 %>
    <tr>
       
       <td><label id="name">Name of Courses:</label></td>
                   <td>
                      <select name="name" class="form-control">
                       <option value="">---------Select Option----------</option>e
              <% while(rs.next()){
                        	%>
             <option value="<%=rs.getString(1)%>"><%=rs.getString(1)%></option>
             <%
                }
                    %>
          </select>    
                       
                   </td>
   </tr>
 </div>
 
       <div class="form-group" style="text-align:left">
   </div>
 <button type="submit" class="btn btn-primary" >Show</button>
 </div>
</div>
<br>
<br>
<%
String c=request.getParameter("c");
System.out.println("C:"+c);
if(c!=null)
{
	ResultSet rs1=db.selectdata("select * from scourse where name='"+ c +"'");
	%>
		
            
                          <table class="table table-striped" style="text-align:center">
                            <thead>
                                <tr>
                                    <th style="text-align:center">Suggested Courses for <%=c %></th>
                                   
                                </tr>
                            </thead>
                        <tbody>
                        <% 
                  
                       while(rs1.next()) {
                        	
                        	%>
                        <tr>
                       	<td><%=rs1.getString(3)%></td>
                       		<%} %>
                       		</tr>
      
                        </tbody>
                </table>
      <%} %>	
	
</div>
<div class="col-md-4"></div>
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

</div>
</form>

