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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FRK Ecommerce</title>
</head>
<body>
	<!-- navigation bar -->
	<%@ include file="navbar.jsp" %>
	
	<c:if test="${ not empty sessionScope.user }">
		
		<br>
			<h3 style="margin-left:45px; color: #EB6864;">Order History</h3>
		<br>
		<table style="width:70%;margin-left:15%;margin-right:15%;text-align:center">
			  <tbody>
			  	<tr>
				  <th scope="col">Order Number</th>
			      <th scope="col">Delivery Address</th>
			      <th scope="col">Remark</th>
			      <th scope="col">Status</th>
			  	</tr>
			  	<c:forEach items="${orders}" var="order">
			  		<tr>
						<td><a href="viewOrder?id=${order.id}">${order.id}</a></td>
						<td>${order.deliveryAddress}</td>
						<td>${order.remarks}</td>
						<td>In Progress</td>
				  	</tr>
			  	</c:forEach>
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