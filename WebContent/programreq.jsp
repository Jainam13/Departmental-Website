
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
<form action="progreq" method="post" name="f1" onsubmit="return checkdata()">
<div class="row" style="margin:10px;">
<div class="col-md-4"></div>
 <div class="col-md-4">
  <div class="panel panel-success">
  <div class="panel-heading" style="text-align:center;"><h4>Programs</h4></div>
  <p style="color:red;text-align:center">${zc}</p>
  <div class="panel-body" style="text-align:center;" >
  <div class="form-group" style="text-align:left">
 <%dbconnection db=new dbconnection();
 ResultSet rs=db.selectdata("select distinct programs from progreq");
 %>
    <tr>
       
       <td><label id="name">Name of Courses:</label></td>
                   <td>
                      <select name="name" class="form-control">
                       <option value="">---------Select Option----------</option>
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
	ResultSet rs1=db.selectdata("select * from progreq where programs='"+ c +"'");
	%>
		<h4 align="center">Program Requirements for <%=c %></h4>
            
                          <table class="table table-striped" style="text-align:center">
                            <thead>
                                <tr>
                                    <th style="text-align:center">Credits</th>
                                   <th style="text-align:center">Core Courses</th>
                                </tr>
                            </thead>
                        <tbody>
                        <% 
                  
                       while(rs1.next()) {
                        	
                        	%>
                        <tr>
                       	<td><%=rs1.getString(3)%></td>
                       		<td><%=rs1.getString(4)%></td>
                       		</tr>
      
                        </tbody>
                </table>
      	
	<% }
	
	
	
}

%>
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

