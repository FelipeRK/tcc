<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<link href="./resources/css/bootstrap.css" rel="stylesheet">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="./resources/js/searchForm.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FRK Ecommerce</title>
</head>
<body>
	<!-- navigation bar -->
	<%@ include file="navbar.jsp" %>
	
	<c:if test="${ not empty order }">
		<br>
			<h4 style="margin-left:45px; color: #EB6864;">Order Number : ${ order.id }</h4>
		<br>
		
		<table style="width:70%;margin-left:15%;margin-right:15%;text-align:center">
			  <tbody>
			  	<tr>
			      <th scope="col">Product</th>
			      <th scope="col">Product Name</th>
			      <th scope="col">Quantity</th>
			      <th scope="col">Price</th>
			    </tr>
		  		<c:forEach items="${order.orderedProductList}" var="orderedProduct">
			  		<tr>
			  			<td><img src="${ orderedProduct.product.productImageList[0].imageLink}" onerror="this.src='./resources/images/image-not-found.png'"
			       			width="150" height="150" /> <br></td>
				  		<td> ${ orderedProduct.product.productName } </td>
				  		<td>${ orderedProduct.quantity }</td>
				  		<td>R$ ${ orderedProduct.price * orderedProduct.quantity }</td>
				  	</tr>
		  		</c:forEach>
		  		<tr>
		  			<td></td>
		  			<td></td>
		  			<td></td>
		  			<td><b>Total Amount:</b></td>
		  		<tr>
		  		<tr>
		  			<td></td>
		  			<td></td>
		  			<td></td>
		  			<td>R$ ${ totalAmount }</td>
		  		<tr>
			  </tbody>
		</table>
		
		<br>
			<h4 style="margin-left:45px; color: #EB6864;">Delivery Information</h4>
		<br>
	
		<table style="width:70%;margin-left:15%;margin-right:15%;text-align:center">
			  <tbody>
			  	<tr>
			  		<th scope="row"> Delivery address</th>
			  		<td>${ order.deliveryAddress }</td>
			  	</tr>
			  	
			  	<tr>
			  		<th scope="row"> Observações</th>
			  		<td>${ order.remarks }</td>
			  	</tr>
			  </tbody>
		</table>
	
	</c:if>
	
	<c:if test="${ empty order }">
		<h3>Ocorreu algum erro, tente novamente mais tarde.</h3>
	</c:if>
</body>
</html>