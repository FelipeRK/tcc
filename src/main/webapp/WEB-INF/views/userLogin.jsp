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
		<h3 style="margin-left:45px; color: #EB6864;">Login</h3>
	<br>
	
	
	<form method="POST" action="login">
		<table style="width:50%;margin-left:25%;margin-right:25%;">
		<tbody>
			<tr>
				<td>
					<label for="username">Email</label>
      				<input name="username" type="text" class="form-control" placeholder="Informe o usuário" required="required"/>
      				<br>
      			</td>
      		</tr>
			<tr>
      			<td>
					<label for="password">Senha</label>
      				<input name="password" type="password" class="form-control" placeholder="Informe a senha" required="required"/>
      			</td>
			</tr>
			<tr>
				<td align="right"><br><button type="submit" class="btn btn-primary">Entrar</button></td>
			</tr>
		</tbody>
		</table>
	</form>
	
	<c:if test="${ not empty requestScope.loginError }">
		<p class="text-danger" style="width:50%;margin-left:25%;margin-right:25%;">${ requestScope.loginError }</p>
	</c:if>
</body>
</html>