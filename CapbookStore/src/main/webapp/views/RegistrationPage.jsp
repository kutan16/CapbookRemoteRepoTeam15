<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<title>Registration</title>
<style>
.error{
color:red;
font-weight:bold;
}
</style>
</head>
<body>
<div align="center">
<h2>Enroll Associate Details Here</h2>
<table>
<form:form action="registerUser" method="post" modelAttribute="user">
<tr>
    <td> FirstName:</td>
    <td><form:input path="firstName" size="30"/></td>
        <td><form:errors path="firstName" cssClass="error"/></td>
    
    </tr>
    <tr>
    <td>LastName:</td>
     <td><form:input path="lastName" size="30"/></td>
        <td><form:errors path="lastName" cssClass="error"/></td>
     </tr>
     <tr>
     
    
    
    <td>emailId:</td>
     <td><form:input path="emailId" size="30"/></td>
        <td><form:errors path="emailId" cssClass="error"/></td>
     </tr>
     <tr>
    
     <td>gender:</td>
     <td><form:input path="gender" size="30"/></td>
        <td><form:errors path="gender" cssClass="error"/></td>
     </tr>
     <tr>
    
    <td>mobileNo</td>
     <td><form:input path="mobileNo" size="30"/></td>
        <td><form:errors path="mobileNo" cssClass="error"/></td>
     </tr>
     <tr>
    
     <td>dateOfBirth</td>
     <td><form:input path="dateOfBirth" size="30"/></td>
        <td><form:errors path="dateOfBirth" cssClass="error"/></td>
     </tr>
     <tr>
     
      
     </tr>
<tr>
<td><input type="submit" value="SignUp"/></td>

</form:form>
</table></div>

</body>
</html>


