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
                 <strong >Welcome,</strong> &nbsp;
                 <a href="loginpage.jsp"><span class="label label-primary btn-lg">Log out</span></a>
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
<div class="container">

<div style="text-align:left" class="menu-toggle4">Courses</div>|<a class="menu-toggle4" style="text-align:left" href="#">Courses</a>

</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="assets/js/sidebar.js"></script>
</body>
</html>