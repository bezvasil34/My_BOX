<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form"  prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


	<script type="text/javascript" src="assets/js/bootstrap.js"></script>



<link rel="stylesheet" type="text/css" href="user.css">


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">


<link href='https://fonts.googleapis.com/css?family=Passion+One'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen'
	rel='stylesheet' type='text/css'>

<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
<link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">


<title>Insert title here</title>
</head>
<body>
 <a href="home">home</a>
 <a style="color: black;"
		 href="myprofile">Профіль</a>


<!-- <div class="testbox"> -->
<!--   <h1>Реєстрація</h1>		  -->

<%-- 		  <sf:form  action="saveUpdateUser/${user.id}" method="post"> --%>

<!--   <label id="icon" for="name"><i class="icon-user"></i></label> -->
<%--   <input type="text" name="newName" id="name" placeholder="${user.name}" /> --%>
<!--     <label id="icon" for="name"><i class="icon-user "></i></label> -->
<%--   <input type="text" name="newSurname" id="name" placeholder="${user.surname}"/> --%>
<!--   <label id="icon" for="name"><i class="icon-user"></i></label> -->
     
<!--   <input type="text" name="newUsername" id="name" placeholder="Enter new login"/> -->
 
<!--    <label id="icon" for="name"><i class="icon-shield"></i></label> -->
  
<%--   <input type="email" name="newEmail" id="name" placeholder="${user.email}" /> --%>
<!--   <label id="icon" for="name"><i class="icon-shield"></i></label> -->
<!--   <input type="text" name="newPhone" id="name" placeholder="newPhone" /> -->

<!-- <div class="reg"> -->
<!-- <button>Змінити</button>  -->

   
<!--    </div> -->
<%--   </sf:form> --%>
<!-- </div> -->

<sf:form action="saveUpdateUser/${user.id}" method="post">

	<input name="newName" placeholder="${user.name}">
	<br>
	<input name="newSurname" placeholder="${user.surname}">
	<br>
	<input name="newUsername" placeholder="Enter new login">
	<br>
	<input name="newEmail" placeholder="${user.email}">
	<br>
	<input name="newPhone" placeholder="${user.phone}">
	<br>
	<button>Змінити</button>
	</sf:form>
	
	
	

</body>
</html>