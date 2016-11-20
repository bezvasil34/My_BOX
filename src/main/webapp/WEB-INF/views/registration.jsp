<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

	<script type="text/javascript" src="assets/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/user.css">


<link rel="stylesheet" type="text/css" href="user.css">


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">


<link href='https://fonts.googleapis.com/css?family=Passion+One'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen'
	rel='stylesheet' type='text/css'>

<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
<link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">


<title>Registration</title>
</head>
<body>
<a href="home">home</a>

	<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
		<c:forEach var="user" items="${users}">
${user.name }  ${ user.surname} ${user.email} <a href="del/${user.id }">delete</a>
			<a href="update/${user.id }">update</a>

			<br>
		</c:forEach>
	</sec:authorize>




	<!-- <div style="text-align: center ; margin-top: 20%"  > -->
	<!-- USER -->
	<!-- 	<form action="newUser" method="post"> -->
	<!-- 	<br> -->
	<!-- 	<input name= "name" placeholder="Enter name"> -->
	<!-- 	<br> -->
	<!-- 	<input name= "surname" placeholder="Enter surname"> -->
	<!-- 	<br> -->
	<!-- 	<input name= "password" placeholder="Enter password"> -->
	<!-- 	<br> -->
	<!-- 	<input name= "email" placeholder="Enter email"> -->
	<!-- 	<br> -->
	<!-- 	<input name= "login" placeholder="Enter login"> -->
	<!-- 	<br> -->
	<!-- 	<input name= "phone" placeholder="Enter phone"> -->
	<!-- 	<br> -->
	<!-- 	<button>Save User</button> -->
	<!-- 	</form> -->

	<!-- </div> -->



<div class="testbox">
  <h1>Реєстрація</h1>

  <sf:form modelAttribute="user" action="newUser" method="post">
  
  <label id="icon" for="name"><i class="icon-user"></i></label>
  <sf:input type="text" path="name" id="name" placeholder="Name" />
    <label id="icon" for="name"><i class="icon-user "></i></label>
  <sf:input type="text" path="surname" id="name" placeholder="Surname"/>
   <sf:errors path="username"/>
  <label id="icon" for="name"><i class="icon-user"></i></label>
    
  <sf:input type="text" path="username" id="name" placeholder="Login"/>
    <label id="icon" for="name"><i class="icon-shield"></i></label>
  <sf:input type="password" path="password" id="name" placeholder="Password" />
   <sf:errors path="username"/>
   <label id="icon" for="name"><i class="icon-shield"></i></label>
     <sf:errors path="email"/>
  <sf:input type="email" path="email" id="name" placeholder="Email" />
  <label id="icon" for="name"><i class="icon-shield"></i></label>
  <sf:input type="text" path="phone" id="name" placeholder="Phone" />

<div class="reg">
<button>Реєстрація</button> 
   <a href="login"><h4>Логін</h4></a>
   
   </div>
  </sf:form>
</div>



</body>
</html>