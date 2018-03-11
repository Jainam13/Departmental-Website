<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link href="assets/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
<style>
body{
background-color: #f3efed;
}
</style>
<script>
function checkdata()
  {
      var p=document.f1.password.value;
      var netid=document.f1.netid.value;
      var firstname=document.f1.firstname.value;
      var lastname=document.f1.lastname.value;
      var role=document.f1.role.value;
      var year=document.f1.year.value;
      var regularExpression = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,16}$/;
      
      if(netid=="")
    	{
    	  alert("Netid cannot be null");
          return false;
    	}
      
       if(regularExpression.test(p)==false)
    	  {
    	  alert("Password must be 8 or more and should contain at least 1 letter,1 number and 1 special character");
          return false;
    	  }
       if(firstname=="")
   	{
   	  alert("firstname cannot be null");
         return false;
   	}
       if(lastname=="")
   	{
   	  alert("lastname cannot be null");
         return false;
   	}
       if(role=="")
      	{
      	  alert("role cannot be null");
            return false;
      	}
      
  }
</script>
</head>
<body >
<div class="container-fluid">
<form action="registration" method="post" name="f1" onsubmit="return checkdata()">

<div class="row" style="margin:10px;">

 <div class="col-md-4"></div>
 <div class="col-md-4">
  <div class="panel panel-success">
  <div class="panel-heading" style="text-align:center;"><h4>Registration</h4></div>
  <div class="panel-body" style="text-align:center;" >
  <p style="color:red;text-align:center">${zc}</p>
  <div class="form-group" style="text-align:left">
  
 <label id="netid">NetID:</label>
 <input class="form-control" name="netid" type="text" placeholder="NetID" >
 </div>
 <div class="form-group" style="text-align:left">
 <label for="password">Password:</label>
 <input class="form-control" name="password" type="password" placeholder="Password" size="50" />
 </div>
 <div class="form-group" style="text-align:left">
<label for="firstname">Firstname:</label>
<input class="form-control" name="firstname" type="text" placeholder="Firstname" size="50" />
</div>
<div class="form-group" style="text-align:left">
<label for="lastname">Lastname: </label>
<input class="form-control" name="lastname" type="text" placeholder="Lastname" size="50" />
</div>
<div class="form-group" style="text-align:left">
<p><label for="role">Role:</label>
<select class="form-control" name = "role" >
        <option value = "">-- Select an Option --</option>
        <option value = "Faculty">Faculty</option>
        <option value = "Student">Student</option>
        <option value = "Staff">Staff</option>
        </select>
        </p>
</div>
 <div id="conditional">
<div class="form-group" style="text-align:left">
<label id="year">Year:</label>
<input class="form-control" name="year" type="text" placeholder="Year" size="50">
</div>
  <div class="form-group" style="text-align:left">
  <label id="year">Program:</label>
   <select class="form-control" name = "program">
        <option value = "">-- Select an Option --</option>
        <option value = "BS">BS</option>
        <option value = "BA">BA</option>
        <option value = "MS">MS</option>
        <option value = "PhD">PhD</option>
        </select>
    </div>
    <div class="form-group" style="text-align:left">
    <label id="major">Major: </label>
    <input class="form-control" name="major" type="text" placeholder="Major" size="50">
    </div>
    </div>
    <button type="submit" class="btn btn-default" >Submit</button>
    
    </div>
    </div>
    </div>
    <div class="col-md-4"></div>
    </form>
   </div>
  <%@include file="footer.jsp" %>
		

    </body>
</html>
</body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script>
  $('p select[name=role]').change(function(e){
  if ($('p select[name=role]').val() == 'Student'){
    $('#conditional').slideDown("fast");
  }else{
    $('#conditional').slideUp("fast");
  }
});
  
</script>
<script src="assets/js/sidebar.js"></script>
<style>
#conditional{display:none;}
</style>
</html>