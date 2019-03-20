<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
.index1{
	width:800px; 
 	margin: auto;
  	border: 3px solid black;
	background-position:center top;
}
h1.h{
	border-bottom: 6px solid red;
  	background-color: lightgrey;
	color:green;
	text:bold;
}
</style>
</head>
<body>
	<div align="center" class="bg-light text-dark">
	<h1>WELCOME TO CAPBOOK REGISTRATION PAGE</h1>
		<h2 class="bg-dark text-white">Enter your correct details to Register to Capbook</h2>
		<table>
			<form:form action="RegisterUser" method="post"
				modelAttribute="userr">
				<tr>
					<td>First Name</td>
					<td><form:input path="firstName" size="30" /></td>
					<td><form:errors path="firstName" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><form:input path="lastName" size="30" /></td>
					<td><form:errors path="lastName" cssClass="error" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Register Account" /></td>
				</tr>
			</form:form>
		</table>
	</div>
</body>
</html>