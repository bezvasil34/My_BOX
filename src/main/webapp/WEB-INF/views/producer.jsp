<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



<title>Insert title here</title>
</head>
<body>

<a href="home">home</a>
		<sf:form action="newProducer" method="post">
			<select name="choosenCategories">
				<option>choose categories</option>
				<c:forEach var="category" items="${categories}">
					<option value="${category.id}">${category.nameOfCategories}</option>
				</c:forEach>
			</select> 
			<br> 
			<br> 
			<input name="nameOfProducer"
				placeholder="Enter name of producer"> 
			<br> 
			<br> <br>
			<button>Save Producer</button>
		</sf:form>

</body>
</html>