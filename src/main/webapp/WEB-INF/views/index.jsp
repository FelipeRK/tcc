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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FRK Ecommerce</title>
</head>

<body>
	<!-- navigation bar -->
	<%@ include file="navbar.jsp" %>
	
	<!-- Result not found image -->
	<c:if test="${empty indexProductBasicDisaplays}">
		<br><br><br><br><br><br><br>
		<img src="./resources/images/noresults.png"
		       			style="display: block; margin-left: auto; margin-right: auto;" width="425" height="150" />
	</c:if>
	
	<!-- table for listing all products -->
	<table style="width:70%;margin-left:15%;margin-right:15%;">
	  <tbody>
	  	<tr>
		     <c:forEach items="${indexProductBasicDisaplays}" var="ipbd" varStatus="loop">
		       <c:if test="${not loop.first and loop.index % 3 == 0}"> 
		            		</tr>
		            <tr>
		       </c:if>
		       	<td style="padding: 5px 10px 5px 5px; align=center">
		       		<a href="detalhe-produto?id=${ipbd.productId}">
		       		<img src="${ipbd.thumbnail}" onerror="this.src='./resources/images/image-not-found.png'"
		       			width="200" height="200" /> <br>
					${ipbd.productName}<br></a>
					 R$ ${ipbd.price}<br>
		       	</td>
		     </c:forEach>
	     </tr>
	  </tbody>
	</table>
</body>
</html>