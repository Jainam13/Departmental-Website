<%@page import="pack.dbconnection"%>
<%@page  import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Login</title>
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
</head>
<body>
<div class="container">
  <div class="row">		
                <span style="float:right;">
                 <strong >Welcome,<%=session.getAttribute("name").toString() %></strong> &nbsp;
                 <a href="logout"><span class="label label-primary btn-lg">Log out</span></a>
                </span>
            </div>
<div class="navbar4">
<h2>
Sidebar Menu
</h2>

<nav>
<a href="editprofilestudent.jsp?x=<%=session.getAttribute("id") %>">Edit Profile</a>
</nav>
</div>
<div class="navbar8">
<h2>
Sidebar Menu
</h2>

<nav>

<a href="viewresult?x=<%=session.getAttribute("id") %>">View Results</a>
</nav>
</div>
 <div class="navbar">
<h2>
Sidebar Menu
</h2>

<nav>
<a href="viewstucourse.jsp">View all courses</a>
<a href="viewcourseinfo.jsp?x=<%=session.getAttribute("id") %>">View course Info</a>

</nav>
</div>
<div class="navbar1">
<h2>
Sidebar Menu
</h2>

<nav>
<a href="resourcedetails?x=<%=session.getAttribute("id") %>">Reserve Resources</a>
<a href="viewreservation?x=<%=session.getAttribute("id") %>">View Reservation</a>
</nav>
</div>
<div class="navbar2">
<h2>
Sidebar Menu
</h2>

<nav>
<a href="viewcourseinfo.jsp?x=<%=session.getAttribute("id") %>">View Office hours</a>


<a href="viewannstudent.jsp?x=<%=session.getAttribute("id") %>">View Events</a>

<a href="viewjobstudent.jsp?x=<%=session.getAttribute("id") %>">View Job opportunities</a>

<a href="viewnewsstudent.jsp?x=<%=session.getAttribute("id") %>">View News</a>
</nav>
</div>
<div class="navbar3">
<h2>
Sidebar Menu
</h2>

<nav>

<a href="alumnidetails?x=<%=session.getAttribute("id") %>">View Alumni</a>
</nav>
</div>

<div class="navbar6">
<h2>
Sidebar Menu
</h2>

<nav>
<a href="viewexamresults.jsp?x=<%=session.getAttribute("id") %>">View Result</a>
<a href="viewstudentexam.jsp?x=<%=session.getAttribute("id") %>">Exam Registration</a>
</nav>
</div>
<div class="navbar7">
<h2>
Sidebar Menu
</h2>

<nav>

<a href="topicdetails?x=<%=session.getAttribute("id") %>">View Topic</a>
</nav>
</div>
<div class="navbar8">
<h2>
Sidebar Menu
</h2>

<nav>

<a href="programreq.jsp?x=<%=session.getAttribute("id") %>">Program Requirements</a>
</nav>
</div>
<div class="navbar5">
<h2>
Sidebar Menu
</h2>

<nav>

<a href="suggcourses.jsp?x=<%=session.getAttribute("id") %>">View Suggested Courses</a>
</nav>
</div>
<div class="container">
<div class="text">
 <p style="color:red;text-align:center">${zc}</p>
<h1>CS Department</h1>
<a class="" href="#" >Student</a>
<a class="menu-toggle" href="#" >Courses</a>
<a class="menu-toggle1" href="#">Resource</a>
<a class="menu-toggle2" href="#">View Post</a>
<a class="menu-toggle3" href="#">Alumni Info</a>
<a class="menu-toggle4" href="#">Edit Profile</a>
<a class="menu-toggle" href="sendemail.jsp">Send Email</a>
<a class="menu-toggle6" href="#">Exam</a>
<a class="menu-toggle7" href="#">Discussion Board</a>
<a class="menu-toggle5" href="#">List of Suggested Courses</a>
<a class="menu-toggle8" href="#">Program Requirements</a>
</div>
</div>
 <%@include file="footer.jsp" %>