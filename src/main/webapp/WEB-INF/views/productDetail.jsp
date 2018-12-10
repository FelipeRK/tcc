<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<link href="./resources/css/bootstrap.css" rel="stylesheet">
<link href="./resources/css/plus-minus-input.css" rel="stylesheet">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="./resources/js/searchForm.js"></script>
<script src="./resources/js/plus-minus-input.js"></script>

<script>
	function checkStock(){
		var stock = ${product.stock};
		var requiredQuantity = document.forms["addToShoppingCartForm"]["quantity"].value;
		
		if(stock >= requiredQuantity){
			window.alert("Adicionado ao carrinho.");
			document.addToShoppingCartForm.submit();
			return true;
		} else {
			window.alert("Sorry, we don't have enough stock");
			return false;
		}
	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FRK Ecommerce</title>
</head>
<body>
	<!-- navigation bar -->
	<%@ include file="navbar.jsp" %>
	
	<!-- Result not found image -->
	<c:if test="${empty product}">
		<br><br><br><br><br><br><br>
		<img src="./resources/images/noresults.png"
		       			style="display: block; margin-left: auto; margin-right: auto;" width="425" height="150" />
	</c:if>


	<!-- Showing the product details -->
	<c:if test="${not empty product}">
		<table style="width:70%;margin-left:15%;margin-right:15%;">
		  <tbody>
		  	<tr>
		  		<td>
		  			<img src="${product.productImageList[0].imageLink}" onerror="this.src='./resources/images/image-not-found.png'"
			       			width="500" height="500" />
			    </td>
			    <td>
			    		<h5>${product.productName} </h5>
			    		<i style="color: #777;">${product.productDescription}</i> <br>
			    		<h6>R$ ${product.price} </h6>
			    		<c:if test="${product.stock <= 50}">
						<p class="text-danger">Low In Stock </p>
					</c:if>
					<c:if test="${product.stock > 50}">
						<p class="text-success">In Stock </p>
					</c:if>
					
					<c:if test="${product.stock <= 0}">
						<p class="text-primary">Out of stock </p>
					</c:if>

					<form name="addToShoppingCartForm" action="addShoppingCart" method="post">
						<!-- stock > 0 -->
						<c:if test="${product.stock > 0}">
							<div class="input-group plus-minus-input">
							  <div class="input-group-button">
							    <button type="button" class="button hollow circle" data-quantity="minus" data-field="quantity">
							      -
							    </button>
							  </div>
							  <input class="input-group-field" type="number" name="quantity" value="1">
							  
							  <div class="input-group-button">
							    <button type="button" class="button hollow circle" data-quantity="plus" data-field="quantity">
							      +
							    </button>
							  </div>
							</div>
							<br>
							<input type="hidden" value="${product.id}" name="productId" />
					    		<button type="button" class="btn btn-primary" style="width:260px;" onClick="checkStock()">ADICIONAR AO CARRINHO</button>
				    		</c:if>
				    		
				    		<!-- stock > 0 -->
				    		<c:if test="${product.stock <= 0}">
				    			<br>
				    			<button type="button" class="btn btn-primary" style="width:260px;" disabled="disabled">ADICIONAR AO CARRINHO</button>
				    		</c:if>
			   		</form>
			    </td>
		  	</tr>
		  </tbody>
		</table>
	</c:if>
	
</body>
</html>