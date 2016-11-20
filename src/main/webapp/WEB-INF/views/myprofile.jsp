<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>

<link rel="stylesheet" type="text/css" href="myprofile.css">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<strong>Вітаємо Вас, шановний користувач!</strong>
    <a href="home">home</a>
   

	<table class="table table-hover table-bordered">
<tr> 
    <td width="50%" valign="top"><div class="row">
  <div class="col-xs-6 col-md-3">
    <a href="#" class="thumbnail">
      <img src="${user.pathImage}" height="100px" width="100px" alt="">
    </a>
  </div>

</div>
   <form:form action="saveImage?${_csrf.parameterName}=${_csrf.token}"
               method="post" enctype="multipart/form-data"> 
        <input type="file" name="image">
       <button>Зберегти фото</button>
    </form:form> 
</td><td valign="top">
<strong>Реєстраційні дані:</strong>
<br>
${user.surname }
<br>
${user.name}

<br>
${user.email}
<br>
${user.phone}
<br>
<a href="update/${user.id }">Змінити реєстраційні дані</a>
</td>
   </tr>
   <tr> 
    <td width="50%" valign="top"><strong>Корзина з замовленими товарами:</strong></td><td valign="top"><c:forEach var="commodity" items="${commodities}">
        ${commodity.nameOfCommodity} ${commodity.price}
        <a href="getOrder/${commodity.id}">Замовити</a>
        <a href="deleteCookie/${commodity.id}">Видалити з корзини</a>
        <br>
    </c:forEach></td>
   </tr>
   <tr> 
    <td width="50%" valign="top"><strong>Підтверджені замовлення:</strong></td><td valign="top">    <br>
    ${user.commodities }
	<br></td>
   </tr>
   <tr> 
    <td width="50%" valign="top">Левая колонка</td><td valign="top">Правая колонка</td>
   </tr>
</table>
    


<br>
<br>

    
<%--     <img src="${user.pathImage}" height="100px" width="100px"> --%>
  
 
  
	

    <br>
<%--     <c:forEach var="commodity" items="${user.commodities}"> --%>
<%--         ${commodity.nameOfCommodity} ${commodity.price} --%>
<%--         <a href="deleteCommodityFromUser/${commodity.id}">delete</a> --%>
<!--         <br> -->
<%--     </c:forEach> --%>




</body>
</html>