<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<link href="./resources/css/bootstrap.css" rel="stylesheet">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="./resources/js/searchForm.js"></script>

<script type="text/javascript">
	function checkLogin(){
		var logined = '<%= session.getAttribute("user") %>';
		console.log(logined);
		if (logined == 'null'){
			window.alert("Please login first.");
			return false;
		} else {
			document.placeOrder.submit();
			return true;
		}
	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FRK Ecommerce</title>
</head>
<body>
	<!-- navigation bar -->
	<%@ include file="navbar.jsp" %>

	<!-- Carrinho is empty -->
	<c:if test="${empty sessionScope.shoppingCart}">
		<br><br><br><br><br><br><br>
		<h4 align=center>Oops! Seu carrinho esta vazio</h4>
	</c:if>
	
	<c:if test="${not empty sessionScope.shoppingCart}">
		<br>
		<h3 style="margin-left:45px; color: #EB6864;">Carrinho</h3>
		<br>
		<table style="width:70%;margin-left:15%;margin-right:15%;text-align:center">
		  <tbody>
		  	<tr>
		      <th scope="col">Produto</th>
		      <th scope="col">Nome</th>
		      <th scope="col">Quantidade</th>
		      <th scope="col">Preco</th>
		    </tr>
				<c:forEach items="${sessionScope.shoppingCart.productMap}" var="productMapItem">
		  		<tr>
		  			<td><img src="${productMapItem.key.productImageList[0].imageLink}" onerror="this.src='./resources/images/image-not-found.png'"
		       			width="150" height="150" /> <br></td>
			  		<td> ${ productMapItem.key.productName } </td>
			  		<td>${ productMapItem.value }</td>
			  		<td>R$ ${ productMapItem.key.price * productMapItem.value}</td>
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
	  			<td>R$ ${sessionScope.shoppingCart.totalAmount }</td>
	  		<tr>
		  </tbody>
		</table>
		
		<br><br><br>
		
		<form name="placeOrder" action="deliveryInfoForm" method="post">
			<button type="button" class="btn btn-primary" style="width:20%;margin-left:65%;margin-right:15%;" onClick="checkLogin()">Comprar</button>
		</form>
	</c:if>
</body>
</html>