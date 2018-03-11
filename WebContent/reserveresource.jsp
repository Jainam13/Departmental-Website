
    <%@ page import="java.util.ArrayList" %>	

<%@ page import="pack.resource" %>


<title>Reserve Resource</title>
<style>
body{
background-color: #f3efed;
}
</style>
</head>
<br>
<form action="addreserveresource" method="post" name="f1" onsubmit="return checkdata()">
<div class="row" style="margin:10px;">
<div class="col-md-4"></div>
 <div class="col-md-4">
  <div class="panel panel-success">
  <div class="panel-heading" style="text-align:center;"><h4>Reserve Resource</h4></div>
  <p style="color:red;text-align:center">${zc}</p>
  <div class="panel-body" style="text-align:center;" >
  <div class="form-group" style="text-align:left">
 <%ArrayList<resource> resource = (ArrayList<resource>)request.getAttribute("resource"); %>
    <tr>
       
       <td><label id="name">Name of resource:</label></td>
                   <td>
                      <select name="name" class="form-control">
              <% for (int i=0;i<resource.size();i++) {
                        	%>
             <option value="<%=resource.get(i).getresourceid()%>"><%=resource.get(i).getnameofresource()%></option>
             <%
                }
                    %>
          </select>    
                       
                   </td>
   </tr>
 </div>
 <div class="form-group" style="text-align:left">
 <label for="type">Date:</label>
 <input class="form-control" name="date" type="date">
 </div>
       <div class="form-group" style="text-align:left">
       <tr>
       <td><label id="name">Time:</label></td>
                   <td>
                      <select name="time" class="form-control">
             <option value="">SELECT TIME</option>
             <option value="7-8">7am-8am</option>
             <option value="8-9">8am-9am</option>
            <option value="9-10">9am-10am</option>
            <option value="10-11">10am-11am</option>
            <option value="11-12">11am-12am</option>
            <option value="12-1">12pm-1pm</option>
          </select>    
                       
                   </td>
                   </tr>
   </div>
 <button type="submit" class="btn btn-primary" >Reserve Resource</button>
 </div>
</div>
</div>
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
<% System.out.println("IN");%>
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
<script>

function checkdata()
{
    var p=document.f1.name.value;
    var date=document.f1.date.value;
    var time=document.f1.time.value;
    
    
    if(p=="")
  	{
  	  alert("Resourcename cannot be null");
        return false;
  	}
   if(date=="")
    	{
    	  alert("Date cannot be null");
          return false;
    	}
   if(time=="")
	{
	  alert("Select time");
     return false;
	}
    
}
</script>
