<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<link href="./resources/css/bootstrap.css" rel="stylesheet">
<link href="./resources/css/font-awesome.min.css" rel="stylesheet">
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
	
	<c:if test="${ not empty sessionScope.user }">
		
		<br>
			<h3 style="margin-left:45px; color: #EB6864;">Minha Conta</h3>
		<br>
		
		<c:if test="${ not empty message }">
			<p class="text-danger">${ message }
			</p>
		</c:if>
		
		<table style="margin-left:15%;margin-right:15%;">
			  <tbody>
		  		<tr>
			  		<td style="font-size:50px"><i class="fa fa-gift" aria-hidden="true"></i></td>
			  		<td><form action="viewPersonalOrderHistory" method="POST"><button type="submit" class="btn btn-link">Meus Pedidos</button></form></td>
			  	</tr>
			  	
			  	<tr>
			  		<td style="font-size:50px"><i class="fa fa-pencil" aria-hidden="true"></i></td>
			  		<td><form action="updateUserInfo" method="POST"><button type="submit" class="btn btn-link">Atualizar Dados</button></form></td>
			  	</tr>
			  	
			  	
			  </tbody>
		</table>
	</c:if>
	
	<c:if test="${ empty sessionScope.user }">
		<br><br><br><br><br><br><br>
		<h4 align=center>Oops! Please login first.</h4>
		<br>
	</c:if>
			  	
</body>
</html>