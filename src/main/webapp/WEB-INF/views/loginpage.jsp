<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<link rel="stylesheet" type="text/css" href="resources/css/loginpage.css">


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<title>Loginpage</title>
</head>
<body>

<%-- <sf:form action="loginprocesing" method="post"> --%>

<!-- 	<input name="username" placeholder=" Enter Login"/>  -->
<!-- 	<br> -->
<!-- 	<input name="password" type="password" placeholder=" Enter password" /> -->
<!-- 	<br> -->
<!-- 	<button>sing in</button> -->
	
<%-- </sf:form> --%>

<div class="log">
<sf:form role="form" action="loginprocesing" method="post" >
  <div class="form-group">
    <label for="exampleInputEmail1">Login</label>
    <br>
    <input name="username" type="text" class="form-control" id="exampleInputEmail1" placeholder="Enter  Login">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <br>
    <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Enter password">
  </div>
  <button>Sign in</button>
  
</sf:form>

</div>
</body>
</html>