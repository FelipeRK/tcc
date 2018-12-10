<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	
	<br>
		<h3 style="margin-left:45px; color: #EB6864;">Pedido realizado com sucesso.</h3>
	<br>
	
	<br>
		<h4 style="margin-left:45px; color: #EB6864;">Numero Pedido : ${ confirmedOrder.id }</h4>
	<br>
	
	<table style="width:70%;margin-left:15%;margin-right:15%;text-align:center">
		  <tbody>
		  	<tr>
		      <th scope="col">Produto</th>
		      <th scope="col">Nome Produto</th>
		      <th scope="col">Quantidade</th>
		      <th scope="col">Preco</th>
		    </tr>
	  		<c:forEach items="${confirmedOrder.orderedProductList}" var="orderedProduct">
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
	  			<td><b>Total:</b></td>
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
		<h4 style="margin-left:45px; color: #EB6864;">Informacoes de Entrega</h4>
	<br>

	<table style="width:70%;margin-left:15%;margin-right:15%;text-align:center">
		  <tbody>
		  	<tr>
		  		<th scope="row"> Endereco de Entrega</th>
		  		<td>${ confirmedOrder.deliveryAddress }</td>
		  	</tr>
		  	
		  	<tr>
		  		<th scope="row"> Observacoes</th>
		  		<td>${ confirmedOrder.remarks }</td>
		  	</tr>
		  </tbody>
	</table>
</body>
</html>