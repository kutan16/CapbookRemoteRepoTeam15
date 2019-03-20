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
					<td>EmailID</td>
					<td><form:input path="emailID" size="30" /></td>
					<td><form:errors path="emailID" cssClass="error" /></td>
				</tr>
				<tr>
					<td>dateOfBirth</td>
					<td><form:input path="dateOfBirth" size="30" /></td>
					<td><form:errors path="dateOfBirth" cssClass="error" /></td>
				</tr>

				<tr>
					<td>mobileNo</td>
					<td><form:input path="mobileNo" size="30" /></td>
					<td><form:errors path="mobileNo" cssClass="error" /></td>
				</tr>
				<tr>
					<td>gender</td>
					<td><form:input path="gender" type ="radio" value="male" size="30" />MALE</td>
					<td><form:input path="gender" type ="radio" value="female" size="30" />FEMALE</td>
					<td><form:input path="gender" type ="radio" value="transgender" size="30" />TRANSGENDER</td>
					<td><form:errors path="gender" cssClass="error" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Register Account" /></td>
				</tr>
			</form:form>
		</table>
	</div>
</body>
</html>