<%@page import="pack.dbconnection"%>
<%@page  import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Faculty Login</title>
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
<a href="editprofilefac?x=<%=session.getAttribute("id") %>">Edit Profile</a>
</nav>
</div>

 
<div class="navbar1">
<h2>
Sidebar Menu
</h2>

<nav>
<a href="createnewresource.jsp?x=<%=session.getAttribute("id") %>">Create Resources</a>
<a href="resourcedetails?x=<%=session.getAttribute("id") %>">Reserve Resources</a>
<a href="viewreservation?x=<%=session.getAttribute("id") %>">View Reservation</a>
</nav>
</div>
<div class="navbar2">
<h2>
Sidebar Menu
</h2>

<nav>

<a href="postann.jsp?x=<%=session.getAttribute("id") %>">Post Events</a>
<a href="viewann?x=<%=session.getAttribute("id") %>">View Events</a>
<a href="postjob.jsp?x=<%=session.getAttribute("id") %>">Post Job opportunities</a>
<a href="viewjobs?x=<%=session.getAttribute("id") %>">View Job opportunities</a>
<a href="postnews.jsp?x=<%=session.getAttribute("id") %>">Post News</a>
<a href="viewnews?x=<%=session.getAttribute("id") %>">View News</a>
</nav>
</div>
<div class="navbar3">
<h2>
Sidebar Menu
</h2>

<nav>
<a href="postalumni.jsp?x=<%=session.getAttribute("id") %>">Post Alumni</a>
<a href="alumnidetails?x=<%=session.getAttribute("id") %>">View Alumni</a>
</nav>
</div>

<div class="navbar6">
<h2>
Sidebar Menu
</h2>

<nav>
<a href="addexam.jsp?x=<%=session.getAttribute("id") %>">Add New Exam</a>
<a href="viewexams?x=<%=session.getAttribute("id") %>">View Added Exams</a>
</nav>
</div>
<div class="navbar8">
<h2>
Sidebar Menu
</h2>

<nav>
<a href="postresult?x=<%=session.getAttribute("id") %>">Post Results</a>
<a href="viewresult?x=<%=session.getAttribute("id") %>">View Results</a>
</nav>
</div>
<div class="navbar7">
<h2>
Sidebar Menu
</h2>

<nav>
<a href="createdistopic.jsp?x=<%=session.getAttribute("id") %>">Create Discussion Topic</a>
<a href="topicdetails?x=<%=session.getAttribute("id") %>">View Topic</a>
</nav>
</div>
<div class="navbar5">
<h2>
Sidebar Menu
</h2>

<nav>
<a href="PhDdetails?x=<%=session.getAttribute("id") %>">View PhD students</a>
</nav>
</div>
<div class="container">
<div class="text">
<h1>CS Department</h1>
<a class="" href="#" >Staff</a>
<a class="menu-toggle1" href="#">Resource</a>
<a class="menu-toggle2" href="#">Post</a>
<a class="menu-toggle3" href="#">Post Alumni Info</a>
<a class="menu-toggle4" href="#">Edit Profile</a>
<a class="menu-toggle5" href="#">PhD Students</a>
<a class="menu-toggle6" href="#">Exam</a>
<a class="menu-toggle7" href="#">Discussion Board</a>
<a class="menu-toggle8" href="#">Result</a>

</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="assets/js/sidebar.js"></script>
</body>
</html>