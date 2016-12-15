<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="resources/css/home1.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


<title>My_BOX</title>
</head>
<body>
<div class="header">
	<div class="aa">
		<h1 class="aa" >
		<strong>
			<a  class="aa" href="">My Box</a>
			</strong>
		</h1>
	
	</div>
	<div class="login">
	<sec:authorize access="!isAuthenticated()">
		<a style="color: black;" href="login"><h3>Логін</h3></a>
		<a style="color: black;" href="registration"><h3>Реєстрація</h3></a>
		</sec:authorize>
		<br>
		<sec:authorize access="isAuthenticated()">
			${userAuth.name}
		<a style="color: black;"+
		 href="myprofile"><h3>Профіль</h3></a>
		<sf:form action="logout" method="post">
        <button class="btn btn-default" >Вихід</button>
    </sf:form>
		</sec:authorize>
		
	</div>

</div>

<div class="centr">
		<c:forEach var="commodity" items="${commodities}">
		<div class="comm1">
		 <img class="imgcomm"  src="${commodity.pathImage }" >
   <h2> ${commodity.nameOfCommodity} ${commodity.price} </h2>
   
   ${commodity.description}
    

    
    <sec:authorize access="isAuthenticated()">
    <div class="buy">
   
<%--         <a class="buy1" href="buy/${commodity.id}">Вибрати</a> --%>
<strong>
		<a class="buy1" href="intoBasket/${commodity.id}">into basket</a>
		</strong>
        </div>
    </sec:authorize>
    </div>
   
</c:forEach>


</div>

<div class="footer"> 

<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
		
		
		
			<a href="categories">Categories</a>
	
			<a href="producer">Producer</a>
		
			<a href="commodity">Commodity</a>
		
</sec:authorize>
</div>






		
	


</body>
</html>