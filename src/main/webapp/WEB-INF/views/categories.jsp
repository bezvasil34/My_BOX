<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="home">home</a>

<sf:form action="newCategory" method="post">
			<br> 
			<input name="nameOfCategories"
				placeholder="Enter name of category"> 
			<br> 
			 <br>
			<button>Save Category</button>
		</sf:form>

</body>
</html>