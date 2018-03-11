<%@include file="header.jsp" %>
<div class="container-fluid">
<form action="checklogin" method="post">
<div class="col-md-4"></div>
 <div class="col-md-4">
  <div class="panel panel-success">
  <div class="panel-heading" style="text-align:center;"><h4>Login</h4></div>
  <div class="panel-body" style="text-align:center;" >
  <p style="color:red;text-align:center">${zc}</p>
  <div class="form-group" style="text-align:left">
 <label id="netid">NetID:</label>
 <input class="form-control" name="netid" type="text" placeholder="NetID">
 </div>
 <div class="form-group" style="text-align:left">
 <label for="password">Password:</label>
 <input class="form-control" name="password" type="password" placeholder="Password" size="50" />
 </div>
 <button type="submit" class="btn btn-primary" >Login</button>
 </div>
 <div class="panel-footer">
 
<a href="registration.jsp" style="text-align:center">Register</a>
</div>
</div>
</div>
</form>
</div>
 <%@include file="footer.jsp" %>