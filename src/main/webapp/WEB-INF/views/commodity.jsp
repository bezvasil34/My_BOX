<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="home">home</a>
<sf:form action="saveCommodityImage?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
	<select name="commodityID">
		<option>choose commodity</option>
			<c:forEach var="com" items="${commodities}">
				<option value="${com.id }">${com.nameOfCommodity}</option>
			</c:forEach>
		</select>
		
	<input type="file" name="image">
	<button>save image</button>
	</sf:form>
	

 

	<div style="text-align: center; margin-top: 20%">
		COMMODITY
		<sf:form action="newCommodity" method="post">
	

			<select name="choosenProducers">
				<option>choose producer</option>
				<c:forEach var="producer" items="${producers}">
					<option value="${producer.id}">${producer.nameOfProducer}</option>
				</c:forEach>
			</select> 
			<br> 
			<input name="nameOfCommodity"
				placeholder="Enter name of commodity"> 
			<br> 
			<input
				name="price" placeholder="Enter price"> 
				
			<br> 
		
		<input name="description"
				type="text" placeholder="Enter description"> 
			<br>
			<button>Save Commodity</button>
		</sf:form>
  
	</div>

<c:forEach var="comm" items="${commodities}">
		${comm.nameOfCommodity } <a href="delete/${comm.id}">delete</a> <img  src="${comm.pathImage }" height="100px" width="100px"><br>
	</c:forEach>

</body>
</html>