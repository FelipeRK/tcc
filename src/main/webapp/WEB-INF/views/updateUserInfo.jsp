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
	
	<c:if test="${ not empty sessionScope.user }">
		<br>
			<h3 style="margin-left:45px; color: #EB6864;">Update Information</h3>
		<br>
		
		<c:if test="${ not empty message }">
			<p class="text-danger">${ message }
			</p>
		</c:if>
		
	<form:form method="POST" action="submitEditUserInfo" modelAttribute="editUser">
		<table style="width:70%;margin-left:15%;margin-right:15%;">
			<tbody>
				<tr>
					<td>
						<br><label for="currentPassword">Current Password</label>
	      				<input name="currentPassword" type="password" class="form-control" placeholder="Enter current password" required="required"/>
	      			</td>
				</tr>
				<tr>
					<td>
						<br><label for="password">New Password</label>
	      				<form:input path="password" type="password" class="form-control" placeholder="Enter password" required="required"/>
	      			</td>
				</tr>
				<tr>
					<td>
			      		<br><label for="email">Email address</label>
			      		<form:input path="email" type="email" class="form-control" placeholder="Enter email" required="required"/>
			      	</td>
		   		</tr>
				<tr>
					<td>
						<br><label for="address">Address</label>
	      				<form:input path="address" type="text" class="form-control" placeholder="Enter address" required="required"/>
	      			</td>
				</tr>
				<tr>
					<td align="right"><br><button type="submit" class="btn btn-primary">Submit</button></td>
				</tr>
			</tbody>
		</table>
	</form:form>
		
	</c:if>
	
	<c:if test="${ empty sessionScope.user }">
		<br><br><br><br><br><br><br>
		<h4 align=center>Oops! Please login first.</h4>
		<br>
	</c:if>
	
</body>
</html>