<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>	
<%@ page import="pack.studentexamsignup" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Post result</title>
<style>
body{
background-color: #f3efed;
}
</style>
</head>
<body>
<br>
                
                        	
<form action="postexamresult" method="post" name="f1" onsubmit="return checkdata()">


<div class="col-md-4"></div>
 <div class="col-md-4">
  <div class="panel panel-success">
  <div class="panel-heading" style="text-align:center;"><h4>Post Result</h4></div>
  <div class="panel-body" style="text-align:center;" >
  <p style="color:red;text-align:center">${zc}</p>
  <div class="form-group" style="text-align:left">
 <label id="name">Exam Name:</label>
 <input type="hidden" name="student" value="<%=request.getParameter("name")%>">
 <input class="form-control" name="name" type="text"  value="<%=request.getParameter("x")%>" readonly>
 </div>
 <div class="form-group" style="text-align:left">
 
       
       <td><label id="name">Student exam id:</label></td>
                   <td>
                      <select name="id" class="form-control">
             <%ArrayList<studentexamsignup> exam = (ArrayList<studentexamsignup>)request.getAttribute("exam"); %>
    <tr>
                 <% for (int i=0;i<exam.size();i++) {%>
             <option value="<%=exam.get(i).getNetid()%>"><%=exam.get(i).getStudentexam_id()%>:<%=exam.get(i).getNetid()%></option>
             <%
                }
                    %>
          </select>    
                       
                   </td>
   </tr>
 </div>
  <div class="form-group" style="text-align:left">
 <label id="member">Result:</label>
 <input class="form-control" name="result" type="text">
 </div>
 
 <button type="submit" class="btn btn-primary" >Post</button>
 </div>
 <div class="panel-footer">
</div>
</div>
</div>
</form>
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

</body>
<script type="text/javascript">
function checkdata()
{
	var name=document.f1.name.value;
	var id=document.f1.id.value;
	var re=document.f1.result.value;
	
	if(re=="")
		{
		alert("Enter Result");
		return false;
		}
	}
</script>
</html>