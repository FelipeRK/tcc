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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FRK Ecommerce</title>
</head>

<body>
	<!-- navigation bar -->
	<%@ include file="navbar.jsp" %>
	
	<br>
		<h3 style="margin-left:45px; color: #EB6864;">Cadastre-se</h3>
	<br>
	
	<form:form method="POST" action="cadastrar-usuario" modelAttribute="user">
		<table style="width:70%;margin-left:15%;margin-right:15%;">
		<tbody>
			<tr>
				<td>
					<label for="username">Nome</label>
      				<form:input path="username" type="text" class="form-control" placeholder="Nome Completo" required="required"/>
      			</td>
			</tr>
			<tr>
				<td>
					<br><label for="password">Senha</label>
      				<form:input path="password" type="password" class="form-control" placeholder="Senha" required="required"/>
      			</td>
			</tr>
			<tr>
				<td>
		      		<br><label for="email">Email</label>
		      		<form:input path="email" type="email" class="form-control" placeholder="Email" required="required"/>
		      	</td>
	   		</tr>
			<tr>
				<td>
					<br><label for="address">Endereco</label>
      				<form:input path="address" type="text" class="form-control" placeholder="Endereço" required="required"/>
      			</td>
			</tr>
			<tr>
				<td align="right"><br><button type="submit" class="btn btn-primary">Cadastrar</button></td>
			</tr>
			</tbody>
		</table>
	</form:form>
	
</body>
</html>