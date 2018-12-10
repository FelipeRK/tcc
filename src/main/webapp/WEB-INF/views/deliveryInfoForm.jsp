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
	
	<br>
	<h3 style="margin-left:45px; color: #EB6864;">Endereco para entrega</h3>
	<br>
	
	<form action="confirmationPage" method="POST">
		<table style="width:50%;margin-left:25%;margin-right:25%;">
		<tbody>
			<tr>
				<td>
					<label for="address">Endereco</label>
      				<input name="address" type="text" class="form-control" placeholder="Informe o endereco" required="required"/>
      				<br>
      			</td>
      		</tr>
			<tr>
      			<td>
					<label for="remarks">Observacoes</label>
      				<input name="remarks" type="text" class="form-control" placeholder="alguma observacao? " />
      			</td>
			</tr>
			<tr>
				<td align="right"><br><button type="submit" class="btn btn-primary">Proximo</button></td>
			</tr>
		</tbody>
		</table>
	</form>
	
</body>
</html>